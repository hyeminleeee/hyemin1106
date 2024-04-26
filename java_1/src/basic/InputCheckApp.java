package basic;

import java.util.Scanner;

//키보드로 점수를 입력받아 학점을 계산하여 출력하는 프로그램
//=> 100~90 : A, 89~80 : B, 79~70 : C, 69~60 : D, 59~0 : F
// => 입력된 점수가 0~100 범위의 정수값이 아닌 경우 에러 메세지 출력 후 재입력 받도록 처리
public class InputCheckApp {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		/*
		System.out.print("점수 입력[0~100] >>");
		int score=scanner.nextInt();
		*/
		
		//변수의 비정상적인 값을 저장해야만 반복문이 실행된다.
		int score=-1;
		
		//비정상적인 점수가 입력된 경우 반복문을 실행하고 정상적인 점수가 입력된 경우 반복문 종료
		while(score<0 || score > 100) {
			System.out.print("점수 입력[0~100] >>");
			score=scanner.nextInt();
			
		}
		
		String grade="";
		switch (score/10) {
		case 10: 
		case 9: grade="A"; break;
		case 8: grade="B"; break;
		case 7: grade="C"; break;
		case 6: grade="D"; break;
		default: grade="F"; break;
		}
		
		System.out.println("[결과]"+score+"점 = "+grade+"학점");
		
		scanner.close();
}
}
