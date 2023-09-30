public class ArrayException2 {
	public static void main(String[] args) {
		int[] intArray = new int[5];
		intArray[0] = 0;
		
		for(int i = 0; i < 5; i++) {
			try {
				intArray[i + 1] = i + 1 + intArray[i];
				System.out.println("intArray[" + i + "] = " + intArray[i]);
				
				if(i == 2) {
					System.out.println(intArray[i] / 0);
				}
			} catch (ArrayIndexOutOfBoundsException e1) {
				System.out.println("Exception: ArrayIndexOutOfBounds");
			} catch (ArithmeticException e2) {
				System.out.println("0");
			}
		}
	}
}