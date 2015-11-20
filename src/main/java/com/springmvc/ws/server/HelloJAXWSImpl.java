package com.springmvc.ws.server;

import javax.jws.WebMethod;
import javax.jws.WebService;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
/**
 * Created by fz on 2015/7/10.
 */
@WebService(endpointInterface = "com.springmvc.ws.server.HelloJAXWS")
public class HelloJAXWSImpl extends SpringBeanAutowiringSupport implements HelloJAXWS {

    @Override
    @WebMethod
    public String sayHello() {
        System.out.println("See see springmvc server...");
        return "Hello, JAX-WS";
    }

    @Override
    @WebMethod
    public String sayHello2(String name) {
        return "Hello, " + name;
    }

}
