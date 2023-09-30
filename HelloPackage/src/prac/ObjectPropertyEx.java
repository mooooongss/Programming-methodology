package prac;

class Point {
	private int x, y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	//public String toString() {
	//	return "Point(" + x + "," + y + ")";
	//}
}

public class ObjectPropertyEx {
	public static void print(Object obj) {
		System.out.println(obj.getClass().getName());
		System.out.println(obj.hashCode());
		System.out.println(obj.toString());
		System.out.println(obj);
	}
	
	public static void main(String[] args) {
		Point p = new Point(2, 3);
		print(p);
		
		//call toString() method
		//System.out.println(p.toString());
		//System.out.println(p);	// automatically convers p to p.toString()
		//System.out.println(p + "입니다.");
	}
}