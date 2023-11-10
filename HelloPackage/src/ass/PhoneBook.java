package ass;

import java.util.Scanner;

class Phone {
    String name;
    String number;

    // 기본 생성자
    public Phone() {
    }

    // 이름과 전화번호를 받는 생성자
    public Phone(String name, String number) {
        this.name = name;
        this.number = number;
    }

    /*
    // 이름만 받는 생성자
    public Phone(String name) {
        this.name = name;
    }

    // 전화번호만 받는 생성자
    public Phone(int number) {
        this.number = Integer.toString(number);
    }
    */
    // 이번 예제에서는 사용하지 않아 주석 처리
}

public class PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Number of Person >> ");
        int num = Integer.parseInt(scanner.nextLine()); // 사람 수를 입력 받음

        Phone[] phone = new Phone[num];

        for (int i = 0; i < phone.length; i++) {
            System.out.print("Name and Phonenumber (ex. 홍길동 010-1234-5678) >> ");
            String input = scanner.nextLine();
            String[] parts = input.split(" "); // 이름과 번호를 입력 받고, 스페이스로 각각을 구분

            if (parts.length == 2) {
                String name = parts[0];
                String number = parts[1];
                phone[i] = new Phone(name, number); // 이름과 번호를 나누어서 배열에 저장
            } else {
                System.out.println("잘못된 입력입니다. 이름과 전화번호를 스페이스로 구분하여 입력하세요.");
                i--;  // 잘못된 입력을 한 경우 다시 시도
            }
        }
        System.out.println("Store Done");

        while (true) {
            System.out.print("Name to search >> ");
            String name = scanner.nextLine(); // 이름을 입력 받음

            if (name.equalsIgnoreCase("stop")) {
                break;
            } // stop 작성 시 프로그램 종료

            int check = -1;

            for (int i = 0; i < phone.length; i++) {
                if (name.equals(phone[i].name)) {
                    System.out.println(name + "'s number is " + phone[i].number);
                    check = 1;
                }
            } // 입력한 이름이 배열 내에 있는 경우 이름과 번호 출력

            if (check == -1) {
                System.out.println(name + " not found");
            } // 입력한 이름이 배열 내에 없는 경우
        }
    }
}
