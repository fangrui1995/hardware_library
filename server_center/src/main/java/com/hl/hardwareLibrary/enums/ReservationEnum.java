package com.hl.hardwareLibrary.enums;

public enum ReservationEnum {

    //'1-申请 2-同意 3-拒绝 4-借出中 5-回收 6-删除',
    APPLY(1,"申请"),
    PASS(2,"同意"),
    REFUSE(3,"拒绝"),
    LENDING(4,"借出"),
    RECOVERY(5,"回收"),
    DISABLE(6,"删除");

    private Integer key;

    private String value;

    ReservationEnum(Integer key, String value) {
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
