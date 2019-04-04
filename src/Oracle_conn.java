/**
 *
 * @author Windows
 */
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
public class Oracle_conn {
   public static void main(String args[]){
       try{
    Class.forName("oracle.jdbc.OracleDriver");
    Connection c= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","pass1234");
    }
      catch(Exception e)
    {
        System.out.print(e);
    }   
    }
}

