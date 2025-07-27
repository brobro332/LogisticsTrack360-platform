package kr.co.logitics_track_360.order.vo;

import java.time.LocalDateTime;
import java.util.List;

import kr.co.logitics_track_360.order.dto.ItemCreateRequestDto;

public class OrderVO {
    private String orderId;
    private String userId;
    private String title;
    private String description;
    private String status;                    /* READY, PICKUP, DISPATCHED */
    private List<ItemCreateRequestDto> items;
    private String userName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    public OrderVO(String orderId, String userId, String title, String description, String status,
                   List<ItemCreateRequestDto> items, String userName, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.orderId = orderId;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.status = status;
        this.items = items;
        this.userName = userName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getOrderId() {
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

    public List<ItemCreateRequestDto> getItems() {
        return items;
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
