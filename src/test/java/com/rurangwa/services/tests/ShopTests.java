package com.rurangwa.services.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import com.rurangwa.beans.Customer;
import com.rurangwa.beans.Employee;
import com.rurangwa.beans.Manager;
import com.rurangwa.data.connection.BicycleConnect;
import com.rurangwa.data.connection.DatabaseConnector;
import com.rurangwa.data.connection.StoreConnct;
import com.rurangwa.services.CustomerServiceImpl;


@TestMethodOrder(OrderAnnotation.class)
public class ShopTests {
	private DatabaseConnector custDAO=new DatabaseConnector();
	private static CustomerServiceImpl custo;
	private Customer cus=new Customer();
	private Employee empl=new Employee();
	private Manager mana=new Manager();
	private BicycleConnect bike=new BicycleConnect();
	private StoreConnct  shop=new StoreConnct ();
	
	
	Connection con;
	
	String jdbcURL="jdbc:postgresql://localhost:5432/postgres";
	
	String userName="postgres";
	String password="Monpost";
	
	@Order(1)
	@Test
	public void testGetCustomerEmailAndPassword() {
		try {
			con= DriverManager.getConnection(jdbcURL, userName, password);
			
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
		}
		
		String sql="SELECT*  FROM CUSTOMERS";
		
	
		ResultSet res;
		try {
			Statement st= con.createStatement();
			
			res = st.executeQuery(sql);
			
			while(res.next()) {
				
				cus.setId(res.getInt("ID"));
				cus.setEmail(res.getString("email"));
				cus.setPassword(res.getString("password"));
				
				
				if(cus.getId()==1) {
					
				assertEquals(cus.getEmail(),"test2");
				assertEquals(cus.getPassword(),"hhh");
			
				}
				
			con.close();
				
			}
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}
		System.out.println("\t<=====testing Method =======\n");

	}
	
	
	@Order(2)
	@Test
	public void testAddCustomer() { 
		
		try {
			con= DriverManager.getConnection(jdbcURL, userName, password);
			
		} catch (SQLException e1) {
		
			System.out.println(e1.getMessage());
			
		}
		String sql;
		

		ResultSet res;
		
		try{
			

			sql = "INSERT INTO CUSTOMERS(password,email,name)"
				
					+ "VALUES('test','test','sys..' )";
			
		Statement st= con.createStatement();
		
		res = st.executeQuery(sql);
	
		while(res.next()) {
			
			mana.setId(res.getInt("ID"));
			mana.setEmail(res.getString("email"));
			mana.setPassword(res.getString("password"));
			
			
			if(mana.getId()==1) {
				
			assertEquals(mana.getEmail(),"sys");
			assertEquals(mana.getPassword(),"sys");
			}}
			}catch (SQLException e) {
		System.out.println(".......");

	}

		
			System.out.println("\t<=====testing Method =======\n");
		
		
	}
	
	
	@Order(3)
	@Test
	public void testGetEmployeeEmailAndPassword() {//DONE!!!!
		
		try {
			con= DriverManager.getConnection(jdbcURL, userName, password);
			
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
		}
		
		String sql="SELECT* FROM  EMPLOYEES";
		
	
		ResultSet res;
		try {
			Statement st= con.createStatement();
			
			res = st.executeQuery(sql);
			
			while(res.next()) {
				
				empl.setId(res.getInt("ID"));
				empl.setEmail(res.getString("email"));
				empl.setPassword(res.getString("password"));
				
				
				if(empl.getId()==1) {
					
				assertEquals(empl.getEmail(),"test@g.net");
				assertEquals(empl.getPassword(),"hhh");
			
				
				}
				
			con.close();
				
			}
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}
		System.out.println("\t<=====testing Method =======\n");
	}
	
	@Order(4)
	@Test
	public void testAddEmployee() {
	
		
		try {
			con= DriverManager.getConnection(jdbcURL, userName, password);
			
		} catch (SQLException e1) {
		
			System.out.println(e1.getMessage());
			
		}
		String sql;
		
			ResultSet res;
	
			try{
				

				sql = "INSERT INTO EMPLOYEES(password,email,name)"
						
						+ "VALUES('tester','tester','sys..' )";
				
			Statement st= con.createStatement();
			
			res = st.executeQuery(sql);
		
			while(res.next()) {
				
				mana.setId(res.getInt("ID"));
				mana.setEmail(res.getString("email"));
				mana.setPassword(res.getString("password"));
				
				
				if(mana.getId()==1) {
					
				assertEquals(mana.getEmail(),"sys");
				assertEquals(mana.getPassword(),"sys");
				}}
				}catch (SQLException e) {
			System.out.println(".......");

		}
		
		
			System.out.println("\t<=====testing Method =======\n");
		
		
	}
	
	@Order(5)
	@Test
	public void testGetManagerEmailAndPassword() {//Done
		try {
			con= DriverManager.getConnection(jdbcURL, userName, password);
			
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
		}
		
		String sql="SELECT*  FROM MANAGER";
		
	
		ResultSet res;
		try {
			Statement st= con.createStatement();
			
			res = st.executeQuery(sql);
			
			while(res.next()) {
				
				mana.setId(res.getInt("ID"));
				mana.setEmail(res.getString("email"));
				mana.setPassword(res.getString("password"));
				
				
				if(mana.getEmail().equals("sys")) {
					
				assertEquals(mana.getEmail(),"sys");
				assertEquals(mana.getPassword(),"sys");
				
				}
				
			con.close();
				
			}
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}
		System.out.println("\t<=====testing Method =======\n");

		
	}
	
