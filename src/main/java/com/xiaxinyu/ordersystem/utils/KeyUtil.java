package com.xiaxinyu.ordersystem.utils;

import java.util.Random;

public class KeyUtil {
    //生成唯一的主键
    //格式：时间 + 随机数

    public static synchronized String genUniqueKey(){
        Random random = new Random();

        System.currentTimeMillis();

        Integer num = random.nextInt(1000000);
        return System.currentTimeMillis() + String.valueOf(num);
    }
}