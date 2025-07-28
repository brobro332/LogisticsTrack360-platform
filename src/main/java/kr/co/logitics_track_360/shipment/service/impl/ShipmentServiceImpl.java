package kr.co.logitics_track_360.shipment.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.logitics_track_360.shipment.dao.ShipmentMapper;
import kr.co.logitics_track_360.shipment.dto.ShipmentCreateRequestDto;
import kr.co.logitics_track_360.shipment.dto.ShipmentResponseDto;
import kr.co.logitics_track_360.shipment.dto.ShipmentUpdateRequestDto;
import kr.co.logitics_track_360.shipment.service.ShipmentService;
import kr.co.logitics_track_360.shipment.vo.ShipmentVO;

@Service
@Transactional(readOnly = true)
public class ShipmentServiceImpl implements ShipmentService {
	private final ShipmentMapper mapper;
	
	public ShipmentServiceImpl(ShipmentMapper mapper) {
		this.mapper = mapper;
	}

	public List<ShipmentResponseDto> selectShipmentList() {
	    List<ShipmentVO> shipmentList = mapper.selectShipmentList();
	    return shipmentList.stream()
	        .map(shipment -> 
	        	new ShipmentResponseDto.Builder()
	        	.shipmentId(shipment.getShipmentId())
	            .orderId(shipment.getOrderId())
	            .carrierName(shipment.getCarrierName())
	            .trackingNumber(shipment.getTrackingNumber())
	            .shippedAt(shipment.getShippedAt())
	            .arrivalEstimate(shipment.getArrivalEstimate())
	            .shipmentStatus(shipment.getShipmentStatus())
	            .sourceType(shipment.getSourceType())
	            .updatedBy(shipment.getUpdatedBy())
	            .updatedAt(shipment.getUpdatedAt())
	            .createdAt(shipment.getCreatedAt())
	            .build()
	        )
	        .collect(Collectors.toList());
	}

	@Override
	public ShipmentResponseDto selectShipment(Long shipmentId) {
		ShipmentVO shipment = mapper.selectShipment(shipmentId);
		
		return new ShipmentResponseDto.Builder()
        	.shipmentId(shipment.getShipmentId())
            .orderId(shipment.getOrderId())
            .carrierName(shipment.getCarrierName())
            .trackingNumber(shipment.getTrackingNumber())
            .shippedAt(shipment.getShippedAt())
            .arrivalEstimate(shipment.getArrivalEstimate())
            .shipmentStatus(shipment.getShipmentStatus())
            .sourceType(shipment.getSourceType())
            .updatedBy(shipment.getUpdatedBy())
            .updatedAt(shipment.getUpdatedAt())
            .createdAt(shipment.getCreatedAt())
            .build();
	}

	@Override
	@Transactional
	public int create(ShipmentCreateRequestDto dto) {
		return mapper.insert(dto);
	}

	@Override
	@Transactional
	public int update(ShipmentUpdateRequestDto dto) {
		return mapper.update(dto);
	}
}
