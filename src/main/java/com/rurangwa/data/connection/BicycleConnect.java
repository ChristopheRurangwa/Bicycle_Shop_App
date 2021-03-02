package com.rurangwa.data.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.rurangwa.beans.Bicycle;
import com.rurangwa.controller.AppDriver;

public class BicycleConnect {
	private ConsoleAppender consoleApp= new ConsoleAppender();
	private static Logger log = Logger.getLogger(BicycleConnect.class);
	

	public Set<Bicycle> availabeBic(Connection con){
		consoleApp.setThreshold(Level.WARN);
		Set<Bicycle> bikes= new HashSet<>();
		
		
		try {
			String sql="SELECT*  FROM BICYCLES";
			
			
			Statement st= con.createStatement();
			
			ResultSet res= st.executeQuery(sql);
			
			
			while(res.next()) {
				
				Bicycle b=new Bicycle();
				b.setId(res.getInt("id"));
				b.setAvailBikes(res.getString("AVAILABLE_BIKES"));
				b.setColor(res.getString("COLOR"));
			System.out.println("  "+b.getId()+"      "+b.getAvailBikes()+"             "+b.getColor());
			
			
				bikes.add(b);
				
			}
			
		} catch (SQLException e) {
			log.warn(e.getMessage(),e);
		}
			
		
		return bikes;
	}
	
	
	public Set<Bicycle> myBikes(Connection con){
		consoleApp.setThreshold(Level.WARN);
		Set<Bicycle> bikes= new HashSet<>();
		
		
		try {
			
			String sql="SELECT* FROM BICYCLES"; 
			
			Statement st= con.createStatement();
			
			ResultSet res= st.executeQuery(sql);
			
			
			while(res.next()) {
				
				Bicycle b=new Bicycle();
				b.setId(res.getInt("id"));
				b.setColor(res.getString("COLOR"));
				b.setMyBikes(res.getString("MY_BIKES"));
				
				//b.setColor(res.getString("color"));
			System.out.println("  "+b.getId()+"      "+b.getMyBikes()+"     "+b.getColor());
				bikes.add(b);
				
			}
			
		} catch (SQLException e) {
			log.warn(e.getMessage(),e);
		}
		
		
		
		return bikes;
		
		
	}
	
	
	
	
	
	
}
