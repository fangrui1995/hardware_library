package com.hl.hardwareLibrary.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
@Slf4j
public class demo {

    public static void main(String[] args) {
        String exePath= "C:\\Users\\fangrui\\Desktop\\xema\\Release\\My_xema_project.exe";
        BufferedReader br = null;
        BufferedReader brError;
        String line = null;
        try {
            /**
             * String cmd = "D:\\Xftp6\\Xftp.exe";
             * 方式一：使用Runtime.getRuntime().exec()；
             * 执行exe cmd可以为字符串(exe存放路径)也可为数组,
             * 调用exe时需要传入参数时，可以传数组调用(参数有顺序要求)
             * String[] cmd ={"exe绝对路径", "param1", "param2", "param3"};
             * Runtime.getRuntime().exec(cmd);
             */
            //方式二：
            Process p = new ProcessBuilder(exePath,"fffff","asdasd").start();
            br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            brError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            while ((line = br.readLine()) != null || (line = brError.readLine()) != null) {
                //输出exe输出的信息以及错误信息
                log.info(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
