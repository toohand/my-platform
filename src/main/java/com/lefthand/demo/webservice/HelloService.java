package com.lefthand.demo.webservice;



import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * Created by hp on 2015/6/29.
 */
@WebService(name = "HelloService")
public interface  HelloService {
    @RequestWrapper(localName = "sayHello")
    @WebMethod
    public String sayHello(@WebParam String username);
}
