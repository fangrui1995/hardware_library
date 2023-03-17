package com.hl.hardwareLibrary.common;

public interface SysRoleConstant {

    /**
     * 角色类型
     */
    public enum sysRoleEnum {

        COMPANY_LEADER(1, "公司领导"),
        OFFICE_PERSON(2, "办公室人员"),
        DEPT_LEADER(3, "部门领导"),
        STAFF(4, "普通员工");

        int code;
        String name;

        sysRoleEnum(int code, String name) {
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
