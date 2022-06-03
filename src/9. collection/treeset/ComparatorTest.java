package collection.treeset;

import java.util.Comparator;
import java.util.TreeSet;

class MyCompare implements Comparator<String> {
	@Override
	public int compare(String str1, String str2) {
		if(str1.length() == str2.length()) {
			return str1.compareTo(str2) * -1;
		} else {
			return 1;
		}
	}
}
public class ComparatorTest {

	public static void main(String[] args) {
		// Comparator<String>�� �� �Ÿ� default�� �ϳ� Set�� ���� �־��ֱ�.
		TreeSet<String> tree = new TreeSet<>(new MyCompare());
		tree.add("aaa");
		tree.add("bbb");
		tree.add("ccc");
		tree.add("accc");
		System.out.println(tree);

	}

}
