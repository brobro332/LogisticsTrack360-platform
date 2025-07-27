package kr.co.logitics_track_360.order.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.logitics_track_360.order.dao.ItemMapper;
import kr.co.logitics_track_360.order.dao.OrderMapper;
import kr.co.logitics_track_360.order.dao.OrderStatusHistoryMapper;
import kr.co.logitics_track_360.order.dto.ItemCreateRequestDto;
import kr.co.logitics_track_360.order.dto.ItemResponseDto;
import kr.co.logitics_track_360.order.dto.OrderCreateRequestDto;
import kr.co.logitics_track_360.order.dto.OrderResponseDto;
import kr.co.logitics_track_360.order.dto.OrderSearchRequestDto;
import kr.co.logitics_track_360.order.dto.OrderStatusHistoryCreateRequestDto;
import kr.co.logitics_track_360.order.dto.OrderStatusHistoryResponseDto;
import kr.co.logitics_track_360.order.service.OrderService;
import kr.co.logitics_track_360.order.vo.ItemVO;
import kr.co.logitics_track_360.order.vo.OrderStatusHistoryVO;
import kr.co.logitics_track_360.order.vo.OrderVO;

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
    public void create(OrderCreateRequestDto orderDto) {
	    orderDto.setStatus("READY");
	 	OrderVO order = orderMapper.insert(orderDto);

        for (ItemCreateRequestDto itemDto : orderDto.getItems()) {
        	itemDto.setOrderId(order.getOrderId());
        	itemMapper.insert(itemDto);
        }

        OrderStatusHistoryCreateRequestDto orderStatusHistoryDto = new OrderStatusHistoryCreateRequestDto();
        orderStatusHistoryDto.setOrderId(order.getOrderId());
        orderStatusHistoryDto.setStatus("READY");
        orderStatusHistoryDto.setUpdatedBy(order.getUserId());
        orderStatusHistoryMapper.insert(orderStatusHistoryDto);
    }

	@Override
    public List<OrderResponseDto> selectOrderList(OrderSearchRequestDto dto) {
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
		            .statusId(orderStatusHistory.getStatusId())
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
	public void updateOrderStatus(OrderStatusHistoryCreateRequestDto dto) {
        orderMapper.updateOrderStatus(dto.getStatus());

        OrderStatusHistoryCreateRequestDto orderStatusHistoryDto = new OrderStatusHistoryCreateRequestDto();
        orderStatusHistoryDto.setOrderId(dto.getOrderId());
        orderStatusHistoryDto.setStatus(dto.getStatus());
        orderStatusHistoryDto.setUpdatedBy(dto.getUpdatedBy());
        orderStatusHistoryMapper.insert(orderStatusHistoryDto);
	}

}
