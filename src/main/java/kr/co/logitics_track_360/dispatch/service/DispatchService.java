package kr.co.logitics_track_360.dispatch.service;

import java.util.List;

import kr.co.logitics_track_360.dispatch.dto.DispatchCreateRequestDto;
import kr.co.logitics_track_360.dispatch.dto.DispatchResponseDto;

public interface DispatchService {
	void create(List<DispatchCreateRequestDto> dto);
    List<DispatchResponseDto> select();
}
