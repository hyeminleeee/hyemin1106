package xyz.itwill.exception;

public class ExceptionThrowsApp {
	//예외가 발생된 명령의 메소드에서 예외처리를 하지 않고 예외가 발생된 메소드를 호출한
	//명령에게 발생된 예외 전달 가능
	//형식) 접근제한자 반환형 메소드명(자료형 변수명, ...) throws 예외클래스, 예외클래스,...{
	//			예외가 발생될 수 있는 명령;
	//			...
	//		}
	//=> 메소드 머릿부에 throws 키워드를 사용하여 메소드에서 발생된 모든 예외 전달
	public static void display() throws ArrayIndexOutOfBoundsException {
		int[] array ={10, 20, 30, 40, 50};
		
		for(int i=0;i<=array.length;i++) {
			System.out.println("array["+i+"] = "+array[i]);
		}
	}

	public static void main(String[] args) {
		try {
			//정적메소드는 정적메소드가 작성된 클래스를 사용하여 호출
			//ExceptionThrowsApp.display();
			//같은 클래스의 정적메소드는 클래스 없이 호출 가능
			display();//메소드 호출한 명령에서 전달된 예외 발생 - 예외처리
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("[에러]프로그램 실행에 예기치 못한 오류가 발생되었습니다.");
		}
	}
}
