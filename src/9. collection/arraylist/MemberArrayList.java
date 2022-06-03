package collection.arraylist;

import java.util.ArrayList;
import java.util.Iterator;

import collection.Member;

public class MemberArrayList {
	private ArrayList<Member> arrayList;
	
	public MemberArrayList() {
		arrayList = new ArrayList<>();
	}
	
	public void addMember(Member m) {
		arrayList.add(m);
	}
	
	public boolean removeMember(int memberId) {
		
//		for(int i=0; i < arrayList.size(); i++) {
//			Member m = arrayList.get(i);
//			int tempId = m.getMemberId();
//			if(tempId == memberId ) {
//				arrayList.remove(i);
//				return true;
//			}
//		}
		
		Iterator<Member> iterator = arrayList.iterator();
		while(iterator.hasNext()) {
			Member member = iterator.next();
			if(memberId == member.getMemberId()) {
				arrayList.remove(member);
				return true;
			}
		}
		
		System.out.println(memberId + "가 존재하지 않습니다.");
		return false;
	}
	
	public void showAll() {
		for(Member m : arrayList) {
			System.out.println(m);
		}
		// System.out.println(arrayList);
	}
	
}
