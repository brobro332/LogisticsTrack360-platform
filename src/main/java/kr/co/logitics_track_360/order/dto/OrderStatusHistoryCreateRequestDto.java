package kr.co.logitics_track_360.order.dto;

import java.time.LocalDateTime;

public class OrderStatusHistoryCreateRequestDto {
	private Long statusId;
    private String orderId;
    private String status;           /* READY, PICKUP, DISPATCHED, DELIVERED, COMPLETED, DELETED */
    private String updatedBy;
    private LocalDateTime updatedAt;
    
    public OrderStatusHistoryCreateRequestDto() { }
    
	public OrderStatusHistoryCreateRequestDto(Long statusId, String orderId, String status, String updatedBy,
			LocalDateTime updatedAt) {
		this.statusId = statusId;
		this.orderId = orderId;
		this.status = status;
		this.updatedBy = updatedBy;
		this.updatedAt = updatedAt;
	}

	public Long getStatusId() {
		return statusId;
	}
	
	public String getOrderId() {
		return orderId;
	}
	
	public String getStatus() {
		return status;
	}
	
	public String getUpdatedBy() {
		return updatedBy;
	}
	
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
}
