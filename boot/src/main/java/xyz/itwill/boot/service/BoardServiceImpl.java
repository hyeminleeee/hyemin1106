package xyz.itwill.boot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import xyz.itwill.boot.dto.BoardDTO;
import xyz.itwill.boot.entity.BoardEntity;
import xyz.itwill.boot.repository.BoardRepository;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	private final BoardRepository boardRepository;
	
	@Override
	public void addBoard(BoardDTO boardDTO) {
		//DTO 객체를 Entity 객체로 변환하여 저장
		BoardEntity boardEntity=boardDTO.toBoardEntity();
		
		//JpaRepository.save(Entity entity) : 매개변수로 전달받은 Entity 객체로 테이블에 행을
		//삽입하여 저장하는 메소드
		boardRepository.save(boardEntity);
	}

	@Override
	public List<BoardDTO> getBoardList() {
		//JpaRepository.findAll() : 테이블에 저장된 모든 행을 검색하여 List 객체로 반환하는 메소드
		// => 하나의 행은 Entity 객체로 변환하여 List 객체의 요소값으로 저장 
		//List<BoardEntity> boardEntityList=boardRepository.findAll();
		//JpaRepository.findAll(Sort sort) : 테이블에 저장된 모든을 행을 정렬하여 검색해 List 객체로 반환하는 메소드
		//Sort.by(Direction direction, String columnName) : 정렬 관련 정보가 저장된 Sort 객체를 반환하는 정적 메소드
		// => Direction 객체는 Sort 객체의 상수필드(ASC, DESC)에 저장된 Direction 객체 사용
		List<BoardEntity> boardEntityList=boardRepository.findAll(Sort.by(Sort.Direction.DESC, "num"));
		List<BoardDTO> boardDTOList=new ArrayList<BoardDTO>();
		for(BoardEntity entity : boardEntityList) {
			boardDTOList.add(entity.toBoardDTO());
		}
		return boardDTOList;
	}

	@Transactional
	public void updateHit(Long num) {
		boardRepository.updateHit(num);
	}
	
	@Override
	public BoardDTO getBoard(Long num) {
		//JpaRepository.findById(Long id) : 매개변수로 전달받은 식별자의 행의 검색하여 Optional 객체로 반환하는 메소드
		// => Optional 객체에 행을 검색한 Entity 객체 저장되어 사용
		//Optional 객체 : 제네릭으로 설정된 클래스의 객체 대신 NULL이 저장될 경우 안전하게
		//처리하는 기능을 제공하는 객체
		Optional<BoardEntity> optionalBoardEntity=boardRepository.findById(num);
		
		//Optional.isPresent() : 제네릭으로 설정된 클래스의 객체가 있는 경우 [true]를 반환하는 메소드
		// => Optional.empty() : 제네릭으로 설정된 클래스의 객체가 있는 경우 [false]를 반환하는 메소드
		if(optionalBoardEntity.isPresent()) {
			//Optional.get() : 제네릭으로 설정된 클래스의 객체를 반환하는 메소드
			BoardEntity boardEntity=optionalBoardEntity.get();
			BoardDTO boardDTO=boardEntity.toBoardDTO();
			
			return boardDTO;
		} else {
			return null;
		}
	}
}







