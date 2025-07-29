package kr.co.logistics_track_360.dispatch.dto;

import java.time.LocalDate;

public class DispatchCreateRequestDto {
    private Long orderId;  
    private String warehouseName;
    private LocalDate dispatchDate;
    private String dispatcher;
    private String sourceType;
    private String updatedBy;

    public DispatchCreateRequestDto() { }

    public DispatchCreateRequestDto(Long orderId, String warehouseName, LocalDate dispatchDate, String dispatcher, String sourceType, String updatedBy) {
        this.orderId = orderId;
        this.warehouseName = warehouseName;
        this.dispatchDate = dispatchDate;
        this.dispatcher = dispatcher;
        this.sourceType = sourceType;
        this.updatedBy = updatedBy;
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getWarehouseName() {
        return warehouseName;
    }
    
    public LocalDate getDispatchDate() {
        return dispatchDate;
    }
    
    public String getDispatcher() {
        return dispatcher;
    }
    
    public String getSourceType() {
        return sourceType;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }
    
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public void setDispatchDate(LocalDate dispatchDate) {
        this.dispatchDate = dispatchDate;
    }

    public void setDispatcher(String dispatcher) {
        this.dispatcher = dispatcher;
        this.updatedBy = dispatcher;
    }

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
}
