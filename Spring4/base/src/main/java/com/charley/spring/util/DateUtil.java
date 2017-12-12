package com.charley.spring.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtil {
    public static String getSystemTime(String dataType) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai")); /* 修正时区 */
        SimpleDateFormat df = new SimpleDateFormat(dataType);
        Date currentTime = new Date();
        String DatTyp = df.format(currentTime);
        return DatTyp;
    }

    public static java.sql.Date getDate(String dataType, String dayTime) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(dataType);
        java.sql.Date date = new java.sql.Date(sdf.parse(dayTime).getTime());
        return date;
    }

    public static java.sql.Timestamp getTimestamp(String dataType, String dayTime) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(dataType);
        java.sql.Timestamp date = new java.sql.Timestamp(sdf.parse(dayTime).getTime());
        return date;
    }

    public static String getStrTime(Date time, String timeType) {
        SimpleDateFormat df = new SimpleDateFormat(timeType);
        String DatTyp = df.format(time);
        return DatTyp;
    }

    public static String getStrTime(java.sql.Timestamp time, String timeType) {
        SimpleDateFormat df = new SimpleDateFormat(timeType);
        String DatTyp = df.format(time);
        return DatTyp;
    }

    public static int getMinuteBy15() {
        Calendar ca = Calendar.getInstance();
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SimpleDateFormat sdf = new SimpleDateFormat("mm");
        return Integer.parseInt(sdf.format(ca.getTime())) / 15 + 1;
    }

    public static int getMinuteBy15Arr(Calendar ca) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SimpleDateFormat sdf = new SimpleDateFormat("mm");
        return Integer.parseInt(sdf.format(ca.getTime())) / 15;
    }

    public static int getMinuteByOne(Calendar ca) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SimpleDateFormat sdf = new SimpleDateFormat("mm");
        return Integer.parseInt(sdf.format(ca.getTime()));
    }

    public static int getMinuteByOne() {
        Calendar ca = Calendar.getInstance();
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SimpleDateFormat sdf = new SimpleDateFormat("mm");
        return Integer.parseInt(sdf.format(ca.getTime()));
    }

    public static String getHourMinute(Calendar ca) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
        return sdf.format(ca.getTime());
    }

    public static String getHourMinute() {
        Calendar ca = Calendar.getInstance();
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
        return sdf.format(ca.getTime());
    }

    public static String getSocketMinute() {
        Calendar ca = Calendar.getInstance();
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SimpleDateFormat sdf = new SimpleDateFormat("mm");
        int i = Integer.parseInt(sdf.format(ca.getTime())) / 15;
        if (i == 0) {
            i = 4;
        }
        return i + "";
    }

    public static Date getTimmerDate(int h, int m, int s) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.set(year, month, day, h, m, s);
        return calendar.getTime();
    }

    public static String getSocketDate() {
        Calendar ca = Calendar.getInstance();
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(ca.getTime());
    }

    public static String getDateStr() {
        Calendar ca = Calendar.getInstance();
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(ca.getTime());
    }

    public static String getMonthStr() {
        Calendar ca = Calendar.getInstance();
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        return sdf.format(ca.getTime());
    }

    public static String getNowTimeStr() {
        Calendar ca = Calendar.getInstance();
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(ca.getTime());
    }

    public static String getDateStr(SimpleDateFormat sdf) {
        Calendar ca = Calendar.getInstance();
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        return sdf.format(ca.getTime());
    }

    /**
     * @param dataDay 日期字符串 yyyyMMdd
     * @param i       天数
     * @return
     */
    public static String getDateStr(String dataDay, int i) {
        Calendar ca = Calendar.getInstance();
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date day;
        try {
            day = sdf.parse(dataDay);
            ca.setTime(day);
            ca.add(Calendar.DAY_OF_MONTH, i);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sdf.format(ca.getTime());
    }

    /**
     * @param month 日期字符串 yyyyMMdd
     * @param i       天数
     * @return
     */
    public static String getMonthStr(String month, int i) {
        Calendar ca = Calendar.getInstance();
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        Date day;
        try {
            day = sdf.parse(month);
            ca.setTime(day);
            ca.add(Calendar.MONTH, i);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sdf.format(ca.getTime());
    }

    public static String getDateStr(int i) {
        Calendar ca = Calendar.getInstance();
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        try {
            ca.add(Calendar.DAY_OF_MONTH, i);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sdf.format(ca.getTime());
    }

    public static String getMonthStr(int i) {
        Calendar ca = Calendar.getInstance();
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        try {
            ca.add(Calendar.MONTH, i);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sdf.format(ca.getTime());
    }

    public static String getDateTimeStr() {
        Calendar ca = Calendar.getInstance();
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
        return sdf.format(ca.getTime());
    }

    public static String getYear() {
        Calendar ca = Calendar.getInstance();
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        return sdf.format(ca.getTime());
    }

    public static String getHour() {
        Calendar ca = Calendar.getInstance();
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SimpleDateFormat sdf = new SimpleDateFormat("HH");
        return sdf.format(ca.getTime());
    }

    public static String getMinute() {
        Calendar ca = Calendar.getInstance();
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SimpleDateFormat sdf = new SimpleDateFormat("mm");
        return sdf.format(ca.getTime());
    }

    public static String getDateStr(Calendar ca) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        return sdf.format(ca.getTime());
    }

    public static String getYear(Calendar ca) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        return sdf.format(ca.getTime());
    }

    public static String getHour(Calendar ca) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH");
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        return sdf.format(ca.getTime());
    }

    public static String getMinute(Calendar ca) {
        SimpleDateFormat sdf = new SimpleDateFormat("mm");
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        return sdf.format(ca.getTime());
    }

    public static String getHour(String strTime) {
        return strTime.substring(0, 2);
    }

    public static String getMinute(String strTime) {
        return strTime.substring(2, 4);
    }

    public static String printTime(Calendar ca) {
        return ca.get(Calendar.YEAR) + "-" + (ca.get(Calendar.MONTH) + 1) + "-" + ca.get(Calendar.DAY_OF_MONTH) + " "
                + ca.get(Calendar.HOUR_OF_DAY) + ":" + ca.get(Calendar.MINUTE) + ":" + ca.get(Calendar.SECOND);
    }

    public static String simleDate(Calendar ca) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(ca.getTime());
    }

    /**
     * 比较日期大小
     *
     * @param DATE1
     * @param DATE2
     * @param format
     * @return 0相等，1前者大，2后者大
     */
    public static int compare_date(String DATE1, String DATE2, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return 2;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
//        System.out.println(com.charley.common.util.DateUtil.getDateStr(-1));

    }
}
