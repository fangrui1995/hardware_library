package com.hl.hardwareLibrary.enums;


/**
 * 四大产业
 */
public enum ParameterEnum {

    HF_DQ("SC01_12A0","PA_A043"),
    HF("SC02_L12A000000","PA_A044"),
    FD("SC02_L12A100000","PA_A045"),
    FX("SC02_L12A200000","PA_A046"),
    CF("SC02_L12A300000","PA_A047"),
    CH("SC02_L12K000000","PA_A048"),
    LJ("SC02_L12K100000","PA_A049");

    private String memberId;

    private String paraId;

    ParameterEnum(String memberId, String paraId) {
        this.memberId = memberId;
        this.paraId = paraId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getParaId() {
        return paraId;
    }

    public void setParaId(String paraId) {
        this.paraId = paraId;
    }


    public static String fromMemberId(String memberId){

        String paraId = "";
        for (ParameterEnum value : ParameterEnum.values()) {
            if(value.getMemberId().equals(memberId)){
                paraId = value.getParaId();
                break;
            }
        }
        return paraId;
    }
}