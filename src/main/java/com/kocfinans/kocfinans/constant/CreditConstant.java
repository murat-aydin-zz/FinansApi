package com.kocfinans.kocfinans.constant;

public enum CreditConstant {
    DENIED(1), NATURALLIMIT(2), ADVANCEDLIMIT(3);

    private final int value;

    private CreditConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
