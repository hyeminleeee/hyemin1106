package xyz.itwill01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/rest")
public class RestfulNoticeController {
	@RequestMapping(value = "/notice", method = RequestMethod.GET)
	public String notice() {
		return "rest/notice";
	}
}
