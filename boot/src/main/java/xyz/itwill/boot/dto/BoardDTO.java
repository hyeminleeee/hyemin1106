package xyz.itwill.boot.dto;

import java.time.LocalDateTime;

import lombok.Data;
import xyz.itwill.boot.entity.BoardEntity;

@Data
public class BoardDTO {
	private Long num;//글번호
	private String writer;//작성자
	private String title;//제목
	private String content;//내용
	private int hit;//조횟수
	private LocalDateTime createDate;//작성날짜
	private LocalDateTime updateDate;//변경날짜
	
	//DTO 객체를 Entity 객체로 변환하여 반환하는 메소드 - 삽입 또는 변경 처리시 사용
	public BoardEntity toBoardEntity() {
		BoardEntity entity=new BoardEntity();
		entity.setWriter(writer);
		entity.setTitle(title);
		entity.setContent(content);
		entity.setHit(0);
		return entity;
	}
}