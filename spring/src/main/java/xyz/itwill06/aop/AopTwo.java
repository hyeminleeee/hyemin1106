package xyz.itwill06.aop;

//핵심관심코드만 사용하여 작성된 메소드가 선언된 클래스 - 핵심관심모듈
public class AopTwo implements AopTarget {

	@Override
	public void display1() {
		System.out.println("*** AopTwo 클래스의 display1() 메소드 호출 ***");
		
	}

	@Override
	public void display2() {
		System.out.println("*** AopTwo 클래스의 display2() 메소드 호출 ***");
		
	}

	@Override
	public void display3() {
		System.out.println("*** AopTwo 클래스의 display3() 메소드 호출 ***");
		
	}

}
