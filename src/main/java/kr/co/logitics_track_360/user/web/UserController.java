package kr.co.logitics_track_360.user.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.logitics_track_360.user.dto.JoinRequestDto;
import kr.co.logitics_track_360.user.dto.LoginRequestDto;
import kr.co.logitics_track_360.user.dto.LoginResponseDto;
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
	
	@PostMapping("/login.do")
    public String handleLogin(@ModelAttribute LoginRequestDto dto, HttpSession session, Model model) {
        LoginResponseDto authnUser = service.authenticate(dto);
        if (authnUser != null) {
            session.setAttribute("userInfo", authnUser);
            return "redirect:/main";
        } else {
            model.addAttribute("errorMsg", "아이디 또는 비밀번호가 틀립니다.");
            return "user/login";
        }
    }
	
	@PostMapping("/join.do")
    public String handleJoin(@RequestBody JoinRequestDto dto) {
        log.info("테스트");
		
		service.register(dto);
        
        return "redirect:/user/login.do";
    }
	
	@GetMapping("/profile.do")
	public String renderProfilePage(HttpSession session, Model model) {
	    LoginResponseDto userInfo = (LoginResponseDto) session.getAttribute("userInfo");

	    if (userInfo != null) {
	        String userId = userInfo.getUserId();
	        model.addAttribute("userInfo", service.select(userId));
	        return "user/profile";
	    } else {
	        return "redirect:/user/login.do";
	    }
	}
}
