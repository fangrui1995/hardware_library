package com.hl.hardwareLibrary.enums;

public enum InventoryEnum {

    //'1-申请 2-同意 3-拒绝 4-借出中 5-回收 6-删除',
    STOCK(1,"在库"),
    LEND(2,"借出"),
    LOST(3,"丢失"),
    DISABLE(4,"删除");

    private Integer key;

    private String value;

    InventoryEnum(Integer key, String value) {
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
