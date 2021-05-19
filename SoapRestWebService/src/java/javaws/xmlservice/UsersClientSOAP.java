package javaws.xmlservice;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class UsersClientSOAP {
    
    public static void main(String[] args) throws Exception 
    {  
    URL url = new URL("http://localhost:8888/SoapRestWebService/javaws.xmlservice/users");  
     
    QName qname = new QName("http://xmlservice.javaws/", "UsersImplementService");  
    Service service = Service.create(url, qname);  
    
    //HelloWorldRPC object = service.getPort(HelloWorldRPC.class);  
    
    UsersDOC object = service.getPort(UsersDOC.class);  
    
    System.out.println("************<><><><><><><><><>************");
    
    System.out.println("  "+object.getDefaultMessage(" Sakthi"));  
    
    System.out.println("************<><><><><><><><><>************");
    
    System.out.println(object.setUsers("Sainadh"));
    
    System.out.println(object.setUsers("Danish"));
    
    System.out.println(object.removeUsers("2"));
    
    System.out.println("----------------");
    System.out.println("   Users List   ");
    System.out.println("----------------");
    
    for (Object item:object.getAll())
    {
        System.out.println(item);
    }
    
    }  
}
