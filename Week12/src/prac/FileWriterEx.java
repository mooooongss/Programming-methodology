package prac;

import java.io.*;
import java.util.Scanner;

public class FileWriterEx {
	public static void main(String[] args) {
		Scanner sin = new Scanner(System.in);
		
		// 파일에 저장할 문자열
		String source = "말고 만은 사람 중에 그대 한 사람 \n"
				+ "너무 맑고 초롱한 그 중 하나 별이여 \n"
				+ "그대만큼 사랑스러운 사람을 본 일이 없다\n";
		
		System.out.print("Enter filename: ");
		String s = sin.next();
		
		try {
			// 파일 명으로 FileWriter 객체 생성
			FileWriter fw = new FileWriter(s);
			
			fw.write(source);
			fw.close();
			
			System.out.print(s + " file created");
		} catch (IOException e) {
			System.out.println("Failed to create file " + s + e.getMessage());
			e.printStackTrace();
		}
	}
}