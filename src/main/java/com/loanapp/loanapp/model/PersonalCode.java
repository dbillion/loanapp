package com.loanapp.loanapp.model;


public enum PersonalCode {
    DEBT("49002010965"),
    SEGMENT_1("49002010976", 100),
    SEGMENT_2("49002010987", 300),
    SEGMENT_3("49002010998", 1000);

    private final String code;
    private final int creditModifier;

    PersonalCode(String code, int creditModifier) {
        this.code = code;
        this.creditModifier = creditModifier;
    }

    PersonalCode(String code) {
        this(code, 0);
    }

    public String getCode() {
        return code;
    }

    public int getCreditModifier() {
        return creditModifier;
    }
}
