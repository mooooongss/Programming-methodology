import java.util.Scanner;

public class Simple369 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter integer value 1~99 : ");
		int num = scanner.nextInt(); // 숫자를 입력 받음
		
		int a = num / 10; // 10의 자리 수
		int b = num % 10; // 1의 자리 수
		int c = 0;
		
		if(num >= 100)
			System.out.println("잘못된 입력입니다.(1~99 사이 입력)"); // 1-99 사이의 수를 입력하지 않은 경우
		else {
				if(a == 3 || a == 6 || a ==9)
					c++; // 10의 자리 수가 3/6/9인 경우 c++
				if(b == 3 || b == 6 || b ==9)
					c++; // 1의 자리 수가 3/6/9인 경우 c++
				
				if(c == 0)
					System.out.println("No 3, 6, or 9");
				if(c == 1)
					System.out.println("박수짝");
				if(c == 2)
					System.out.println("박수짝짝"); // c값에 따른 출력
		}
	}
}
