package com.utils.attack;

import org.apache.http.impl.client.CloseableHttpClient;

/**
 * Created by fz on 2015/8/23.
 */
public interface MessageBomber {

    public String emissionMissile(CloseableHttpClient httpClient, String fuckNo) throws Exception;

    public String getBomberName();
}
