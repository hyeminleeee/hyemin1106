package xyz.itwill.boot.dto;

import java.time.LocalDateTime;

import lombok.Data;
import xyz.itwill.boot.entity.BoardEntity;

@Data
public class Board {
	private Long num;//글번호
	private String write;//작성자
	private String title;//제목
	private String content;//내용
	private int hit;//조회수
	private LocalDateTime createDate;//작성날짜
	private LocalDateTime updateDate;//변경날짜
	
	public BoardEntity toBoardEntity() {
		BoardEntity entity=new BoardEntity();
		entity.setWriter(write);
		entity.setTitle(title);
		entity.setContent(content);
		entity.setHit(0);
		return entity;
	}
}
