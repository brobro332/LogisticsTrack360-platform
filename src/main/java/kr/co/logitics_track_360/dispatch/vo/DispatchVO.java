package kr.co.logitics_track_360.dispatch.vo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DispatchVO {

    private Long dispatchId;
    private String orderId;
    private String warehouseName;
    private LocalDate dispatchDate;
    private String dispatcher;
    private String dispatchStatus;
    private String sourceType;
    private String updatedBy;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;

    public DispatchVO() {}

    public DispatchVO(Long dispatchId, String orderId, String warehouseName, LocalDate dispatchDate, String dispatcher,
                      String dispatchStatus, String sourceType, String updatedBy, LocalDateTime updatedAt, LocalDateTime createdAt) {
        this.dispatchId = dispatchId;
        this.orderId = orderId;
        this.warehouseName = warehouseName;
        this.dispatchDate = dispatchDate;
        this.dispatcher = dispatcher;
        this.dispatchStatus = dispatchStatus;
        this.sourceType = sourceType;
        this.updatedBy = updatedBy;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
    }

    public Long getDispatchId() {
        return dispatchId;
    }

    public void setDispatchId(Long dispatchId) {
        this.dispatchId = dispatchId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public LocalDate getDispatchDate() {
        return dispatchDate;
    }

    public void setDispatchDate(LocalDate dispatchDate) {
        this.dispatchDate = dispatchDate;
    }

    public String getDispatcher() {
        return dispatcher;
    }

    public void setDispatcher(String dispatcher) {
        this.dispatcher = dispatcher;
    }

    public String getDispatchStatus() {
        return dispatchStatus;
    }

    public void setDispatchStatus(String dispatchStatus) {
        this.dispatchStatus = dispatchStatus;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
