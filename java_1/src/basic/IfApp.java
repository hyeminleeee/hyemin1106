package basic;

public class IfApp {
	public static void main(String[] args) {
		int su=90;
		//변수값이 50인 이상인 경우 변수값을 화면에 출력 프로그램 작성
		if(su >= 50) System.out.println("su = "+su);//명령이 하나면 블럭을 쓸 필요 없다.
		System.out.println("==============================================================");
		
		//변수값이 60인 이상인 경우 합격메세지/미만인 경우 불합격메세지 화면에 출력 프로그램 작성
		/*int score=50;
		if (score >= 60) {
			System.out.println("[결과]점수가 60점 이상이므로 <합격>입니다.");
		}
		if (score < 60) {
			System.out.println("[결과]점수가 60점 미만이므로 <불합격>입니다.");
			
		}*/
		
		int score=50;
		if (score >= 60) {
			System.out.println("[결과]점수가 60점 이상이므로 <합격>입니다.");
		}
		else {
			System.out.println("[결과]점수가 60점 미만이므로 <불합격>입니다.");
			
		}
		
		int num=10;
		if(num % 2 != 0) {
			System.out.println(num+" = 홀수");
		} 
		else {
			System.out.println(num+" = 짝수");
		}
		
		char mun='0';
		
		//변수값을 영문자 또는 비영문자로 구분하여 출력하는 프로그램 작성
		if(mun >= 'a' && mun <= 'z' || mun >= 'A' && mun <= 'Z') {
			System.out.println("[결과]"+mun+" = 영문자");
		} else {
			System.out.println("[결과]"+mun+" = 비영문자");
		}
		System.out.println("==============================================================");
		
		/*boolean bool=true;
		if(bool == true) {
			System.out.println("현재 변수값은 [true]입니다.");
		} else {
			System.out.println("현재 변수값은 [false]입니다.");
		}
		System.out.println("==============================================================");
		*/

		boolean bool=false;
		if(bool) {
			System.out.println("현재 변수값은 [true]입니다.");
		} else {
			System.out.println("현재 변수값은 [false]입니다.");
		}
		System.out.println("==============================================================");

		}
		
	}

