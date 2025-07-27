package kr.co.logitics_track_360.order.dto;

import java.math.BigDecimal;

public class ItemCreateRequestDto {
	private String orderId;
	private String name;
    private int quantity;
    private String unit;       /* EA, KG */
    private BigDecimal weight;
    private String hsCode;
    
    public ItemCreateRequestDto() { }
    
	public ItemCreateRequestDto(String orderId, String name, int quantity, String unit, BigDecimal weight, String hsCode) {
		this.orderId = orderId;
		this.name = name;
		this.quantity = quantity;
		this.unit = unit;
		this.weight = weight;
		this.hsCode = hsCode;
	}
	
	public String getOrderId() {
		return orderId;
	}

	public String getName() {
		return name;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public String getUnit() {
		return unit;
	}
	
	public BigDecimal getWeight() {
		return weight;
	}
	
	public String getHsCode() {
		return hsCode;
	}
	
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}
	
	public void setHsCode(String hsCode) {
		this.hsCode = hsCode;
	}
}
