import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class MapTest {
	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>();

		System.out.println(map.put("daniel", 22)); // null
		System.out.println(map); // {daniel=22}
		System.out.println(map.put("samsung", 100)); // null
		System.out.println(map); // {daniel=22, samsung=100}

		System.out.println(map.put("daniel", 32)); // 22
		System.out.println(map); // {daniel=32, samsung=100}
		System.out.println(map.put("kakao", 32));
		System.out.println(map.put("samsung", 52)); // 100
		System.out.println(map); // {daniel=32, samsung=52}

		Collection<Integer> collection = map.values(); // values는 collection 타입을 리턴한다.
		System.out.println(collection);
		System.out.println(new LinkedList<>(collection)); // linkedlist로 전환 시,

		Set<Map.Entry<String, Integer>> set = map.entrySet();
		for(Map.Entry<String, Integer> s : set) {
			System.out.println(s.getKey() + " - " + s.getValue());
		}

		System.out.println(map.containsKey("daniel"));
		System.out.println(map.containsKey("sk"));
		System.out.println(map.containsValue(32));
		System.out.println(map.containsValue(102));

		System.out.println(map.size());
	}
}
