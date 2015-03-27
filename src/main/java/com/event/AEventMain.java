package com.event;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2015-3-23.
 */
public class AEventMain {

    private static Logger logger = Logger.getLogger(AEventMain.class);

    public static void main(String[] args) throws IOException {

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"eventContext.xml"});
        EmailService emailService = context.getBean("emailService", EmailService.class);
        emailService.sendEmail("john.doe@example.org", "test");
    }
}
