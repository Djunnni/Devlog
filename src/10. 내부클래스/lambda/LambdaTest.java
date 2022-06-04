package lambda;

interface PrintString {
	void showString(String str);
}

public class LambdaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintString lambdaPrint = str -> System.out.println(str);
		lambdaPrint.showString("test");
		
		showMyString(lambdaPrint);
		
		PrintString reStr = returnPrint();
		reStr.showString("hello");
	}
	
	public static void showMyString(PrintString lambda) {
		lambda.showString("test2");
	}
	public static PrintString returnPrint() {
		return s -> System.out.println(s + " world");
	}
}
