package com.travel.common.util;

import java.sql.Connection;
import java.sql.DriverManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DBConnUtil {

	private static final Logger logger = LoggerFactory.getLogger(DBConnUtil.class);

	public DBConnUtil() {
	}

	public static Connection getDBConnection() {
		Connection conn = null;
		try {
			String driverClassName = PropertyUtil.getProperty("jdbc.driverClassName0", "/properties/jdbc.properties");
			String url = PropertyUtil.getProperty("jdbc.url0", "/properties/jdbc.properties");
			String userName = PropertyUtil.getProperty("jdbc.username0", "/properties/jdbc.properties");
			String password = PropertyUtil.getProperty("jdbc.password0", "/properties/jdbc.properties");
			if (logger.isDebugEnabled())
				logger.debug((new StringBuilder()).append("url is ")
						.append(url).append(";userName is ").append(userName)
						.append(";password is ").append(password).toString());
			Class.forName(driverClassName).newInstance();
			conn = DriverManager.getConnection(url, userName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
