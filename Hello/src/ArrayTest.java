import java.util.Scanner;

public class ArrayTest {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int i;
		double sum = 0.0, avg;
		// one-dimensional array declaration & instantiation
		double dnum[] = new double[5];
		
		// find out length of the array using length property
		System.out.println("length of dnum array: " + dnum.length);
		System.out.print("uninitialized dnum[] values: ");
		// using length property for loop condition
		// print out uninitialized array element values
		for(i = 0; i < dnum.length; i++)
			System.out.print(dnum[i] + " ");
		System.out.println();
		
		// array initialization using for loop
		for(i = 0; i < dnum.length; i++) {
			System.out.print("dnum[" + i + "] value: ");
			dnum[i] = stdin.nextDouble();
		}
		
		// calculate sum of the array elements
		for(i = 0; i < dnum.length; i++) {
			sum += dnum[i];
		}
		
		System.out.println("sum of the array elements: " + sum);
		avg = sum / dnum.length;
		System.out.println("the average of the array elements: " + avg);
	}
}
