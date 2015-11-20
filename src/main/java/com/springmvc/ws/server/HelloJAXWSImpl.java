package com.springmvc.ws.server;

import com.springmvc.service.FooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by fz on 2015/7/10.
 */
@Service
@WebService(serviceName = "springHelloJaxWs", portName = "helloJaxWsPort", endpointInterface = "com.springmvc.ws.server.HelloJAXWS")
public class HelloJAXWSImpl implements HelloJAXWS {

    @Autowired
    private FooService fooService;

    @Override
    @WebMethod
    public String sayHello() {
        System.out.println("See see springmvc server...");
        fooService.sayHello();
        return "Hello, JAX-WS";
    }

    @Override
    @WebMethod
    public String sayHello2(String name) {
        return "Hello, " + name;
    }

}
