package com.hl.hardwareLibrary.enums;

public enum RoleEnum {


    r001(1,"公司领导"),
    r002(2,"办公室人员"),
    r003(3,"部门领导"),
    r004(4,"普通员工");


    private Integer key;

    private String value;

    RoleEnum(Integer key, String value) {
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
