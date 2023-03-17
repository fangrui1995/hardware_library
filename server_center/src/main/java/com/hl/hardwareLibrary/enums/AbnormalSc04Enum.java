package com.hl.hardwareLibrary.enums;//package com.wtkj.internalsimulation.com.ahsh.home.enums;
//
//public enum AbnormalSc04Enum {
//
//
//
////    1、供电所利润PS4110=0为异常，标记2，否则正常，标记1；
////            2、台区综合线损率YS4119<0或为空为异常，标记2，否则正常，标记1；
////            3、供电所台区容量 JH4121<=0为异常，标记2，否则正常，标记1；
////            4、供电所服务用户数 JH4122<=0为异常，标记2，否则正常，标记1；
////            5、供电所公变售电量yz4112<0为异常，标记2，否则正常，标记1；
////            6、供电所购电成本JH4105<0为异常，标记2，否则正常，标记1；
////            7、供电所购电量JH4109<0为异常，标记2，否则正常，标记1；
////            8、供电所人数YS4120=0为异常，标记2，否则正常，标记1。
//
//
//    yz4110("sc04_01","供电所利润=0","PS4110 = 0","PS4110","元"),
//    zb4002("sc04_02","供电所台区容量<=0","zb4002 = 0","","千伏安"),
//    zb4013("sc04_03","台区综合线损率<0","zb4013 < 0","","%"),
//    zb4013_null("sc04_04","台区综合线损率为空","zb4013 is null","","%"),
//    zb4014("sc04_05","人均台区容量=0","zb4014 = 0","","千伏安/人"),
//    zb4015("sc04_06","人均服务用户数=0","zb4015 = 0","","户/人");
//
//    private String code;
//
//    private String txt;
//
//    private String value;
//
//    private String factorId;
//
//    private String unit;
//
//    AbnormalSc04Enum(String code, String txt, String value,String factorId,String unit) {
//        this.code = code;
//        this.txt = txt;
//        this.value = value;
//        this.factorId = factorId;
//        this.unit = unit;
//    }
//
//
//    public String getCode() {
//        return code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//    public String getTxt() {
//        return txt;
//    }
//
//    public void setTxt(String txt) {
//        this.txt = txt;
//    }
//
//    public String getValue() {
//        return value;
//    }
//
//    public void setValue(String value) {
//        this.value = value;
//    }
//
//    public String getFactorId() {
//        return factorId;
//    }
//
//    public void setFactorId(String factorId) {
//        this.factorId = factorId;
//    }
//
//    public String getUnit() {
//        return unit;
//    }
//
//    public void setUnit(String unit) {
//        this.unit = unit;
//    }
//
//    public static String fromCodeToValue(String code){
//
//        String value = "";
//        for (AbnormalSc04Enum noScoreSc04Enum : AbnormalSc04Enum.values()) {
//            if(noScoreSc04Enum.getCode().equals(code)){
//                value = noScoreSc04Enum.getValue();
//                break;
//            }
//        }
//        return value;
//    }
//
//
//    public static String fromValueToTxt(String value){
//
//        String txt = "";
//        for (AbnormalSc04Enum noScoreSc04Enum : AbnormalSc04Enum.values()) {
//            if(noScoreSc04Enum.getValue().equals(value)){
//                txt = noScoreSc04Enum.getTxt();
//                break;
//            }
//        }
//        return txt;
//    }
//
//
//    public static String fromValueToFactorId(String value){
//
//        String factorId = "";
//        for (AbnormalSc04Enum noScoreSc04Enum : AbnormalSc04Enum.values()) {
//            if(noScoreSc04Enum.getValue().equals(value)){
//                factorId = noScoreSc04Enum.getFactorId();
//                break;
//            }
//        }
//        return factorId;
//    }
//}
