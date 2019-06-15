package com.qfedu.ljb.server.user.util;

import java.util.Random;

/**
 *@Author feri
 *@Date Created in 2019/6/15 14:35
 */
public class RandomUtil {
    public static int createNum(int start,int end){
        Random random=new Random();
        return random.nextInt(end-start)+start;
    }
}
