package collection.treeset;

import java.util.TreeSet;
import java.util.Iterator;

import collection.Member;

public class MemberTreeSet {
	private TreeSet<Member> treeSet;
	
	public MemberTreeSet() {
		treeSet = new TreeSet<>(new Member());
	}

	public void addMember(Member m) {
		treeSet.add(m);
	}
	
	public boolean removeMember(int memberId) {

		Iterator<Member> iterator = treeSet.iterator();
		while(iterator.hasNext()) {
			Member member = iterator.next();
			if(memberId == member.getMemberId()) {
				treeSet.remove(member);
				return true;
			}
		}
		
		System.out.println(memberId + "가 존재하지 않습니다.");
		return false;
	}
	
	public void showAll() {
		for(Member m : treeSet) {
			System.out.println(m);
		}
	}
	
}
