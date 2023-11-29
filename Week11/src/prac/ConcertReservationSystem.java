package prac;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//좌석 정보를 담는 Seat 클래스
class Seat {
 protected String type;  // 좌석 타입 (V, S, A, B)
 protected int seatNumber;  // 좌석 번호
 protected boolean isReserved;  // 예약 여부
 protected String reservedBy;  // 예약자 이름
 protected String phoneNumber;  // 예약자 전화번호

 // Seat 클래스 생성자
 public Seat(String type, int seatNumber) {
     this.type = type;
     this.seatNumber = seatNumber;
     this.isReserved = false;
     this.reservedBy = "";
     this.phoneNumber = "";
 }

 // 좌석 예약을 시도하고 결과를 반환하는 메서드
 public boolean reserve(String reservedBy, String phoneNumber) {
     if (!isReserved) {
         this.isReserved = true;
         this.reservedBy = reservedBy;
         this.phoneNumber = phoneNumber;
         return true;  // 예약 성공
     } else {
         System.out.println("이미 예약된 좌석입니다.");
         System.out.println();
         return false;  // 예약 실패
     }
 }

 // 좌석 정보를 출력하는 메서드
 public void display() {
     System.out.println("좌석 " + type + seatNumber + ": " + (isReserved ? "예약됨" : "예약 가능"));
 }
}

//공연장 좌석 정보를 관리하는 Venue 클래스
class Venue {
 protected Map<String, Seat[]> seats;  // 각 타입별 좌석 배열을 저장하는 맵

 // Venue 클래스 생성자
 public Venue() {
     this.seats = new HashMap<>();
     seats.put("V", new Seat[30]);
     seats.put("S", new Seat[30]);
     seats.put("A", new Seat[30]);
     seats.put("B", new Seat[30]);

     initializeSeats();  // 좌석 초기화 메서드 호출
 }

 // 각 타입별로 좌석을 초기화하는 메서드
 private void initializeSeats() {
     for (String type : seats.keySet()) {
         for (int i = 0; i < 30; i++) {
             seats.get(type)[i] = new Seat(type, i + 1);
         }
     }
 }

 // 특정 타입과 번호의 좌석을 가져오는 메서드
 public Seat getSeat(String type, int seatNumber) {
     return seats.get(type)[seatNumber - 1];
 }

 // 현재 좌석 예약 상태를 출력하는 메서드
 public void displaySeatStatus() {
     for (String type : seats.keySet()) {
         System.out.println("=== " + type + "석 ===");
         for (Seat seat : seats.get(type)) {
             seat.display();
         }
         System.out.println();
     }
 }
}

//예약 시스템을 관리하는 ReservationSystem 클래스
class ReservationSystem {
 private Venue venue;  // 공연장 정보를 담는 Venue 객체
 private Map<Integer, Seat> reservations;  // 예약된 좌석 정보를 담는 맵
 private Map<String, Integer> reservationsPerType;  // 각 타입별 예약 횟수를 담는 맵
 private Map<String, Integer> reservationsPerPerson;  // 각 예약자별 예약 횟수를 담는 맵
 private int reservationCounter;  // 예약 번호를 관리하는 변수

 // ReservationSystem 클래스 생성자
 public ReservationSystem() {
     this.venue = new Venue();  // Venue 객체 초기화
     this.reservations = new HashMap<>();  // 예약된 좌석 정보를 담는 맵 초기화
     this.reservationsPerType = new HashMap<>();  // 각 타입별 예약 횟수를 담는 맵 초기화
     this.reservationsPerPerson = new HashMap<>();  // 각 예약자별 예약 횟수를 담는 맵 초기화
     this.reservationCounter = 1;  // 예약 번호 초기화

     // 초기에 각 좌석 타입별 예약 횟수 0으로 설정
     reservationsPerType.put("V", 0);
     reservationsPerType.put("S", 0);
     reservationsPerType.put("A", 0);
     reservationsPerType.put("B", 0);
 }

 // 예약 번호 생성 메서드
 private int generateReservationNumber() {
     return reservationCounter++;
 }

 // 좌석 예약 메서드
 public void reserveSeat(String type, int seatNumber, String reservedBy, String phoneNumber) {
     Seat seat = venue.getSeat(type, seatNumber);

     // 개인당 최대 2좌석 예약 가능
     int reservationsForPerson = reservationsPerPerson.getOrDefault(reservedBy, 0);
     if (reservationsForPerson >= 2) {
         System.out.println(reservedBy + "님은 개인당 최대 2좌석 예약이 가능합니다.");
         System.out.println();
         return;
     }

     if (seat.reserve(reservedBy, phoneNumber)) {
         int reservationNumber = generateReservationNumber();
         reservations.put(reservationNumber, seat);
         reservationsPerType.put(type, reservationsPerType.get(type) + 1);
         reservationsPerPerson.put(reservedBy, reservationsForPerson + 1);
         System.out.println("예약 성공. 예약 번호: " + reservationNumber);
         System.out.println();
     } else {
         System.out.println("예약 실패.");
         System.out.println();
     }
 }

 // 예약 취소 메서드
 public void cancelReservation(int reservationNumber) {
     Seat seat = reservations.get(reservationNumber);
     if (seat != null && seat.isReserved) {
         seat.isReserved = false;
         seat.reservedBy = "";
         seat.phoneNumber = "";
         reservationsPerType.put(seat.type, reservationsPerType.get(seat.type) - 1);
         System.out.println("예약 취소 성공.");
         System.out.println();
     } else {
         System.out.println("유효하지 않은 예약 번호이거나 좌석이 이미 예약되지 않았습니다.");
         System.out.println();
     }
 }

 // 좌석 현황 출력 메서드
 public void displaySeatStatus() {
     venue.displaySeatStatus();
 }
}

//프로그램 실행을 담당하는 ConcertReservationSystem 클래스
public class ConcertReservationSystem {
 public static void main(String[] args) {
     ReservationSystem reservationSystem = new ReservationSystem();
     Scanner scanner = new Scanner(System.in);

     // 사용자에게 작업 선택을 받는 루프
     while (true) {
         System.out.println("1. 좌석 예약");
         System.out.println("2. 좌석 예약 현황 확인");
         System.out.println("3. 예약 취소");
         System.out.println("4. 종료");
         System.out.print("원하는 작업을 선택하세요: ");

         int choice = scanner.nextInt();
         scanner.nextLine(); // 개행 문자 소비

         // 선택에 따른 동작 수행
         switch (choice) {
             case 1:
                 System.out.print("좌석 타입을 입력하세요 (V/S/A/B): ");
                 String type = scanner.nextLine().toUpperCase();
                 System.out.print("좌석 번호를 입력하세요: ");
                 int seatNumber = scanner.nextInt();
                 scanner.nextLine(); // 개행 문자 소비
                 System.out.print("예약자 이름을 입력하세요: ");
                 String name = scanner.nextLine();
                 System.out.print("전화번호를 입력하세요: ");
                 String phoneNumber = scanner.nextLine();
                 reservationSystem.reserveSeat(type, seatNumber, name, phoneNumber);
                 break;
             case 2:
                 reservationSystem.displaySeatStatus();
                 break;
             case 3:
                 System.out.print("취소할 예약 번호를 입력하세요: ");
                 int cancelReservationNumber = scanner.nextInt();
                 reservationSystem.cancelReservation(cancelReservationNumber);
                 break;
             case 4:
                 System.out.println("프로그램을 종료합니다.");
                 System.out.println();
                 System.exit(0);
                 break;
             default:
                 System.out.println("유효하지 않은 선택입니다. 다시 시도하세요.");
         }
     }
 }
}
