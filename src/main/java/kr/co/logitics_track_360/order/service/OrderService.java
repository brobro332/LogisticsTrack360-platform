package kr.co.logitics_track_360.order.service;

import java.util.List;

import kr.co.logitics_track_360.order.dto.ItemResponseDto;
import kr.co.logitics_track_360.order.dto.OrderCreateRequestDto;
import kr.co.logitics_track_360.order.dto.OrderResponseDto;
import kr.co.logitics_track_360.order.dto.OrderSearchRequestDto;
import kr.co.logitics_track_360.order.dto.OrderStatusHistoryCreateRequestDto;
import kr.co.logitics_track_360.order.dto.OrderStatusHistoryResponseDto;

public interface OrderService {
	void create(OrderCreateRequestDto dto);
	List<OrderResponseDto> selectOrderList(OrderSearchRequestDto dto);
	OrderResponseDto selectOrder(String orderId);
	List<ItemResponseDto> selectItemList(String orderId);
	List<OrderStatusHistoryResponseDto> selectStatusHistoryList(String orderId);
	void updateOrderStatus(OrderStatusHistoryCreateRequestDto dto);
}
