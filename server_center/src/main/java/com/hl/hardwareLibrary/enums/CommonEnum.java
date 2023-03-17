package com.hl.hardwareLibrary.enums;

public enum CommonEnum {

    ENABLE(1,"正常"),
    DISABLE(2,"禁用");

    private Integer key;

    private String value;

    CommonEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
