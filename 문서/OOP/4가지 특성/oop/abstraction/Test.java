package oop.abstraction;

public class Test {
	// Computer로 형태를 잡아두고 공통의 특성(변수, 메서드)를 묶어둔다.
	public static void main(String[] args) {
		SamsungLaptop sLaptop = new SamsungLaptop();
		MacBook macBook = new MacBook();
		
		macBook.runOs();
		sLaptop.runOs();
	}
}
