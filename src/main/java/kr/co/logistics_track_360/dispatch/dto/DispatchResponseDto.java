package kr.co.logistics_track_360.dispatch.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DispatchResponseDto {

    private final Long dispatchId;
    private final String orderId;
    private final String warehouseName;
    private final LocalDate dispatchDate;
    private final String dispatcher;
    private final LocalDateTime createdAt;

    public DispatchResponseDto(Long dispatchId, String orderId, String warehouseName, LocalDate dispatchDate,
                               String dispatcher, LocalDateTime createdAt) {
        this.dispatchId = dispatchId;
        this.orderId = orderId;
        this.warehouseName = warehouseName;
        this.dispatchDate = dispatchDate;
        this.dispatcher = dispatcher;
        this.createdAt = createdAt;
    }

    public Long getDispatchId() {
        return dispatchId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public LocalDate getDispatchDate() {
        return dispatchDate;
    }

    public String getDispatcher() {
        return dispatcher;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public static class Builder {
        private Long dispatchId;
        private String orderId;
        private String warehouseName;
        private LocalDate dispatchDate;
        private String dispatcher;
        private LocalDateTime createdAt;

        public Builder dispatchId(Long dispatchId) {
            this.dispatchId = dispatchId;
            return this;
        }

        public Builder orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder warehouseName(String warehouseName) {
            this.warehouseName = warehouseName;
            return this;
        }

        public Builder dispatchDate(LocalDate dispatchDate) {
            this.dispatchDate = dispatchDate;
            return this;
        }

        public Builder dispatcher(String dispatcher) {
            this.dispatcher = dispatcher;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public DispatchResponseDto build() {
            return new DispatchResponseDto(dispatchId, orderId, warehouseName, dispatchDate, dispatcher, createdAt);
        }
    }
}
