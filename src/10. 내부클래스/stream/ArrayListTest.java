package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> arr = new ArrayList<>();
		
		arr.add("bbb");
		arr.add("aaa");
		arr.add("ccc");
		
		Stream<String> stream = arr.stream();
		stream.forEach(s -> System.out.println(s));
		
		arr.stream().sorted().forEach(s -> System.out.println(s));
	}

}
