package com.test;

import com.event.EmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

/**
 * Created by Administrator on 2015-4-24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("production")
@ContextConfiguration
public class MyEventTest {

    @Autowired
    EmailService emailService;

    @Test
    public void doTest() throws Exception{
        emailService.sendEmail("john.doe@example.org", "test");
    }

    @Test
    public void doProTest() throws Exception{
        emailService.sendEmail("fz3@example.org", "test");
    }
}
