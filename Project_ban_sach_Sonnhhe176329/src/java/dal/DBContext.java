
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
    protected Connection con;
    public DBContext()
    {
        try {
            // Edit URL , username, password to authenticate with your MS SQL Server
            String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=PRJ_BookStore";
            String username = "sa";
            String password = "123456";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url, username, password);
            //System.out.println("----");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }

}
