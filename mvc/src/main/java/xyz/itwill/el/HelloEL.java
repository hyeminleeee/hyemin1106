package xyz.itwill.el;

//EL 표현식에서 EL 함수를 사용할 경우 호출될 정적 메소드를 작성하기 위한 클래스
public class HelloEL {
	//EL 표현식에서 EL 함수를 사용할 경우 호출될 정적 메소드
	// => 매개변수로 값을 전달받아 처리한 후 결과값을 반환하는 명령 작성
	public static String hello(String name) {
		return name+"님, 안녕하세요.";
	}
}
