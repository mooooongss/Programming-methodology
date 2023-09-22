import java.util.Scanner; // Scanner 사용을 위한 import

public class ChangeMoney {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // 사용자의 입력을 받음
		
		int[] unit = {50000, 10000, 5000, 1000, 100, 10, 1}; // 배열 선언(가격대별)
		System.out.print("Input price(won): ");
		int num = scanner.nextInt(); // 숫자를 입력 받음
						
		for(int i = 0; i < unit.length; i++) {
			System.out.println(unit[i] + "원: " + num/unit[i] + "개"); // num에 입력된 값의 몫을 구해 출력
			num %= unit[i]; // 위에서 계산한 값(몫)을 뺀 나머지를 num으로 설정해 계산을 반복
		}
	}
}