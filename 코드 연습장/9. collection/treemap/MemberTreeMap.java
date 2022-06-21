package collection.treemap;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeMap;

import collection.Member;

class MyComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		return - o1 + o2;
	}
	
}
public class MemberTreeMap {
	private TreeMap<Integer, Member> treeMap;
	
	public MemberTreeMap() {
		treeMap = new TreeMap<>(new MyComparator());
	}
	public void addMember(Member member) {
		if(!treeMap.containsKey(member.getMemberId()))
			treeMap.put(member.getMemberId(), member);
	}
	public boolean removeMember(int memberId) {
		if(treeMap.containsKey(memberId)) {
			treeMap.remove(memberId);
			return true;
		} else {
			System.out.println(memberId + "멤버를 가지고 있지 않습니다.");
			return false;
		}
	}
	public void showAll() {
		Iterator<Integer> ir = treeMap.keySet().iterator();
		while(ir.hasNext()) {
			int key = ir.next();
			Member member = treeMap.get(key);
			System.out.println(member);
		}
	}
	
}
