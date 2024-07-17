package xyz.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import xyz.itwill.dto.NoticeDTO;

public class NoticeDAO extends JdbcDAO{
	private static NoticeDAO _dao;
	
	public NoticeDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new NoticeDAO();
	}
	
	public static NoticeDAO getDAO() {
		return _dao;
	}
	
	//조회정보(조회대상과 조회단어)를 전달받아 NOTICE 테이블에 저장된 행에서 조회정보가 포함된 
	//행의 갯수를 검색하여 반환하는 메소드
	// => 조회기능을 사용하지 않을 경우 REVIEW 테이블에 저장된 모든 행의 갯수를 검색하여 반환	
	//페이징 처리할 때 필요한 기능
	public int selectTotalNotice(String search, String keyword) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		try {
			con=getConnection();
			
			//매개변수에 저장된 값을 비교하여 DBMS 서버에 다른 SQL 명령을 전달하여 실행
			// => 동적 SQL(Dynamic SQL)
			if(keyword.equals("")) {//조회기능을 사용하지 않을 경우
				String sql="select count(*) from notice";
				pstmt=con.prepareStatement(sql);
			} else {
				String sql="select count(*) from notice join member on notice_member=member_num"
						+ " where "+search+" like '%'||?||'%'";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, keyword);
			}
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectTotalNotice() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return count;
	}
	
	//페이징 관련 정보(시작행번호, 종료행번호)와 게시글 조회기능 관련 정보(조회대상과 조회단어)를
	//전달받아 NOTICE 테이블에 저장된 행에서 조회정보가 포함된 행을 페이징 처리로 검색하여
	//검색된 게시글 목록(List 객체)을 반환하는 메소드
	public List<NoticeDTO> selectNoticeList(int startRow, int endRow, String search, String keyword) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<NoticeDTO> noticeList=new ArrayList<NoticeDTO>();
		try {
			con=getConnection();
			
			if(keyword.equals("")) {
				String sql="select * from (select rownum rn, temp.* from (select notice_num,notice_title"
						+ ",notice_content,notice_image,notice_date,notice_update,notice_count,notice_member"
						+ " from notice join member on notice_member=member_num order by notice_num desc)"
						+ "temp) where rn between ? and ?";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
			} else {
				String sql="select * from (select rownum rn, temp.* from (select notice_num,notice_title"
					+ ",notice_content,notice_image,notice_date,notice_update,notice_count,notice_member"
					+ " from notice join member on notice_member=member_num where "+search+"like '%'||?||'%'"
					+ "order by notice_num desc) temp) where rn between ? and ?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, keyword);
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
			}
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				NoticeDTO review=new NoticeDTO();
				
				review.setNoticeNum(rs.getInt("notice_num"));
				review.setNoticeTitle(rs.getString("notice_title"));
				review.setNoticeContent(rs.getString("notice_content"));
				review.setNoticeImage(rs.getString("notice_image"));
				review.setNoticeDate(rs.getString("notice_date"));
				review.setNoticeUpdate(rs.getString("notice_update"));
				review.setNoticeCount(rs.getInt("notice_count"));
				review.setNoticeMember(rs.getInt("notice_member"));
								
				noticeList.add(review);
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectNoticeList() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return noticeList;
	}
	
	
	
}






























