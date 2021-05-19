
package javaws.xmlservice;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style= Style.DOCUMENT)
public interface UsersDOC {
    @WebMethod String getDefaultMessage(String name); 
    
    @WebMethod String removeUsers(String id); 
    
    @WebMethod List getAll();
    
    @WebMethod String setUsers(String name);
}
