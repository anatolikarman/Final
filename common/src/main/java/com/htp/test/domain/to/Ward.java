package com.htp.test.domain.to;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ward ward = (Ward) o;
        return Objects.equals(wardId, ward.wardId) &&
                Objects.equals(number, ward.number) &&
                Objects.equals(maxCapacity, ward.maxCapacity) &&
                Objects.equals(capacity, ward.capacity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wardId, number, maxCapacity, capacity);
    }
}
