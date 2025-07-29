package kr.co.logitics_track_360.order.dto;

import java.time.LocalDateTime;

public class OrderStatusHistoryResponseDto {
	private Long historyId;
    private String orderId;
    private String status;           /* READY, PICKUP, DISPATCHED, DELIVERED, COMPLETED, DELETED */
    private String updatedBy;
    private LocalDateTime updatedAt;
    
    public OrderStatusHistoryResponseDto() { }
    
	public OrderStatusHistoryResponseDto(Long historyId, String orderId, String status, String updatedBy,
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
    
    public static class Builder {
        private Long historyId;
        private String orderId;
        private String status;
        private String updatedBy;
        private LocalDateTime updatedAt;

        public Builder historyId(Long historyId) {
            this.historyId = historyId;
            return this;
        }

        public Builder orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder updatedBy(String updatedBy) {
            this.updatedBy = updatedBy;
            return this;
        }

        public Builder updatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public OrderStatusHistoryResponseDto build() {
            return new OrderStatusHistoryResponseDto(historyId, orderId, status, updatedBy, updatedAt);
        }
    }
}
