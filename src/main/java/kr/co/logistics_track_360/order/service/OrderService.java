package kr.co.logistics_track_360.order.service;

import java.util.List;

import kr.co.logistics_track_360.order.dto.ItemResponseDto;
import kr.co.logistics_track_360.order.dto.OrderCreateRequestDto;
import kr.co.logistics_track_360.order.dto.OrderResponseDto;
import kr.co.logistics_track_360.order.dto.OrderSearchRequestDto;
import kr.co.logistics_track_360.order.dto.OrderStatusHistoryCreateRequestDto;
import kr.co.logistics_track_360.order.dto.OrderStatusHistoryResponseDto;

public interface OrderService {
	void create(String userId, OrderCreateRequestDto dto);
	List<OrderResponseDto> selectOrderList(String userId, OrderSearchRequestDto dto);
	List<OrderResponseDto> selectOrderListForDispatch();
	OrderResponseDto selectOrder(String orderId);
	List<ItemResponseDto> selectItemList(String orderId);
	List<OrderStatusHistoryResponseDto> selectStatusHistoryList(String orderId);
	void updateOrderStatus(String userId, OrderStatusHistoryCreateRequestDto dto);
}
