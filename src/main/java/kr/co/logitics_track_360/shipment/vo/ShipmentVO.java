package kr.co.logitics_track_360.shipment.vo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ShipmentVO {

    private final Long shipmentId;
    private final String orderId;
    private final String carrierName;
    private final String trackingNumber;
    private final LocalDateTime shippedAt;
    private final LocalDate arrivalEstimate;
    private final String shipmentStatus;
    private final String sourceType;
    private final String updatedBy;
    private final LocalDateTime updatedAt;
    private final LocalDateTime createdAt;

    public ShipmentVO(Long shipmentId, String orderId, String carrierName, String trackingNumber,
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
}