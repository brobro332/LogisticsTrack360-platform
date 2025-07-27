package kr.co.logitics_track_360.order.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.logitics_track_360.order.dto.OrderCreateRequestDto;
import kr.co.logitics_track_360.order.dto.OrderSearchRequestDto;
import kr.co.logitics_track_360.order.vo.OrderVO;

@Mapper
public interface OrderMapper {
	OrderVO insert(OrderCreateRequestDto dto);
	void updateOrderStatus(String status);
	List<OrderVO> selectOrderList(OrderSearchRequestDto dto);
	OrderVO selectOrder(String orderId);
}
