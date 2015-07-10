package com.ws.server;

import javax.xml.ws.Endpoint;

/**
 * Created by fz on 2015/7/10.
 *
 * 1.创建webservice接口，类名标注@WebService，方法标注@WebMethod
 * 2.创建webservice接口的实现类，类名标注@WebService，方法名标注@WebMethod，
 *   此时如果在@WebService中添加endPointInterface属性会引起下面生成wsdl相关java文件错误，
 *   错误信息提示的含义就是有@WebMethod时，不可有endPointInterface属性
 * 3.使用jdk自带的工具wsgen生成wsdl将要使用的相关文件，将生成后的文件拷贝到*.server.jaxws目录下
 *   F:\ideaWorkSpace\springStepByStep\build\classes\main>wsgen -keep -cp . com.ws.server.HelloJAXWSImpl
 *   copy generated java files to *.server.jaxws package
 * 4.在生成完wsdl相关文件后，可以在实现类的@WebService中添加endPointInterface属性
 *   @WebService(endpointInterface = "com.ws.server.HelloJAXWS")
 *   这样做之后在客户端使用时，相应的接口类就是这里指定的接口类
 * 5.新建本Main类，通过Endpoint.publish（应该是实现了一个简单的web服务）发布webservice
 * 6.run it
 */
public class HelloServerMain {

    public static void main(String[] args){

        Endpoint.publish("http://localhost:8080/service/helloJaxWs", new HelloJAXWSImpl());
    }
}
