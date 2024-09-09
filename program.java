package workingwithimages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
public class JdbcUtility {
private JdbcUtility() {		
	}
    static {
		 try {
			    Class.forName("com.mysql.cj.jdbc.Driver");
				 System.out.println("Driver loaded ");
	      }catch(ClassNotFoundException ce) {
			           ce.printStackTrace();
		   }
	}
	public static Connection getConnection() throws IOException, SQLException,FileNotFoundException {
		FileInputStream fir=new FileInputStream("E:\\IDE\\workingwithimages\\src\\workingwithimages\\application.properties");
		Properties p1=new Properties();
		p1.load(fir);
		Connection connection=DriverManager.getConnection(p1.getProperty("url"),p1.getProperty("username"),p1.getProperty("password"));
		return connection;
	}
	public static void close(Connection connection,Statement statement,ResultSet resultset) {
			try {
				if(connection!=null) {
					connection.close();
				}
				if(statement!=null) {
					statement.close();
				}
				if(resultset!=null) {
					resultset.close();
				}
				}catch(SQLException se) {
					se.printStackTrace();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			public static void close(Connection connection,Statement statement,CallableStatement callablestatement) {
				try {
					if(connection!=null) {
						connection.close();
					}
					if(statement!=null) {
						statement.close();
					}
					if(callablestatement!=null){
						callablestatement.close();
					}
					
				}catch(SQLException se) {
					se.printStackTrace();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
	}

