package xyz.itwill.leehyemin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

//DAO(Data Access Object) 클래스 : 저장매체에 행을 삽입, 변경, 삭제, 검색하는 기능을 제공하는
//객체를 생성하기 위한 클래스 - 테이블 갯수만큼 생성

//MEMBER 테이블에 행을 삽입, 변경, 삭제, 검색하는 기능의 메소드가 작성된 DAO 클래스
public class MemberDAOImpl extends JdbcDAO{
private static MemberDAOImpl _dao;
	
	public MemberDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new MemberDAOImpl();
		
	}
	
	public static MemberDAOImpl getDAO() {
		return _dao;
	}
	
	//매개변수로 회원정보(MemberDTO 객체)를 전달받아 MEMBER 테이블에 행으로 삽입하여 저장하고
	//삽입행의 갯수를 반환하는 메소드
	//MemberDTO 객체에 저장 된 정보 : 회원추가 다이얼로그 TF에 입력한 정보와 TYPE 컬럼을 변경하여
	//자동 검색된 가격과 기간도 추가된 값
	public int insertMember(MemberDTO member) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		int rows=0;
		
		try {
			con=getConnection();
			
			String sql="insert into member values(?,?,?,?,?,?,?)";
			//String sql="insert into member values(?,?,?,?,?,?,?,?,?)";//membertype 테이블에 있는 컬럼 추가
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, member.getNo());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getBirth());
			pstmt.setString(4, member.getGender());
			pstmt.setString(5, member.getPhone());
			pstmt.setString(6, member.getType());
			pstmt.setString(7, member.getStardate());
			pstmt.setString(8, member.getPrice());
			pstmt.setString(9, member.getDuringdate());
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]insertStudent() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
		
	}
	//매개변수로 회원정보(MemberDTO 객체)를 전달받아 MEMBER 테이블에 저장된 행을 변경하고
	//변경행의 갯수를 반환하는 메소드
	public int updateMember(MemberDTO member) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		
		
		return 0;
		
	}
	
}





















