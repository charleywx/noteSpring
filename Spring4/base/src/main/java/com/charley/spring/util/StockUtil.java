package com.charley.spring.util;//package util;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//
//public class StockUtil {
//
//    private static Logger log = LoggerFactory.getLogger(StockUtil.class);
//
//    public static String getFullCode(String code) {
//        if(StringUtil.isBlank(code)) {
//            log.error("参数为空，代码为空!");
//            return null;
//        }
//        if(code.startsWith("00") || code.startsWith("30")) {
//            return "sz" + code;
//        }
//        else if(code.startsWith("60")) {
//            return "sh" + code;
//        }
//        return null;
//    }
//
//}
