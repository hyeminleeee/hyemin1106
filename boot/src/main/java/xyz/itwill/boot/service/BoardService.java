package xyz.itwill.boot.service;

import java.util.List;

import xyz.itwill.boot.dto.BoardDTO;

public interface BoardService {
	void addBoard(BoardDTO boardDTO);
	List<BoardDTO> getBoardList();
	BoardDTO getBoard(Long num);
	void updateHit(Long num);
}