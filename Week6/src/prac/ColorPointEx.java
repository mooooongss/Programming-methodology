package prac;

class MyPoint {
	private int x, y;
	
	public void set(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// print out the coordination of the Point
	public void showPoint() {
		System.out.println("x = " + x + ", y = " + y);
	}
}

// code for ColorPoint that inherit (extends) MyPoint class
class ColorPoint extends MyPoint {
	private String color;
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void showColorPoint() {	// color point의 좌표 출력
		System.out.println(color);
		showPoint();
	}
}

public class ColorPointEx {

	public static void main(String[] args) {
		MyPoint p = new MyPoint();	// create MyPoint object
		p.set(1, 2);	// Call set() of MyPoint class
		p.showPoint();
		
		ColorPoint cp = new ColorPoint();	// object of ColorPoint
		cp.set(3, 4);	// Call set() of MyPoint class
		cp.setColor("red");		// Call setColor() of ColorPoint class
		cp.showColorPoint();	// print color and coordination
	}

}
