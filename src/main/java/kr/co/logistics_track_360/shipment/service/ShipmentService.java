package kr.co.logistics_track_360.shipment.service;

import java.util.List;

import kr.co.logistics_track_360.shipment.dto.ShipmentCreateRequestDto;
import kr.co.logistics_track_360.shipment.dto.ShipmentResponseDto;
import kr.co.logistics_track_360.shipment.dto.ShipmentUpdateRequestDto;

public interface ShipmentService {
	List<ShipmentResponseDto> selectShipmentList();
	ShipmentResponseDto selectShipment(Long shipmentId);
	int create(ShipmentCreateRequestDto dto);
	int update(ShipmentUpdateRequestDto dto);
}
