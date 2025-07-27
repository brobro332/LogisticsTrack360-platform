package kr.co.logitics_track_360.order.dto;

import java.time.LocalDateTime;

public class OrderStatusHistoryResponseDto {
	private Long statusId;
    private String orderId;
    private String status;           /* READY, PICKUP, DISPATCHED, DELIVERED, COMPLETED, DELETED */
    private String updatedBy;
    private LocalDateTime updatedAt;
    
    public OrderStatusHistoryResponseDto() { }
    
	public OrderStatusHistoryResponseDto(Long statusId, String orderId, String status, String updatedBy,
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
    
    public static class Builder {
        private Long statusId;
        private String orderId;
        private String status;
        private String updatedBy;
        private LocalDateTime updatedAt;

        public Builder statusId(Long statusId) {
            this.statusId = statusId;
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
            return new OrderStatusHistoryResponseDto(statusId, orderId, status, updatedBy, updatedAt);
        }
    }
}
