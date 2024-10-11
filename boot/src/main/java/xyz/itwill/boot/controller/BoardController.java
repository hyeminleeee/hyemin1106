package xyz.itwill.boot.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import xyz.itwill.boot.dto.BoardDTO;
import xyz.itwill.boot.service.BoardService;

//JPA(Java Persistence API) : ORM(Object Relational Mapping) 기능을 제공하는 표준 인터페이스
// => ORM : 데이타베이스의 테이블과 Java 객체가 1:1로 매핑되도록 처리하는 기능
// => 객체와 테이블이 자동으로 매핑되어 필요한 SQL 명령이 자동으로 생성되어 처리 - SQL 명령을
//작성할 필요가 없어 특정 DBMS에 종속되지 않아 유지보수의 효율성 증가
// => 복잡한 SQL 명령을 생성하기 불편하며 테이블 결합이 많아질 경우 가독성 감소

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
	private final BoardService boardService;
	
	@GetMapping("/write")
	public String write() {
		return "board/write";
	}
	
	@PostMapping("/write")
	public String write(@ModelAttribute BoardDTO board) {
		boardService.addBoard(board);
		return "redirect:/board/list"; 
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("boardList", boardService.getBoardList());
		return "board/list"; 
	}
	
	@GetMapping("/detail/{num}")
	public String detail(@PathVariable(value = "num") Long num,  Model model
			, @PageableDefault(page = 1, size = 5) Pageable pageable) {
		model.addAttribute("board", boardService.getBoard(num));
		model.addAttribute("page", pageable.getPageNumber());
		model.addAttribute("size", pageable.getPageSize());
		return "board/detail"; 
	}
	
	@GetMapping("/modify/{num}")
	public String modify(@PathVariable(value = "num") Long num,  Model model) {
		model.addAttribute("board", boardService.getBoard(num));
		return "board/modify"; 
	}
	
	@PostMapping("/modify")
	public String modify(@ModelAttribute BoardDTO board) {
		boardService.modifyBoard(board);
		return "redirect:/board/detail/"+board.getNum(); 
	}
	
	@GetMapping("/remove/{num}")
	public String remove(@PathVariable(value = "num") Long num) {
		boardService.removeBoard(num);
		return "redirect:/board/list"; 
	}
	
	//요청 처리 메소드에 Pageable 인터페이스로 매개변수를 작성하면 Front Controller에게 Pageable
	//객체를 제공받아 저장하여 사용 가능
	// => Pageable 객체 : 페이징 처리 관련 정보를 저장하기 위한 객체
	// => 페이징 처리 관련 전달값이 있는 Pageable 객체 필드에 전달값 저장 
	//@PageableDefault : 페이징 처리 관련 전달값이 없는 경우 Pageable 객체의 필드에 원하는 
	//초기값을 저장하기 위한 어노테이션
	//page 속성 : 전달값이 없는 경우 요청 페이지 번호를 속성값으로 설정
	//size 속성 : 전달값이 없는 경우 페이지에 출력될 검색행의 갯수를 속성값으로 설정
	@GetMapping("/paging")
	public String paging(@PageableDefault(page = 1, size = 5) Pageable pageable, Model model) {
		Page<BoardDTO> boardList=boardService.getBoardList(pageable); 
		int blockSize=3;
		int startPage=(((int)(Math.ceil((double)pageable.getPageNumber() / blockSize)))
				- 1) * blockSize + 1;//1 4 7 10 ...
		int endPage=((startPage + blockSize - 1) < boardList.getTotalPages()) ? 
				startPage + blockSize - 1 : boardList.getTotalPages();//3 6 9 12 ...
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		
		return "board/paging"; 
	}
}












