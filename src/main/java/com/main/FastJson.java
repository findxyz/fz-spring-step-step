package com.main;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fz on 2015/12/16.
 */
public class FastJson {

    public static void main(String[] args) throws InterruptedException {

        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("name", "abc");
        long begin = System.currentTimeMillis();
        String json = JSON.toJSONString(map);
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
        System.out.println(json);
    }
}
