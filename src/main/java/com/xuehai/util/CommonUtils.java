package com.xuehai.util;

import com.xuehai.base.Log;

import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Properties;

/**
 * @author Sniper
 * @ClassName: Utils
 * @Description: 工具类, 主要是一些公共方法
 * @date 2018-09-30 13:26:00
 */
public class CommonUtils {
    private static final Log LOGGER = new Log(CommonUtils.class);
    private static final String CLASS_NAME = CommonUtils.class.getName();
    private static final String CONFIG_PROPERTIES_PATH = "src/main/resources/config/config.properties";
    //签名秘钥
    private static final String SECRET = "eptim]q34imt5b]-q04i5q=fdkfjfsadlkjfasdfrt573df4pltoy]-pn965498d";


    /**
     * @param filePath 文件路径
     * @param key      key值
     * @return String    返回String value
     * @Title: 读取java配置文件
     * @Description: 从目标文件根据key读取value对象
     */
    public static String getProperties(String filePath, String key) {
        String value = null;
        FileInputStream fis = null;
        InputStreamReader in = null;
        try {
            try {
                fis = new FileInputStream(filePath);
                in = new InputStreamReader(fis, "utf-8");
                Properties prop = new Properties();
                prop.load(in);
                if (prop.containsKey(key)) {
                    value = prop.getProperty(key);
                } else {
                    LOGGER.error(filePath + " 不存在 key=\"" + key + "\" 的配置项");
                }
            } finally {
                if (in != null)
                    in.close();
                if (fis != null)
                    fis.close();
            }
        } catch (FileNotFoundException e) {
            LOGGER.error("Property获取失败", e);
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("Property获取失败", e);
        } catch (IOException e) {
            LOGGER.error("Property获取失败", e);
        }
        return value;
    }

    /**
     * @param key key值
     * @return String    返回String value
     * @Title: 读取config.properties配置文件
     * @Description: 从config.properties文件根据key读取value对象
     */
    public static String getConfigProperties(String key) {
        return getProperties(CONFIG_PROPERTIES_PATH, key);
    }

    /**
     * @param filePath 文件路径
     * @param key      key值
     * @return String    返回String value
     * @Title: 读取java配置文件
     * @Description: 从目标文件根据key读取value对象
     */
    public static String getProperty(String filePath, String key) {
        String value = null;
        FileInputStream fis = null;
        InputStreamReader in = null;
        try {
            try {
                fis = new FileInputStream(filePath);
                in = new InputStreamReader(fis, "utf-8");
                Properties prop = new Properties();
                prop.load(in);
                if (prop.containsKey(key)) {
                    value = prop.getProperty(key);
                } else {
//					Log.(CLASS_NAME, filePath + " 不存在 key=\"" + key + "\" 的配置项");
                    LOGGER.info(CLASS_NAME);
                }
            } finally {
                if (in != null)
                    in.close();
                if (fis != null)
                    fis.close();
            }
        } catch (FileNotFoundException e) {
//			Log.error(CLASS_NAME, "Property获取失败", e);
            LOGGER.info(CLASS_NAME);
        } catch (UnsupportedEncodingException e) {
//			Log.error(CLASS_NAME, "Property获取失败", e);
            LOGGER.info(CLASS_NAME);
        } catch (IOException e) {
//			Log.error(CLASS_NAME, "Property获取失败", e);
            LOGGER.info(CLASS_NAME);
        }
        return value;
    }

    /**
     * @param key key值
     * @return String    返回String value
     * @Title: 读取config.properties配置文件
     * @Description: 从config.properties文件根据key读取value对象
     */
    public static String getConfigProperty(String key) {
        return getProperty(CONFIG_PROPERTIES_PATH, key);
    }

    /**
     * @param target   目标uri
     * @param encoding 字符编码
     * @return String        返回编码后uri字符串
     * @Title: URI编码
     * @Description:
     */
    public static String encodeURI(String target, String encoding) {
        String encodeString = null;
        try {
            encodeString = URLEncoder.encode(target, encoding);
        } catch (UnsupportedEncodingException e) {
            LOGGER.info(CLASS_NAME);
//			Log.error(CLASS_NAME, "字符串encode失败", e);
        }
        return encodeString;
    }

    /**
     * @param target   目标uri
     * @param encoding 字符编码
     * @return String        返回编码后uri字符串
     * @Title: URI解码
     * @Description:
     */
    public static String decodeURI(String target, String encoding) {
        String decodeString = null;
        try {
            decodeString = URLDecoder.decode(target, encoding);
        } catch (UnsupportedEncodingException e) {
            LOGGER.info(CLASS_NAME);
//			Log.error(CLASS_NAME, "字符串decode失败", e);
        }
        return decodeString;
    }


