package fitness;
/*
 이름        널? 유형           
--------- -- ------------ 
NO           NUMBER(4)    
NAME         VARCHAR2(20) 
BIRTHDAY     VARCHAR2(30) 
GENDER       VARCHAR2(10) 
PHONE        VARCHAR2(30) 
TYPE         VARCHAR2( 20) 
STARTDATE    VARCHAR2(20) 
 */
public class MemberDTO {//회원정보 저장하는 객체 생성하는 클래스
	private int no;
	private String name;
	private String birth;
	private String gender;
	private String phone;
	private String type;
	private String stardate;
	private String price;
	private String duringdate;
	
	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}

	public MemberDTO(int no, String name, String birth, String gender, String phone, String type, String stardate,
			String price, String duringdate) {
		super();
		this.no = no;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.phone = phone;
		this.type = type;
		this.stardate = stardate;
		this.price = price;
		this.duringdate = duringdate;
	}
	public MemberDTO(int no, String name, String birth, String gender, String phone, String type, String stardate
			) {
		super();
		this.no = no;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.phone = phone;
		this.type = type;
		this.stardate = stardate;
		
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStardate() {
		return stardate;
	}

	public void setStardate(String stardate) {
		this.stardate = stardate;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDuringdate() {
		return duringdate;
	}

	public void setDuringdate(String duringdate) {
		this.duringdate = duringdate;
	}
	
}