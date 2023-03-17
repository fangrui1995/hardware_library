package com.hl.hardwareLibrary.enums;

/**
 * @author Candy
 * @date 2020/12/1 9:08
 */
public enum RoleIdEnum {
    /*
    1	provinceUser	省级用户	2020-07-09 12:21:37
    2	cityUser	市级用户	2020-07-09 12:21:49
    3	countyUser	县级用户	2020-07-09 12:22:34
    4	groupUser	班组用户	2020-07-09 12:23:04
    5	admin	超级管理员	2020-07-09 12:07:19
    8	superadmin	临时超管	2020-10-08 11:25:32
    9	auditor	审计员	2021-01-07 07:36:05
     */

    provinceUser(1,"省级用户"),
    cityUser(2,"市级用户"),
    countyUser(3,"县级用户"),
    groupUser(4,"班组用户"),
    admin(5,"超级管理员"),
    superadmin(8,"临时超管"),
    auditor(9,"审计员");

    private Integer key;

    private String value;

    RoleIdEnum(Integer key, String value) {
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

