package xyz.itwill.other;

import xyz.itwill.access.ProtectedMember;

public class ProtectedMemberOtherInheritanceUse extends ProtectedMember {
	public void run() {
		//부모클래스(ProtectedMember)의 필드 또는 메소드 사용
		num=100;
		display();
	}
}