package kr.co.logitics_track_360.order.dao;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import kr.co.logitics_track_360.order.dto.ItemCreateRequestDto;
import kr.co.logitics_track_360.order.vo.ItemVO;

@Mapper
public interface ItemMapper {
	void insert(ItemCreateRequestDto dto);
	List<ItemVO> selectItemList(String orderId);
}
