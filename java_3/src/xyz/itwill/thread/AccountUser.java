package xyz.itwill.thread;
//은행계좌를 사용할 수 있는 사용자 정보(은행계좌정보, 사용자명)를 저장하기 위한 클래스
public class AccountUser {
	//생성자 또는 Setter 메소드로 필드에 객체를 저장하여 포함관계 완성
	private Account account;
	private String userName;
	
	public AccountUser() {
		// TODO Auto-generated constructor stub
	}

	public AccountUser(Account account, String userName) {
		super();
		this.account = account;
		this.userName = userName;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userNameString) {
		this.userName = userNameString;
	}
	
	
}
