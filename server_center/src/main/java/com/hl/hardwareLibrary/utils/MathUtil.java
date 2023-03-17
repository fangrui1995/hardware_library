package com.hl.hardwareLibrary.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MathUtil {

    public static Set<String> getFactorIds(String indexFomula) {

        Pattern pattern = Pattern.compile("\\+|\\-|\\*|\\/|\\(|\\)|\\{|\\}");
        String[] split = pattern.split(indexFomula);

        Set<String> set = new HashSet<>();
        if(null!=split&&split.length>0){
            //指标因子名集合
            List<String> yzList = new ArrayList<>(Arrays.asList(split));

            set = yzList.stream().filter(StringUtils::isNotEmpty)
                    .collect(Collectors.toSet());
        }
        return set;
    }


    public static List<String> getIndexAnalyze(String indexFomula) {

        Pattern pattern = Pattern.compile("\\+|\\-|\\*|\\/|\\(|\\)|\\{|\\}|\\（|\\）|\\,|\\，|\\;|\\；");
        Matcher matcher = pattern.matcher(indexFomula);

        String[] split = pattern.split(indexFomula);

        List<String> stringList = new ArrayList<>();

        if(split.length>0){
            int count = 0;
            while (count<split.length){

                stringList.add(split[count]);
                if(matcher.find()){
                    stringList.add(matcher.group());
                }
                count++;
            }
        }
        return stringList;
    }



}
