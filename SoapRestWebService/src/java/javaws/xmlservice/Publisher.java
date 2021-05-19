package javaws.xmlservice;

import javax.xml.ws.Endpoint;

public class Publisher {
    public static void main(String[] args)
    {
        Endpoint ep= Endpoint.create(new UsersImplement());
        ep.publish("http://localhost:8888/SoapRestWebService/javaws.xmlservice/users"); 
    }
}
