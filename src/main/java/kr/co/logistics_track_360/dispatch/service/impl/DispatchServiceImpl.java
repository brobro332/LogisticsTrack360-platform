package kr.co.logistics_track_360.dispatch.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.logistics_track_360.dispatch.dao.DispatchMapper;
import kr.co.logistics_track_360.dispatch.dto.DispatchCreateRequestDto;
import kr.co.logistics_track_360.dispatch.dto.DispatchResponseDto;
import kr.co.logistics_track_360.dispatch.service.DispatchService;
import kr.co.logistics_track_360.dispatch.vo.DispatchVO;
import kr.co.logistics_track_360.order.dto.OrderStatusHistoryCreateRequestDto;
import kr.co.logistics_track_360.order.service.OrderService;

@Service
@Transactional(readOnly = true)
public class DispatchServiceImpl implements DispatchService {
	private final OrderService orderService;
	private final DispatchMapper mapper;
	
	public DispatchServiceImpl(OrderService orderService, DispatchMapper mapper) {
		this.orderService = orderService;
		this.mapper = mapper;
	}
	
	@Transactional
	public void create(List<DispatchCreateRequestDto> dtoList) {
	    for (DispatchCreateRequestDto dto : dtoList) {
	        if (dto.getSourceType() == null) dto.setSourceType("MANUAL");
	        if (dto.getUpdatedBy() == null) dto.setUpdatedBy(dto.getDispatcher());
	        
	        orderService.updateOrderStatus(
        		dto.getDispatcher(), 
        		new OrderStatusHistoryCreateRequestDto(null, dto.getOrderId(), "DISPATCHED", null, null)
    		);
	    }
	    
	    mapper.insertBatch(dtoList);
	}

	@Override
	public List<DispatchResponseDto> select() {
	    List<DispatchVO> dispatchList = mapper.select();

	    return dispatchList.stream()
	        .map(dispatch -> {
	        	return new DispatchResponseDto.Builder()
		        	.dispatchId(dispatch.getDispatchId())
		            .orderId(dispatch.getOrderId())
		            .warehouseName(dispatch.getWarehouseName())
		            .dispatchDate(dispatch.getDispatchDate())
		            .dispatcher(dispatch.getDispatcher())
		            .createdAt(dispatch.getCreatedAt())
		            .build();
	        })
	        .collect(Collectors.toList());
	}
}
