
/**
 * String 예시
 * @author djunnni
 * UTF-8 SET이 기본이면
 결과
 => 
 -19 -107 -100 -22 -72 -128 
 한글
 * UTF-16 이면
 * -57 -47 -79 -37
 * 한글
 */
public class StringSample {
	public static void main(String[] args) {
		StringSample sample = new StringSample();
		sample.convert16();
	}
	public void convert() {
		try {
			String korean = "자바의신";
			byte[] array1 = korean.getBytes("UTF-8");
			printByteArr(array1);
			
			String korean2 = new String(array1);
			System.out.println(korean2);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void convert16() {
		try {
			String korean = "자바의신";
			byte[] array1 = korean.getBytes("UTF-16");
			printByteArr(array1);
			
			String korean2 = new String(array1, "UTF-16");
			System.out.println(korean2);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void printByteArr(byte[] array) {
		for(byte data : array) {
			System.out.print(data + " ");
		}
		System.out.println();
	}
}
