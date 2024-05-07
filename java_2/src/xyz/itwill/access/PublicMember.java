package xyz.itwill.access;

//public : 클래스, 필드, 생성자, 메소드의 접근을 제한하기 위한 접근 제한자
//=> 클래스, 필드, 생성자, 메소드를 같은 패키지 및 다른 패키지의 클래스에서 사용 가능하도록
//설정하는 접근 제한자
public class PublicMember {
	public int num;
	
	public void display() {
		System.out.println("num = "+num);
	}

}
