package basic;


public class TypeCastApp {
	public static void main(String[] args) {
		//자동형변환 : 자료형이 다른값을 연산하기 위해 JVM이 값의 자료형을 일시적으로 변환하여 사용하는 방법
		//=> 표현의 범위가 작은 자료의 값을 큰 자료형의 값으로 형변환하여 연산처리
		//=>byte >> short >> char >> int >> long >> float >> double
		System.out.println("결과 ="+(3+1.5));

		int kor=95, eng=90;
		int tot=kor+eng;
		//double avg=tot/2; - 연산결과값 : 정수값
		double avg=tot/2.;// 연산결과값 : 실수값
		System.out.println("총점 ="+tot+", 평균 ="+avg);
		
		//int 자료형보다 작은 자료형의 값을 연산할 경우 무조건 int 자료형으로 자동 형변환되어 연산 처리
		byte su1=10, su2=20;
		//byte su3=su1+su2;//byte+byte > int+int > int(연산 결과값)-byte변수에 저장
		int su3=su1+su2;
		System.out.println("su3="+su3);
		System.out.println("====================================================");
		
		int num=(int)12.3;
		System.out.println("num ="+num);
		
		int num1=95, num2=10;
		//double num3=num1 / num2;//연산결과값 : 9 > 변수값 : 9.0(자동형변환)
		double num3=(double)num1 / num2;//강제형변환
		System.out.println("num3 ="+num3);
		
		
		int num4=100_000_000, num5=30;
		//문제점)정수값은 4byte(-2147483648~21478483647)로 표현되므로 연산 결과값이 4byte의 표현범위를
		//벗어날 경우 잘못된 결과값이 변수에 저장 - 실행오류
		//int num6=num4*num5;
		//해결법 연산 결과값이 4byte의 표현범위를 벗어날 경우 8byte(long)로 처리뢰도록 피연산자를 강제 
		//형변환하여 연산처리 - 연산 결과값을 저장할 변수도 long으로 선언
		long num6=(long)num4*num5;
		System.out.println("num6 ="+num6);
		
		double number=1.23456789;
		System.out.println("number ="+number);
		
		//변수에 저장된 실수값을 소수점 2번째 자리까지만 출력되도록 변환
		System.out.println("number(내림) ="+(int)(number*100)/100.);
		System.out.println("number(반올림) ="+(int)(number*100+0.5)/100.);
		System.out.println("number(올림) ="+(int)(number*100+0.9)/100.);
		
	}

}
