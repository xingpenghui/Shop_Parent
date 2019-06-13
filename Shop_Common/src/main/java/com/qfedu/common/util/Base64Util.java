package com.qfedu.common.util;

import java.util.Base64;

/**
 *@Author feri
 *@Date Created in 2019/4/29 15:25
 */
public class Base64Util {
    //转换为Base64
    public static String base64Enc(byte[] msg) {
        return Base64.getEncoder().encodeToString(msg);
    }
    //解码
    public static byte[] base64Dec(String msg) {
        return Base64.getDecoder().decode(msg);
    }
}