package assignment;

abstract class PairMap {
	protected String keyArray[]; // key 등을 저장하는 배열
	protected String valueArray[]; // value 등을 저장하는 배열
	abstract String get(String key); // key 값을 가진 value 리턴, 없으면 null 리턴
	abstract void put(String key, String value);
		// key와 value를 쌍으로 저장, 기존에 key가 있으면, 값을 value로 수정
	abstract String delete(String key);
		// key 값을 가진 아이템(value와 함께) 삭제, 삭제된 value 값 리턴
	abstract int length(); // 현재 저장된 아이템의 개수 리턴
}

class Dictionary extends PairMap {
	private int num;
	private int cnt = 0;
	
	public Dictionary(int num) {
		this.num = num;
		super.keyArray = new String[num];
		super.valueArray = new String[num];
	}
	
	@Override
	String get(String key) {
		for(int i = 0; i < cnt; i++) {
			if(key.equals(keyArray[i]))
				return valueArray[i];
		}
		return null;
	}
	
	@Override
	void put(String key, String value) {
		for(int i = 0; i < cnt; i++) {
			if(key.equals(keyArray[i])) {
				valueArray[i] = value;
				return;
			}
		}
		keyArray[length()] = key;
		valueArray[length()] = value;
		cnt++;
	}
	
	@Override
	String delete(String key) {
		for(int i = 0; i < num; i++) {
			if(key.equals(keyArray[i])) {
				valueArray[i] = "null";
				return "null";
			}
		}
		return null;
	}
	
	@Override
	int length() {
		return cnt;
	}
}

public class DictionaryApp {
	public static void main(String[] args) {
		Dictionary dic = new Dictionary(10);
		dic.put("스마트ICT융합공학과", "공과대학");
		dic.put("금속공예디자인학과", "조형대학");
		dic.put("인공지능응용학과", "창의융합대학");
		dic.put("스마트ICT융합공학과", "정보통신대학");
		// “스마트ICT융합공학과” 의 값을 “정보통신대학” 으로 수정
		System.out.println("인공지능응용학과는 " + dic.get("인공지능응용학과")); // value 출력
		System.out.println("금속공예디자인학과는 " + dic.get("금속공예디자인학과")); // value 출력
		System.out.println("스마트ICT융합공학과는 " + dic.get("스마트ICT융합공학과")); // value 출력
		dic.delete("금속공예디자인학과"); // item 삭제
		System.out.println("금속공예디자인학과는 " + dic.get("금속공예디자인학과"));
		// 삭제된 item 접근
	}
}