	@Order(6)
	@Test
	public void testAddManager() {
		try {
			con= DriverManager.getConnection(jdbcURL, userName, password);
			
		} catch (SQLException e1) {
		
			System.out.println(e1.getMessage());
			
		}
		String sql;
		
		ResultSet res;
		
		try{
			

			sql = "INSERT INTO MANAGER(password,email,name)"
					
						+ "VALUES('sys','sys','sh' )";
	
			
		Statement st= con.createStatement();
		
		res = st.executeQuery(sql);
	
		while(res.next()) {
			
			mana.setId(res.getInt("ID"));
			mana.setEmail(res.getString("email"));
			mana.setPassword(res.getString("password"));
			
			
			if(mana.getId()==1) {
				
			assertEquals(mana.getEmail(),"sys");
			assertEquals(mana.getPassword(),"sys");
			}}
			} catch (SQLException e) {
				System.out.println("........");
			}

		
			System.out.println("\t<=====testing Method =======\n");
		
	}
	
	@Order(7)
	@Test
	public void testGetAvailableBicycles() {
		
		try {
			con= DriverManager.getConnection(jdbcURL, userName, password);
			
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
		}
		
		assertNotNull(bike.availabeBic(con));
		System.out.println("\t<=====testing Method =======\n");
	}
	
	
	@Order(8)
	@Test
	public void  testGetMyBicycles() {
		try {
			con= DriverManager.getConnection(jdbcURL, userName, password);
			
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
		}
		
		assertNotNull(bike.myBikes(con));
		
		System.out.println("\t<=====testing Method =======\n");
	}
	
	@Order(9)
	@Test
	public void  testMakeAnOffer() {
		
		try {
			con= DriverManager.getConnection(jdbcURL, userName, password);
			
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
		}
		
		String sql="SELECT OFFER FROM  SHOP_FIN WHERE ID="+2;
		
	
		ResultSet res;
		try {
			Statement st= con.createStatement();
			
			res = st.executeQuery(sql);
			
			while(res.next()) {
					
				assertEquals(res.getDouble("OFFER"),200);
				
			con.close();
				
			}
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}
		System.out.println("\t<=====testing Method =======\n");
		
	}
	
	@Order(10)
	@Test
	public void  testViewRemainPayments() {
		try {
			con= DriverManager.getConnection(jdbcURL, userName, password);
			
		} catch (SQLException e1) {
			
			System.out.println(e1.getMessage());
			
		}
		assertEquals(shop.paymentsToBeMade(con, 1),75);
		
		System.out.println("\t<=====testing Method =======\n");
	}
	
	@Order(11)
	@Test
	public void  testAcceptOffer() {
		if(con==null) {
		assertEquals(con,null);}
		else 	{try {
			con= DriverManager.getConnection(jdbcURL, userName, password);
			
		} catch (SQLException e1) {
			
			System.out.println(e1.getMessage());
			
		}
		shop.approveOffers(con);}
		
		System.out.println("\t<=====testing Method =======\n");
	}
	
	@Order(12)
	@Test
	public void  testRejectOffer() {
		if(con==null) {
		assertEquals(con,null);}
		else 	{try {
			con= DriverManager.getConnection(jdbcURL, userName, password);
			
		} catch (SQLException e1) {
			
			System.out.println(e1.getMessage());
			
		}
		shop.offerRejections(con, 1);}
		
		System.out.println("\t<=====testing Method =======\n");
	}
	
	
	@Order(13)
	@Test
	public void  testGetAllPayments() {
		try {
			con= DriverManager.getConnection(jdbcURL, userName, password);
			
		} catch (SQLException e1) {
			
			System.out.println(e1.getMessage());
			
		}
		assertNotNull(shop.paymentsSummary(con));
		
		
		System.out.println("\t<=====testing Method =======\n");
	}
	
	
	@Order(14)
	@Test
	public void  testRejectAllOffer() {
		
		if(con==null) {
			assertEquals(con,null);}
			else 	{try {
				con= DriverManager.getConnection(jdbcURL, userName, password);
				
			} catch (SQLException e1) {
				
				System.out.println(e1.getMessage());
				
			}
			shop.rejectAllOfferes(con);}
			
			System.out.println("\t<=====testing Method =======\n");
	}
	
	@Order(15)
	@Test
	public void  testWeeklySum() {
		try {
			con= DriverManager.getConnection(jdbcURL, userName, password);
			
		} catch (SQLException e1) {
			
			System.out.println(e1.getMessage());
			
		}
		assertEquals(shop.weeklySum(con),500);
		System.out.println("\t<=====testing Method =======\n");
	}
	
	
	@Order(16)
	@Test
	public void  testGiveBikeOwnership() {
		if(con==null) {
			assertEquals(con,null);}
			else 	{try {
				con= DriverManager.getConnection(jdbcURL, userName, password);
				
			} catch (SQLException e1) {
				
				System.out.println(e1.getMessage());
				
			}
			shop.giveBikeOwnerShip(con);}
			
			System.out.println("\t<=====testing Method =======\n");
		
		
	}
	
	
	@AfterEach
	public void afterEachTest() {
		System.out.println("Finished testing a method.\n");
	}
	
	@BeforeEach
	public void beforeEachTest() {
		System.out.println("preparing testing!\n");
	}
	
	@AfterAll
	public static void tearDown() {
		System.out.println("::::::::::::::::::::::::.... .......:::::::....:FInished All Tests:.......::::::::::::::::.......... .........::::::::::::::::::::::::::::::::::::");
	}
	
}
