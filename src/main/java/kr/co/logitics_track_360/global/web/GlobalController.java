package kr.co.logitics_track_360.global.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GlobalController {
	@GetMapping("/main.do")
	public String renderMain() {
		return "main";
	}
}
