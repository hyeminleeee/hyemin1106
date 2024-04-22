package basic;

public class VairableApp {
	public static void main(String[] args) {
		int su;//정수값을 저장하기 위한 변수 선언 - 메로리에 su 이름의 변수 생성
		//대입연산자(=)를 사용하여 값을 변수에 저장
		su=100;
		System.out.print("초기값 = ");
		System.out.println(su);//변수에 저장된 값을 제공받아 화면에 출력 - 출력 명령
		
		//int su; - 동일한 이름으로 변수 선언할 경우 에러
		 su=200;
		 System.out.print("변경값 = ");
		 System.out.println(su);
		 System.out.println("====================================================");
		 int num=100;//변수 선언 및 초기값 저장
		 //"문자열"+값 또는 값+"문자열" >> 문자열에 값을 결합한 결과값(문자열)을 제공하는 연산식
		 System.out.println("num ="+num);
		 System.out.println("====================================================");
		 System.out.println("");
	}
}
