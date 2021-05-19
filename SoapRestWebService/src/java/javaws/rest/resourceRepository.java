package javaws.rest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class resourceRepository 
{
    ArrayList<myResource> resource;
    Connection conn= null;
    
    public resourceRepository()
    {
        resource= new ArrayList<>();
        try 
        {
            conn = dbConnect.initializeDatabase();
        } 
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
      
    public ArrayList<myResource> getallbooks()
    {
        try 
        {
            String query= "SELECT product_id,bookname,cover,product_category,count from bookadmin";
            PreparedStatement stat = conn.prepareStatement(query);  
            ResultSet result = stat.executeQuery();
            while(result.next())
            {
                resource.add(new myResource(result.getInt("product_id"),result.getString("bookname"),result.getString("cover"),result.getString("product_category"),result.getInt("count")));          
            }
            stat.close();
            
            System.out.println("??????"+resource.get(0).bookname +"??????");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return resource;
    }
    
    public ArrayList<myResource> getonebook(int item)
    {
       try 
       {
           String query= "SELECT product_id,bookname,cover,product_category,count from bookadmin where product_id = ?";
           PreparedStatement stat = conn.prepareStatement(query); 
           stat.setInt(1, item);
           ResultSet result = stat.executeQuery();
           while(result.next())
           {
               resource.add(new myResource(result.getInt("product_id"),result.getString("bookname"),result.getString("cover"),result.getString("product_category"),result.getInt("count")));          
           }
           stat.close();
           
           System.out.println("??????"+resource.get(0)+"??????");
       }
       catch(Exception e)
       {
           System.out.println(e);
       }

       return resource;
    }
    
    public void postonebook(myResource res)
    {
        try
        {
            String getIDquery= "SELECT MAX(product_id) from bookadmin";
            PreparedStatement stat = conn.prepareStatement(getIDquery);  
            ResultSet result = stat.executeQuery();
            result.next();
            int maxID= result.getInt(1)+1;          

            String query= "INSERT INTO bookadmin VALUES (?, ?, ?, ?, ?)";
            stat = conn.prepareStatement(query);
            stat.setInt(1, maxID);
            stat.setString(2, res.bookname);
            stat.setString(3, res.cover);
            stat.setString(4, res.category);
            stat.setInt(5, res.count);
            int flag = stat.executeUpdate();
            if(flag > 0)
            {
              System.out.println("?????Book Added?????");
            }
            stat.close();
        }
       catch(Exception e)
       {
           System.out.println(e);
       }
   }
    
   public ArrayList<myResource> updateonebook(int id, myResource res)
    {
        try
        {         
            String query="UPDATE bookadmin SET bookname= ?, cover= ?, product_category=?, count=? WHERE product_id= ?";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, res.bookname);
            stat.setString(2, res.cover);
            stat.setString(3, res.category);
            stat.setInt(4, res.count);
            stat.setInt(5, id);
            stat.executeUpdate();
            resource.add(new myResource(id, res.bookname, res.cover, res.category, res.count));
            stat.close();
            System.out.println("?????Book Added?????");

        }
       catch(Exception e)
       {
           System.out.println(e);
       }
       return resource;
    }
   
    public void removeonebook(int id)
    {
     try
        {
            String query= "DELETE FROM bookadmin WHERE product_id= ?";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setInt(1, id);
            stat.executeUpdate();
            stat.close();
        }
       catch(Exception e)
       {
           System.out.println(e);
       }
    }
}
