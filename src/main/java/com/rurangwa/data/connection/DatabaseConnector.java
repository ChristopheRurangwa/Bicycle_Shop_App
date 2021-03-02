package com.rurangwa.data.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.rurangwa.controller.AppDriver;
import com.rurangwa.exceptions.ConnectionToDatabaseFailed;

public class DatabaseConnector implements DatabaseConn {
	private static Logger log = Logger.getLogger(DatabaseConnector.class);
	private static ConsoleAppender consoleApp= new ConsoleAppender();
	
	@Override
	public void connect(String passwrd, String email,String name,boolean run,boolean run2, int userSequence) throws ConnectionToDatabaseFailed {
		consoleApp.setThreshold(Level.WARN);
		AddingDataToDB input= new AddingDataToDB();
		UpdatingAndRetrievingData retrv=new UpdatingAndRetrievingData();
		
		Connection con;
		
		String jdbcURL="jdbc:postgresql://localhost:5432/postgres";
		
		String userName="postgres";
		String password="Monpost";
		
		try {
			con= DriverManager.getConnection(jdbcURL, userName, password);
			input.buildAllTables(con);
		
			if(!(userSequence==1||userSequence==2||userSequence==3)) {
				
			//will only run, given the condition is satisfied...
		if(run==false&&run2==false) { input.insertDataIntoCol(0,passwrd,email,con,name);
		
		}//employee's table
		
		
		else	if(run2==true&&run==false) {input.insertDataIntoCol(0, passwrd, email, con, name, run, run2);}//manager's table
			
		else if(run==true&&run2==false)	{input.insertDataIntoCol(0, passwrd, email, con, name, run);}// data into customer's table
			
		else System.out.println("");
		}
			
		
		if(userSequence==1||userSequence==2||userSequence==3) {
			
			retrv.retrieveLogInInfoAndVerifies(email, passwrd, con, userSequence);}
			
			
			System.out.println("Connection Ended . .. ... ....");
			con.close();
		} catch (SQLException e) {
			log.info("Make sure you check both (password, username) and internet connection..");
			log.warn(e.getMessage(),e);
			throw new ConnectionToDatabaseFailed();
			
		
		}
		
	}
	

	
}
