package com.wangli.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * @author wangli
 * 基于jdk1.8的javax.jws 发布webservice接口
 * @WebService － 它是一个注解，用在类上指定将此类发布成一个ws。
 * Endpoint – 此类为端点服务类，它的方法publish用于将一个已经添加了@WebService注解
 * 对象绑定到一个地址的端口上。
 */
@WebService
public class JwsServiceHello {
    /**
     * 供客户端调用的方法，该方法是非静态的，会被发布
     * */
    public String getValue(String name) {
        return "欢迎你！" + name;
    }

    /**
     * 方法加上@WebMethod(exclude = true)后，该方法不会被发布
     * */
    @WebMethod(exclude = true)
    public String getHello(String name) {
        return "你好！" + name;
    }

    /**
     * 静态方法不会被发布
     * */
    public static String sayGoodbye(String name) {
        return "再见！" + name;
    }

    /**
     * 通过Endpoint(端点服务)发布一个WebService
     * */
    public static void main(String[] args) {
        //2个参数：1.本地的服务地址 2.提供服务的类
        Endpoint.publish("http://10.0.2.29:8080/Service/ServiceHello", new JwsServiceHello());
        System.out.println("发布成功！");
    }
}
