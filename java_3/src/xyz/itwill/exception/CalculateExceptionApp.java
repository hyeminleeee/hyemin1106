package xyz.itwill.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

//키보드로 정수값 2개를 입력받아 첫번째 정수값에서 두번째 정수값을 나눈 몫을 계산하여 출력하는 프로그램
public class CalculateExceptionApp {
	//public CalculateExceptionApp() throws InputMismatchException, ArithmeticException {
	public CalculateExceptionApp() throws Exception {//메소드에서 발생되는 모든 예외 전달
		Scanner scanner=new Scanner(System.in);
		
		System.out.print("첫번째 정수값 입력 >> ");
		//Scanner.nextInt() : 입력값을 얻어와 정수값으로 변환하여 반환하는 메소드
		//=> 입력값을 정수값으로 변환할 수 없는 경우 InputMismatchException 발생
		//=> 예외처리하지 않고 예외 전달
		int num1=scanner.nextInt();
		
		System.out.print("두번째 정수값 입력 >> ");
		int num2=scanner.nextInt();
		
		
		//어떤수를 [0]으로 나눈 경우 ArithmeticException 발생
		//=> 예외처리하지 않고 예외 전달
		System.out.println("[결과]"+num1+" / "+num2+" = "+(num1/num2));
		
		scanner.close();
	}
	
	public static void main(String[] args) {
		/*
		try {
			//new 연산자로 클래스의 생성자를 호출하여 객체 생성 - 생성자의 명령 실행
			//=> 생성자에서 전달된 예외에 대한 예외처리
			new CalculateExceptionApp();
		} catch (InputMismatchException e) {
			System.out.println("[에러]형식에 맞는 값을 입력해 주세요.");
		} catch (ArithmeticException e) {
			System.out.println("[에러]0으로 나눌 수 없습니다.");
		} catch (Exception e) {//모든 예외를 전달받아 예외처리
			System.out.println("[에러]프로그램 실행에 예기치 못한 오류가 발생되었습니다.");
		}
		*/
		
		//catch 블럭에서 예외클래스를 | 연산자로 연결하여 다수의 예외클래스의 객체를 전달받아 
		//예외처리 가능
		try {
			//new 연산자로 클래스의 생성자를 호출하여 객체 생성 - 생성자의 명령 실행
			//=> 생성자에서 전달된 예외에 대한 예외처리
			new CalculateExceptionApp();
		} catch (InputMismatchException | ArithmeticException e) {
			System.out.println("[에러]형식에 맞는 값을 입력해 주세요.");
		} catch (Exception e) {//모든 예외를 전달받아 예외처리
			System.out.println("[에러]프로그램 실행에 예기치 못한 오류가 발생되었습니다.");
		}
	}
}