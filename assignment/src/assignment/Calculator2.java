package assignment;

import java.util.*;

abstract class Calc {
	public int a;
	public int b;
	
	public void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}
	// abstract void setValue(double a, double b);
	abstract int calculate();
}

class Add2 extends Calc {
	public int calculate() {
		return a + b;
	}
}

class Sub2 extends Calc {
	public int calculate() {
		return a - b;
	}
}

class Mul2 extends Calc{
	public int calculate() {
		return a * b;
	}
}

class Div2 extends Calc {
	public int calculate() {
		return a / b;
	}
}

public class Calculator2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num1, num2;
		char op;
		
		System.out.print("input two operands and operator >> ");
		num1 = scanner.nextInt();
		num2 = scanner.nextInt();
		op = scanner.next().charAt(0);
		
		switch(op) {
		case '+':
			Add2 add2 = new Add2();
			add2.setValue(num1, num2);
			System.out.println(add2.calculate());
			break;
		case '-':
			Sub2 sub2 = new Sub2();
			sub2.setValue(num1, num2);
			System.out.println(sub2.calculate());
			break;
		case '*':
			Mul2 mul2 = new Mul2();
			mul2.setValue(num1, num2);
			System.out.println(mul2.calculate());
			break;
		case '/':
			Div2 div2 = new Div2();
			div2.setValue(num1, num2);
			System.out.println(div2.calculate());
			break;
		}
	}
}
