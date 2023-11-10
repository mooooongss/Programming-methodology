package prac;

class MyPoint {
	private int x, y;
	
	// default constructor that sets (x, y) as (0, 0)
	public MyPoint() {
		this.x = 0;
		this.y = 0;
	}
	
	// constructor with arguments (x, y) that sets x and y
	
	public MyPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void showPoint() { // 점의 좌표 출력
		System.out.println("(" + x + ", " + y + ")");
	}
}

class ColorPoint extends MyPoint {
	private String color; // 점의 색
	
	// constructor with arguments (x, y, color) that sets x, y and color
	// call superclass's constructor using super()
	public ColorPoint(int x, int y, String color) {
		super(x, y);
		this.color = color;
	}
	
	public void showColorPoint() { // 컬러 점의 좌표 추력
		System.out.print(color + " ");
		showPoint(); // Point 클래스의 showPoint() 호출
	}
}

public class ColorPointEx {
	public static void main(String[] args) {
		ColorPoint cp = new ColorPoint(5, 6, "blue");
		cp.showColorPoint();
	}
}
