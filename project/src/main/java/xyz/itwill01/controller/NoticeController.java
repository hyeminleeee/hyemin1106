package xyz.itwill01.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import lombok.RequiredArgsConstructor;
import xyz.itwill01.dto.Notice;
import xyz.itwill01.service.NoticeService;

@RestController
@RequestMapping("/rest")
@RequiredArgsConstructor
public class NoticeController {
	private final NoticeService noticeService;
	
	@GetMapping("/notice_list")
	public List<Notice> noticeList() {
		return noticeService.getNoticeList();
	}
	
	@PostMapping("/notice_add")
	public String noticeAdd(@RequestBody Notice notice) {
		notice.setNoticeContent(HtmlUtils.htmlEscape(notice.getNoticeContent()));
		System.out.println("제목 = "+notice.getNoticeTitle());
		System.out.println("내용 = "+notice.getNoticeContent());
		noticeService.addNotice(notice);
		return "success";
	}
}
