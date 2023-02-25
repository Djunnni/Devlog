
public class StringCheck {
	public static void main(String[] args) {
		StringCheck sc = new StringCheck();
		
		String addresses[] = new String[] {
				"서울시 구로구 신도림동",
				"경기도 성남시 분당구 정자동 개발 공장",
				"서울시 구로구 개봉동"
		};
		// sc.checkAddress(addresses);
		// sc.checkMatch();
		sc.checkReplace();
	}
	public void checkAddress(String[] addresses) {
		int startCount = 0;
		int endCount = 0;
		
		String startText="서울시";
		String endText="동";
		
		for(String address : addresses) {
			if(address.startsWith(startText)) startCount++;
			if(address.endsWith(endText)) endCount++;
		}
		
		System.out.println(startCount);
		System.out.println(endCount);
	}
	/**
	 * false가 나오는 경우
	 * toffset이 음수
	 * ooffset이 음수
	 * toffset + len이 비교대상보다 길이가 클 때
	 * ooffset + len이 other객체의 길이보다 클 때
	 * ignoreCase가 false인경우 비교범위 문자중 같은 위치의 char가 다를 때
	 * ignoreCase가 true인 경우 비교범위 문자중 같은 위치의 char가 다를 때
	 * 
	 */
	public void checkMatch() {
		String text = "This is a text";
		String compare1 = "is";
		String compare2 = "this";
		
		System.out.println(text.regionMatches(2, compare1, 0, 1));
		System.out.println(text.regionMatches(5, compare1, 0, 2));
		System.out.println(text.regionMatches(true, 0, compare2, 0, 4));
	}
	public void checkReplace() {
		String text = "The String class represents character strings.";
		System.out.println(text.replace('s', 'z'));
		System.out.println(text);
		System.out.println(text.replace("tring", "trike"));
		System.out.println(text.replaceAll(" ", "|"));
		System.out.println(text.replaceFirst(" ", "|"));
	}
}
