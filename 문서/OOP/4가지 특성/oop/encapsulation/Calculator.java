package oop.encapsulation;

public class Calculator {
	// result에 대한 캡슐화
	private int result;
	
	public void plus(int i, int j) {
		result = i + j;
	}
	public void divide(int i, int j) {
		if(j == 0) {
			System.out.println("[에러] 0으로 나눌 수 없습니다.");
			return;
		}
		result = i / j;
	}
	public void printResult() {
		System.out.println("결과는 "+result + " 입니다.");
	}
	
	public static void main(String[] args) {
		Calculator cal = new Calculator();
		
		cal.plus(5, 11);
		cal.printResult();
		cal.divide(4, 0);
		cal.printResult();
	}
}
