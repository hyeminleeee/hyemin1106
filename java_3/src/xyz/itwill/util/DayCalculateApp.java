package xyz.itwill.util;

import java.util.Date;
import java.util.Scanner;

//키보드로 생년월일을 입력받아 오늘까지 살아온 날짜(일)을 계산하여 출력하는 프로그램 작성
//ex) 생년월일 입력[ex. 2000-01-01] >> 2024-05-12
//    [결과]태어난지 <1일>이 지났습니다.
//=> 형식에 맞지 않는 생년월일 입력한 경우 에러 메세지 출력 후 프로그램 종료(try catch 사용)
public class DayCalculateApp {
	public static void main(String[] args) {
		//스캐너 객체 이용해서 년월일 입력받기
		//심플데이트포맷 이용해서 패턴 지정해 문자열을 date 객체로 바꿈
		//오늘, 생년월일 date 객체를 뺴기
		//스캐너, 데이트, 심플데이트포맷 클래스 이용
		
		Scanner scanner=new Scanner(System.in);
		
		System.out.print("생년월일 입력[ex. 2000-01-01] >> ");
		
		String birth=scanner.nextLine();
		
		scanner.close();
		
		Date now=new Date();
		
		long currentTime=now.getTime();
		
		
		Date wnatDate=new Date(birth);
		long wantTime=wnatDate.getTime();
		
		System.out.println("[결과]태어난지 <"+((currentTime-wantTime)/(1000*86400))+"일>이 지났습니다.");
		
	}
}
