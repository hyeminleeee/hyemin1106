package sunday;

import java.util.Scanner;

//키보드로 점수를 입력받아 학점을 계산하여 출력하는 프로그램
//=> 100~90 : A, 89~80 : B, 79~70 : C, 69~60 : D, 59~0 : F
//=> 입력된 점수가 0~100 범위의 정수값이 아닌 경우 에러 메세지 출력 후 재입력 받도록 처리
public class InputCheckApp {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		
		int score;
		 do {
			 System.out.print("점수를 입력하세요 >> ");
			 score=scanner.nextInt();
			 if(score < 0 || score >100) {
				 System.out.println("[에러]0~100범위의 점수를 입력해주세요.");
			 }
		 } while(score <0 || score >100);
		 String grade="";
		 switch(score /10) {
		 case 10 : grade="A"; break;
		 case 9 : grade="A"; break;
		 case 8 : grade="B"; break;
		 case 7 : grade="C"; break;
		 case 6 : grade="D"; break;
		 default : grade="F"; break;
		 }
			 
		 System.out.println("점수 : "+score+", 학점 : "+grade);
		
		 scanner.close();
	}
}
