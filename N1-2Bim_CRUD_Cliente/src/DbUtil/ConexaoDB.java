package DbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {

	private static Connection connection = null;

    public static Connection getConnection() throws Exception {
       
    	if (connection != null)
            return connection;
        else {

                String driver = "com.mysql.jdbc.Driver";
                String url = "jdbc:mysql://localhost:3306";
                String user = "root";
                String password = "admin";
            	
            	Class.forName(driver);
                
                connection = DriverManager.getConnection(url, user, password);
                
                connection.setAutoCommit(true);
            
            
            return connection;
        }

    }

}
