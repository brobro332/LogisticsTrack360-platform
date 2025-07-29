package kr.co.logistics_track_360.order.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.logistics_track_360.order.dao.ItemMapper;
import kr.co.logistics_track_360.order.dao.OrderMapper;
import kr.co.logistics_track_360.order.dao.OrderStatusHistoryMapper;
import kr.co.logistics_track_360.order.dto.ItemCreateRequestDto;
import kr.co.logistics_track_360.order.dto.ItemResponseDto;
import kr.co.logistics_track_360.order.dto.OrderCreateRequestDto;
import kr.co.logistics_track_360.order.dto.OrderResponseDto;
import kr.co.logistics_track_360.order.dto.OrderSearchRequestDto;
import kr.co.logistics_track_360.order.dto.OrderStatusHistoryCreateRequestDto;
import kr.co.logistics_track_360.order.dto.OrderStatusHistoryResponseDto;
import kr.co.logistics_track_360.order.service.OrderService;
import kr.co.logistics_track_360.order.vo.ItemVO;
import kr.co.logistics_track_360.order.vo.OrderStatusHistoryVO;
import kr.co.logistics_track_360.order.vo.OrderVO;

@Service
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrderService {
	private final OrderMapper orderMapper;
	private final ItemMapper itemMapper;
	private final OrderStatusHistoryMapper orderStatusHistoryMapper;
	
	public OrderServiceImpl(OrderMapper orderMapper, ItemMapper itemMapper, OrderStatusHistoryMapper orderStatusHistoryMapper) {
		this.orderMapper = orderMapper;
		this.itemMapper = itemMapper;
		this.orderStatusHistoryMapper = orderStatusHistoryMapper;
	}
	
	@Override
	@Transactional
    public void create(String userId, OrderCreateRequestDto orderDto) {
		orderDto.setUserId(userId);
	    orderDto.setStatus("READY");
	    
	 	orderMapper.insert(orderDto);

        for (ItemCreateRequestDto itemDto : orderDto.getItems()) {
        	itemDto.setOrderId(orderDto.getOrderId());
        	itemMapper.insert(itemDto);
        }

        OrderStatusHistoryCreateRequestDto orderStatusHistoryDto = new OrderStatusHistoryCreateRequestDto();
        orderStatusHistoryDto.setOrderId(orderDto.getOrderId());
        orderStatusHistoryDto.setStatus("READY");
        orderStatusHistoryDto.setUpdatedBy(userId);
        orderStatusHistoryMapper.insert(orderStatusHistoryDto);
    }

	@Override
    public List<OrderResponseDto> selectOrderList(String userId, OrderSearchRequestDto dto) {
		dto.setUserId(userId);
		List<OrderVO> orderList = orderMapper.selectOrderList(dto);
		
		return orderList.stream()
	        .map(order -> {
	        	return new OrderResponseDto.Builder()
		            .orderId(order.getOrderId())
		            .title(order.getTitle())
		            .description(order.getDescription())
		            .status(order.getStatus())
		            .userId(order.getUserId())
		            .userName(order.getUserName())
		            .createdAt(order.getCreatedAt())
		            .updatedAt(order.getUpdatedAt())
		            .build();
	            })
	       .collect(Collectors.toList());
    }
	
	@Override
	public List<OrderResponseDto> selectOrderListForDispatch() {
		List<OrderVO> orderList = orderMapper.selectOrderListForDispatch();
		
		return orderList.stream()
	        .map(order -> {
	        	return new OrderResponseDto.Builder()
		            .orderId(order.getOrderId())
		            .title(order.getTitle())
		            .description(order.getDescription())
		            .status(order.getStatus())
		            .userId(order.getUserId())
		            .userName(order.getUserName())
		            .createdAt(order.getCreatedAt())
		            .updatedAt(order.getUpdatedAt())
		            .build();
	            })
	       .collect(Collectors.toList());
	}

	@Override
    public OrderResponseDto selectOrder(String orderId) {
        OrderVO order = orderMapper.selectOrder(orderId);
        
        return new OrderResponseDto.Builder()
            .orderId(order.getOrderId())
            .title(order.getTitle())
            .description(order.getDescription())
            .status(order.getStatus())
            .userId(order.getUserId())
            .userName(order.getUserName())
            .createdAt(order.getCreatedAt())
            .updatedAt(order.getUpdatedAt())
            .build();
    }
	
	@Override
    public List<ItemResponseDto> selectItemList(String orderId) {
        List<ItemVO> itemList = itemMapper.selectItemList(orderId);
        
        return itemList.stream()
	        .map(item -> {
	        	return new ItemResponseDto.Builder()
        			.itemId(item.getItemId())
		    		.orderId(item.getOrderId())
		    		.name(item.getName())
		    		.quantity(item.getQuantity())
		    		.unit(item.getUnit())
		    		.weight(item.getWeight())
	    			.hsCode(item.getHsCode())
	    			.build();
            	})
	       .collect(Collectors.toList());
    }

	@Override
    public List<OrderStatusHistoryResponseDto> selectStatusHistoryList(String orderId) {
		List<OrderStatusHistoryVO> orderStatusHistoryList = orderStatusHistoryMapper.selectOrderStatusHistoryList(orderId);
		
		 return orderStatusHistoryList.stream()
	        .map(orderStatusHistory -> {
	        	return new OrderStatusHistoryResponseDto.Builder()
		            .historyId(orderStatusHistory.getHistoryId())
		            .orderId(orderStatusHistory.getOrderId())
		            .status(orderStatusHistory.getStatus())
		            .updatedBy(orderStatusHistory.getUpdatedBy())
		            .updatedAt(orderStatusHistory.getUpdatedAt())
		            .build();
	        })
	        .collect(Collectors.toList());
    }

	@Override
	@Transactional
	public void updateOrderStatus(String userId, OrderStatusHistoryCreateRequestDto dto) {
		orderMapper.updateOrderStatus(dto.getOrderId(), dto.getStatus());

        dto.setUpdatedBy(userId);
        orderStatusHistoryMapper.insert(dto);
	}

}
