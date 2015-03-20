package com.friday;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * Created by Administrator on 2015-3-20.
 */
@Component
public class Example {

    private static Logger logger = Logger.getLogger(Example.class);

    @Autowired
    private MessageSource messageSource;

    public void execute(){
        String message = this.messageSource.getMessage("arguments.require", new String[]{"name"}, "some arguments is missed", null);
        logger.info(message);
    }

}
