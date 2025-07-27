package kr.co.logitics_track_360.order.dao;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import kr.co.logitics_track_360.order.dto.OrderStatusHistoryCreateRequestDto;
import kr.co.logitics_track_360.order.vo.OrderStatusHistoryVO;

@Mapper
public interface OrderStatusHistoryMapper {
	void insert(OrderStatusHistoryCreateRequestDto dto);
	List<OrderStatusHistoryVO> selectOrderStatusHistoryList(String orderId);
}
