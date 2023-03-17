package com.hl.hardwareLibrary.enums;

public enum SceneEnum {

    CITY(1,"市公司"),
    COUNTY(2,"县公司"),
    REGION(3,"地区");

    private Integer code;

    private String str;

    SceneEnum(Integer code, String str) {
        this.code = code;
        this.str = str;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
