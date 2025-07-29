package kr.co.logitics_track_360.user.service;

import kr.co.logitics_track_360.user.dto.JoinRequestDto;
import kr.co.logitics_track_360.user.dto.UserResponseDto;

public interface UserService {
	void register(JoinRequestDto dto);
	UserResponseDto select(String userId);
}
