package com.charley.spring.util;


import java.io.*;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shenb on 2017/7/12.
 */
public class FileUtil {
    
    /**
     * 按行读取文件
     *
     * @param path 文件路径
     * @return 字符串集合
     */
    public static List<String> readFileByLineToList(String path) {
        List<String> list = new ArrayList<String>();
        BufferedReader br = null;
        String line;
        try {
            br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
            }
        }
        return list;
    }
    
    /**
     * 按行读取文件，返回字符串集合
     *
     * @param path    文件路径
     * @param charset 字符集，默认UTF-8
     * @return 字符串集合
     */
    public static List<String> readFileByLineToList(String path, String charset) {
        if (charset == null || charset == "" || charset.length() == 0) {
            charset = "UTF-8";
        }
        List<String> list = new ArrayList<String>();
        BufferedReader br = null;
        String line;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(path), charset));
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
            }
        }
        return list;
    }
    
    public static boolean isFile(String s) {
        if (new File(s).isFile())
            return true;
        return false;
    }
    
    /**
     * 获取当前文件夹下的文件
     *
     * @param path 当前文件夹路径
     * @return List<String>
     */
    public static List<String> getChildFile(String path) {
        List<String> list = new ArrayList<String>();
        String[] files = new File(path).list();
        for (String s : files) {
            if (isFile(path + File.separator + s)) {
                list.add(s);
            }
        }
        return list;
    }
    
    /**
     * 获取当前文件夹下的子文件夹
     *
     * @param path 当前文件夹路径
     * @return List<String>
     */
    public static List<String> getChildDirectory(String path) {
        List<String> list = new ArrayList<String>();
        String[] files = new File(path).list();
        for (String s : files) {
            if (new File(s).isDirectory()) {
                list.add(s);
            }
        }
        return list;
    }
    
    /**
     * 按行读取文件
     *
     * @param path 文件路径
     * @return 字符串集合
     */
    public static int[] readFileToInt(String path) {
        BufferedInputStream bis = null;
        int i;
        IntBuffer intBuffer = IntBuffer.allocate(10);
        try {
            bis = new BufferedInputStream(new FileInputStream(path));
            while ((i = bis.read()) != -1) {
                intBuffer = putInt(intBuffer, i);
            }
            intBuffer.flip();
            int[] ints = new int[intBuffer.limit()];
            for (int j = 0; j < intBuffer.limit(); j++) {
                ints[j] = intBuffer.get();
            }
            return ints;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis != null) {
                    bis.close();
                }
            } catch (IOException e) {
            }
        }
        return null;
    }
    
    /**
     * 读取2进制文件
     *
     * @param path 文件路径
     * @return 返回16进制字符串
     */
    public static String readByteFileToHexString(String path) {
        byte[] bytes = readByteFileToByteArray(path);
        return ByteUtil.bytes2HexString(bytes);
    }
    
    /**
     * 读取2进制文件
     *
     * @param path 文件路径
     * @return 返回2进制数组
     */
    public static byte[] readByteFileToByteArray(String path) {
        return readByteFileToByteArray(path, 10000);
    }
    
    /**
     * 读取2进制文件
     *
     * @param path   文件路径
     * @param length 初始化byte字节长度
     * @return 返回2进制数组
     */
    public static byte[] readByteFileToByteArray(String path, int length) {
        DataInputStream dis = null;
        try {
            ByteBuffer byteBuffer = ByteBuffer.allocate(length);
            byte[] bytes = new byte[1];
            dis = new DataInputStream(new FileInputStream(path));
            while (true) {
                if (dis.read(bytes) == -1) {
                    break;
                }
                byteBuffer = putByte(byteBuffer, bytes[0]);
            }
            if (byteBuffer.position() > 0) {
                byteBuffer.flip();
                byte[] bytes1 = new byte[byteBuffer.limit()];
                for (int j = 0; j < byteBuffer.limit(); j++) {
                    bytes1[j] = byteBuffer.get();
                }
                return bytes1;
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (dis != null) {
                    dis.close();
                }
            } catch (IOException e) {
            }
        }
        return null;
    }
    
    public static IntBuffer putInt(IntBuffer intBuffer, int i) {
        try {
            intBuffer.put(i);
        } catch (BufferOverflowException e) {
            IntBuffer ex = IntBuffer.allocate(intBuffer.capacity() * 2);
            ex.put(intBuffer.array(), 0, intBuffer.position());
            ex.put(i);
            //System.out.println("IntBuffer 变更长度为 " + ex.capacity());
            return ex;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return intBuffer;
    }
    
    public static ByteBuffer putByte(ByteBuffer byteBuffer, byte b) {
        try {
            byteBuffer.put(b);
        } catch (BufferOverflowException e) {
            ByteBuffer ex = ByteBuffer.allocate(byteBuffer.capacity() * 2);
            ex.put(byteBuffer.array(), 0, byteBuffer.position());
            ex.put(b);
            //System.out.println("ByteBuffer 变更长度为 " + ex.capacity());
            return ex;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return byteBuffer;
    }
    
    /**
     * 将 List<String> 写入文件
     *
     * @param path   文件完整路径
     * @param list   list
     * @param append 是否追加
     */
    public static void writeFile(String path, List<String> list, boolean append) {
        PrintWriter pw = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            pw = new PrintWriter(new FileWriter(path, append));
            for (int i = 0; i < list.size(); i++) {
                stringBuilder.append(list.get(i)).append("\n");
                if (i > 0 && i % 2000 == 0) {
                    pw.println(stringBuilder.toString());
                    stringBuilder.setLength(0);
                }
            }
            pw.println(stringBuilder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pw != null) {
                    pw.close();
                }
            } catch (Exception e) {
            }
        }
    }
    
    /**
     * 字节转换为浮点
     *
     * @param b 字节（至少4个字节）
     * @return
     */
    public static float byteArrayToFloat(byte[] b) {
        return byteArrayToFloat(b, 0);
    }
    
    /**
     * 字节转换为浮点
     *
     * @param b     字节（至少4个字节）
     * @param index 开始位置
     * @return
     */
    public static float byteArrayToFloat(byte[] b, int index) {
        int l;
        l = b[index + 0];
        l &= 0xff;
        l |= ((long) b[index + 1] << 8);
        l &= 0xffff;
        l |= ((long) b[index + 2] << 16);
        l &= 0xffffff;
        l |= ((long) b[index + 3] << 24);
        return Float.intBitsToFloat(l);
    }
    
    // 从byte数组的index处的连续4个字节获得一个float
    public static float getFloat(byte[] arr) {
        return Float.intBitsToFloat(getInt(arr, 0));
    }
    
    // 从byte数组的index处的连续4个字节获得一个float
    public static float getFloat(byte[] arr, int index) {
        return Float.intBitsToFloat(getInt(arr, index));
    }
    
    // 从byte数组的index处的连续4个字节获得一个int
    public static int getInt(byte[] arr, int index) {
        return (0xff000000 & (arr[index + 0] << 24)) |
                (0x00ff0000 & (arr[index + 1] << 16)) |
                (0x0000ff00 & (arr[index + 2] << 8)) |
                (0x000000ff & arr[index + 3]);
    }
}
