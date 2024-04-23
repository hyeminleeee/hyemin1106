package basic;

//자료형(DataType) : 값 or 객체를 표현하기 위한 단어(키워드 또는 식별자)

public class DataTypeApp {
	public static void main(String[] args) {
		System.out.println("<<정수값(IntegerType)>>");
		System.out.println("정수값(10진수 100) = "+100);
		System.out.println("정수값(8진수 100) = "+0100);
		System.out.println("정수값(16진수 100) = "+0x0100);
		System.out.println("정수값(10진수 100) = "+100L);//정수값L : 10진수 - LongType(8Byte)
		System.out.println("==============================================");
		
		byte a1=127;//1Btye : -128~127
		short a2=32761;//2Byte : -32768~32767
		int a3=2147000;//4Btye : -2147483648~2147483647
		long a4=214748368;//8Btye
		
		System.out.println("a1 = "+a1);
		System.out.println("a2 = "+a2);
		System.out.println("a3 = "+a3);
		System.out.println("a4 = "+a4);
		System.out.println("==============================================");
		
		System.out.println("<<실수형(DoubleType)>>");
		System.out.println("실수값(4Byte) ="+12.3f);//실수값f>> 4Byte(FloatType)
		System.out.println("==============================================");
		
		float b1=1.23456789f;//소수점 7자리
		double b2=1.23456789;//소수점 15자리

		System.out.println("b1 ="+b1);
		System.out.println("b2 ="+b2);
		System.out.println("==============================================");
		
		System.out.println("<<문자형(CharacterType)>>");
		System.out.println("문자값 ="+'A');
		System.out.println("문자값 ="+'가');
		System.out.println("문자값 ="+'\'');
		System.out.println("==============================================");
		
		
		char c1='A';
		char c2=65;//문자변수에는 문자값 대신 약속된 정수값 저장 가능
		char c3='a'-32;//문자값에 대한 연산 가능

		System.out.println("c1 ="+c1);
		System.out.println("c2 ="+c2);
		System.out.println("c3 ="+c3);
		System.out.println("==============================================");
		
		System.out.println("<<논리형(BooleanType)>>");
		System.out.println("논리값 ="+false);
		System.out.println("논리값 ="+true);
		System.out.println("논리값 ="+(20 > 10));
		System.out.println("논리값 ="+(20 < 10));
		System.out.println("==============================================");
		
		boolean d1=false;
		boolean d2=20>10;//True
		
		System.out.println("d1 ="+d1);
		System.out.println("d2 ="+d2);
		System.out.println("==============================================");		
		
		System.out.println("<<문자열(StringType)>>");
		System.out.println("문자열 = "+"홍길동");
		System.out.println("문자열 = "+"유관순 열사가 \"대한민국 만세!!\"를 외쳤습니다.");
		
		String name="임꺽정";
		System.out.println("이름 ="+name);
		System.out.println("==============================================");
		
		
		
		
		
	}

}
