package prac;

class Shape {	// super class
	public Shape next;
	public Shape() {
		next = null;
	}
	
	public void draw() {
		System.out.println("Shape");
	}
}

class Line extends Shape {
	// Method overriding
	public void draw() {
		System.out.println("Line");
	}
}

class Rect extends Shape {
	// Method overriding
	public void draw() {
		System.out.println("Rect");
	}
}

class CCircle extends Shape {
	// Method overriding
	public void draw() {
		System.out.println("Circle");
	}
}
public class MethodOverridingEx {
	static void paint(Shape p) {
		// call draw() of the object that p references
		p.draw();
	}
	
	public static void main(String[] args) {
		Line line = new Line();
		
		paint(line);
		paint(new Shape());
		paint(new Line());
		paint(new Rect());
		paint(new CCircle());
	}
}
