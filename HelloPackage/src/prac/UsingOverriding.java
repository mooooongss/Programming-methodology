package prac;

public class UsingOverriding {

	public static void main(String[] args) {
		Shape start, last, obj;
		
		// using linked list to connect shape objects
		start = new Line();		// connect Line object
		last = start;
		
		obj = new Rect();		// connect Rect object
		last.next = obj;
		last = obj;
		
		obj = new Line();		// connect Line object
		last.next = obj;
		last = obj;
		
		obj = new CCircle();	// connect CCircle object
		last.next = obj;
		
		// print elements in linked list
		Shape p = start;
		while (p != null) {
			p.draw();
			p = p.next;
		}
	}
}
