package com.hl.hardwareLibrary.enums;

/**
 *  各市场等级对应的编码
 */
public enum IndexType456Enum {

    ZL("zl","发展质量"),
    XY("xy","经营效益"),
    XL("xl","管理效率");


    private String code;

    private String value;

    IndexType456Enum(String code, String value) {
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


    public static String fromCode(String code){

        String value = "";
        for (IndexType456Enum indexType456Enum : IndexType456Enum.values()) {
            if(indexType456Enum.getCode().equals(code)){
                value = indexType456Enum.getValue();
                break;
            }
        }
        return value;
    }
}
