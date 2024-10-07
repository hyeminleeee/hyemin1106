package xyz.itwill.boot.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import xyz.itwill.boot.dto.Board;
import xyz.itwill.boot.entity.BoardEntity;
import xyz.itwill.boot.repository.BoardRepository;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	private final BoardRepository boardRepository;
	
	@Override
	public void addBoard(Board board) {
		//DTO 객체를 Entity 객체로 변환하여 저장
		BoardEntity entity=board.toBoardEntity();
		
		//JpaRepository.save(Entity entity) : 매개변수로 전달받은 Entity 객체로 테이블에 행을
		//삽입하는 메소드
		boardRepository.save(entity);
	}

}
