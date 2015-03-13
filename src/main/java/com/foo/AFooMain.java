package com.foo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Administrator on 2015-3-5.
 */
public class AFooMain {
    static Logger logger = Logger.getLogger(AFooMain.class);

    public static void main(String[] args) throws IOException {
        logger.info("Spring ApplicationContext is Loading");
        AbstractApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
        context.registerShutdownHook();

        ExampleDestroyBean destroyBean = context.getBean("exampleDestroyBean", ExampleDestroyBean.class);

        HelloWorld helloWorld = context.getBean("helloWorld", HelloWorld.class);
        Greeter greeter = helloWorld.getGreeter();
        logger.info(greeter.sayHello());
        logger.info(greeter.getHelloWorld());

        ChildObj childObj = context.getBean("child", ChildObj.class);
        logger.info(childObj.getAdminEmails());

        logger.info(greeter.getAccounts());

        ObjectMapper jacksonMapper = context.getBean("jacksonMapper", ObjectMapper.class);
        String mapJson = jacksonMapper.writeValueAsString(greeter.getAccounts());
        logger.info(jacksonMapper.readValue(mapJson, Map.class));

        People fz_classic = context.getBean("fz-classic", People.class);
        People fz_modern = context.getBean("fz-modern", People.class);
        People fz_modern2 = context.getBean("fz-modern", People.class);

        logger.info(fz_modern);
        logger.info(fz_modern2);

        logger.info(fz_classic.getName());
        logger.info(fz_classic.getSpouse());

        logger.info(fz_modern.getName());
        logger.info(fz_modern.getSpouse());

    }
}
