// Copied from OATemplate project by OABuilder 06/20/21 11:44 AM
package com.viaoa.docbuilder.webservice.client.hello;

import java.net.URL;

import javax.xml.namespace.QName;

import com.viaoa.docbuilder.webservice.client.hello.wsimport.Hello;
import com.viaoa.docbuilder.webservice.client.hello.wsimport.HelloService;

/**
 * Client app to call a Webservice
 * 
 * NOTE: the directory wsimport is for the wsimport generated files
 * 
 *  wsimport -p com.viaoa.docbuilder.webservice.client.hello.wsimport -d /projects/java/docBuilder/bin -s /projects/java/docBuilder/src http://localhost:8081/ws/hello?WSDL
*/
public class HelloClient {

    public static void main(String[] args) throws Exception {
        
        URL urlWSDL = new URL("http://localhost:8081/ws/hello?WSDL");
        QName qname = new QName("http://server.webservice.docBuilder.com/", "HelloService");        
        
        HelloService service = new HelloService(urlWSDL, qname);
        Hello hello = service.getHelloPort();

        for (int i=0; i<100; i++) {
            String s = hello.getHello("test"+i);
            System.out.println("==>"+s);
        }
    }
    
}
