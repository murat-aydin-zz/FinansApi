package com.kocfinans.kocfinans.constant;

public enum CreditStatus {
    SUCCESS("KREDI ONAYLANDI"),
    DENIED("KREDI ONAYLANMADI")
    ;

    private final String text;

    CreditStatus(String text){
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
