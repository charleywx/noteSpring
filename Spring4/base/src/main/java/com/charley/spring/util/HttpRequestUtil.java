package com.charley.spring.util;//package util;
//
//import org.slf4j.LoggerFactory;
//
//import java.io.*;
//import java.net.*;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * HTTP请求工具类
// */
//public class HttpRequestUtil {
//
//    private static org.slf4j.Logger log = LoggerFactory.getLogger(HttpRequestUtil.class);
//
//    static boolean proxySet = false;
//    static String proxyHost = "127.0.0.1";
//    static int proxyPort = 8087;
//
//    /**
//     * 编码
//     *
//     * @param source
//     * @return
//     */
//    public static String urlEncode(String source, String encode) {
//        String result = source;
//        try {
//            result = URLEncoder.encode(source, encode);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//            return "0";
//        }
//        return result;
//    }
//
//    public static String urlEncodeGBK(String source) {
//        String result = source;
//        try {
//            result = URLEncoder.encode(source, "GBK");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//            return "0";
//        }
//        return result;
//    }
//
//    /**
//     * 访问HTTP请求，对返回的页面对字符串进行截取
//     * @param url           URL
//     * @param startWords    开始字符串
//     * @param endWords      结束字符串
//     * @return
//     */
//    public static List<String> getListByBetMiddle(String url, String startWords, String endWords) {
//        BufferedReader br = null;
//        List<String> list = new ArrayList<>();
//        String line;
//        try {
//            br = HttpRequestUtil.getBuffer(url);
//            while ((line = br.readLine()) != null) {
//                line = line.trim();
//                if(line.startsWith(startWords)) {
//                    int start = line.indexOf(startWords) + startWords.length();
//                    int end = line.indexOf(endWords);
//                    list.add(line.substring(start, end));
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if(br != null) {
//                try {
//                    br.close();
//                } catch (Exception e) {
//                }
//            }
//        }
//        return list;
//    }
//
//    /**
//     * 发起http请求获取返回输入流
//     *
//     * @param req_url 请求地址
//     * @return
//     */
//    public static BufferedReader getBuffer(String req_url) {
//        return getBuffer(req_url, "utf-8");
//    }
//
//    /**
//     * 发起http请求获取返回输入流
//     *
//     * @param req_url 请求地址
//     * @return
//     */
//    public static BufferedReader getBuffer(String req_url, String charset) {
//        if(StringUtil.isBlank(req_url)) {
//            log.error("请求失败：方法参数不能为空！");
//            return null;
//        }
//        try {
//            URL url = new URL(req_url);
//            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
//
//            httpUrlConn.setDoOutput(false);
//            httpUrlConn.setDoInput(true);
//            httpUrlConn.setUseCaches(false);
//
//            httpUrlConn.setRequestMethod("GET");
//            httpUrlConn.connect();
//
//            // 将返回的输入流转换成字符串
//            InputStream inputStream = httpUrlConn.getInputStream();
//            return new BufferedReader(new InputStreamReader(inputStream, charset));
//
//        } catch (Exception e) {
//            e.getStackTrace();
//        }
//        return null;
//    }
//
//    /**
//     * 发起http请求获取返回结果
//     *
//     * @param req_url 请求地址
//     * @return
//     */
//    public static String httpRequest(String req_url) {
//        return httpRequest(req_url, "utf-8");
//    }
//
//    /**
//     * 发起http请求获取返回结果
//     *
//     * @param req_url 请求地址
//     * @return
//     */
//    public static String httpRequest(String req_url, String charsets) {
//        if(StringUtil.isBlank(req_url)) {
//            log.error("请求失败：方法参数不能为空！");
//            return null;
//        }
//        StringBuffer buffer = new StringBuffer();
//        try {
//            URL url = new URL(req_url);
//            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
//
//            httpUrlConn.setDoOutput(false);
//            httpUrlConn.setDoInput(true);
//            httpUrlConn.setUseCaches(false);
//
//            httpUrlConn.setRequestMethod("GET");
//            httpUrlConn.connect();
//
//            // 将返回的输入流转换成字符串
//            InputStream inputStream = httpUrlConn.getInputStream();
//            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charsets);
//            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//
//            String str = null;
//            while ((str = bufferedReader.readLine()) != null) {
//                buffer.append(str);
//            }
//            bufferedReader.close();
//            inputStreamReader.close();
//            // 释放资源
//            inputStream.close();
//            inputStream = null;
//            httpUrlConn.disconnect();
//
//        } catch (Exception e) {
//            e.getStackTrace();
//        }
//        return buffer.toString();
//    }
//
//    /**
//     * 发送http请求取得返回的输入流
//     *
//     * @param requestUrl 请求地址
//     * @return InputStream
//     */
//    public static InputStream httpRequestIO(String requestUrl) {
//        InputStream inputStream = null;
//        try {
//            URL url = new URL(requestUrl);
//            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
//            httpUrlConn.setDoInput(true);
//            httpUrlConn.setRequestMethod("GET");
//            httpUrlConn.connect();
//            // 获得返回的输入流
//            inputStream = httpUrlConn.getInputStream();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return inputStream;
//    }
//
//
//    /**
//     * 向指定URL发送GET方法的请求
//     *
//     * @param url   发送请求的URL
//     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
//     * @return URL 所代表远程资源的响应结果
//     */
//    public static String sendGet(String url, String param) {
//        StringBuilder result = new StringBuilder();
//        BufferedReader in = null;
//        String urlNameString;
//        try {
//            if (StringUtil.isBlank(param)) {
//                urlNameString = url;
//            } else {
//                urlNameString = url + "?" + param;
//            }
//            URL realUrl = new URL(urlNameString);
//            // 打开和URL之间的连接
//            URLConnection connection = realUrl.openConnection();
//            // 设置通用的请求属性
//            connection.setRequestProperty("accept", "*/*");
//            connection.setRequestProperty("connection", "Keep-Alive");
//            connection.setRequestProperty("user-agent",
//                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
//            // 建立实际的连接
//            connection.connect();
//            // 获取所有响应头字段
//            // Map<String, List<String>> map = connection.getHeaderFields();
//            // 定义 BufferedReader输入流来读取URL的响应
//            in = new BufferedReader(new InputStreamReader(
//                    connection.getInputStream()));
//            String line;
//            while ((line = in.readLine()) != null) {
//                result.append(line);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (in != null) {
//                    in.close();
//                }
//            } catch (Exception e2) {
//                e2.printStackTrace();
//            }
//        }
//        return result.toString();
//    }
//
//    /**
//     * 向指定 URL 发送POST方法的请求
//     *
//     * @param url     发送请求的 URL
//     * @param param   请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
//     * @param isproxy 是否使用代理模式
//     * @return 所代表远程资源的响应结果
//     */
//    public static String sendPost(String url, String param, boolean isproxy) {
//        OutputStreamWriter out = null;
//        BufferedReader in = null;
//        String result = "";
//        try {
//            URL realUrl = new URL(url);
//            HttpURLConnection conn = null;
//            if (isproxy) {//使用代理模式
//                @SuppressWarnings("static-access")
//                Proxy proxy = new Proxy(Proxy.Type.DIRECT.HTTP, new InetSocketAddress(proxyHost, proxyPort));
//                conn = (HttpURLConnection) realUrl.openConnection(proxy);
//            } else {
//                conn = (HttpURLConnection) realUrl.openConnection();
//            }
//            // 打开和URL之间的连接
//
//            // 发送POST请求必须设置如下两行
//            conn.setDoOutput(true);
//            conn.setDoInput(true);
//            conn.setRequestMethod("POST");    // POST方法
//
//
//            // 设置通用的请求属性
//
//            conn.setRequestProperty("accept", "*/*");
//            conn.setRequestProperty("connection", "Keep-Alive");
//            conn.setRequestProperty("user-agent",
//                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
//            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//
//            conn.connect();
//
//            // 获取URLConnection对象对应的输出流
//            out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
//            // 发送请求参数
//            out.write(param);
//            // flush输出流的缓冲
//            out.flush();
//            // 定义BufferedReader输入流来读取URL的响应
//            in = new BufferedReader(
//                    new InputStreamReader(conn.getInputStream()));
//            String line;
//            while ((line = in.readLine()) != null) {
//                result += line;
//            }
//        } catch (Exception e) {
//            System.out.println("发送 POST 请求出现异常！" + e);
//            e.printStackTrace();
//        }
//        //使用finally块来关闭输出流、输入流
//        finally {
//            try {
//                if (out != null) {
//                    out.close();
//                }
//                if (in != null) {
//                    in.close();
//                }
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        }
//        return result;
//    }
//
//    public static void main(String[] args) {
//        //demo:代理访问
//        String url = "http://221.232.149.173:7015/metro_data_service/data/metroStation";
//        String para = "token=13d062abab095f6df76131451d2eefa35";
//
//        //String sr = HttpRequestUtil.sendPost(url, para, true);
//        String sr = com.charley.common.util.HttpRequestUtil.sendGet(url, para);
//        System.out.println(sr);
//    }
//
//}