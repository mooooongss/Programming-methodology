package prac;

public class Circle {
	private final double PI = 3.14;
	
	public int radius;
	public String name;
	
	public Circle() {
		
	}
	
	public double getPI() {
		return this.PI;
	}
	
	public double getArea() {
		return this.PI * radius * radius;
	}
	
	public static void main(String[] args) {
		System.out.println("Class and Object Practice");
	}
}
