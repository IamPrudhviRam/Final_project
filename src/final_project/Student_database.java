package final_project;
import java.sql.*;
public class Student_database {
      public static void main(String args[])
    {
try{
    Class.forName("oracle.jdbc.OracleDriver");
    Connection c= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","pass1234");
   Statement st = c.createStatement();
   ResultSet rs = st.executeQuery("select * from student ");
   while(rs.next())
   {
       System.out.println("ID     :"+rs.getInt(1));
       System.out.println("STUDNAME   : "+rs.getString(2));
       System.out.println("STUDDEPT : "+rs.getString(3));
       System.out.println("GENDER : "+rs.getString(4));
       System.out.println("SEM_1 : "+rs.getFloat(5));
       System.out.println("SEM_2 : "+rs.getFloat(6));
       System.out.println("SEM_3 : "+rs.getFloat(7));
       System.out.println("SEM_4 : "+rs.getFloat(8));
       System.out.println("SEM_5 : "+rs.getFloat(9));
       System.out.println("SEM_6 : "+rs.getFloat(10));
       System.out.println("SEM_7 : "+rs.getFloat(11));
       System.out.println("SEM_8 : "+rs.getFloat(12));
       //System.out.println("SEM_1 : "+rs.getFloat(13));
   }
    }
    catch(Exception e)
    {
        System.out.print(e);
    }
}
}