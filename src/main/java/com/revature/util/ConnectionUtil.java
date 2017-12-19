package com.revature.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	public static Connection getConnection() throws IOException, SQLException {
		Properties properties = new Properties();
		InputStream inputStream = new FileInputStream("connection.properties");
		properties.load(inputStream);
		
		String url = properties.getProperty("url");
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		return DriverManager.getConnection(url, user, password);
	}
}
