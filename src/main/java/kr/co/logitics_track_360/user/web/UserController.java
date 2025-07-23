package kr.co.logitics_track_360.user.web;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.logitics_track_360.user.dto.JoinRequestDto;
import kr.co.logitics_track_360.user.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/user")
public class UserController {
	private final UserService service;

	public UserController(UserService service) {
        this.service = service;
    }
	
	@GetMapping("/login.do") 
	public String renderLoginPage() {
	    return "user/login";
	}
	
	@GetMapping("/join.do")
	public String renderJoinPage() {
		return "user/join";
	}
	
	@PostMapping("/join.do")
    public String handleJoin(@ModelAttribute JoinRequestDto dto) {
		service.register(dto);
        
        return "redirect:/user/login.do";
    }
	
	@GetMapping("/profile.do")
	public String profile(Authentication authentication, Model model) {
	    String userId = authentication.getName();
	    model.addAttribute("userInfo", service.select(userId));
	    
	    return "user/profile";
	}
}
