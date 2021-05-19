
package javaws.rest;

import javax.xml.bind.annotation.XmlRootElement;

// POJO Class

@XmlRootElement
public class myResource {
    public int id;
    public int count;
    public String bookname;
    public String author;
    public String projects;
    public String cover;
    public String category;
    public String name;

public myResource()
{

}
 
public myResource(int a)
{
id= a;
} 

public myResource(int w, String x, String y, String z, int a)
{
id= w;
bookname = x; 
cover = y;
category = z;
count= a;
}

@Override
public String toString() {
    return "myResource{" + " count=" + count + ", bookname=" + bookname + ", cover=" + cover + ", category=" + category + '}';
}

}
