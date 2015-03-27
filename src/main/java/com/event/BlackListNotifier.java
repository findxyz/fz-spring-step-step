package com.event;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.context.ApplicationListener;

/**
 * Created by Administrator on 2015-3-23.
 */
public class BlackListNotifier implements ApplicationListener<BlackListEvent> {

    private static Logger logger = Logger.getLogger(BlackListNotifier.class);

    private String notificationAddress;

    public void setNotificationAddress(String notificationAddress) {
        this.notificationAddress = notificationAddress;
    }

    @Override
    public void onApplicationEvent(BlackListEvent event) {
        DateTime dt = new DateTime(event.getTimestamp());
        logger.info(event.getAddress()+","+event.getText()+","+dt.toString("yyyy-MM-dd HH:mm:ss"));
        logger.info(notificationAddress);
    }
}
