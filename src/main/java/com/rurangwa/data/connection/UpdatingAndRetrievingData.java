package com.rurangwa.data.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Scanner;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.rurangwa.controller.AppDriver;
import com.rurangwa.services.BicycleServiceImpl;
import com.rurangwa.services.StoreFinancesServices;

public class UpdatingAndRetrievingData {
	private static Logger log = Logger.getLogger(UpdatingAndRetrievingData.class);
	private Statement stm=null;
	private AppDriver appScan= new AppDriver();//<-- continues to use one scan for data input.
	private BicycleServiceImpl bk=new BicycleServiceImpl();
	private StoreFinancesServices storeBk=new StoreFinancesServices();
	private StoreConnct  shop=new StoreConnct ();
	


public void retrieveLogInInfoAndVerifies(String email, String password, Connection con,int sequenceToRun) {
	 
	
	 
	 //sequenceToRun
	 
	 int user1Empl=1;
	 int user2Cust=2;
	 int user3Mana=3;
	 
	 int identi=0;
	 
		 
		try {
			stm=con.createStatement();

			if(sequenceToRun==user2Cust) {
				
				ResultSet rs=stm.executeQuery("SELECT* FROM CUSTOMERS;");
				while(rs.next()) {
				if(email.equals(rs.getString("email").toLowerCase())&&password.equals(rs.getString("password").toLowerCase())) { 
					//setLoggedE();
					identi=rs.getInt("id");
					
					//System.out.println(identi);
					
					System.out.println("Please make a selection below: :\n\n 1. VIEW AVAILABLE BICYCLES \n "
						+ "2. MAKE AN OFFER FOR BICYCLE \n 3. VIEW MY BICYCLE(S) \n 4. VIEW REMAINING PAYMENTS \n");		
					
					int selectMana=Integer.valueOf(appScan.getScan().nextLine());
					
					switch(selectMana) {
					
					case 1 :{//View availabe bikes
						
						System.out.println("  "+"IDs  Name          Colors\n");
						bk.getAvailableBicycles(con);
				
						
					} break;
					
					case 2:{// Make an offer
						System.out.println("\t\tBicycles price is subject to CHANGE, today price is $575\n");
						
						System.out.print("Please enter the amount you would like to offer: ->$");
						
						double amount=Double.valueOf(appScan.getScan().nextLine());
						
						storeBk.makeAnOffer(amount, con);
						
					} break;
					
					case 3 :{// view my bikes
						System.out.println("==::::::::::::BICYCLES LIST::::::::::::==:");
						System.out.println("  "+"IDs  Name        Colors\n");
						bk.getMyBicycles(con);

					} break;
					case 4 :{// view remaining balance
						System.out.println("You have $"+storeBk.viewRemainPayments(con, identi)+" remaining balance.");
						
					} break;
	
					
					default: System.out.println("Please make a selection below: :\n\n 1. VIEW AVAILABLE BICYCLES \n "
							+ "2. MAKE AN OFFER FOR BICYCLE \n 3. VIEW MY BICYCLE(S) \n 4. VIEW REMAINING PAYMENTS \n");	
					log.info("wrong data was entered.");
					Integer.valueOf(appScan.getScan().nextLine());
					}
					
					}
				
				}
				rs.close();
				
				
		}// end user2Cust
			
			else if(sequenceToRun==user1Empl) {
				
			
				ResultSet rs1=stm.executeQuery("SELECT* FROM EMPLOYEES;");
				
				while(rs1.next()) {
					
					if(email.equals(rs1.getString("email"))&&password.equals(rs1.getString("password"))) {
						
						System.out.println("Please make a selection below: :\n\n 1. ADD BICYCLE TO SHOP \n 2. ACCEPT OR REJECT"
								+ " PENDING OFFER \n 3. REMOVE A BICYCLE FROM SHOP \n 4. VIEW ALL PAYMENTS \n");
						
						int selectEmp=Integer.valueOf(appScan.getScan().nextLine());
					
					switch(selectEmp) {
					
					case 1 :{
						try {// save data to db after taking it from user
							System.out.println("Enter the type of Bicycle, e.g: BMX: ");
							String type = appScan.getScan().nextLine();
							
						System.out.println("Enter color of the Bicycle: ");
						
						String color = appScan.getScan().nextLine();
						
							String sql="INSERT INTO BICYCLES(type,color,available_bikes)"
									
									+ "VALUES('"+type+"','"+color+"','"+type+"' )";
							log.info("Inserted data to db.");
							Statement statement=con.createStatement();
							
							statement.executeUpdate(sql);
						
							System.out.println(type+", was successfully added to the Shop.");
						System.out.println("Data saved to Database....");
						} catch (SQLException e) {
							
							log.warn(e.getMessage(),e);
					
						}
						
					} break;
					
					case 2:{// offer rejection here
						System.out.println("  "+"IDs             AMOUNT IN $\n");
						storeBk.acceptOffer(con);
						System.out.print ("Enter 1 to reject all or accept a value: ");
						
						int removID= Integer.valueOf(appScan.getScan().nextLine());
						
						storeBk.rejecOffer(con,removID );
						
						System.out.println("\n ===The task was performed successfully===");
					
						
						
					} break;
					
					case 3 :{	//employee remove bikes from database
						
						System.out.println("  "+"IDs  Name          Colors\n");
						bk.getAvailableBicycles(con);
						System.out.println("\n");
						stm=con.createStatement();
	
						System.out.println("Please select the id of bicycle to be REMOVED or enter ZERO (0) to exist.\n");
						
						int id=Integer.valueOf(appScan.getScan().nextLine());
						if(id ==0) {
							System.out.println("Bye!!!");
							System.exit(0);}
						String deleSql="DELETE FROM BICYCLES WHERE ID='"+id+"'";
						
						stm.executeUpdate(deleSql);
						
						System.out.println("Bicycle with id: "+id+ " was removed from store inventory.");
									
									
		
					} break;
	
					case 4 :{// print all payments
						
						System.out.println("ALL PAYMENT MADE to BICYCLE SHOP\n");
						System.out.println("IDs | PAYMENTS-----\n");
						storeBk.getAllPayments(con);

					} break;
					
					default: System.out.println("Please make a selection below: :\n\n 1. ADD BICYCLE TO SHOP \n 2. ACCEPT OR REJECT"
							+ " PENDING OFFER \n 3. REMOVE A BICYCLE FROM SHOP \n 4. VIEW ALL PAYMENTS \n");
					}

					}
					
				}
			
				rs1.close();
						
				}//end user1Empl
			else if(sequenceToRun==user3Mana) {
				
				ResultSet rs2=stm.executeQuery("SELECT* FROM MANAGER;");
				
while(rs2.next()) {
					
					if(email.equals(rs2.getString("email"))&&password.equals(rs2.getString("password"))) {
						
						System.out.println("Please make a selection below: :\n\n 1. CALCULATE WEEKLY PAYMENT \n 2. REJECT  PENDING OFFERS \n 3. UPDATE A BICYCLE TO OWNERSHIP \n");
						
						int selectMana=Integer.valueOf(appScan.getScan().nextLine());
						
						switch(selectMana) {
						
						case 1 :{// will find the sum of the weekly payments
						System.out.println(" The total of the week  payments is -->$ "+shop.weeklySum(con)+"\n");
							
							
						} break;
						
						case 2:{
							System.out.println("All bicycle goes for");
							System.out.println("  "+"IDs  Name               AMOUNT IN $\n");
							shop.approveOffers(con);
							System.out.print("Please enter 1 to reject all offers, or enter other numerics to exit: ");
							int select=Integer.valueOf(appScan.getScan().nextLine());
							
							if(select==1) {
								
								shop.rejectAllOfferes(con);
								System.out.println("All offers have been rejected");
							}
							else if(select!=1) {
								System.out.println("No rejections were made.");
								selectMana=Integer.valueOf(appScan.getScan().nextLine());
							}
							
							
						} break;
						
						case 3 :{
							
							shop.giveBikeOwnerShip(con);
							
										
			
						} break;
		
						
						default: 	System.out.println("Please make a selection below: :\n\n 1. CALCULATE WEEKLY PAYMENT \n "
								+ "2. REJECT ALL PENDING OFFERS \n 3. UPDATE A BICYCLE TO OWNERSHIP \n");
						}
						
					}

				
			}
				rs2.close();

			}//end user3Mana
			
		} catch (SQLException e) {
			
			log.warn(e.getMessage());
		}
		
		
		

}}
