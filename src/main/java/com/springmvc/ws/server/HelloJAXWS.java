package com.springmvc.ws.server;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by fz on 2015/7/10.
 */
@WebService
public interface HelloJAXWS {

    @WebMethod
    public String sayHello();

    @WebMethod
    public String sayHello2(String name);
}
