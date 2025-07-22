package user.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import user.dto.JoinRequestDto;
import user.dto.LoginRequestDto;
import user.dto.LoginResponseDto;
import user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	private final UserService service;

	public UserController(UserService service) {
        this.service = service;
    }
	
	@GetMapping("/login")
	public String renderLoginPage() {
		return "user/login";
	}
	
	@GetMapping("/join")
	public String renderJoinPage() {
		return "user/join";
	}
	
	@PostMapping("/login")
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
	
	@PostMapping("/join")
    public String handleRegister(@ModelAttribute JoinRequestDto dto) {
        service.register(dto);
        return "redirect:/user/login";
    }
	
	@GetMapping("/profile")
	public String renderProfilePage(HttpSession session, Model model) {
	    LoginResponseDto userInfo = (LoginResponseDto) session.getAttribute("userInfo");

	    if (userInfo != null) {
	        String userId = userInfo.getUserId();
	        model.addAttribute("userInfo", service.select(userId));
	        return "user/profile";
	    } else {
	        return "redirect:/user/login";
	    }
	}
}
