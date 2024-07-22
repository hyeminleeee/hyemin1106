package xyz.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QnaDAO extends JdbcDAO  {
	private static QnaDAO _dao;
	
	public QnaDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new QnaDAO();
	}
	
	public static QnaDAO getDAO() {
		return _dao;
	}
	
	public int selectTotalQna(String search, String keyword) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		try {
			con=getConnection();
			
			if(keyword.equals("")) {
				String sql="selelct count(*) from qna";
				pstmt=con.prepareStatement(sql);
			} else {
				String sql="select count(*) from qna join member on qna_member=member_num"
						+"where"+search+"like '%'||?||'%'";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, keyword);
			}
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				count=rs.getInt(1);
			}	
		} catch (SQLException e) {
			System.out.println("[에러]selectTotalQna() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return count;
	}
}
