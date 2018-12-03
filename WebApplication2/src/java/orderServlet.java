import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class orderServlet extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String n=request.getParameter("pickup");  
String p=request.getParameter("restaurant");  
String e=request.getParameter("location");  
String c=request.getParameter("cuisine");  
String a=request.getParameter("time");  
          
try{  
String myurl="jdbc:mysql://localhost:3306/project";
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection(myurl,"root","");  
  //out.println("abc");
PreparedStatement ps=conn.prepareStatement(  
"insert into orders values(?,?,?,?,?)");  
  
ps.setString(1,n);  
ps.setString(2,p);  
ps.setString(3,e);  
ps.setString(4,c); 
ps.setString(5,a); 
          
int i=ps.executeUpdate(); 
//out.println("def");
if(i>0)  
{
                RequestDispatcher rd=request.getRequestDispatcher("home.html");
                rd.forward(request, response);
            }
            else
            {
                RequestDispatcher rd=request.getRequestDispatcher("order.html");
                rd.include(request,response);
            }    
}catch (Exception e2) {System.out.println(e2);}  
          
out.close();  
}  
  
}