package xyz.itwill.thread;

public class AccountUserApp {
	public static void main(String[] args) {
		//Account 클래스로 객체를 생성하여 참조변수에 저장 - 은행계좌 생성
		Account account=new Account(10000);
		
		//AccountUser 클래스로 객체를 생성하여 참조변수에 저장
		//=> 동일한 은행계좌를 사용할 수 있는 다수의 사용자 생성
		AccountUser userOne=new AccountUser(account, "홍길동");
		AccountUser userTwo=new AccountUser(account, "임꺽정");
		AccountUser userThree=new AccountUser(account, "전우치");
		
		//사용자(AccountUser 객체)로부터 은행계좌(Account 객체)를 제공받아 입금 처리(메소드 호출)
		//=> 단일스레드(main 스레드)를 이용해 객체를 참조해 메소드 호출
		//=> 단일스레드를 사용하므로 동시 입금 처리 불가능
		userOne.getAccount().disposit(userOne.getUserName(), 5000);
		userTwo.getAccount().disposit(userTwo.getUserName(), 5000);
		userThree.getAccount().disposit(userThree.getUserName(), 5000);
		
	}
}
