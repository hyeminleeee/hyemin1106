package xyz.itwill.app;

import xyz.itwill.subject.JavaSubject;
import xyz.itwill.subject.OracleSubject;
import xyz.uniwill.subject.NetworkSubject;

//패키지(Package) : 같은 목적의 Java 자료형(참조형)을 명확히 구분하여 저장하기 위한 폴더(디렉토리)
//=> Java 자료형 : 클래스(Class), 인터페이스(Interface), 열거법(Enum), 레코드(Record), 어노테이션(Annotation)
//=> Java 자료형을 쉽게 구분하여 사용하기 위해 패키지를 사용하는 것을 권장

//패키지는 프로그램을 개발하는 그룹(개인)의 도메인을 역방향으로 나열하여 작성한 후 작업명을
//지정하여 작성하는 것을 권장
//=> 도메인(Domain) : 인터넷에서 개인 또는 그룹이 사용하는 컴퓨터를 표현하기 위해 제공되는
//문자로된 고유의 네트워크 식별자
//ex) itwill.xyz >> 패키지 : xyz.itwill.app

//Java 자료형을 선언할 때 Java 소스파일의 처음 위치에 Java 자료형이 선언된 패키지를 반드시 작성
//형식) package 패키지경로;
//=> package 선언문으로 Java 자료형이 특정 패키지에 존재하는지를 명확히 구분하여 사용

//import : 다른 패키지에 작성된 Java 자료형을 명확히 표현하여 제공하기 위한 키워드
//형식) import 패키지경로.자료형
//=> Java 자료형 대신 [*] 기호 사용하여 패키지의 작성된 모든 Java 자료형 제공 가능
//=> package 선언문 뒤에 작성하고 Java 자료형 선언 전에 작성
//이클립스에서는 프로그램 작성에 필요한 Java 자료형을 import 선언문으로 처리하거나 불필요한
//Java 자료형의 import 선언문을 제거하는 기능 제공
//=> [Ctrl]+[Shift]+[O] - import 선언문을 정리하는 단축키

public class SubjectApp {
	public static void main(String[] args) {
		//같은 패키지에 선언된 Java 자료형은 패키지 경로를 표현하지 않아도 Java 자료형 사용 가능
		//다른 패키지에 선언된 Java 자료형은 패키지 경로를 반드시 표현해야만 Java 자료형 사용 가능
		//xyz.itwill.subject.OracleSubject subject1=new xyz.itwill.subject.OracleSubject();
		
		
		//다른 패키지에 선언된 Java 자료형 import 처리하면 패키지 경로를 표현하지 않고
		//Java 자료형 사용 가능
		OracleSubject subject1=new OracleSubject();
		subject1.display();
		
		//이클립스에서는 다른 패키지의 Java 자료형을 사용할 경우 import 선언문을 자동으로 생성하는 기능 제공
		//=> 형식) 자료형 이름 >> [Ctrl]+[Space]
		NetworkSubject subject2=new NetworkSubject();
		subject2.display();
		
		//같은 이름의 Java 자료형이 여러개인 경우 패키지를 잘 구분하여 자료형 선택하여 사용
		JavaSubject subject3=new JavaSubject();
		subject3.display();
		
		//같은 이름의 Java 자료형이 이미 import 처리되어 있는 경우 import 처리 불가능
		//=> 패키지 경로를 표현하여 Java 자료형을 사용 
		xyz.uniwill.subject.JavaSubject subject4=new xyz.uniwill.subject.JavaSubject();
		subject4.display();
	}
}
