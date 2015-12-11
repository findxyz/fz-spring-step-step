package com.utils;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class EmailUtil {

    private static final String userCount = "djangomail@126.com";

    private static final String password = "djangomail~!@";

    private static final String hostName = "smtp.126.com";

    public static void send(String title, String address, String content,
                            String sender, String receiver) {

        HtmlEmail email = new HtmlEmail();
        email.setHostName(hostName);
        email.setTLS(false);
        email.setAuthentication(userCount, password);
        try {
            email.setCharset("UTF-8");
            email.setFrom(userCount, sender);
            email.setSmtpPort(25);
            email.addTo(address, receiver);
            email.setSubject(title);
            email.setTextMsg(content);
            email.send();
            System.out.println("邮件发送成功");
        } catch (EmailException e) {
            e.printStackTrace();
            System.out.println("邮件发送失败【" + e.toString() + "】");
        }
    }

    public static void main(String[] args) {
        send("标题", "djangomail@126.com", "内容", "发送者", "接收者");
    }
}
