package daoImpl;

import java.sql.Connection;

import dao.Dao;
import dataConnection.CreateConnection;

public class DaoImpl implements Dao {
	private String url;
	private String dbName;
	private String userName;
	private String password;

	public DaoImpl() {
		/*
		url = "localhost";
		*/

		url = "10.0.200.1:5432";
		dbName = "wakai";
		/*
		userName = "sasurai";
		password = "omoide5432";
		*/

		userName = "postgres";
		password = "3uhhm933";
	}

	public Connection init() {
		return CreateConnection.getConnection(url, dbName, userName, password);
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