    /**
     * @param method      方法名
     * @param requestURI  URI
     * @param queryString 查询字符串
     * @param body        请求body
     * @param authToken   登录token
     * @return 返回签名后URL
     * @Title: 生成签名并返回完整URL
     * @Description: MD5(method + requestUrl + ? + queryString + t + secret + body + " Authorization : " + authToken)
     */
    public static String getRequestSignature(String method, String requestURL, String queryString, String body, String authToken) {
        StringBuilder sb = new StringBuilder();
        if (method != null && !"".equals(method)) {
            sb.append(method);
        }
        if (requestURL != null && !"".equals(requestURL)) {
            sb.append(requestURL);
        }
        if (queryString != null && !"".equals(queryString)) {
            sb.append("?" + queryString);
        }
        long time = System.currentTimeMillis();
        sb.append(time).append(SECRET);
        if (body != null && !"".equals(body)) {
            sb.append(body);
        }
        if (authToken != null && !"".equals(authToken)) {
            sb.append("Authorization: " + authToken);
        }
        String sign = CommonUtils.MD5(sb.toString());
        if (queryString != null && !"".equals(queryString))
            return requestURL + "?" + queryString + "&sign=" + sign + "&t=" + time;
        else
            return requestURL + "?sign=" + sign + "&t=" + time;
    }

    /**
     * @param sourceStr 目标字符串
     * @return 返回md5加密字符串
     * @Title: 字符串md5加密
     * @Description:
     */
    public static String MD5(String sourceStr) {
        StringBuffer buf = new StringBuffer();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(sourceStr.getBytes());
            byte b[] = md.digest();
            int i;
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
        } catch (NoSuchAlgorithmException e) {
            LOGGER.info(CLASS_NAME);
//			Log.error(CLASS_NAME, "MD5加密失败", e);
        }
        return buf.toString();
    }

    /**
     * @param file 目标文件
     * @return 返回md5加密字符串
     * @Title: 文件md5加密
     * @Description:
     */
    public static String MD5(File file) {
        FileInputStream in = null;
        byte[] bytes = null;
        DigestInputStream digestInputStream = null;
        StringBuilder sb = new StringBuilder();
        try {
            try {
                in = new FileInputStream(file);
                MessageDigest md5 = MessageDigest.getInstance("md5");
                digestInputStream = new DigestInputStream(in, md5);
                byte[] buffer = new byte[4096];
                while (digestInputStream.read(buffer) > 0) ;
                md5 = digestInputStream.getMessageDigest();
                bytes = md5.digest();
                for (int i = 0; i < bytes.length; i++) {
                    String a = Integer.toHexString(0XFF & bytes[i]);
                    if (a.length() < 2) {
                        a = '0' + a;
                    }
                    sb.append(a);
                }
            } finally {
                digestInputStream.close();
                in.close();
            }
        } catch (FileNotFoundException e) {
            LOGGER.info(CLASS_NAME);
//			Log.error(CLASS_NAME, "MD5加密失败", e);
        } catch (NoSuchAlgorithmException e) {
            LOGGER.info(CLASS_NAME);
//			Log.error(CLASS_NAME, "MD5加密失败", e);
        } catch (IOException e) {
            LOGGER.info(CLASS_NAME);
//			Log.error(CLASS_NAME, "MD5加密失败", e);
        }
        return sb.toString();
    }

    /**
     * @param target 目标StringBuilder字符串
     * @return String    返回格式化后的String字符串
     * @Title: StringBuilder字符串格式化
     * @Description: 把StringBuilder字符串中',]' ',}'替换为']' '}'
     */
    public static String format(StringBuilder target) {
        int index = target.lastIndexOf(",}");
        while (index > 0) {
            target.replace(index, index + 1, "");
            index = target.lastIndexOf(",}");
        }
        index = target.lastIndexOf(",]");
        while (index > 0) {
            target.replace(index, index + 1, "");
            index = target.lastIndexOf(",]");
        }
        index = target.lastIndexOf(",)");
        while (index > 0) {
            target.replace(index, index + 1, "");
            index = target.lastIndexOf(",)");
        }
        return target.toString();
    }

    public static String format(Object parameter) {
        if (parameter instanceof Map) {
            Map<?, ?> map = (Map<?, ?>) parameter;
            StringBuilder temp = new StringBuilder("[");
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                temp.append(key)
                        .append("=")
                        .append(value)
                        .append(",");
            }
            temp.append("]");
            return format(temp);
        } else {
            return parameter.toString();
        }
    }

    public static String trim(String target) {
        if (target != null)
            return target.trim();
        else
            return null;
    }

    public static void createDirectory(String dir) {
        File file = new File(dir);
        if (!file.exists()) {
            file.mkdir();
        }
    }
}
