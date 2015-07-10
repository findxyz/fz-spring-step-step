package com.ws.clientByServlet;

import com.ws.clientByServlet.HelloJAXWS;
import com.ws.clientByServlet.HelloJAXWSImplService;

/**
 * Created by Administrator on 2015/7/10.
 *
 * 7.����webservice������wsdl��url��ʽ��������Ӧ��java�ͻ��˴���
 *   ���ɷ�����
 *   1)ͨ��idea ide����java�ͻ��˴��룬
 *     ��������Ҫ����java�ͻ��˴����Ŀ¼���Ҽ���
 *     ������ѡ���ѡ��WebService->Generate java code from wsdl
 *   2)ͨ��jdk�Դ���wsimport��������java�ͻ��˴��룬
 *     F:\>wsimport -keep -verbose -p com.ws.client http://localhost:8080/service/helloJAXWS?wsdl
 *     ���в���-p������ָ������java�ļ��İ����ģ�
 *     ������ɵ�java���뿽������Ŀ�оͿ���ʹ����
 *   3)����...
 * 8.ʹ��webservice�ͻ��˴��룬�½���Main�࣬
 *   �ҵ������Service��β���࣬�����Ӧ�Ľӿ��࣬
 *   ͨ��Service.getPort��ȡ��Ӧ�ӿڵ�ʵ���࣬
 *   ������ط���
 */
public class HelloClientMain {

    public static void main(String[] args){

        HelloJAXWS helloJaxWs = new HelloJAXWSImplService().getHelloJAXWSImplPort();
        System.out.println(helloJaxWs.sayHello());
        System.out.println(helloJaxWs.sayHello2("fz"));
    }
}
