package collection.treeset;

import collection.Member;
import collection.arraylist.MemberArrayList;

public class MemberTreeSetTest {
	public static void main(String[] args) {
		MemberTreeSet memberHashSet = new MemberTreeSet();
		Member memberKim = new Member(102, "������");
		Member memberLee = new Member(101, "�̼���");
		Member memberShin = new Member(103, "�Ż��Ӵ�");
		
		memberHashSet.addMember(memberLee);
		memberHashSet.addMember(memberKim);
		memberHashSet.addMember(memberShin);
		
		memberHashSet.showAll();
		// vector�� toString�� [] �ȿ� element�� ���� �����ְ� �ִ�.
		
		Member memberLee2 = new Member(101, "�̸���");
		memberHashSet.addMember(memberLee2);
		
		memberHashSet.removeMember(memberKim.getMemberId());
		memberHashSet.removeMember(memberKim.getMemberId());
		memberHashSet.showAll();
	}

}
