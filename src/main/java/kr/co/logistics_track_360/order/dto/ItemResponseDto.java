package kr.co.logistics_track_360.order.dto;

import java.math.BigDecimal;

public class ItemResponseDto {
	private Long itemId;
    private String orderId;
    private String name;
    private int quantity;
    private String unit;
    private BigDecimal weight;
    private String hsCode;
    
    public ItemResponseDto() { }
    
	public ItemResponseDto(Long itemId, String orderId, String name, int quantity, String unit, BigDecimal weight,
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
	
	public static class Builder {
        private Long itemId;
        private String orderId;
        private String name;
        private int quantity;
        private String unit;       /* EA, KG */
        private BigDecimal weight;
        private String hsCode;

        public Builder itemId(Long itemId) {
            this.itemId = itemId;
            return this;
        }

        public Builder orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder unit(String unit) {
            this.unit = unit;
            return this;
        }

        public Builder weight(BigDecimal weight) {
            this.weight = weight;
            return this;
        }

        public Builder hsCode(String hsCode) {
            this.hsCode = hsCode;
            return this;
        }

        public ItemResponseDto build() {
            return new ItemResponseDto(itemId, orderId, name, quantity, unit, weight, hsCode);
        }
    }
}
