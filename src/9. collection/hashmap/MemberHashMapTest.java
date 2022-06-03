package collection.hashmap;

import collection.Member;
import collection.treeset.MemberTreeSet;

public class MemberHashMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MemberHashMap memberHashMap = new MemberHashMap();
		Member memberKim = new Member(102, "������");
		Member memberLee = new Member(101, "�̼���");
		Member memberShin = new Member(103, "�Ż��Ӵ�");
		
		memberHashMap.addMember(memberLee);
		memberHashMap.addMember(memberKim);
		memberHashMap.addMember(memberShin);
		
		memberHashMap.showAll();
		// vector�� toString�� [] �ȿ� element�� ���� �����ְ� �ִ�.
		
		Member memberLee2 = new Member(101, "�̸���");
		memberHashMap.addMember(memberLee2);
		
		memberHashMap.removeMember(102);
		
		memberHashMap.showAll();
	}

}
