package com.ws.clientByServlet;

import com.ws.clientByServlet.HelloJAXWS;
import com.ws.clientByServlet.HelloJAXWSImplService;

/**
 * Created by Administrator on 2015/7/10.
 *
 * 7.根据webservice发布的wsdl（url形式）生成相应的java客户端代码
 *   生成方法：
 *   1)通过idea ide生成java客户端代码，
 *     可以在想要生成java客户端代码的目录点右键，
 *     在最后的选项卡中选择WebService->Generate java code from wsdl
 *   2)通过jdk自带的wsimport工具生成java客户端代码，
 *     F:\>wsimport -keep -verbose -p com.ws.client http://localhost:8080/service/helloJAXWS?wsdl
 *     其中参数-p是用来指定生成java文件的包名的，
 *     最后将生成的java代码拷贝到项目中就可以使用了
 *   3)其他...
 * 8.使用webservice客户端代码，新建本Main类，
 *   找到最后以Service结尾的类，和其对应的接口类，
 *   通过Service.getPort获取对应接口的实现类，
 *   调用相关方法
 */
public class HelloClientMain {

    public static void main(String[] args){

        HelloJAXWS helloJaxWs = new HelloJAXWSImplService().getHelloJAXWSImplPort();
        System.out.println(helloJaxWs.sayHello());
        System.out.println(helloJaxWs.sayHello2("fz"));
    }
}
