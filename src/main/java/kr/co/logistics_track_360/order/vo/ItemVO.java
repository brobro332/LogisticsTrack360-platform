package kr.co.logistics_track_360.order.vo;

import java.math.BigDecimal;

public class ItemVO {
	private Long itemId;
    private String orderId;
    private String name;
    private int quantity;
    private String unit;       /* EA, KG */
    private BigDecimal weight;
    private String hsCode;
    
	public ItemVO(Long itemId, String orderId, String name, int quantity, String unit, BigDecimal weight,
			String hsCode) {
		this.itemId = itemId;
		this.orderId = orderId;
		this.name = name;
		this.quantity = quantity;
		this.unit = unit;
		this.weight = weight;
		this.hsCode = hsCode;
	}

	public Long getItemId() {
		return itemId;
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
}
