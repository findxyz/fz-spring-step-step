package com.ws.server;

import javax.xml.ws.Endpoint;

/**
 * Created by fz on 2015/7/10.
 *
 * 1.����webservice�ӿڣ�������ע@WebService��������ע@WebMethod
 * 2.����webservice�ӿڵ�ʵ���࣬������ע@WebService����������ע@WebMethod��
 *   ��ʱ�����@WebService�����endPointInterface���Ի�������������wsdl���java�ļ�����
 *   ������Ϣ��ʾ�ĺ��������@WebMethodʱ��������endPointInterface����
 * 3.ʹ��jdk�Դ��Ĺ���wsgen����wsdl��Ҫʹ�õ�����ļ��������ɺ���ļ�������*.server.jaxwsĿ¼��
 *   F:\ideaWorkSpace\springStepByStep\build\classes\main>wsgen -keep -cp . com.ws.server.HelloJAXWSImpl
 *   copy generated java files to *.server.jaxws package
 * 4.��������wsdl����ļ��󣬿�����ʵ�����@WebService�����endPointInterface����
 *   @WebService(endpointInterface = "com.ws.server.HelloJAXWS")
 *   ������֮���ڿͻ���ʹ��ʱ����Ӧ�Ľӿ����������ָ���Ľӿ���
 * 5.�½���Main�࣬ͨ��Endpoint.publish��Ӧ����ʵ����һ���򵥵�web���񣩷���webservice
 * 6.run it
 */
public class HelloServerMain {

    public static void main(String[] args){

        Endpoint.publish("http://localhost:8080/service/helloJaxWs", new HelloJAXWSImpl());
    }
}
