package com.hl.hardwareLibrary.enums;

/*
质效分类
 */
public enum QualityEffectEnum {

    JYXY(1,"经营效益"),
    GLXL(2,"管理效率"),
    FZZL(3,"发展质量");

    private Integer key;

    private String value;

    QualityEffectEnum(Integer key, String value) {
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