package xyz.itwill.boot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	public void modifyBoard(BoardDTO board) {
		//DTO 객체를 Entity 객체로 변환하여 저장
		BoardEntity entity=board.toBoardEntity();
		boardRepository.save(entity);
	}

	@Override
	public void removeBoard(Long num) {
		//JpaRepository.deleteById(Long id) : 매개변수로 전달받은 식별자를 사용해 테이블에서 
		//행을 삭제하는 메소드
		boardRepository.deleteById(num);
	}

	@Override
	public Page<BoardDTO> getBoardList(Pageable pageable) {
		//Pageable.getPageNumber() : 요청 페이지 번호를 반환하는 메소드
		// => Pageable 객체로 페이징 처리시 요청 페이지 번호는 [0]부터 시작되므로 1 감소 후 검색
		int pageNum=pageable.getPageNumber() - 1;
		
		//Pageable.getPageSize() : 페이지에 출력될 검색행의 갯수를 반환하는 메소드
		int pageSize=pageable.getPageSize();
		
		//JpaRepository.findAll(Pageable pageable) : 테이블에서 페이징 처리된 행을 검색해 
		//Page 객체로 반환하는 메소드
		//Page 객체 : 페이징 처리된 결과를 저장한 객체 - List 객체와 유사
		// => 제네릭으로 설정된 클래스의 객체를 요소값으로 저장
		//PageRequest.of(int pageNumber, int pageSize, Sort sort) : PageRequest 객체를 생성
		//하여 반환하는 정적메소드
		// => PageRequest 객체 : 페이징 처리 관련 정보기 저장된 Pageable 객체를 생성하는 객체
		Page<BoardEntity> boardEitityPage=boardRepository.findAll(PageRequest.of
				(pageNum, pageSize, Sort.by(Sort.Direction.DESC, "num")));
		
		//Page.getContent() : 요청 패이지에 해당하는 행을 반환하는 메소드
		System.out.println("boardEitityList.getContent() = "+boardEitityPage.getContent());
		//Page.getTotalElements() : 전체 행의 갯수를 반환하는 메소드
		System.out.println("boardEitityList.getTotalElements() = "+boardEitityPage.getTotalElements());
		//Page.getNumber() : 요청 페이지 번호를 반환하는 메소드
		System.out.println("boardEitityList.getNumber() = "+boardEitityPage.getNumber());
		//Page.getTotalPages() : 전체 페이지 갯수를 반환하는 메소드
		System.out.println("boardEitityList.getTotalPages() = "+boardEitityPage.getTotalPages());
		//Page.getSize() : 페이지에 출력될 검색행의 갯수를 반환하는 메소드
		System.out.println("boardEitityList.getSize() = "+boardEitityPage.getSize());
		//Page.hasPrevious() : 이전 페이지의 존재 유무를 반환하는 메소드
		System.out.println("boardEitityList.hasPrevious() = "+boardEitityPage.hasPrevious());
		//Page.hasNext() : 다음 페이지의 존재 유무를 반환하는 메소드
		System.out.println("boardEitityList.hasNext() = "+boardEitityPage.hasNext());
		//Page.hasNext() : 첫번째 페이지 여부를 반환하는 메소드
		System.out.println("boardEitityList.isFirst() = "+boardEitityPage.isFirst());
		//Page.hasNext() : 마지막 페이지 여부를 반환하는 메소드
		System.out.println("boardEitityList.isLast() = "+boardEitityPage.isLast());

		//Page<T>.map(Function<? super T, ? extends U> converter) : Page 객체의 요소값을 변환하여 
		//Page 객체를 반환하는 메소드
		// => Page<BoardEntity> 객체를 Page<BoardDTO> 객체로 변환하여 저장
		Page<BoardDTO> boardDTOPage=boardEitityPage.map(boardEntity -> {
			BoardDTO boardDTO=new BoardDTO();
			boardDTO.setNum(boardEntity.getNum());
			boardDTO.setWriter(boardEntity.getWriter());
			boardDTO.setTitle(boardEntity.getTitle());
			boardDTO.setHit(boardEntity.getHit());
			boardDTO.setCreateDate(boardEntity.getCreateDate());
			return boardDTO;
		});
		
		return boardDTOPage;
	}
}







