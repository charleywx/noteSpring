package com.charley.spring.util;

public class ByteUtil {

    /**
     * 将字节数组bytes转为一个整数，字节数组的低位是整型的低字节位
     * @param bytes
     * @return
     */
    public static int byteArrayToInt(byte[] bytes) {
        int ir = 0;
        byte b;
        for (int i = 0; i < bytes.length; i++) {
            b = bytes[i];
            ir += (b & 0xFF) << (8 * i);
        }
        return ir;
    }

    /**
     * 将2进制数组转为16进制字符串
     *
     * @param bytes
     * @return
     */
    public static String bytes2HexString(byte[] bytes) {
        String ret = "";
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            ret += hex.toUpperCase();
        }
        return ret;
    }

}
