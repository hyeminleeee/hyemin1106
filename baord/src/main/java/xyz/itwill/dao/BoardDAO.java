package xyz.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import xyz.itwill.dto.BoardDTO;

public class BoardDAO extends JdbcDAO {
	private static BoardDAO _dao;
	
	public BoardDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new BoardDAO();
	}
	
	public static BoardDAO getDAO() {
		return _dao;
	}
	
	public List<BoardDTO> selectBoardList() throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<BoardDTO> boardList=new ArrayList<BoardDTO>();
		try {
			con=getConnection();
			
			String sql="select * from board";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO board=new BoardDTO();
				board.setBoardNum(rs.getInt("board_num"));
				board.setBoardTitle(rs.getString("board_title"));
				board.setBoardWriter(rs.getString("board_writer"));
				board.setBoardCount(rs.getInt("board_count"));
				board.setBoardDate(rs.getString("board_date"));
				board.setBoardUpdate(rs.getString("board_update"));
				board.setBoardImage(rs.getString("board_image"));
				
				boardList.add(board);
			}
		} finally {
			close(con, pstmt, rs);
		}
		return boardList;
	}
	
	//작성 게시물을 전달받아 BOARD 테이블의 행으로 삽입하고 삽입행의 갯수를 반환하는 메소드
	public int insertBoard(BoardDTO board) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="insert into board values(?,?,?,0,sysdate,null,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, board.getBoardNum());
			pstmt.setString(2, board.getBoardTitle());
			pstmt.setString(3, board.getBoardWriter());
			pstmt.setString(4, board.getBoardImage());
			
			rows=pstmt.executeUpdate();
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	
}
