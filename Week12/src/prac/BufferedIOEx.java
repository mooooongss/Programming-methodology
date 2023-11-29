package prac;

import java.io.*;
import java.util.Scanner;

public class BufferedIOEx {
	public static void main(String[] args) {
		FileReader fin = null;
		int c;
		
		try {
			fin = new FileReader("C:\\Temp\\test2.txt");
			BufferedOutputStream out = new BufferedOutputStream(System.out, 5);
			
			while ((c = fin.read()) != -1) {
				out.write(c);		// 버퍼가 꽉 찰 때 (5byte read) 문자가 화면에 출력됨
			}
			
			// 파일 데이터가 모두 출력된 상태
			// new Scanner(System.in).nextLine();		// <Enter> 키 입력 기다림
			
			// out.flush();		// 버퍼에 남아 있던 문자 모두 출력
			
			// fin.close();
			// out.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
