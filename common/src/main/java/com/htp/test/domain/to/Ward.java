package com.htp.test.domain.to;

public class Ward {
    private Long wardId;
    private Long number;
    private Long maxCapacity;
    private Long capacity;

    public Long getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Long maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public Long getWardId() {
        return wardId;
    }

    public void setWardId(Long wardId) {
        this.wardId = wardId;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long name) {
        this.number = number;
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }
}
