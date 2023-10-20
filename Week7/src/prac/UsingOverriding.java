package prac;

public class UsingOverriding {
	public static void main(String[] args) {
		Shape start, last, obj;
		
		// using linked list to connect shape objects
		start = new Line();		// Connect Line object
		last = start;
		
		obj = new Rect();		// Connect Rect object
		last.next = obj;
		last = obj;
		
		obj = new Line();		// Connect Line object
		last.next = obj;
		last = obj;

		obj = new CCircle();		// Connect CCircle object
		last.next = obj;
		
		// print elements in linked list
		Shape p = start;
		while(p != null) {
			p.draw();
			p = p.next;
		}
	}

}
