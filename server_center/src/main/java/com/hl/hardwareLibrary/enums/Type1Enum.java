package com.hl.hardwareLibrary.enums;

/**
 *  属性1
 */
public enum Type1Enum {

    CITY_COM("市公司","市公司"),
    COUNTY_COM("县公司","县公司"),
    PRIVATE_COMPANY("本部","本部"),
    DIRECTLY_UNDER("直属单位","直属单位");

    private String code;

    private String value;

    Type1Enum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
