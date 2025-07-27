package kr.co.logitics_track_360.order.dto;

import java.util.List;

public class OrderCreateRequestDto {
    private String userId;
    private String title;
    private String description;
    private String status;                    /* READY, PICKUP, DISPATCHED */
    private List<ItemCreateRequestDto> items;
    
    public OrderCreateRequestDto() { }
    
	public OrderCreateRequestDto(String userId, String title, String description, String status, List<ItemCreateRequestDto> items) {
		this.userId = userId;
		this.title = title;
		this.description = description;
		this.status = status;
		this.items = items;
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
