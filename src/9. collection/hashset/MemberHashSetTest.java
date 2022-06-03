package collection.hashset;

import collection.Member;
import collection.arraylist.MemberArrayList;

public class MemberHashSetTest {
	public static void main(String[] args) {
		MemberHashSet memberHashSet = new MemberHashSet();
		
		Member memberLee = new Member(101, "�̼���");
		Member memberKim = new Member(102, "������");
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
