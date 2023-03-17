package com.hl.hardwareLibrary.utils;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class OrderUtils {


    public static <T> List<T> getRank(List<T> list,String filedName) {

        if(null==list||list.size()<=0){
            return list;
        }

        int rank = 1;
        String value = "";

        for (int i = 0; i < list.size(); i++) {

            T t = list.get(i);

            if(null==t){
                continue;
            }

            JSONObject o = (JSONObject) JSONObject.toJSON(t);

            if(null==o.get(filedName)){
                rank = i+1;
                BeanUtil.setProperty(t,"rank",i+1);
                continue;
            }

            String rankValue = o.get(filedName).toString();



            if(i==0){
                BeanUtil.setProperty(t,"rank",rank);
                value = rankValue;
                continue;
            }

            if(value.equals(rankValue)){
                BeanUtil.setProperty(t,"rank",rank);
            }else {
                rank = i+1;
                value = rankValue;
                BeanUtil.setProperty(t,"rank",i+1);
            }
        }

        return list;
    }



    public static <T> List<T> getRank(List<T> list,String filedName,String setFiled) {

        if(null==list||list.size()<=0){
            return list;
        }

        int rank = 1;
        String value = "";

        for (int i = 0; i < list.size(); i++) {

            T t = list.get(i);

            if(null==t){
                continue;
            }

            JSONObject o = (JSONObject) JSONObject.toJSON(t);


            if(null==o.get(filedName)){
                rank = i+1;
                BeanUtil.setProperty(t,"rank",i+1);
                continue;
            }

            String rankValue = o.get(filedName).toString();

            if(i==0){
                BeanUtil.setProperty(t,setFiled,rank);
                value = rankValue;
                continue;
            }

            if(value.equals(rankValue)){
                BeanUtil.setProperty(t,setFiled,rank);
            }else {
                rank = i+1;
                value = rankValue;
                BeanUtil.setProperty(t,setFiled,i+1);
            }
        }

        return list;
    }
}
