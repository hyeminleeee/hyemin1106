package xyz.itwill.dto;

/*
create table board (board_num number primary key, board_title varchar2(200), 
board_writer varchar2(100), board_count number, board_date date, board_update date, 
board_image varchar2(200));
 */

/*
이름           널?       유형            
------------ -------- ------------- 
BOARD_NUM    NOT NULL NUMBER        
BOARD_TITLE           VARCHAR2(200) 
BOARD_WRITER          VARCHAR2(100) 
BOARD_COUNT           NUMBER        
BOARD_DATE            DATE          
BOARD_UPDATE          DATE          
BOARD_IMAGE           VARCHAR2(200)
 */

public class BoardDTO {
	private int boardNum;
	private String boardTitle;
	private String boardWriter;
	private int boardCount;
	private String boardDate;
	private String boardUpdate;
	private String boardImage;

	public BoardDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	public int getBoardCount() {
		return boardCount;
	}

	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}

	public String getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}

	public String getBoardUpdate() {
		return boardUpdate;
	}

	public void setBoardUpdate(String boardUpdate) {
		this.boardUpdate = boardUpdate;
	}

	public String getBoardImage() {
		return boardImage;
	}

	public void setBoardImage(String boardImage) {
		this.boardImage = boardImage;
	}
	
	
	
	
}
