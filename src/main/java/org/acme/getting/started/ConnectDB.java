package org.acme.getting.started;
import java.sql.*;

/*
 * https://www.postgresql.org/docs/7.4/jdbc-use.html
 * https://jdbc.postgresql.org/documentation/head/connect.html
 * https://quarkus.io/guides/datasource
 */
public class ConnectDB {
	private final static String url="jdb:postgresql://127.0.0.1:5432/";
	private final static String driver ="org.postgresql.Driver";
	private final static String user ="user";
	private final static String pass ="password";
	private final static String db = "testdb";
	public static Connection connection = null;
	
	public ConnectDB() throws SQLException {
		try {
			/*
			 *  can use java -Djdbc.drivers=org.postgresql.Driver as Argument during compilation	<prorgam name>
			 *  you'll need to remove or comment the next line
			 *  Can move the class.forName in the other catch, this is more explicit
			 */
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your PostgreSQL JDBC Driver? "
                + "Include in your library path!");
			e.printStackTrace();
			System.exit(1);
			return ;
			
		}
		System.out.println("PostgreSQL JDBC Driver Registered!");
			connection = DriverManager.getConnection(
				url+db, user, pass);
		if (connection != null) {
			System.out.println("You are connected!");
		}
		else{
			System.out.println("Failed to make connection!");
		}
	}
	
	
	public static void dropCreateDB() throws SQLException {
			Statement statement = connection.createStatement();
			String query = "DROP DATABASE IF EXISTS DB";
			statement.executeUpdate(query);
			query = "CREATE DATABASE DB";
			statement.executeUpdate(query);
			query = "CREATE TABLE Todo ("
					+ "id SERIAL PRIMARY KEY,"
					+ "title VARCHAR(50),"
					+ "description VARCHAR(400),"
					+ "expireAt DATE,"
					+ "createdAt DATE,"
					+ "doneAt DATE,"
					+ "version INTEGER);";	
			statement.executeUpdate(query);	      
	}
	
	public static void disconnect() throws SQLException{
		if (connection!=null)
			connection.close();		
	}
}
