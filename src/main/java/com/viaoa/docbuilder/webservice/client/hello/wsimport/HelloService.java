// Copied from OATemplate project by OABuilder 06/20/21 11:44 AM
package com.viaoa.docbuilder.webservice.client.hello.wsimport;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "HelloService", targetNamespace = "http://server.webservice.templaze.com/", wsdlLocation = "http://localhost:8081/ws/hello?WSDL")
public class HelloService
    extends Service
{

    private final static URL HELLOSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(com.viaoa.docbuilder.webservice.client.hello.wsimport.HelloService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = com.viaoa.docbuilder.webservice.client.hello.wsimport.HelloService.class.getResource(".");
            url = new URL(baseUrl, "http://localhost:8081/ws/hello?WSDL");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://localhost:8081/ws/hello?WSDL', retrying as a local file");
            logger.warning(e.getMessage());
        }
        HELLOSERVICE_WSDL_LOCATION = url;
    }

    public HelloService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public HelloService() {
        super(HELLOSERVICE_WSDL_LOCATION, new QName("http://server.webservice.templaze.com/", "HelloService"));
    }

    /**
     * 
     * @return
     *     returns Hello
     */
    @WebEndpoint(name = "HelloPort")
    public Hello getHelloPort() {
        return super.getPort(new QName("http://server.webservice.templaze.com/", "HelloPort"), Hello.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Hello
     */
    @WebEndpoint(name = "HelloPort")
    public Hello getHelloPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://server.webservice.templaze.com/", "HelloPort"), Hello.class, features);
    }

}
