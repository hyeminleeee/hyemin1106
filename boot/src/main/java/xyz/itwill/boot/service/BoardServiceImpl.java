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
		//삽입하거나 변경하여 저장하는 메소드
		// => 식별자의 컬럼값이 없는 경우 삽입 처리하고 컬럼값이 있는 경우 변경 처리
		boardRepository.save(boardEntity);
	}

	@Override
	public List<BoardDTO> getBoardList() {
		//JpaRepository.findAll() : 테이블에 저장된 모든 행을 검색하여 List 객체로 반환하는 메소드
		// => 하나의 행은 Entity 객체로 변환하여 List 객체의 요소값으로 저장 
		//List<BoardEntity> boardEntityList=boardRepository.findAll();
		
		//JpaRepository.findAll(Sort sort) : 테이블에 저장된 모든 행을 정렬하여 검색해 List 객체로 반환하는 메소드
		//Sort.by(Direction direction, String columnName) : 정렬 관련 정보가 저장된 Sort 객체를 반환하는 정적 메소드
		// => Direction 객체는 Sort 객체의 상수필드(ASC, DESC)에 저장된 Direction 객체 사용
		List<BoardEntity> boardEntityList=boardRepository.findAll(Sort.by(Sort.Direction.DESC, "num"));
		
		List<BoardDTO> boardDTOList=new ArrayList<BoardDTO>();
		for(BoardEntity entity : boardEntityList) {
			boardDTOList.add(entity.toBoardDTO());
		}
		return boardDTOList;
	}
	
	//@Transactional : JPQL을 사용해 UPDATE, DELETE 명령이 등록된 추상메소드를 호출할 때 
	//트렌젝션을 생성하여 커밋 또는 롤백 처리되도록 설정하는 어노테이션
	// => UPDATE, DELETE 명령이 등록된 추상메소드를 호출할 때  @Transactional 어노테이션을 
	//사용하지 않은 경우 예외 발생
	@Transactional
	@Override
	public BoardDTO getBoard(Long num) {
		//JpaRepository.findById(Long id) : 매개변수로 전달받은 식별자의 행을 검색하여 Optional 객체로 반환하는 메소드
		// => Optional 객체에는 행을 검색하여 변환된 Entity 객체 저장
		//Optional 객체 : 제네릭으로 설정된 클래스의 객체 대신 NULL이 저장될 경우 안전하게
		//처리하는 기능을 제공하는 객체 - NullPointerException 발생 방지
		Optional<BoardEntity> optionalBoardEntity=boardRepository.findById(num);
		
		//Optional.isPresent() : Optional 객체에 제네릭의 객체가 저장되어 있는 경우 [true]를 반환하는 메소드
		// => Optional.empty() : Optional 객체에 NULL이 저장되어 있는 경우 [true]를 반환하는 메소드
		if(optionalBoardEntity.isPresent()) {
			//Optional.get() : Optional 객체에 저장된 제네릭의 객체를 반환하는 메소드
			BoardEntity boardEntity=optionalBoardEntity.get();
			BoardDTO boardDTO=boardEntity.toBoardDTO();
	
			boardRepository.updateHit(num);

			return boardDTO;
		} else {
			return null;
		}
	}

	@Override
	public void modifyBoard(BoardDTO boardDTO) {
		//DTO 객체를 Entity 객체로 변환하여 저장
		BoardEntity entity=boardDTO.toBoardEntity();
		boardRepository.save(entity);
	}

	@Override
	public void removeBoard(Long num) {
		//JpaRepository.deleteById(Long id) : 매개변수로 전달받은 식별자를 사용해 테이블에서
		//행을 삭제하는 메소드 
		boardRepository.deleteById(num);
	}
}







