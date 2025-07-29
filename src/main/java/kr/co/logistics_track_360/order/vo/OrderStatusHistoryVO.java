package kr.co.logistics_track_360.order.vo;

import java.time.LocalDateTime;

public class OrderStatusHistoryVO {
	private Long historyId;
    private String orderId;
    private String status;           /* READY, PICKUP, DISPATCHED */
    private String updatedBy;
    private LocalDateTime updatedAt;
    
	public OrderStatusHistoryVO(Long historyId, String orderId, String status, String updatedBy,
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
}
