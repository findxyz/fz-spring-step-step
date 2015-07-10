package com.ws.server;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by fz on 2015/7/10.
 */
@WebService(endpointInterface = "com.ws.server.HelloJAXWS")
public class HelloJAXWSImpl implements HelloJAXWS {

    @Override
    @WebMethod
    public String sayHello() {
        return "Hello, JAX-WS";
    }

    @Override
    @WebMethod
    public String sayHello2(String name) {
        return "Hello, " + name;
    }

}
