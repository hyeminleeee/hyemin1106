package xyz.itwill.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

//키보드로 정수값을 입력받아 변수에 저장된 비밀번호와 비교하여 결과를 출력하는 프로그램
public class PasswardMatchApp {
	public static void main(String[] args) {
		/*
		int password=123456;//비밀번호가 저장된 변수
		
		Scanner scanner=new Scanner(System.in);
		
		System.out.print("비밀번호 입력 >> ");
		int number=scanner.nextInt();
		
		if(number == password) {
			System.out.println("[결과]키보드로 입력한 비밀번호가 맞습니다.");
		} else {
			System.out.println("[결과]키보드로 입력한 비밀번호가 틀립니다.");
		}
		
		scanner.close();
		*/
		
		Scanner scanner=new Scanner(System.in);
		int password=123456;//비밀번호가 저장된 변수
		
		try {
			System.out.print("비밀번호 입력 >> ");
			int number=scanner.nextInt();
			
			if(number != password) {
				//예외클래스로 객체를 생성하여 인위적 예외 발생
				//형식) throw new 예외클래스(값, 값,...);
				//=> 예외클래스의 매개변수(예외메세지)가 작성된 생성자로 객체 생성
				
				//인위적으로 발생되는 예외에 대한 예외클래스는 직접 작성하여 사용하는 것을 권장
				//=> 발생되는 예외를 명확히 구분하여 예외처리 가능
				//throw new RuntimeException("[결과]키보드로 입력된 비밀번호가 틀립니다.");
				
				throw new PasswardMissmatchException("[결과]키보드로 입력된 비밀번호가 틀립니다.");
			}
			
			System.out.println("[결과]키보드로 입력한 비밀번호가 맞습니다.");
			scanner.close();
		} catch (InputMismatchException e) {
			System.out.println("[에러]숫자만 입력 가능합니다.");
		} catch (PasswardMissmatchException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("[에러]프로그램 실행에 예기치 못한 오류가 발생되었습니다.");
		} finally {
			scanner.close();
		}
		
	}
}
