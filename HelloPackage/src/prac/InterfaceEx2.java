package prac;

interface PhoneInterface1 {  // 인터페이스 선언
	final int TIMEOUT = 10000; // 상수 필드 선언
	void sendCall(); // 추상 메소드
	void recieveCall(); // 추상 메소드
	default void printLogo() { // default 메소드
		System.out.println("** Phone **");
	}
}

interface MobilePhoneInterface extends PhoneInterface1 {
	void sendSMS();
	void recieveSMS();
}

interface MP3Interface { // 인터페이스 선언
	public void play();
	public void stop();
}

class PDA { //클래스 작성
	public int calculate(int x, int y) {
		return x + y;
	}
}
// SmartPhone 클래스는 PDA를 상속받고,
// MobilePhoneInterface와 MP3Interface 인터페이스에 선언된 추상 메소드를 모두 구현한다.

class SmartPhone extends PDA implements PhoneInterface1, MP3Interface { // 인터페이스 구현
	// MobilePhoneInterface의 추상 메소드 구현
	@Override
	public void sendCall() {
		System.out.println("따르릉따르릉~~");
	}
	
	@Override
	public void recieveCall() {
		System.out.println("전화 왔어요.");
	}
	
	//@Override
	public void sendSMS() {
		System.out.println("문자 갑니다.");
	}
	
	//@Override
	public void recieveSMS() {
		System.out.println("문자 왔어요.");
	}
	
	// MP3Interface의 추상 메소드 구현
	@Override
	public void play() {
		System.out.println("음악 연주합니다.");
	}
	
	@Override
	public void stop() {
		System.out.println("음악 중단합니다.");
	}
	
	// 추가로 작성한 메소드
	public void schedule() {
		System.out.println("일정 관리합니다.");
	}
}

public class InterfaceEx2 {
	public static void main(String[] args) {
		SmartPhone phone = new SmartPhone();
		phone.printLogo();
		phone.sendCall();
		phone.play();
		System.out.println("3과 5를 더하면 " + phone.calculate(3, 5));
		phone.schedule();
	}
}