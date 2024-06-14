package xyz.itwill.project;

/*
 이름         널? 유형           
---------- -- ------------ 
TYPE          VARCHAR2(10) 
DURINGDATE    VARCHAR2(20) 
PRICE         VARCHAR2(20)
 */

public class MemberTypeDTO {
	private String type;	
	private String price;
	private String duringDate;
	
	public MemberTypeDTO() {
		// TODO Auto-generated constructor stub
	}

	public MemberTypeDTO(String type, String duringDate, String price) {
		super();
		this.type = type;
		this.price = price;
		this.duringDate = duringDate;
		
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	
	public String getDuringDate() {
		return duringDate;
	}

	public void setDuringDate(String duringDate) {
		this.duringDate = duringDate;
	}
	
}
