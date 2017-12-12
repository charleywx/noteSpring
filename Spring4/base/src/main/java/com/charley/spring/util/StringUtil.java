package com.charley.spring.util;

public class StringUtil {

    /**
     * 字符是否为空
     * @param strName
     * @return
     */
    public static boolean isNotBlank(String strName) {
        if (strName != "" && strName != null && strName.length() > 0) {
            return true;
        }
        return false;
    }

    /**
     * 字符是否为空
     * @param strName
     * @return
     */
    public static boolean isBlank(String strName) {
        if (strName == "" || strName == null || strName.length() == 0) {
            return true;
        }
        return false;
    }

    /**
     * 将16进制字符串转为2进制数组
     *
     * @param hexString
     * @return
     */
    public static byte[] hexStringToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        }
        return d;
    }

    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    public static void main(String[] args) {
        System.out.println(isBlank(""));
        System.out.println(isBlank(null));
        System.out.println(isBlank(new String()));
    }

}
