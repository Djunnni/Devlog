package collection.treemap;

import collection.Member;

public class MembeTreeMapTest {
	public static void main(String[] args) {
		MemberTreeMap memberHashSet = new MemberTreeMap();
		
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
		memberHashSet.showAll();
	}

}
