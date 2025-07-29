package kr.co.logitics_track_360.order.dto;

import java.time.LocalDateTime;

import lombok.ToString;

@ToString
public class OrderResponseDto {
	private Long orderId;
	private String title;
    private String description;
    private String status;           /* READY, PICKUP, DISPATCHED, DELIVERED, COMPLETED, DELETED */
    private String userId;
    private String userName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    public OrderResponseDto() { }
    
	public OrderResponseDto(Long orderId, String title, String description, String status, String userId, String userName,
			LocalDateTime createdAt, LocalDateTime updatedAt) {
		this.orderId = orderId;
		this.title = title;
		this.description = description;
		this.status = status;
		this.userId = userId;
		this.userName = userName;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getOrderId() {
		return orderId;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getStatus() {
		return status;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	
	public static class Builder {
		private Long orderId;
		private String title;
	    private String description;
	    private String status;
	    private String userId;
	    private String userName;
	    private LocalDateTime createdAt;
	    private LocalDateTime updatedAt;

        public Builder orderId(Long orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }
        
        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }
        
        public Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }
        
        public Builder updatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public OrderResponseDto build() {
            return new OrderResponseDto(orderId, title, description, status, userId, userName, createdAt, updatedAt);
        }
    }
}
