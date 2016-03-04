package com.mirror;

import com.summer.Apple;
import net.vidageek.mirror.dsl.Mirror;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by fz on 2016/3/4.
 */
public class MirrorMain {

    private String someFiled = "abc";

    private String sayHello(String name) {

        return "Hello, " + name;
    }

    public static void main(String[] args) {

        // 反射方法
        MirrorMain mirrorMain = new MirrorMain();
        Object hiStr = new Mirror().on(mirrorMain).invoke().method("sayHello").withArgs("mirror");
        System.out.println(hiStr);

        // 反射类
        Class c = new Mirror().reflectClass("com.mirror.MirrorMain");
        System.out.println(c.getName());

        // 射实例
        MirrorMain aMirrorMain = new Mirror().on(MirrorMain.class).invoke().constructor().withoutArgs();
        System.out.println(aMirrorMain.someFiled);

        // 反射注解
        List<Annotation> classAnnotations = new Mirror().on(Apple.class).reflectAll().annotations().atClass();
        System.out.println(classAnnotations);
        Component classAnnotation = new Mirror().on(Apple.class).reflect().annotation(Component.class).atClass();
        System.out.println(classAnnotation.value());

        List<Annotation> methodAnnotations = new Mirror().on(Apple.class).reflectAll().annotations().atMethod("init").withArgs(String.class, String.class);
        System.out.println(methodAnnotations);
        Autowired autowiredAnnotation = (Autowired) methodAnnotations.get(0);
        System.out.println(autowiredAnnotation.required());

        List<Annotation> fieldAnnotations = new Mirror().on(Apple.class).reflectAll().annotations().atField("color");
        System.out.println(fieldAnnotations);
        Value valueAnnotation = (Value) fieldAnnotations.get(0);
        System.out.println(valueAnnotation.value());

        // 反射修改属性，获取属性
        new Mirror().on(mirrorMain).set().field("someFiled").withValue("123");
        Object ret = new Mirror().on(mirrorMain).get().field("someFiled");
        System.out.println(ret);

        // 反射获取属性
        String aField = "a";
        Field f = new Mirror().on(MirrorMain.class).reflect().field(aField);
        if (f != null) {
            System.out.println(f.getName());
        } else {
            System.out.println("没有" + aField + "这个属性");
        }

    }
}
