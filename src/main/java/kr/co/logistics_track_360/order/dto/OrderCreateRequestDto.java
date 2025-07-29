package kr.co.logistics_track_360.order.dto;

import java.util.List;

public class OrderCreateRequestDto {
	private Long orderId;
    private String userId;
    private String title;
    private String description;
    private String status;                    /* READY, PICKUP, DISPATCHED, DELIVERED, COMPLETED, DELETED */
    private List<ItemCreateRequestDto> items;
    
    public OrderCreateRequestDto() { }
    
	public OrderCreateRequestDto(Long orderId, String userId, String title, String description, String status, List<ItemCreateRequestDto> items) {
		this.orderId = orderId;
		this.userId = userId;
		this.title = title;
		this.description = description;
		this.status = status;
		this.items = items;
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
	
	public List<ItemCreateRequestDto> getItems() {
		return items;
	}
	
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setItems(List<ItemCreateRequestDto> items) {
		this.items = items;
	}
}
