package xyz.itwill.nested;

public class OuterThreeApp {
	public static void main(String[] args) {
		OuterThree outerThree=new OuterThree(100);
		outerThree.outerDisplay();
		System.out.println("=======================================================");
		//메소드 호출시 지역 내부클래스가 메모리에 저장되고 객체 생성
		outerThree.local();
		System.out.println("=======================================================");
	}
}
