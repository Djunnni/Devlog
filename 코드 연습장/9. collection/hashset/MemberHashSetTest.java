package collection.hashset;

import collection.Member;
import collection.arraylist.MemberArrayList;

public class MemberHashSetTest {
	public static void main(String[] args) {
		MemberHashSet memberHashSet = new MemberHashSet();
		
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
		memberHashSet.removeMember(memberKim.getMemberId());
		memberHashSet.showAll();
	}

}
