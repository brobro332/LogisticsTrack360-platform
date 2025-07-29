package kr.co.logitics_track_360.order.dto;

import java.time.LocalDate;

public class OrderSearchRequestDto {
	private String userId;
	private String keyword;     /* title, description */
    private String status;      /* READY, PICKUP, DISPATCHED, DELIVERED, COMPLETED, DELETED */
    private LocalDate fromDate;
    private LocalDate toDate;
    private int page = 1;
    private int size = 10;
    
    public OrderSearchRequestDto() { }
    
	public OrderSearchRequestDto(String userId, String keyword, String status, LocalDate fromDate, LocalDate toDate, int page, int size) {
		this.userId = userId;
		this.keyword = keyword;
		this.status = status;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.page = page;
		this.size = size;
	}

	public String getUserId() {
		return userId;
	}

	public String getKeyword() {
		return keyword;
	}
	
	public String getStatus() {
		return status;
	}
	
	public LocalDate getFromDate() {
		return fromDate;
	}
	
	public LocalDate getToDate() {
		return toDate;
	}
	
	public int getPage() {
		return page;
	}
	
	public int getSize() {
		return size;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}
	
	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}
	
	public void setPage(int page) {
		this.page = page;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
}
