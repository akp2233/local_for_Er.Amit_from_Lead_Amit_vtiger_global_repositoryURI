package com.crm.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
//here we declare Connection as a globally because we want to use same reference in another method 	
Connection conn;
/**
 * @author dk
 * this method is establish the connection to Database
 * @param url
 * @param username
 * @param password
 */
public void getDBConection(String url,String username,String password) {
	try {
		Driver driver=new Driver();//create driver object
		DriverManager.registerDriver(driver);//using DriverManger first register driver to DriverManager
		
		//using DriverManager establish the connection w/b database
		conn=DriverManager.getConnection(url,username,password);
	}catch(Exception e) {
		
	}
	
}
/**
 * @author dk
 * this method is used to close database connection 
 */
public void closeDBConnection() {
	try {
		conn.close();
	}catch(Exception e) {
		
	}
}
/**
 * @author dk
 * this method is use to execute select query
 * here we the multiple data to query thats why return type of method is ResultSet
 * @param query
 * @return
 */
public ResultSet executeSelectQuery(String query) {
ResultSet result=null;//here we declare globally because if declare inside the try block not able to return 
	try {
		Statement stmn = conn.createStatement();
		result=stmn.executeQuery(query);
	}catch(Exception e) {
		
	}
	return result;
}
/**
 * @author dk
 * this method use to perform non select Query in database 
 * method return type is int because if query is executed produce +1 if not 0 thats why method return type is int
 * @param query
 * @return
 */
public int executeNonSelectQuery(String query) {
	int result=0;
	try {
		Statement stmn = conn.createStatement();
		result=stmn.executeUpdate(query);
	}catch(Exception e) {
		
	}
	return result;
}


}
