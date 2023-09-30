public class EnumEx {
	public static void main(String[] args) {
		enum Week { 월, 화, 수, 목, 금, 토, 일 };
		
		for(Week day : Week.values())
			System.out.println(day + "요일 ");
		
		System.out.println();
		
		for(Week day : Week.values())
			System.out.println(day + "요일 has values " + day.ordinal());
		
		System.out.println();
		
		Week weekTest1 = Week.목;
		Week weekTest2 = Week.valueOf("토");
		
		System.out.println(weekTest1);
		System.out.println(weekTest2);
		
		System.out.println();
	}

}
