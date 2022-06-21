package stream;

import java.util.Arrays;
import java.util.function.BinaryOperator;

class CompareString implements BinaryOperator<String> {

	@Override
	public String apply(String s1, String s2) {
		if(s1.getBytes().length <= s2.getBytes().length) {
			return s1;
		} else return s2;
	}
	
}

public class ReduceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] greetings = {"¾È³çÇÏ¼¼¿ä~~~~.","hello", "Good Morning"};
		
		String a = Arrays.stream(greetings).reduce("", (s1, s2) -> {
			if(s1.getBytes().length >= s2.getBytes().length) {
				return s1;
			} else return s2;
		});
		System.out.println(a);
		a = Arrays.stream(greetings).reduce(new CompareString()).get();
		System.out.println(a);
	}

}
