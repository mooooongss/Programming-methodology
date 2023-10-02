package prac;

public class MathEx {
	public static void main(String[] args) {
		System.out.println(Math.PI);		// 원주율 상수 출력
		
		double a = Math.PI;
		System.out.println(Math.ceil(a));		// ceil (올림)
		System.out.println(Math.floor(a));		// floor (내림)
		
		System.out.println(Math.sqrt(9));		// square root (제곱근)
		System.out.println(Math.exp(2));		// e의 2승	
		System.out.println(Math.round(3.14));	// 반올림
		
		// [1, 45] 사이의 정수형 난수 5개 생성
		System.out.println("이번 주 행운의 번호는");
		for(int i = 0; i < 5; i++) {
			System.out.println((int)(Math.random() * 45 + 1) + " ");
		}
		
		System.out.println();
	}

}
