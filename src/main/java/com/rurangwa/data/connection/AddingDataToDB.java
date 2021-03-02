package com.rurangwa.data.connection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class AddingDataToDB{

	
	DatabaseConnector db=new DatabaseConnector();
	private ConsoleAppender consoleApp= new ConsoleAppender();
	private static Logger log = Logger.getLogger(AddingDataToDB.class);
	
	
	/**
	 * will create all the tables needed, and adds them to the database. ALL TABLES GET CREATED the first time a user signs up.
	 * @param con
	 */
	public void buildAllTables(Connection con) {
		 consoleApp.setThreshold(Level.WARN);
		
		try {
			String managerTable="CREATE TABLE MANAGER(id SERIAL PRIMARY KEY,"
					+ "EMAIL VARCHAR UNIQUE, PASSWORD VARCHAR NOT NULL, name VARCHAR)";
			
			String employeeTable="CREATE TABLE EMPLOYEES(id  SERIAL PRIMARY KEY, "
					+ "name VARCHAR, PASSWORD VARCHAR, EMAIL VARCHAR UNIQUE)";
			
			String cutomerTable="CREATE TABLE CUSTOMERS(id  SERIAL PRIMARY KEY, "
					+ "name VARCHAR, PASSWORD VARCHAR, EMAIL VARCHAR UNIQUE)";
			
			String bicycleTable="CREATE TABLE BICYCLES(id SERIAL PRIMARY KEY,"
					+ " TYPE VARCHAR NOT NULL, COLOR VARCHAR, AVAILABLE_BIKES VARCHAR, MY_BIKES VARCHAR )";
			
			
			String bikeStore="CREATE TABLE SHOP_FIN(id SERIAL PRIMARY KEY ,REMNPAYMNT NUMERIC, "
					+ "WEEKLY_PAYMNT NUMERIC, ALLPAYMNT NUMERIC , OFFER NUMERIC,"
					+ " ACCEPTEDOFFER  NUMERIC, REJECTEDOFFER NUMERIC)";
			
			
			Statement statement=con.createStatement();
			
			statement.executeUpdate(managerTable);
			
			statement.executeUpdate(employeeTable);
			
			statement.executeUpdate(cutomerTable);
			
			statement.executeUpdate(bicycleTable);
			statement.executeUpdate(bikeStore);
			
			statement.close();
			
			
			System.out.println("Tables created...");
		} catch (SQLException e) {
			
			// table already exist
		
			System.out.println(" ");
		}
		
	}
	
	/**
	 *  Adds data into manager's table
	 * @param i
	 * @param pass
	 * @param email
	 * @param con
	 * @param name
	 * @param run
	 * @param run2
	 */
	
	public  void insertDataIntoCol( int i,String pass,String email, Connection con,String name,boolean run, boolean run2 ) {


		try {
			String sql="INSERT INTO MANAGER(password,email,name)"
					
					+ "VALUES('"+pass+"','"+email+"','"+name+"' )";
			
			Statement statement=con.createStatement();
			
			statement.executeUpdate(sql);
			
		statement.close();
		
			System.out.println(name+", You successfully register to Bicycle Shop.");
		System.out.println("Data saved to Database....");
		} catch (SQLException e) {
			System.out.println("\t\t\t==The user already exits with that email.==\n");
		
			log.warn(e.getMessage(),e);
			
	
		}
	
		
		
		}
	

	/**
	 * adds data to customer's table
	 * @param i
	 * @param pass
	 * @param email
	 * @param con
	 * @param name
	 * @param run
	 */
	public  void insertDataIntoCol( int i,String pass,String email, Connection con,String name,boolean run ) {

		if(run==true) {
		try {
			String sql="INSERT INTO CUSTOMERS(password,email,name)"
					
					+ "VALUES('"+pass+"','"+email+"','"+name+"' )";
			
			Statement statement=con.createStatement();
			
			statement.executeUpdate(sql);
			statement.close();
			System.out.println(name+", You successfully register to Bicycle Shop.");
		System.out.println("Data saved to Database....");
		} catch (SQLException e) {
		
			System.out.println("\t\t\t==The user already exits with that email.==\n");
			
			System.out.print(e.getMessage());
	
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				log.warn(e.getMessage(),e);
			}
		}
		
		}
		else System.out.println("");
		
		}
	
	/**
	 * adds data into the employee's table.
	 * @param i
	 * @param str0
	 * @param str1
	 * @param con
	 * @param str2
	 */
	public  void insertDataIntoCol( int i,String str0,String str1, Connection con,String str2) {

		try {
			String sql="INSERT INTO EMPLOYEES(password,email,name)"
					
					+ "VALUES('"+str0+"','"+str1+"','"+str2+"' )";
			
			Statement statement=con.createStatement();
			
			statement.executeUpdate(sql);
			statement.close();
			
			System.out.println(str2+", You successfully register to Bicycle Shop.");
		System.out.println("Data saved to Database....");
		} catch (SQLException e) {
			
			
			System.out.println("\t\t\t==The user already exits with that email.==\n");
			log.warn(e.getMessage(),e);
	
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				log.warn(e.getMessage(),e);
			}
		}
		
		}
	
	
	

	

}
