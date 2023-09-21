public class WhileSample {
	public static void main(String[] args) {
		char c = 'a';
		
		//while(c <= 'z') {
		//	System.out.print(c);
		//	c = (char)(c + 1);
		//	}
		do {
			System.out.print(c);
			c = (char)(c + 1);
		} while(c <= 'z');
	}
}