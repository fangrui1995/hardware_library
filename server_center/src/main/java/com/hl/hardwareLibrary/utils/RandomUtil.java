package com.hl.hardwareLibrary.utils;

import java.security.SecureRandom;

/**
 * @Description: 随机字符串工具类
 * @Author: lojic
 * @Date: 2020/12/21
 * @see: com.wtkj.internalsimulation.com.ahsh.home.utils
 */
public class RandomUtil {
    private static final String src_number = "0123456789";
    private static final String src_upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String get(int size) {
        StringBuffer r = new StringBuffer(size);
        String src = src_number + src_upper;
        for (int i = 0; i < size; i++) {
            r.append(getRandomChar(src));
        }
        return r.toString();
    }

    private static final String getRandomChar(String src) {
        if (null == src || "".equals(src)) {
            return "";
        }
        SecureRandom secureRandom = new SecureRandom();
        return String.valueOf((src.charAt((int) (secureRandom.nextDouble() * src.length()))));
    }
}
