package fitness;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


//삽입, 변경, 삭제, 검색 기능 제공하는 객체 생성 클래스
public class MemberDAOImpl extends JdbcDAO implements MemberDAO {
	private static MemberDAOImpl _dao;
	
	public MemberDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new MemberDAOImpl();
	}
	
	public static MemberDAOImpl getDao() {
		return _dao;
	}
	@Override
	public int insertMember(MemberDTO member) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		int rows=0;
		try {
			con=getConnection();
			
			String sql="insert into member values(?,?,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, member.getNo());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getBirth());
			pstmt.setString(4, member.getGender());
			pstmt.setString(5, member.getPhone());
			pstmt.setString(6, member.getType());
			pstmt.setString(7, member.getStardate());
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]insertStudent() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
		
	}
	@Override
	public int updateMember(MemberDTO member) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="update member set name=?,birth=?,gender=?,phone=?,type=?,startdate=? where no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getBirth());
			pstmt.setString(3, member.getGender());
			pstmt.setString(4, member.getPhone());
			pstmt.setString(5, member.getType());
			pstmt.setString(6, member.getStardate());
			pstmt.setInt(7, member.getNo());
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]updateStudent() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	/*
	@Override
	public int deleteMember(int no) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="delete from student where no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]deleteStudent() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return 0;
	}
	*/
	
	@Override
	public MemberDTO selectMemberByno(int no) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		MemberDTO member=null;
		try {
			con=getConnection();
			
			String sql="SELECT NO, NAME, BIRTH, GENDER, PHONE, TYPE, STARTDATE, PRICE, DURINGDATE "
					+ "FROM MEMBER NATURAL JOIN MEMBERTYPE WHERE NO=? order by startdate";
	
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				member=new MemberDTO();
				member.setNo(rs.getInt("no"));
				member.setName(rs.getString("name"));
				member.setBirth(rs.getString("birth"));
				member.setGender(rs.getString("gender"));
				member.setPhone(rs.getString("phone"));
				member.setType(rs.getString("type"));
				member.setStardate(rs.getString("startdate"));
				member.setPrice(rs.getString("price"));
				member.setDuringdate(rs.getString("duringdate"));
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectMemberByno() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return member;
	}
	/*
	@Override
	public List<MemberDTO> selectMemberByName(String name) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<MemberDTO> memberList=new ArrayList<MemberDTO>();
		try {
			con=getConnection();
			
			String sql="select no,name,birth,gender,phone,type,startdate from member where name=? order by no";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				//ResultSet 객체의 커서가 위치한 처리행을 DTO 객체로 변환되도록 처리 - 매핑 처리
				MemberDTO member=new MemberDTO();
				member.setNo(rs.getInt("no"));
				member.setName(rs.getString("name"));
				member.setBirth(rs.getString("birth"));
				member.setGender(rs.getString("gender"));
				member.setPhone(rs.getString("phone"));
				member.setType(rs.getString("type"));
				member.setStardate(rs.getString("startdate"));
				
				//처리행이 변환된 DTO 객체를 List 객체의 요소로 추가하여 저장
				memberList.add(member);
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectMemberByName() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		
		return memberList;
	}
	*/
	@Override
	public List<MemberDTO> selectMemberAll() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<MemberDTO> memberList=new ArrayList<MemberDTO>();
		try {
			con=getConnection();
			
			String sql="SELECT NO, NAME, BIRTH, GENDER, PHONE, TYPE, STARTDATE, PRICE, DURINGDATE "
					+ "FROM MEMBER NATURAL JOIN MEMBERTYPE order by name";
			pstmt=con.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				MemberDTO member=new MemberDTO();
				member.setNo(rs.getInt("no"));
				member.setName(rs.getString("name"));
				member.setBirth(rs.getString("birth"));
				member.setGender(rs.getString("gender"));
				member.setPhone(rs.getString("phone"));
				member.setType(rs.getString("type"));
				member.setStardate(rs.getString("startdate"));
				member.setPrice(rs.getString("price"));
				member.setDuringdate(rs.getString("duringdate"));
				
				memberList.add(member);
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectMemberAll() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		
		return memberList;
	}
		
	@Override
	public int deleteMember(int no) {
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    int rows = 0;
	    try {
	        con = getConnection();
	        
	        String sql = "delete from member where no = ?";
	        pstmt = con.prepareStatement(sql);
	        pstmt.setInt(1, no);
	        
	        rows = pstmt.executeUpdate();
	    } catch (SQLException e) {
	        System.out.println("[에러]deleteMember() 메소드의 SQL 오류 = " + e.getMessage());
	    } finally {
	        close(con, pstmt);
	    }
	    return rows;
	}
	/*
	@Override
	public MemberDTO selectMemberByphone(String phone) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		MemberDTO member=null;
		try {
			con=getConnection();
			
			String sql="SELECT NAME,no, STARTDATE, TYPE, PRICE,  from MEMBER NATURAL JOIN MEMBERTYPE WHERE phone=?";
					
	
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, phone);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				member=new MemberDTO();
				member.setNo(rs.getInt("no"));
				member.setName(rs.getString("name"));
				member.setBirth(rs.getString("birth"));
				member.setGender(rs.getString("gender"));
				member.setPhone(rs.getString("phone"));
				member.setType(rs.getString("type"));
				member.setStardate(rs.getString("startdate"));
				member.setPrice(rs.getString("price"));
				member.setDuringdate(rs.getString("duringdate"));
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectMemberByno() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return member;
	}
	*/	
	
}