package xyz.itwill.Record;

public class MemberOneApp {
	public static void main(String[] args) {
		MemberOne memberOne=new MemberOne("abc123", "홍길동", "abc@itwill.xyz");
		
		System.out.println("아이디 = "+memberOne.getId());
		System.out.println("이름 = "+memberOne.getName());
		System.out.println("이메일 = "+memberOne.getEmail());
	}
}
