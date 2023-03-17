package com.hl.hardwareLibrary.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Pattern;

public class IpUtil {
    /**
     * 获取登录用户的IP地址
     *
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if ("0:0:0:0:0:0:0:1".equals(ip)) {
            ip = "127.0.0.1";
        }
        if (ip.split(",").length > 1) {
            ip = ip.split(",")[0];
        }
        return ip;
    }


    public static String getNewIpAddr(HttpServletRequest request) {
        String ipAddress = request.getHeader("x-forwarded-for");
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
                try {
                    ipAddress = ipMatch(InetAddress.getLocalHost().getHostAddress());
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }

            }
        }

        if (ipAddress != null && ipAddress.length() > 15) {
            if (ipAddress.indexOf(",") > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
            }
        }
        return ipAddress;
    }


    private static String ipMatch(String ip){
        if (Pattern.matches("[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(/.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+/.?", ip)) {
            return ip;
        }
        return "0";
    }


    public static String getIp(HttpServletRequest request) throws Exception{
        String ip = request.getHeader("X-Real-IP");
        if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
            return ip;
        }
        ip = request.getHeader("X-Forwarded-For");
        if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个IP值，第一个为真实IP。
            int index = ip.indexOf(',');
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        } else {
            return request.getRemoteAddr();
        }
    }

    /**
     * 通过IP获取地址(需要联网，调用淘宝的IP库)
     *
     * @param ip
     * @return
     */
//    public static String getIpInfo(String ip) {
//        if ("127.0.0.1".equals(ip)) {
//            ip = "127.0.0.1";
//        }
//        String info = "";
//        BufferedReader bufferedReader = null;
//        try {
//            URL url = new URL("http://ip.taobao.com/service/getIpInfo.php?ip=" + ip);
//            HttpURLConnection htpcon = (HttpURLConnection) url.openConnection();
//            htpcon.setRequestMethod("GET");
//            htpcon.setDoOutput(true);
//            htpcon.setDoInput(true);
//            htpcon.setUseCaches(false);
//
//            InputStream in = htpcon.getInputStream();
//            bufferedReader = new BufferedReader(new InputStreamReader(in));
//            StringBuilder temp = new StringBuilder();
//            String line = bufferedReader.readLine();
//            while (line != null) {
//                temp.append(line).append("\r\n");
//                line = bufferedReader.readLine();
//            }
//            JSONObject obj = (JSONObject) JSONObject.parse(temp.toString());
//            if (obj.getIntValue("code") == 0) {
//                JSONObject data = obj.getJSONObject("data");
//                info += data.getString("country") + " ";
//                info += data.getString("region") + " ";
//                info += data.getString("city") + " ";
//                info += data.getString("isp");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            if (null!=bufferedReader) {
//                try {
//                    bufferedReader.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        }
//        return info;
//    }
}

