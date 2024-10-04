package xyz.itwill.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String main(Model model) {
		model.addAttribute("name", "임꺽정");
		return "index";
	}
}
