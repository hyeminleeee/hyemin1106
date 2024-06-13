package xyz.itwill.project;

public class MemberTypeDAOImpl extends JdbcDAO implements MemberTypeDAO {
	private static MemberTypeDAOImpl _typeDao;
	
	public MemberTypeDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_typeDao=new MemberTypeDAOImpl();
	}
	
	public static MemberTypeDAOImpl geTypeDao() {
		return _typeDao;
	}
	
	@Override
	public MemberTypeDAO selectDuringDateByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberTypeDAO selectPriceeByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

}
