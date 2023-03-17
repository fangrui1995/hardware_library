package com.hl.hardwareLibrary.enums;

public enum DirectionEnum {


    FORWARD("正向"),
    REVERSE("反向");

    private String direction;

    DirectionEnum(String direction) {
        this.direction = direction;
    }


    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
