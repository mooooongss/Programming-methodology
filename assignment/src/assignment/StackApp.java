package assignment;

import java.util.Scanner;

interface Stack {
	int length();	// 현재 스택에 저장된 개수 리턴
	int capacity();	//스택의 전체 저장 가능한 개수 리턴
	String pop();	//스택의 톱(top)에 실수 저장
	boolean push(String val);	//스택의 톱(top)에 저장된 실수 리턴
}

class StringStack implements Stack {
	private String[] input;
	private int top;
	
	public StringStack(int size) {
		input = new String[size];
		top = -1;	//-1로 초기화
	}

	@Override
	public int length() {
		return top + 1;
	}

	@Override
	public int capacity() {
		return input.length;
	}

	@Override
	public String pop() {
		if (top == -1)
			return null;
		String string = input[top];
		top--;
		return string;
	}

	@Override
	public boolean push(String val) {
		if(top == input.length-1)
			return false;
		else {
			top++;
			input[top] = val;
			return true;
		}
	}
}
public class StackApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("총 스택 저장 공간의 크기 입력 >> ");
		int num = scanner.nextInt();
		
		StringStack stringstack = new StringStack(num);
		while (true) {
			System.out.print("문자열 입력 >> ");
			String string = scanner.next();
			if(string.equals("그만"))
				break;
			boolean full = stringstack.push(string);
			if(full == false) {
				System.out.println("스택이 꽉 차서 푸시 불가!");
			}	
		}
		System.out.print("스택에 저장된 모든 문자열 팝: ");
		int length = stringstack.length();
		for(int i = 0; i < length; i++) {
			System.out.print(stringstack.pop() + " ");
		}
		scanner.close();
	}
}
