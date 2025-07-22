package user.dao;

import org.apache.ibatis.annotations.Param;

import user.dto.JoinRequestDto;
import user.vo.UserVO;

public interface UserMapper {
	void insertUser(JoinRequestDto dto);
	UserVO selectBy(@Param("userId") String userId, @Param("email") String email);
}
