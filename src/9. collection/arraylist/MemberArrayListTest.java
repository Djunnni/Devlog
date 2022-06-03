package collection.arraylist;

import collection.Member;

public class MemberArrayListTest {
	public static void main(String[] args) {
		MemberArrayList memberArrayList = new MemberArrayList();
		
		Member memberLee = new Member(101, "이순신");
		Member memberKim = new Member(102, "김유신");
		Member memberShin = new Member(103, "신사임당");
		
		memberArrayList.addMember(memberLee);
		memberArrayList.addMember(memberKim);
		memberArrayList.addMember(memberShin);
		
		memberArrayList.showAll();
		// vector의 toString은 [] 안에 element를 전부 보여주고 있다.
		
		memberArrayList.removeMember(memberKim.getMemberId());
		memberArrayList.removeMember(memberKim.getMemberId());
		memberArrayList.showAll();
	}
}
