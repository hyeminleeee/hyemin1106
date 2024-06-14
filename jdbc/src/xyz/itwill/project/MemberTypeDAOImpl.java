package xyz.itwill.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberTypeDAOImpl extends JdbcDAO {
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
	
	public List<MemberTypeDTO> selectMembertpyeAll(String type) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<MemberTypeDTO> membertypeList=new ArrayList<MemberTypeDTO>();
		try {
			con=getConnection();
			
			String sql="select price,duringdate from member natural join membertype";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, type);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				MemberTypeDTO memberType=new MemberTypeDTO();
				memberType.setPrice(rs.getString("price"));
				memberType.setDuringDate(rs.getString("duringdate"));
				
				membertypeList.add(8, memberType);
			}
			
		} catch (SQLException e) {
			System.out.println("[에러]selectMembertpyeAll() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		
		return null;
		
	}

}
