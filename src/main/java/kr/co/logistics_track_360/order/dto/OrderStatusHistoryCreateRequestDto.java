package kr.co.logistics_track_360.order.dto;

import java.time.LocalDateTime;

import lombok.ToString;

@ToString
public class OrderStatusHistoryCreateRequestDto {
	private Long historyId;
    private Long orderId;
    private String status;           /* READY, PICKUP, DISPATCHED, DELIVERED, COMPLETED, DELETED */
    private String updatedBy;
    private LocalDateTime updatedAt;
    
    public OrderStatusHistoryCreateRequestDto() { }
    
	public OrderStatusHistoryCreateRequestDto(Long historyId, Long orderId, String status, String updatedBy,
			LocalDateTime updatedAt) {
		this.historyId = historyId;
		this.orderId = orderId;
		this.status = status;
		this.updatedBy = updatedBy;
		this.updatedAt = updatedAt;
	}

	public Long getHistoryId() {
		return historyId;
	}
	
	public Long getOrderId() {
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

	public void setHistoryId(Long historyId) {
		this.historyId = historyId;
	}

	public void setOrderId(Long orderId) {
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
