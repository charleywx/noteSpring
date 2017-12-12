package com.charley.spring.util;

public class CharUtil {

    /**
     * 将字符数组转为一个整数，字节数组的低位是整型的低字节位
     * @param chars
     * @return
     */
    public static int charArrayToInt(char[] chars) {
        String s = new String(chars);
        return ByteUtil.byteArrayToInt(StringUtil.hexStringToBytes(s));
    }

}
