package kr.co.logitics_track_360.user.service;

import kr.co.logitics_track_360.user.dto.JoinRequestDto;
import kr.co.logitics_track_360.user.dto.SelectResponseDto;

public interface UserService {
	void register(JoinRequestDto dto);
	SelectResponseDto select(String userId);
}
