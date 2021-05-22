
package railway.reservation.system;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
/**
 *
 * @author Gunesh Madusanka
 */
public class db {
    private static Connection c;
    
    private static void createNewConnection()throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        c=DriverManager.getConnection("jdbc:mysql://localhost:3306/railway", "root", "123");
    }
    public static void iud(String sql)throws Exception{
        if (c==null) {
            createNewConnection();
        }
        c.createStatement().executeUpdate(sql);
    }
    
    public static ResultSet search(String sql)throws Exception{
        if (c==null) {
            createNewConnection();
        }
        return c.createStatement().executeQuery(sql);
    }
    
    public static Connection getDBCon()throws Exception{
         if (c==null) {
            createNewConnection();
        }
         return c;
    }
    
}   

