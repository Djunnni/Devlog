package collection.treemap;

import collection.Member;

public class MembeTreeMapTest {
	public static void main(String[] args) {
		MemberTreeMap memberHashSet = new MemberTreeMap();
		
		Member memberLee = new Member(101, "이순신");
		Member memberKim = new Member(102, "김유신");
		Member memberShin = new Member(103, "신사임당");
		
		memberHashSet.addMember(memberLee);
		memberHashSet.addMember(memberKim);
		memberHashSet.addMember(memberShin);
		
		memberHashSet.showAll();
		// vector의 toString은 [] 안에 element를 전부 보여주고 있다.
		
		Member memberLee2 = new Member(101, "이몽룡");
		memberHashSet.addMember(memberLee2);
		
		memberHashSet.removeMember(memberKim.getMemberId());
		memberHashSet.showAll();
	}

}
