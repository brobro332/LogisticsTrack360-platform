package kr.co.logistics_track_360.shipment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.logistics_track_360.shipment.dto.ShipmentCreateRequestDto;
import kr.co.logistics_track_360.shipment.dto.ShipmentUpdateRequestDto;
import kr.co.logistics_track_360.shipment.vo.ShipmentVO;

@Mapper
public interface ShipmentMapper {
	List<ShipmentVO> selectShipmentList();
	ShipmentVO selectShipment(Long shipmentId);
	int insert(ShipmentCreateRequestDto dto);
	int update(ShipmentUpdateRequestDto dto);
}