package collection.hashmap;

import collection.Member;
import collection.treeset.MemberTreeSet;

public class MemberHashMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MemberHashMap memberHashMap = new MemberHashMap();
		Member memberKim = new Member(102, "김유신");
		Member memberLee = new Member(101, "이순신");
		Member memberShin = new Member(103, "신사임당");
		
		memberHashMap.addMember(memberLee);
		memberHashMap.addMember(memberKim);
		memberHashMap.addMember(memberShin);
		
		memberHashMap.showAll();
		// vector의 toString은 [] 안에 element를 전부 보여주고 있다.
		
		Member memberLee2 = new Member(101, "이몽룡");
		memberHashMap.addMember(memberLee2);
		
		memberHashMap.removeMember(102);
		
		memberHashMap.showAll();
	}

}
