package com.renren.jinkong.springbootThymeleaf.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

/**
 * Program:       springboot-thymeleaf
 * package        com.renren.jinkong.springbootThymeleaf.util
 * ClassName:     Utils
 * Description:   This is  a  class!
 * Date:          Created in  2019/6/20 16:56
 * Author         gaohaijiang
 * Version        V1.0.0
 */
public class Utils {

    public static  String  getUUID(){
       return UUID.randomUUID().toString().replaceAll("-","").toUpperCase();
    }

    public static String getDateStr(String formatDate){//"yyyy-MM-dd hh:mm:ss"
        return  new SimpleDateFormat(formatDate).format(Calendar.getInstance().getTime());
    }

    //test
    public static void main(String[] args) {

        System.out.println(Utils.getUUID());
        System.out.println(Utils.getDateStr("yyyy-MM-dd HH:mm:ss"));
    }
}
