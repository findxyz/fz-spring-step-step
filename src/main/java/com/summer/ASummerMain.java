package com.summer;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2015-3-16.
 */
public class ASummerMain {

    private static Logger logger = Logger.getLogger(ASummerMain.class);

    public static void main(String[] args){

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});

        Apple apple = context.getBean("summerApple", Apple.class);
        logger.info(apple.getColor()+","+apple.getShape().value+","+apple.getTaste().value);

        Shape appleShape = context.getBean("shape", Shape.class);
        logger.info(appleShape.value);

        FruitShop fruitShop = context.getBean("fruitShop", FruitShop.class);
        logger.info(fruitShop.getName()+","+fruitShop.getAddress()+","+fruitShop.getContact()+","+fruitShop.getTodaySp());

        MyShops myShops = context.getBean("myShops", MyShops.class);
        logger.info(myShops.getBookShop().getName()+","+myShops.getBookShop().getAddress()+","+myShops.getBookShop().getContact());
        logger.info(myShops.getFruitShop().getName()+","+myShops.getFruitShop().getAddress()+","+myShops.getFruitShop().getContact());

        Shop shop = context.getBean("shop", Shop.class);
        logger.info(shop.getName()+","+shop.getAddress()+","+shop.getContact());
    }
}
