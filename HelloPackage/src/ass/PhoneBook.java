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
}

public class PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Number of Person >> ");
        int num = Integer.parseInt(scanner.nextLine());

        Phone[] phone = new Phone[num];

        for (int i = 0; i < phone.length; i++) {
            System.out.print("Name and Phonenumber (ex. 홍길동 010-1234-5678) >> ");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");

            if (parts.length == 2) {
                String name = parts[0];
                String number = parts[1];
                phone[i] = new Phone(name, number);
            } else {
                System.out.println("잘못된 입력입니다. 이름과 전화번호를 스페이스로 구분하여 입력하세요.");
                i--;  // 다시 시도
            }
        }
        System.out.println("Store Done");

        while (true) {
            System.out.print("Name to search >> ");
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("stop")) {
                break;
            }

            int check = -1;

            for (int i = 0; i < phone.length; i++) {
                if (name.equals(phone[i].name)) {
                    System.out.println(name + "'s number is " + phone[i].number);
                    check = 1;
                }
            }

            if (check == -1) {
                System.out.println(name + " not found");
            }
        }
    }
}
