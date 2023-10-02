public class EnumEx {
	public static void main(String[] args) {
		enum Week { 월, 화, 수, 목, 금, 토, 일 };
		
		// values() method returns all enumerated elements in an array in sequential order
		for(Week day : Week.values())
			System.out.println(day + "요일 ");
		
		System.out.println();
		
		
		// ordinal() returns the enumerated order of an element as an integer value
		// index value starts from 0 and values increase sequentially
		for(Week day : Week.values())
			System.out.println(day + "요일 has values " + day.ordinal());
		
		System.out.println();
		
		// valueOf() returns the element in the enumeration
		// that has a name matching the String provided as a parameter
		Week weekTest1 = Week.목;
		Week weekTest2 = Week.valueOf("토");
		
		System.out.println(weekTest1);
		System.out.println(weekTest2);
		
		System.out.println();
		
		// associate characters with constants, you should use a semicolon
		enum WeekEng {
			월("Mon"),
			화("Tue"),
			수("Wed"),
			목("Thu"),
			금("Fri"),
			토("Sat"),
			일("Sun");
			
			final private String engName;
			private WeekEng(String name) {
				this.engName = name;
			}
			
			public String getName() {
				return engName;
			}
		};
		
		for(WeekEng day : WeekEng.values()) {
			System.out.println(day.getName());
		}
	}
}
