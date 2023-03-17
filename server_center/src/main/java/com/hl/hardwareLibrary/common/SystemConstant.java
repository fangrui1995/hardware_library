package com.hl.hardwareLibrary.common;

public interface SystemConstant {

    /**
     * 状态
     */
    public enum statusEnum {

        NORMAL(1, "正常"),
        FORBIDDEN(2, "禁用");

        int code;
        String name;

        statusEnum(int code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getCode() {
            return code;
        }
    }

}
