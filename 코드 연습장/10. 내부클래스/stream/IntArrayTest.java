package stream;

import java.util.Arrays;

public class IntArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5};
		
		int sum = Arrays.stream(arr).sum();
		System.out.println(sum);
		// �ѹ� ������ ��Ʈ���� �ѹ� ���� ��������. �ٽ� ������ �Ѵ�.
		
		int count = (int) Arrays.stream(arr).count();
		System.out.println(count);
		
		int v = Arrays.stream(arr).reduce(0, (a, b) -> (int) (Math.sqrt(a) + Math.sqrt(b)));
		System.out.println(v);
	}

}
