package lambda;

public class TestStringConcat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 인터페이스 / 한번 만들고 계속 쓸 때,
		// 여러개 인터페이스 implements 메서드도 여러개.
		StringConcatImpl sImpl = new StringConcatImpl();
		sImpl.makeString("hello", "java");
		
		// 람다 / 한번쓰고만다
		// 하나의 메서드만
		StringConcat concat = (s1,s2) -> System.out.println(s1 + " " + s2);
		concat.makeString("hello", "java");
		
		// 익명 내부클래스 / 한번쓰고만다
		// 여러개의 인터페이스를 한꺼번에 implements 가능
		// 하나의 인터페이스는 하나의 추상클래스
		StringConcat concat2 = new StringConcat() {
			 public void makeString(String s1, String s2) {
				 System.out.println(s1 + " " + s2);
			 }
		};
		
		concat2.makeString("hello", "java");
	}

}
