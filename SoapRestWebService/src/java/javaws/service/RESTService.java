package javaws.service;

import javaws.rest.myResource;
import javaws.rest.resourceRepository;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("guide")
public class RESTService 
{
    resourceRepository resObj= new resourceRepository();
      
    @GET
    @Path("getbook")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ArrayList<myResource> getObject()
    {
    System.out.println("GET route called...");
    return resObj.getallbooks() ;
    }
    
    @GET
    @Path("getbook/{item}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ArrayList<myResource> getOneObject(@PathParam("item") Integer id)
    {
    System.out.println("GET ONE route called...");
    return resObj.getonebook(id) ;
    }
   
    @POST
    @Path("addbook")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public myResource addObject(myResource res)
    {
        System.out.println("POST route called...");
        resObj.postonebook(res);
        
        System.out.println(res);
        return res;
    }
    
    @PUT
    @Path("updatebook/{item}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ArrayList<myResource> updateObject(@PathParam("item") Integer id, myResource res) 
    {
        System.out.println("PUT route called...");
        return resObj.updateonebook(id, res);
    }
    
    @DELETE
    @Path("deletebook/{item}")
    public void remove(@PathParam("item") Integer id) 
    {
        System.out.println("DELETE route called...");
        resObj.removeonebook(id);
        
    }
 
}
