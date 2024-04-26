package example;

public class IfExample {
	public static void main(String[] args) {
		//변수에 저장된 문자값을 출력하세요.
		//단, 변수에 저장된 문자값이 소문자인 경우 대문자로 변환하여 출력하세요.
		char mun='x';
		if(mun >= 'a' && mun <= 'z') {
			System.out.println(mun-=32);
		} else {
			System.out.println(mun);
		}
			
		System.out.println("============================================================");
		/*<강사님풀이>
		 * char mun='x';
		 * 
		 * if(mun>='a' && mun <= 'z') {
		 * 		mun-=32;
		 * }
		 * 
		 * System.out.println("mun = "+mun);
		 * 
		 */
		
		
		//변수에 저장된 정수값이 4의 배수인지 아닌지를 구분하여 출력하세요.
		int num=345644;
			System.out.println(num+" = "+(num % 4 == 0 ? "4의 배수" : "4의 배수가 아님"));
		System.out.println("============================================================");
		
		/*<강사님풀이>
		 * 
		 * if(num % 4 == 0) {
		 * 		System.out.println(num+"는(은)  4의 배수가 맞습니다.");
		 * } else {
		 * 		System.out.println(num+"는(은)  4의 배수가 아닙니다.");
		 * }
		 */
		
		//이름이 [홍길동]인 학생이 국어점수 89점, 영어점수 93점, 수학점수 95점을 받은 경우
		//총점과 평균, 학점을 계산하여 이름, 총점, 평균, 학점을 출력하세요.
		// => 국어,영어,수학 점수 중 하나라도 0~100 범위가 아닌 경우 프로그램 강제 종료
		//    System.exit(0) : 프로그램을 강제로 종료하는 메소드
		// => 평균을 이용한 학점 계산 : 100~90:A, 89~80:B, 79~70:C, 69~60:D, 59~0:F
		// => 평균은 소숫점 두자리까지만 출력하고 나머지는 절삭 처리 하세요.
		
		/*String name = "홍길동";
		System.out.println("이름 : "+name);
		
		String grade = "";
		int kor=89, eng=93, mat=95;
		
		int tot=kor+eng+mat;
		System.out.println("총점 : "+tot);
		
		double avg=tot/3.0;
		System.out.println("평균 : "+(int)(avg*100)/100.);
		
		if(kor >= 0 && kor <= 100 || eng >= 0 && eng <= 100 || mat >= 0 && mat <= 100 ) {
			if(avg >= 90) {
				grade="A";
			} else if(avg >= 80) {
				grade="B";
			} else if(avg >= 70) {
				grade="C";
			} else if(avg >= 60) {
				grade="D";
			} else {
				grade="F";		
		} 
			System.out.println("학점 : "+grade);
		} else {
			System.out.println("[Error]0~100 범위를 벗어난 비정상적인 점수가 입력 되었습니다.");
			System.exit(0);
		}
		System.out.println("============================================================");
	*/
		
		//이름이 [홍길동]인 학생이 국어점수 89점, 영어점수 93점, 수학점수 95점을 받은 경우
		//총점과 평균, 학점을 계산하여 이름, 총점, 평균, 학점을 출력하세요.
		// => 국어,영어,수학 점수 중 하나라도 0~100 범위가 아닌 경우 프로그램 강제 종료
		//    System.exit(0) : 프로그램을 강제로 종료하는 메소드
		// => 평균을 이용한 학점 계산 : 100~90:A, 89~80:B, 79~70:C, 69~60:D, 59~0:F
		// => 평균은 소숫점 두자리까지만 출력하고 나머지는 절삭 처리 하세요.
		
		//강사님 풀이
		String name="홍길동";
		int kor=89, eng=93, mat=95;
		if(kor>100 || kor<0 || eng>100 || eng<0 || mat>100 || mat<0) {
			System.exit(0);
		}
		
		int tot=kor+eng+mat;
		double avg=tot/3.;
		
		String grade="";
		switch((int)avg/10) {
		case 10: grade="A"; break;
		case 9: grade="A"; break;
		case 8: grade="B"; break;
		case 7: grade="C"; break;
		case 6: grade="D"; break;
		default: grade="F"; break;
		}
		

		System.out.println("이름 : "+name+", 총점 : "+tot+", 평균 : "+(int)(avg*100)/100.+", 학점 : "+grade);

	}
}
