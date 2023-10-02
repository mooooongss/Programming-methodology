package lib;

// specify class as public to allow access from other package
// (classes in app package)
public abstract class Calculator {
	public abstract int add(int a, int b);
	public abstract int subtract(int a, int b);
	public abstract double average(int[] a);
}
