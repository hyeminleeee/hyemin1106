package xyz.itwill.dbcp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Properties 파일 : 프로그램 실행에 필요한 값을 제공하기 위한 텍스트 파일
//=> 파일의 확장자를 [properties]로 저장하며 Properties 파일에는 [이름 = 값] 형식의 문자열을 행단위로 저장
//=> Properties 파일로 제공되는 값을 이름으로 구분하여 사용하므로 이름이 중복되지 않도록 작성
//=> Properties 파일에는 영문자, 숫자, 일부 특수문자를 제외한 문자는 유니코드로 자동 변환
//=> 프로그램에서 자주 변경되는 값을 Properties 파일로 제공받으면 프로그램의 유지보수 효율 증가

//[user.properties] 파일에 저장된 값을 얻어와 출력하는 프로그램 작성
public class PropertiesApp {
	public PropertiesApp() throws IOException {
		//Properties 파일에 저장된 내용을 읽기 위한 입력스트림 생성
		//=> Properties 파일의 경로를 제공받아 FileInputStream 클래스로 입력스트림 생성
		//=> 프로그램 배포시 파일 경로에 문제 발생
		//FileInputStream in=new FileInputStream("src/xyz/itwill/dbcp/user.properties");
		
		//Object.getClass() : 실행 중인 명령이 작성된 클래스에 대한 Class 객체를 반환하는 메소드
		//Class 객체 : 메소드에 만들어진 클래스에 대한 정보가 저장된 객체
		//Class.getClassLoader() : Class 객체를 생성한 ClassLoader 객체를 반환하는 메소드
		//ClassLoader 객체 : 클래스 파일(XXX.class)을 읽어 메모리에 Class 객체로 생성하는 객체
		//ClassLoader.getResourceAsStream(String name) : 매개변수로 프로젝트의 존재하는 파일의
		//경로를 제공받아 입력스트림을 생성하여 반환하는 메소드
		InputStream in=getClass().getClassLoader().getResourceAsStream("xyz/itwill/dbcp/user.properties");
		
		//Properties 클래스로 객체 생성
		//=> Properties 클래스는 Map 인터페이스를 상속받은 콜렉션 클래스
		//=> Properties 객체에는 다수의 엔트리(Entry)를 저장하여 사용
		Properties properties=new Properties();
		
		//Properties.load(InputStream in) : 매개변수로 Properties 파일을 읽기 위한 입력스트림을
		//전달받아 Properties 파일을 [이름=값] 형식의 문자열을 Properties 객체의 엔트리로
		//추가하는 메소드
		properties.load(in);
		
		//Properties.get(String key) : Properties 객체에 저장된 엔트리 중 매개변수로 전달받은
		//맵키(Key)에 대한 엔트리의 맵값(Value)을 반환하는 메소드
		//=> 맵값은 Object 자료형의 객체로 반환되므로 반드시 명시적 객체 형변환하여 사용
		//=> Properties 객체의 맵값은 무조건 String 객체로 형변환하여 사용
		String id=(String)properties.get("id");
		String name=(String)properties.get("name");
		String email=(String)properties.get("email");
		
		System.out.println("아이디 = "+id);
		System.out.println("이름 = "+name);
		System.out.println("이메일 = "+email);
	}
	
	public static void main(String[] args) throws IOException {
		new PropertiesApp();	
	}
}































