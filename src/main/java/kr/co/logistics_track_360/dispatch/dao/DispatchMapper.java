package kr.co.logistics_track_360.dispatch.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.logistics_track_360.dispatch.dto.DispatchCreateRequestDto;
import kr.co.logistics_track_360.dispatch.vo.DispatchVO;

@Mapper
public interface DispatchMapper {
    int insertBatch(List<DispatchCreateRequestDto> dtoList);
    List<DispatchVO> select();
}
