package xyz.itwill.Record;

public class MemberTwoApp {
	public static void main(String[] args) {
		MemberTwo member=new MemberTwo("abc123", "홍길동", "abc@itwill.xyz");
		
		System.out.println("아이디 = "+member.id());
		System.out.println("이름 = "+member.name());
		System.out.println("이메일 = "+member.email());
	}

}
