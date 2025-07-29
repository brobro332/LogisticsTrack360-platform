package kr.co.logistics_track_360.user.dao;

import java.util.Map;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import kr.co.logistics_track_360.user.dto.JoinRequestDto;
import kr.co.logistics_track_360.user.vo.UserVO;

@Mapper
public interface UserMapper {
	void insertUser(JoinRequestDto dto);
	UserVO selectBy(Map<String, Object> params);
}
