package dataConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class CreateConnection {
	public static Connection getConnection(String url, String databaseName, String userName, String passwd) {
		try {
			Class.forName("org.postgresql.Driver");

			return DriverManager.getConnection("jdbc:postgresql://" + url + "/" + databaseName, userName, passwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
