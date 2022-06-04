package lambda;

public class TestStringConcat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// �������̽� / �ѹ� ����� ��� �� ��,
		// ������ �������̽� implements �޼��嵵 ������.
		StringConcatImpl sImpl = new StringConcatImpl();
		sImpl.makeString("hello", "java");
		
		// ���� / �ѹ�������
		// �ϳ��� �޼��常
		StringConcat concat = (s1,s2) -> System.out.println(s1 + " " + s2);
		concat.makeString("hello", "java");
		
		// �͸� ����Ŭ���� / �ѹ�������
		// �������� �������̽��� �Ѳ����� implements ����
		// �ϳ��� �������̽��� �ϳ��� �߻�Ŭ����
		StringConcat concat2 = new StringConcat() {
			 public void makeString(String s1, String s2) {
				 System.out.println(s1 + " " + s2);
			 }
		};
		
		concat2.makeString("hello", "java");
	}

}
