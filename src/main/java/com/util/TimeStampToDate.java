package com.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author LByier
 * @date 2020/11/7 21:52
 */

public class TimeStampToDate {

    public  String Function(Date timeStamp,String format){

        SimpleDateFormat sdf = new SimpleDateFormat(format);

//        if (timeStamp.length()==13){
//            String date = sdf.format(new Date(Long.parseLong(timeStamp)));
//            return date;
//        }else
//        {
//            String date = sdf.format(new Date(Integer.parseInt(timeStamp) * 1000L));
//            return date;
//        }
        String format1 = sdf.format(timeStamp);
        return format1;
    }
}
