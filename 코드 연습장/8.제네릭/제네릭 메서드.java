/**
 * 제네릭 메서드를 활용한 최대 최소를 찾는 법을 작성합니다.
 * @Djunnni
 * 2023-03-01
 */
public class GenericTest {
	public static void main(String[] args) {
		GenericTest gt = new GenericTest();
		gt.testGetMax();
	}
	public void testGetMax() {
		System.out.println(getMax(1,2,3));
		System.out.println(getMax(3,1,2));
		System.out.println(getMax(2,3,1));
		System.out.println(getMax("a","b","c"));
		System.out.println(getMax("b", "c", "a"));
		System.out.println(getMax("a","c","b","f"));
		System.out.println(getMax("f","F"));
		
		
		System.out.println(getMin(1,2,3));
		System.out.println(getMin(3,1,2));
		System.out.println(getMin(2,3,1));
		System.out.println(getMin("a","b","c"));
		System.out.println(getMin("b", "c", "a"));
		System.out.println(getMin("a","c","b","f"));
		System.out.println(getMin("f","F"));
	}
	public <T extends Comparable<T>> T getMax(T ...a) {
		T maxT = a[0];
		
		for(T tempA : a) {
			if(tempA.compareTo(maxT) > 0) maxT = tempA;
		}
		return maxT;
	}
	
	public <T extends Comparable<T>> T getMin(T ...a) {
		T minT = a[0];
		
		for(T tempA : a) {
			if(minT.compareTo(tempA) > 0) minT = tempA;
		}
		return minT;
	}
}
