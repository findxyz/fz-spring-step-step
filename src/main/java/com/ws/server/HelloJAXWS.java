package com.ws.server;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

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
