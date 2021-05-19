package javaws.xmlservice;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;

/*

RPC Style


@WebService(endpointInterface = "javaws.xmlservice.HelloWorldRPC")  
public class UsersImplement implements HelloWorldRPC{

    @Override
    public String getHelloWorldAaString(String name) {
       return "Hello World JAX-WS" + name;
    }
    
}

*/

/*

DOCUMENT Style

*/
@WebService(endpointInterface = "javaws.xmlservice.UsersDOC")  
public class UsersImplement implements UsersDOC{
     
    List<String> users;

    public UsersImplement() {
        this.users = new ArrayList<>();
    }
    
    @Override
    public String getDefaultMessage(String name) {
               return "Hello " + name+" :) Your Activities Stats ";
    }
    
    @Override
    public List getAll() 
    {
               return users;
    }
    
    @Override
    public String setUsers(String name) {
        users.add(name);
        return "User named - "+ name+ " added to the Collection.\n";
    }
    
    @Override
    public String removeUsers(String id) {
        int loc = Integer.parseInt(id)-1;
        String deletedBook= users.get(loc);
        users.remove(loc);
        return "User named - "+ deletedBook+ " removed from the Collection.\n";
    }

}

