package kr.co.logitics_track_360.order.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.co.logitics_track_360.order.dto.OrderCreateRequestDto;
import kr.co.logitics_track_360.order.dto.OrderSearchRequestDto;
import kr.co.logitics_track_360.order.vo.OrderVO;

@Mapper
public interface OrderMapper {
	int insert(OrderCreateRequestDto dto);
	int updateOrderStatus(@Param("orderId") Long orderId, @Param("status") String status);
	List<OrderVO> selectOrderList(OrderSearchRequestDto dto);
	List<OrderVO> selectOrderListForDispatch();
	OrderVO selectOrder(String orderId);
}
