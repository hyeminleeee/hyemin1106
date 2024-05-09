package xyz.itwill.enumerate;

//클래스 또는 인터페이스에 상수필드를 작성할 경우 발생될 수 있는 문제점
// => 상수필드를 값을 대표하는 이름으로 사용하기 부적절한 경우 발생
// => 상수필드가 작성된 클래스 또는 인터페이스를 자료형보다는 상수필드를 사용하기 위한 접근 용도로만 제공
//Java 언어에서는 클래스 또는 인터페이스에 상수필드를 작성하여 발생될 수 있는 문제점을 해결
//하기 위해 열거형(Enumerate)이라는 자료형(참조형) 제공
public class InterfaceApp {
	public static void main(String[] args) {
		//인터페이스에 작성된 상수필드 출력 - 필드에 저장된 값 출력
		System.out.println("삽입(InterfaceOne.INSERT) = "+InterfaceOne.INSERT);
		System.out.println("변경(InterfaceOne.UPDATE) = "+InterfaceOne.UPDATE);
		System.out.println("삭제(InterfaceOne.DELETE) = "+InterfaceOne.DELETE);
		System.out.println("검색(InterfaceOne.SELECT) = "+InterfaceOne.SELECT);
		System.out.println("==============================================================");
		System.out.println("삽입(InterfaceTwo.ADD) = "+InterfaceTwo.ADD);
		System.out.println("변경(InterfaceTwo.MODIFY) = "+InterfaceTwo.MODIFY);
		System.out.println("삭제(InterfaceTwo.REMOVE) = "+InterfaceTwo.REMOVE);
		System.out.println("검색(InterfaceTwo.SEARCH) = "+InterfaceTwo.SEARCH);
		System.out.println("==============================================================");
		//인터페이스로 변수를 생성하여 상수필드값 저장 불가능
		//InterfaceOne choice=InterfaceOne.INSERT;//에러 발생
		//상수필드의 자료형과 동일한 자료형으로 변수를 생성해야만 상수필드값 저장 가능
		int choice=InterfaceOne.INSERT;
		System.out.println("choice = "+choice);
		System.out.println("==============================================================");
		switch(choice) {
		//case InterfaceOne.INSERT:
		case InterfaceTwo.ADD:
			System.out.println("# 학생정보를 삽입합니다.");
			break;
		case InterfaceOne.UPDATE:
			System.out.println("# 학생정보를 변경합니다.");
			break;
		case InterfaceOne.DELETE:
			System.out.println("# 학생정보를 삭제합니다.");
			break;
		case InterfaceOne.SELECT:
			System.out.println("# 학생정보를 검색합니다.");
			break;	
		}
		System.out.println("==============================================================");
	}
}









