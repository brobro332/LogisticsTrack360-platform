package kr.co.logitics_track_360.user.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.logitics_track_360.user.dao.UserMapper;
import kr.co.logitics_track_360.user.dto.JoinRequestDto;
import kr.co.logitics_track_360.user.dto.UserResponseDto;
import kr.co.logitics_track_360.user.service.UserService;
import kr.co.logitics_track_360.user.vo.UserVO;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
	private final UserMapper mapper;
	private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserMapper mapper, BCryptPasswordEncoder passwordEncoder) {
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }
    
	@Override
	@Transactional
	public void register(JoinRequestDto dto) {
		Map<String, Object> params = new HashMap<>();
        params.put("userId", dto.getUserId());
        params.put("email", dto.getEmail());
        
        if (mapper.selectBy(params) != null) throw new RuntimeException("이미 존재하는 사용자 ID입니다.");

        params.put("userId", null);
        if (mapper.selectBy(params) != null) throw new RuntimeException("이미 존재하는 이메일입니다.");
        
	    String encryptedPassword = passwordEncoder.encode(dto.getPassword());
	    dto.setPassword(encryptedPassword);

	    mapper.insertUser(dto);
	}

	@Override
	public UserResponseDto select(String userId) {
		Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        params.put("email", null);
        
		UserVO user = mapper.selectBy(params);
		
		if (user == null) throw new RuntimeException("사용자가 없습니다.");
		
		return new UserResponseDto.Builder()
			.userId(user.getUserId())
			.name(user.getName())
			.role(user.getRole())
			.email(user.getEmail())
			.phone(user.getPhone())
			.build();
	}
}
