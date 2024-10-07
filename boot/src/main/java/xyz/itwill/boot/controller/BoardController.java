package xyz.itwill.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import xyz.itwill.boot.dto.Board;
import xyz.itwill.boot.service.BoardService;

//JPA(Java Presistence API) : ORM(Object Relational Mapping) 기능을 제공하는 표준 인터페이스
// => ORM : 데이타베이스의 테이블과 Java 객체가 1:1로 매핑되도록 처리하는 기능
// => SQL 명령을 작성하지 않아도 객체와 테이블이 자동으로 매핑되어 필요한 SQL 명령이 자동으로 
//생성되어 처리 - 특정 DBMS에 종속되지 않아 유지보수의 효율성 증가
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
	public String write(@ModelAttribute Board board) {
		boardService.addBoard(board);
		return "redirect:/board/list";
	}

	@GetMapping("/list")
	public String list() {
		return "board/list";
	}
}
