package org.falcon.utils;


import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by lihuibing on 16/7/30.
 */
public class DateUtils {

    public final static String FORMAT_YYYY_MM_DD = "yyyy-MM-dd";

    public final static String FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public final static String FORMAT_YYYYMMDD = "yyyyMMdd";

    public final static String FORMAT_YYYYMM = "yyyyMM";

    public final static String FORMAT_YYYY = "yyyy";

    public final static String FORMAT_YYYYMMDDHHMISS = "yyyyMMdd HH:mm:ss";

    public final static String FORMAT_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public final static String FORMAT_YYYY_MM_DD_HH_MI_SS = "yyyy-MM-dd HH:mm:ss";

    public final static String FORMAT_YYYY_MM = "yyyy-MM";

    public final static String FORMAT_DD_HH_MM_SS = "dd HH:mm:ss";

    public final static String FORMAT_HH_MM_SS = "HH:mm:ss";

    public static String getCurrateDate(){
        DateTime dateTime = new DateTime();
        return dateTime.toString(FORMAT_YYYY_MM_DD);
    }

    public static String getCurrentDateTime(){
        DateTime dateTime = new DateTime();
        return dateTime.toString(FORMAT_YYYY_MM_DD_HH_MM_SS);
    }

    public static String getCacuteTime(int time){
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_YYYY_MM_DD_HH_MM_SS);
        Calendar beforeTime = Calendar.getInstance();
        beforeTime.add(Calendar.MINUTE, time);// 3分钟之前的时间
        Date beforeD = beforeTime.getTime();
        String timeStr = sdf.format(beforeD);
        return timeStr;
    }
}
