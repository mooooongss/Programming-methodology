package prac;

class Person {
	// field declaration
	private int weight;
	int age;
	protected int height;
	public String name;
	
	public void setWeight(int weight) {
		// code for setWeight
		this.weight = weight;
	}
	
	public int getWeight() {
		// code for getWeight()
		return weight;		
	}
}

class NewStudent extends Person {
	public void set() {
		// code for set()
		age = 30;
		name = "홍길동";
		height = 170;
		setWeight(99);
	}
}

public class InheritanceEx {

	public static void main(String[] args) {
		NewStudent s = new NewStudent();
		s.set();
		System.out.println("나이: " + s.age + "살");
		System.out.println("이름: " + s.name);
		System.out.println("키: " + s.height + "cm");
		System.out.println("몸무게: " + s.getWeight() + "kg");
	}
}
