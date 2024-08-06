package xyz.itwill.service;

import java.sql.SQLException;
import java.util.List;

import xyz.itwill.dao.BoardDAO;
import xyz.itwill.dto.BoardDTO;

public class BoardService {
	private static BoardService _service;
	
	public BoardService() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_service=new BoardService();
	}
	
	public static BoardService getService() {
		return _service;
	}
	
	public List<BoardDTO> getBoardList() throws SQLException {
		return BoardDAO.getDAO().selectBoardList();
	}
	
	public void addBoard(BoardDTO board) throws SQLException {
		BoardDAO.getDAO().insertBoard(board);
	}
}
