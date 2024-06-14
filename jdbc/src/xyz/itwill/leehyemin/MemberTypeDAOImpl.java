package xyz.itwill.leehyemin;

public class MemberTypeDAOImpl extends JdbcDAO{
	private static MemberTypeDAOImpl _daoMemberType;
	
	public MemberTypeDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	static {
		_daoMemberType=new MemberTypeDAOImpl();
	}
	
	public static MemberTypeDAOImpl getDaoMemberType() {
		return getDaoMemberType();
	}
}
