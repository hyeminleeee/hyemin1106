package xyz.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import xyz.itwill.dto.NoticeDTO;
import xyz.itwill.dto.QnaDTO;

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
	
	public int selectTotalQna() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		try {
			con=getConnection();
			
			String sql="select count(*) from qna";
			pstmt=con.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				count=rs.getInt(1);
			}	
		} catch (SQLException e) {
			System.out.println("[에러]selectTotalQna() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return count;
	}
	
	public QnaDTO selectQnaByClientNum(int qnaClientNum) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		QnaDTO qna=null;
		try {
			con=getConnection();
			
			String sql="select qna_num,qna_client_num,qna_subject,qna_title,qna_content,"
					+"qna_image,qna_date,qna_update,qna_ip,qna_reply,"
					+"qna_product_num,qna_status,qna_writer from qna where qna_client_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, qnaClientNum);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				qna=new QnaDTO();
				qna.setQnaNum(rs.getInt("qna_num"));
				qna.setQnaClientNum(rs.getInt("qna_client_num"));
				qna.setQnaSubject(rs.getString("qna_subject"));
				qna.setQnaTitle(rs.getString("qna_title"));
				qna.setQnaContent(rs.getString("qna_content"));
				qna.setQnaImage(rs.getString("qna_image"));
				qna.setQnaDate(rs.getString("qna_date"));
				qna.setQnaUpdate(rs.getString("qna_update"));
				qna.setQnaIp(rs.getString("qna_ip"));
				qna.setQnaReply(rs.getString("qna_reply"));
				qna.setQnaProductNum(rs.getInt("qna_product_num"));
				qna.setQnaStatus(rs.getInt("qna_status"));
				qna.setQnaWriter(rs.getString("qna_writer"));
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectQnaByClientNum() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return qna;
	}
	
	public List<QnaDTO> selectQnaList(int startRow, int endRow) {
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    List<QnaDTO> qnaList = new ArrayList<QnaDTO>();
	    try {
	        con = getConnection();
	        
	        String sql = "select * from ("
	                   + " select temp.*, rownum rn from ("
	                   + " select qna_num, qna_client_num, qna_subject, qna_title, "
	                   + " qna_content, qna_image, qna_date, qna_update, "
	                   + " qna_ip, qna_reply, qna_product_num, "
	                   + " qna_status,client_name,product_name,qna_writer from qna join "
	                   + "client on qna_client_num = client_num "
	                   + " join product on qna_product_num = product_num "
	                   + " order by qna_num desc"
	                   + " ) temp where rownum <= ?"
	                   + ") where rn >= ?";
	        
	        pstmt = con.prepareStatement(sql);
	        pstmt.setInt(1, endRow);
	        pstmt.setInt(2, startRow);
	        
	        rs = pstmt.executeQuery();
	        
	        while (rs.next()) {
	            QnaDTO qna = new QnaDTO();
	            qna.setQnaNum(rs.getInt("qna_num"));
	            qna.setQnaClientNum(rs.getInt("qna_client_num"));
	            qna.setQnaSubject(rs.getString("qna_subject"));
	            qna.setQnaTitle(rs.getString("qna_title"));
	            qna.setQnaContent(rs.getString("qna_content"));
	            qna.setQnaImage(rs.getString("qna_image"));
	            qna.setQnaDate(rs.getString("qna_date"));
	            qna.setQnaUpdate(rs.getString("qna_update"));
	            qna.setQnaIp(rs.getString("qna_ip"));
	            qna.setQnaReply(rs.getString("qna_reply"));
	            qna.setQnaProductNum(rs.getInt("qna_product_num"));
	            qna.setQnaStatus(rs.getInt("qna_status"));
	            qna.setClientName(rs.getString("client_name"));
	            qna.setProductName(rs.getString("product_name"));
	            qna.setQnaWriter(rs.getString("qna_writer"));
	            
	            qnaList.add(qna);
	        }
	    } catch (SQLException e) {
	        System.out.println("[에러]selectQnaList() 메소드의 SQL 오류 = " + e.getMessage());
	    } finally {
	        close(con, pstmt, rs);
	    }
	    return qnaList;
	}
	
	public int insertQna(QnaDTO qna) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="insert into qna values(?,?,?,?,?,?,sysdate,null,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, qna.getQnaNum());
			pstmt.setInt(2, qna.getQnaClientNum());
			pstmt.setString(3, qna.getQnaSubject());
			pstmt.setString(4, qna.getQnaTitle());
			pstmt.setString(5, qna.getQnaContent());
			pstmt.setString(6, qna.getQnaImage());
			pstmt.setString(7, qna.getQnaIp());
			pstmt.setString(8, qna.getQnaReply());
			pstmt.setInt(9, qna.getQnaProductNum());
			pstmt.setInt(10, qna.getQnaStatus());
			pstmt.setString(11, qna.getQnaWriter());
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]insertQna() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	public int selectQnaNextNum() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int nextNum=0;
		try {
			con=getConnection();
			
			String sql="select qna_seq.nextval from dual";
			pstmt=con.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				nextNum=rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectQnaNextNum() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return nextNum;
	}
	
	public QnaDTO selectQnaByNum(int qnaNum) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		QnaDTO qna=null;
		try {
			con=getConnection();
			
			String sql="select qna_num,qna_client_num,qna_subject,qna_title,qna_content,"
					+ "qna_image,qna_date,qna_update,qna_ip,qna_reply,"
					+ "qna_product_num,qna_status,qna_writer from qna where qna_num=?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, qnaNum);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				qna=new QnaDTO();
				qna.setQnaNum(rs.getInt("qna_num"));
				qna.setQnaClientNum(rs.getInt("qna_client_num"));
				qna.setQnaSubject(rs.getString("qna_subject"));
				qna.setQnaTitle(rs.getString("qna_title"));
				qna.setQnaContent(rs.getString("qna_content"));
				qna.setQnaImage(rs.getString("qna_image"));
				qna.setQnaDate(rs.getString("qna_date"));
				qna.setQnaUpdate(rs.getString("qna_update"));
				qna.setQnaIp(rs.getString("qna_ip"));
				qna.setQnaReply(rs.getString("qna_reply"));
				qna.setQnaProductNum(rs.getInt("qna_product_num"));
				qna.setQnaStatus(rs.getInt("qna_status"));
				qna.setQnaWriter(rs.getString("qna_writer"));
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectQnaByNum() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return qna;
	}
	
}






















