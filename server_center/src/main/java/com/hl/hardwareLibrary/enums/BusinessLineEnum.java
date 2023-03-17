package com.hl.hardwareLibrary.enums;

public enum BusinessLineEnum {
    YWTJ(0,"投资建设"),
    YWSD(1,"输电运检"),
    YWBD(2,"变电运检"),
    YWPD(3,"配电运检"),
    YWDT(4,"调度通信"),
    YWYJ(5,"运检综合"),
    YWJL(6,"电能计量"),
    YWKF(7,"客户服务"),
    YWYZ(8,"营销综合"),
    YWYG(9,"运营管理");

    private Integer key;

    private String value;

    BusinessLineEnum(Integer key, String value) {
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
