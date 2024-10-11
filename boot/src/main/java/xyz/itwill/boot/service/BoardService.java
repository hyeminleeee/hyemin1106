package xyz.itwill.boot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import xyz.itwill.boot.dto.BoardDTO;

public interface BoardService {
	void addBoard(BoardDTO boardDTO);
	List<BoardDTO> getBoardList();
	BoardDTO getBoard(Long num);
	void modifyBoard(BoardDTO boardDTO);
	void removeBoard(Long num);
	Page<BoardDTO> getBoardList(Pageable pageable);
}