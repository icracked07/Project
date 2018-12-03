<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<% 
String connectionURL ="jdbc:mysql://localhost:3306/database12";
Connection con=null;
Class.forName("com.mysql.jdbc.Driver").newInstance();
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database12","root","");
ResultSet rs=null;
PreparedStatement pstmt=null;
OutputStream img;
try{
    pstmt=con.prepareStatement("select * from image1");
    rs=pstmt.executeQuery();
 if(rs.next())
 {
     byte barray[] = rs.getBytes(2);
     response.setContentType("image/png");
     img=response.getOutputStream();
     img.write(barray);
     img.flush();
     img.close();
 }
}
 catch (Exception e) {
} finally {
try {
    if(con!=null)
        con.close();
}catch(Exception ex)
{
}
}
%>
