package xyz.itwill.dao;

public class ReviewDAO extends JdbcDAO {
	private static ReviewDAO _dao;
	
	public ReviewDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new ReviewDAO();
	}
	
	public static ReviewDAO getDao() {
		return _dao;
	}
	
	
}
