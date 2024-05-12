package xyz.itwill.lang;

import java.util.Scanner;

//키보드로 하나의 사칙 연산식을 입력받아 연산결과를 계산하여 출력하는 프로그램 작성
//ex) 연산식 입력 >> 20 + 10
//    [결과]30
// => 입력 연산식에서 사용 가능한 연산자는 사칙 연산자(*, /, +, -)만 허용
// => 형식에 맞지 않는 연산식이 입력될 경우 에러 메세지 출력 후 프로그램 종료
// => 입력 연산식에 공백 입력이 가능하도록 처리
public class ConsoleCalculateApp {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		String number;
		while(true) {
			System.out.print("연산식 입력 >> ");
			
			number=scanner.nextLine();
			
		//	if(number.) break;
		
		
			scanner.close();
			
			String serparation=number.substring(3, 4);
			
			if(serparation.equals("+") || serparation.equals("/") || serparation.equals("+") || serparation.equals("-")) {
				break;
			} else {
				System.out.println("[에러]연산식이 형식에 맞지 않게 입력되었습니다."); break;
			}
			
			
			
			//System.out.println("[결과]"+Integer.parseInt(num1)+Integer.parseInt(num2));
		}
	}
}