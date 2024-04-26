package basic;

//import : 다른 패키지의 클래스를 소스파일에서 사용할 수 있도록 제공하는 키워드.
import java.util.Scanner;

//사용자로부터 키보드로 이름과 나이를 입력받아 화면에 출력.
public class ScannerApp {
	public static void main(String[] args) {
		//Scanner 클래스 : 입력스트림을 제공받아
		
		Scanner scanner=new Scanner(System.in);
		
		
		//참조변수에 저장된 객체를 사용하여 메소드 호출
		//scanner.nextLine() : Scanner 객체를 사용하여 입력값을 문자열로 변환하여 반환하는 메소드
		//키보드로 입력된 값을 문자열로 변환하여 반환받아 변수에 저장
		//=> 키보드 입력값이 없는 경우 프로그램의 흐름(스레드)가 일시 중지
		//=> 키보드로 값을 입력한 후 엔터를 눌러 프로그램의 흐름이 재실행되도록 처리.
		System.out.print("이름 입력 >> ");
		String name=scanner.nextLine();//엔터를 꼭 눌러줘야함.
		
		//scanner.nextLine() : Scanner 객체를 사용하여 입력값을 정수열로 변환하여 반환하는 메소드
		System.out.print("나이 입력 >> ");
		//키보드로 입력된 값을 정수값로 변환하여 반환받아 변수에 저장
		// => 입력값이 정수값이 아닌 경우 예외(Exception) 발생 - 예외 발생 시 프로그램 강제 종료
		int age=scanner.nextInt();		

		System.out.println("[결과]"+name+"님의 나이는 "+age+"살입니다.");
		
		//scanner.close() : Scanner 객체가 사용한 입력스트림을 제거하는 메소드
		scanner.close();
		
		
		
	}

}
