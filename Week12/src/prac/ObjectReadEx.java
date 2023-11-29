package prac;

import java.io.*;

public class ObjectReadEx {
	public static void main(String[] args) {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Temp\\tmp.txt"));
			Object s = ois.readObject();
			Box mybox = (Box)ois.readObject();
			System.out.println(s);
			System.out.println("Box width: " + mybox.width);
			System.out.println("Box height: " + mybox.height);
			System.out.println("Box depth: " + mybox.depth);
			System.out.println("Double Value: " + ois.readDouble());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
