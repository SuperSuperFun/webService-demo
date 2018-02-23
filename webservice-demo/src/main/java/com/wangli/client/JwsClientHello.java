package com.wangli.client;

import com.wangli.ws.JwsServiceHello;
import com.wangli.ws.JwsServiceHelloService;

/**
 * @author wangli
 */
public class JwsClientHello {
    public static void main(String[] args) {
        //调用WebService
        JwsServiceHello hello = new JwsServiceHelloService().getJwsServiceHelloPort();
        String val = hello.getValue("wangli");
        System.out.println(val);
    }
}
