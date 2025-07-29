package kr.co.logitics_track_360.shipment.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public class ShipmentUpdateRequestDto {
    private Long shipmentId;
    private String carrierName;
    private String trackingNumber;
    private String shipmentStatus;
    private String sourceType = "MANUAL";
    private String updatedBy;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") 
    private LocalDateTime shippedAt;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd") 
    private LocalDate arrivalEstimate;

    public ShipmentUpdateRequestDto() {}

    public ShipmentUpdateRequestDto(Long shipmentId, String carrierName, String trackingNumber,
                                    LocalDateTime shippedAt, LocalDate arrivalEstimate,
                                    String shipmentStatus, String sourceType, String updatedBy) {
        this.shipmentId = shipmentId;
        this.carrierName = carrierName;
        this.trackingNumber = trackingNumber;
        this.shippedAt = shippedAt;
        this.arrivalEstimate = arrivalEstimate;
        this.shipmentStatus = shipmentStatus;
        this.sourceType = sourceType;
        this.updatedBy = updatedBy;
    }

    public Long getShipmentId() {
        return shipmentId;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public LocalDateTime getShippedAt() {
        return shippedAt;
    }

    public LocalDate getArrivalEstimate() {
        return arrivalEstimate;
    }

    public String getShipmentStatus() {
        return shipmentStatus;
    }

    public String getSourceType() {
        return sourceType;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

	public void setShipmentId(Long shipmentId) {
		this.shipmentId = shipmentId;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public void setShippedAt(LocalDateTime shippedAt) {
		this.shippedAt = shippedAt;
	}

	public void setArrivalEstimate(LocalDate arrivalEstimate) {
		this.arrivalEstimate = arrivalEstimate;
	}

	public void setShipmentStatus(String shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
}
