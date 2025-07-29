package kr.co.logitics_track_360.order.vo;

import java.time.LocalDateTime;

public class OrderVO {
    private Long orderId;
    private String userId;
    private String title;
    private String description;
    private String status;                    /* READY, PICKUP, DISPATCHED */
    private String userName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    public OrderVO(Long orderId, String userId, String title, String description, String status,
                   String userName, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.orderId = orderId;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.status = status;
        this.userName = userName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getUserId() {
        return userId;
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

    public String getUserName() {
        return userName;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
