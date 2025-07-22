package user.service;

import user.dto.JoinRequestDto;
import user.dto.LoginRequestDto;
import user.dto.LoginResponseDto;
import user.dto.SelectResponseDto;

public interface UserService {
	LoginResponseDto authenticate(LoginRequestDto dto);
	void register(JoinRequestDto dto);
	SelectResponseDto select(String userId);
}
