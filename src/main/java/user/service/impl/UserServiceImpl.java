package user.service.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import user.dao.UserMapper;
import user.dto.JoinRequestDto;
import user.dto.LoginRequestDto;
import user.dto.LoginResponseDto;
import user.dto.SelectResponseDto;
import user.service.UserService;
import user.vo.UserVO;

public class UserServiceImpl implements UserService {
	private final UserMapper mapper;
	private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserMapper mapper, BCryptPasswordEncoder passwordEncoder) {
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }
    
	@Override
	public LoginResponseDto authenticate(LoginRequestDto dto) {
        UserVO user = mapper.selectBy(dto.getUserId(), null);
        
        if (user == null) throw new RuntimeException("사용자가 없습니다.");
        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new RuntimeException("비밀번호가 틀립니다.");
        }

        return new LoginResponseDto.Builder()
    		.userId(user.getUserId())
    		.name(user.getName())
    		.role(user.getRole())
    		.email(user.getEmail())
    		.phone(user.getPhone())
    		.build();
    }

	@Override
	public void register(JoinRequestDto dto) {
		if (mapper.selectBy(dto.getUserId(), null) != null) {
	        throw new RuntimeException("이미 존재하는 사용자 ID입니다.");
	    }

	    if (mapper.selectBy(null, dto.getEmail()) != null) {
	        throw new RuntimeException("이미 존재하는 이메일입니다.");
	    }
		
	    String encryptedPassword = passwordEncoder.encode(dto.getPassword());
	    dto.setPassword(encryptedPassword);

	    mapper.insertUser(dto);
	}

	@Override
	public SelectResponseDto select(String userId) {
		UserVO user = mapper.selectBy(userId, null);
		
		if (user == null) throw new RuntimeException("사용자가 없습니다.");
		
		return new SelectResponseDto.Builder()
			.userId(user.getUserId())
			.name(user.getName())
			.role(user.getRole())
			.email(user.getEmail())
			.phone(user.getPhone())
			.build();
	}
}
