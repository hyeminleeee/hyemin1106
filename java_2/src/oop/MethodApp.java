package oop;

//프로그램 실행을 목적으로 작성된 클래스 - main() 메소드 작성
public class MethodApp {
	//JVM(Java Virtual Machine)에 의해 자동 호출되는 메소드 - 프로그램 실행의 시작점
	public static void main(String[] args) {
		//클래스로 객체를 생성하여 객체의 메모리 주소를 참조변수에 저장
		//=>같은 패키지에 작성된 클래스는 패키지를 표현하지 않아도 클래스 사용 가능
		Method method=new Method();
		
		//참조변수를 출력할 경우 "클래스@메모리주소" 형식의 문자열을 변환되어 출력 처리
		System.out.println("method = "+method);
		System.out.println("====================================================");
		//참조변수에 저장된 메모리 주소로 객체를 참조하여 객체로 클래스에 작성된 메소드 호출
		//=>메소드를 호출하면 프로그램의 흐름(스레드)이 메소드로 이동하여 메소드의 명령을
		//실행하고 메소드가 종료되면 다시 되돌아와 다음 명령을 실행
	}

}
