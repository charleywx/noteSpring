package com.charley.spring.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import static java.lang.Double.NaN;

public class DoubleUtil {

    public static void main(String[] args) {
        System.out.println(fmtDoubToDoub(-0.18855830198171067));
    }

    /**
     * 将字符串转化为浮点数，并保留2位小数
     * @param s
     * @return
     */
    public static double fmtStrToDoub(String s) {
        return fmtDoubToDoub(Double.parseDouble(s));
    }

    /**
     * Double 四舍五入转为Int
     * @param d
     * @return
     */
    public static int fmtDoubToInt(double d) {
        return (int)fmtDoubToDoub(d, 0);
    }

    /**
     * Double保留2位小数
     * @param d
     * @return
     */
    public static double fmtDoubToDoub(double d, int num) {
        BigDecimal bg = new BigDecimal(d);
        return bg.setScale(num, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * Double保留2位小数
     * @param d
     * @return
     * ROUND_HALF_UP 高位
     * ROUND_CEILING 四舍五入
     */
    public static double fmtDoubToDoub(Double d) {
        try {
            if(d == null || d == 0.0 || d == NaN) {
                return 0.0;
            }
            BigDecimal bg = new BigDecimal(d);
            return bg.setScale(2, BigDecimal.ROUND_CEILING).doubleValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0.0;
    }

    /**
     * Double保留2位小数
     * @param d
     * @return
     */
    public static String fmtDoubToStr(double d) {
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(d);
    }

    /**
     * Double保留2位小数
     * @param d
     * @return
     */
    public static String fmtDoubToStr2(double d) {
        return String.format("%.2f", d);
    }

    /**
     * Double保留2位小数
     * @param d
     * @return
     */
    public static String fmtDoubToStr3(double d) {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        return nf.format(d);
    }

}
