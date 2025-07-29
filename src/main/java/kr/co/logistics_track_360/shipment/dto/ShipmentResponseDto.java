package kr.co.logistics_track_360.shipment.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ShipmentResponseDto {
    private Long shipmentId;
    private String orderId;
    private String carrierName;
    private String trackingNumber;
    private LocalDateTime shippedAt;
    private LocalDate arrivalEstimate;
    private String shipmentStatus;
    private String sourceType;
    private String updatedBy;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;

    public ShipmentResponseDto() {}

    public ShipmentResponseDto(Long shipmentId, String orderId, String carrierName, String trackingNumber,
                               LocalDateTime shippedAt, LocalDate arrivalEstimate, String shipmentStatus,
                               String sourceType, String updatedBy, LocalDateTime updatedAt, LocalDateTime createdAt) {
        this.shipmentId = shipmentId;
        this.orderId = orderId;
        this.carrierName = carrierName;
        this.trackingNumber = trackingNumber;
        this.shippedAt = shippedAt;
        this.arrivalEstimate = arrivalEstimate;
        this.shipmentStatus = shipmentStatus;
        this.sourceType = sourceType;
        this.updatedBy = updatedBy;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
    }

    public Long getShipmentId() {
        return shipmentId;
    }

    public String getOrderId() {
        return orderId;
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

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public static class Builder {
        private final ShipmentResponseDto dto;

        public Builder() {
            dto = new ShipmentResponseDto();
        }

        public Builder shipmentId(Long shipmentId) {
            dto.shipmentId = shipmentId;
            return this;
        }

        public Builder orderId(String orderId) {
            dto.orderId = orderId;
            return this;
        }

        public Builder carrierName(String carrierName) {
            dto.carrierName = carrierName;
            return this;
        }

        public Builder trackingNumber(String trackingNumber) {
            dto.trackingNumber = trackingNumber;
            return this;
        }

        public Builder shippedAt(LocalDateTime shippedAt) {
            dto.shippedAt = shippedAt;
            return this;
        }

        public Builder arrivalEstimate(LocalDate arrivalEstimate) {
            dto.arrivalEstimate = arrivalEstimate;
            return this;
        }

        public Builder shipmentStatus(String shipmentStatus) {
            dto.shipmentStatus = shipmentStatus;
            return this;
        }

        public Builder sourceType(String sourceType) {
            dto.sourceType = sourceType;
            return this;
        }

        public Builder updatedBy(String updatedBy) {
            dto.updatedBy = updatedBy;
            return this;
        }

        public Builder updatedAt(LocalDateTime updatedAt) {
            dto.updatedAt = updatedAt;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            dto.createdAt = createdAt;
            return this;
        }

        public ShipmentResponseDto build() {
            return dto;
        }
    }
}
