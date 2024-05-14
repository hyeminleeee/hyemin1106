package xyz.itwill.util;

import java.util.Objects;

//VO 클래스(Value Object) : 객체를 하나의 값으로 표현하기 위한 클래스
// => Set 캨게
//=> VO 클래스의 객체의 모든 필드값을 변경하지 못하도록 final 제한자를 사용하여 작성 - 데이타 불변
//=> final 제한자로 작성된 필드는 매개변수가 작성된 생성자로 반드시 초기화 처리 - 매개변수가 없는
//기본 생성자를 작성하면 에러 발생
//=> final 제한자로 작성된 필드는 Setter 메소드로 필드값을 변경할 수 없으므로 Getter 메소드만 작성
//=> 객체를 하나의 값으로 비교하기 위해 Object 클래스의 equals() 메소드와 hashCode() 메소드를
//반드시 오버라이딩 선언
//=> 객체에 저장된 필드값을 검증하여 사용하기 위해 선언하는 클래스
//=> VO 클래스 대신 Record 자료형으로 선언하여 사용 가능

//사용자정보(아이디, 이름, 이메일)를 저장하기 위한 클래스
//=> Set 객체는 객체에 동일한 사용자정보(UserVO 객체)가 저장되는 것을 방지하기 위해 VO 클래스로 선언
public class UserVO {
	private final String id;
	private final String name;
	private final String email;
	
	/*
	public UserVO() {
		// TODO Auto-generated constructor stub
	}	
	*/
	
	public UserVO(String id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	/*
	public void setId(String id) {
		this.id = id;
	}
	*/


	public String getName() {
		return name;
	}

	/*
	public void setName(String name) {
		this.name = name;
	}
	*/


	public String getEmail() {
		return email;
	}

	/*
	public void setEmail(String email) {
		this.email = email;
	}
	*/

	//필드값을 문자열로 변환하여 반환하는 메소드
	//=> Object 클래스의 toString() 메소드를 오버라이딩 선언
	@Override
	public String toString() {
		return "{"+id+", "+name+", "+email+"}";
	}
	
	//메소드를 호출한 객체(this)와 매개변수로 전달받은 객체의 필드값을 비교한 결과값을 반환하는 메소드
	//=> 객체의 필드값이 다른 경우 [false]를 반환하고 같은 경우 [true]를 반환하는 메소드
	@Override
	public boolean equals(Object obj) {
		//매개변수로 전달받은 객체를 명시적 객체 형변환하여 자식클래스의 참조변수에 저장
		UserVO userVO=(UserVO)obj;
		
		//Objects 클래스 : 객체를 비교하거나 [null]을 검사하기 위한 기능을 제공하는 클래스
		//Objects.equals(Object value1, Object value2) : 매개변수로 전달받은 객체(값)를 비교하여
		//결과값을 논리값으로 반환하는 정적메소드 - NullPointException 발생 방지
		return Objects.equals(this.id, userVO.id);//사용자정보의 아이디를 비교한 결과 반환
	}
	
	
	//객체의 필드값을 해싱기법을 사용해 정수값으로 변환하여 반환하는 메소드
	@Override
	public int hashCode() {
		//Objects.hashCode(Object o) : 매개변수로 전달받은 객체의 필드값을 해싱기법으로 변환된
		//정수값으로 반환하는 메소드 - 메소드를 호출한 객체의 메모리 주소(hasthCode) 반환
		return Objects.hashCode(id);
	}
	
}


















