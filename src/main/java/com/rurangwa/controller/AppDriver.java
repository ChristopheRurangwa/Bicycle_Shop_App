package com.rurangwa.controller;

import java.util.Scanner;
import java.util.logging.ConsoleHandler;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.rurangwa.beans.Customer;
import com.rurangwa.beans.Employee;
import com.rurangwa.beans.Manager;

import com.rurangwa.exceptions.ConnectionToDatabaseFailed;
import com.rurangwa.services.BicycleServiceImpl;
import com.rurangwa.services.BicycleServices;
import com.rurangwa.services.CustomerServiceImpl;
import com.rurangwa.services.CustomerServices;
import com.rurangwa.services.EmployeeServices;
import com.rurangwa.services.EmployeeServicesImpl;
import com.rurangwa.services.ManagerAdmiServices;
import com.rurangwa.services.ManagerAdmiServicesImpl;

public class AppDriver {
	
private static Logger log = Logger.getLogger(AppDriver.class);
private static ConsoleAppender consoleApp= new ConsoleAppender();
private static CustomerServices custServ= new CustomerServiceImpl();
private static BicycleServices bicyServ=new BicycleServiceImpl();
private static EmployeeServices emploServ = new EmployeeServicesImpl();
private static ManagerAdmiServices mangServ = new ManagerAdmiServicesImpl();
private static Scanner scan;
//private static AppDriver userInfo=new AppDriver();
public static Scanner getScan() {
	return scan;
}

public static void setScan(Scanner scan) {
	AppDriver.scan = scan;
}



public static void outterMenu() {
	
	
	System.out.println("\n\t===Welcome to BicycleShop_App===\n");
	System.out.println("\t\tMake a selection below.\n");
	System.out.println("\t1. Log in.\n\t2. Register. \n\t3. Exit.\n ");
}

	public static void main(String[] args) {
			
			consoleApp.setThreshold(Level.WARN);
	
		String email=null;
		String passwrd=null;
		String name=null;
		
		outterMenu();
		scan= new Scanner(System.in);
		 
		Customer loggedInCustomer=null;
		Employee loggedInEmployee=null;
		Manager loggedInMana_Admi=null;
		Customer newCustomerAcct=new Customer();
		Employee newEmployeeAcct= new Employee();
		Manager newManagerAcct= new Manager();

		
		
		int outter_User_Choice=0;
		boolean activeUser=true;
		
		 do {
			 
			 outter_User_Choice=Integer.valueOf(scan.nextLine());
			 
			 while(loggedInCustomer==null || loggedInEmployee==null || loggedInMana_Admi==null) {
			 
		switch(outter_User_Choice){
		
		case 1:{
			//----------LOGIN SECTION------------------//
			
			System.out.println("Select user:\n 1. Customer\n 2. Employee \n 3. Manager \n 4. Log Out.");
			
			int  inner1_User_Choice=Integer.valueOf(scan.nextLine());
			
			switch(inner1_User_Choice) {
			
			case 1:{
			
			System.out.println("Enter Email & Password: \n");
			
			System.out.print("Enter your Email: ");
			email=scan.nextLine();
			newCustomerAcct.setEmail(email);
			
			System.out.print("Enter your Password: ");
			passwrd=scan.nextLine();
			newCustomerAcct.setPassword(passwrd);
			loggedInCustomer=newCustomerAcct;
			
			if(loggedInCustomer!=null) {
				
				try {
					
				
					custServ.getCustomerEmailAndPassword(loggedInCustomer);
					
				
				} catch (ConnectionToDatabaseFailed e) {
				
					
					log.warn(e.getMessage(),e);
				}
				
			}
			
			
			}break;
			
			case 2:{
				
				System.out.println("Enter Email & Password: \n");
				
				System.out.print("Enter your Email: ");
				email=scan.nextLine();
				newEmployeeAcct.setEmail(email);
				
				System.out.print("Enter your Password: ");
				passwrd=scan.nextLine();
				newEmployeeAcct.setPassword(passwrd);
				loggedInEmployee=newEmployeeAcct;
				
				if(newEmployeeAcct!=null) {
					
					try {
						
						emploServ.getEmployeeEmailAndPassword(loggedInEmployee);
						
						
					} catch (ConnectionToDatabaseFailed e) {
					
						log.warn(e.getMessage(),e);
					}
					
				}
				
				}break;
			case 3:{
				
				System.out.println("Enter Email & Password: \n");
				
				System.out.print("Enter your Email: ");
				email=scan.nextLine();
				 newManagerAcct.setEmail(email);
				
				System.out.print("Enter your Password: ");
				passwrd=scan.nextLine();
				 newManagerAcct.setPassword(passwrd);
				 loggedInMana_Admi=newManagerAcct;
				
				if(loggedInMana_Admi!=null) {
					
					try {
						
						mangServ.getManagerEmailAndPassword(loggedInMana_Admi);
					} catch (ConnectionToDatabaseFailed e) {
				
						log.warn(e.getMessage(),e);
					}
					
				}
		
				
				
				}break;
				
			case 4:{
				System.out.println("You logged out!");
				System.exit(0);
			
			break;
			}
				
				default:{	System.out.println("Select user:\n 1. Customer\n 2. Employee \n 3. Manager");
				
				
				log.info("Inserted wrong entry while selecting on the menu");
				}
									
			
			
			}//end switch statement
			
		
		
		}
			break;
		case 2:{
			
			//--------REGISTER SECTION-----------------//
			
			System.out.println("Register as: \n\t1. Employee \n\t2. Customer \n\t3. Manager \n\t4. Exit");
			int inner_User_Choice=Integer.valueOf(scan.nextLine());
			
			switch(inner_User_Choice) {
					
			case 1:{
				System.out.println("Please enter 555 before continuing, provide by Manager.\n");
				int code=Integer.valueOf(scan.nextLine());
				if(code==555) {
				System.out.println("EMPLOYEE\n");
				System.out.print("Enter your Email: ");
				email=scan.nextLine();
				newEmployeeAcct.setEmail(email);
				System.out.print("Enter your Password: ");
				passwrd=scan.nextLine();
				newEmployeeAcct.setPassword(passwrd);
				System.out.print("Enter your Name: ");
				name=scan.nextLine();
				newEmployeeAcct.setName(name);
				try {
					
					emploServ.addEmployee(newEmployeeAcct);
				} catch (ConnectionToDatabaseFailed e) {
				
					System.out.print(e.getMessage());
				}
				
			log.debug(newEmployeeAcct);
				}
				else System.out.println("You provided the Wrong code, please enter 555 before continuing.");
				
			}break;
			
			case 2:{
				
				System.out.println("CUSTOMER\n");
				System.out.print("Enter your Email: ");
				email=scan.nextLine();
				newCustomerAcct.setEmail(email);
				System.out.print("Enter your Password: ");
				passwrd=scan.nextLine();
				newCustomerAcct.setPassword(passwrd);
				System.out.print("Enter your Name: ");
				name=scan.nextLine();
				newCustomerAcct.setName(name);
				
				 try {
					custServ.addCustomer(newCustomerAcct);
				} catch (ConnectionToDatabaseFailed e) {
		
					log.warn(e.getMessage(),e);
				}
				 
			}
			break;
			case 3:{
				System.out.println("Please enter 777 to verify id.\n");
				int code=Integer.valueOf(scan.nextLine());
				if(code==777) {
				System.out.println("MANAGER\n");
				System.out.print("Enter your Email: ");
				email=scan.nextLine();
				newManagerAcct.setEmail(email);
				System.out.print("Enter your Password: ");
				passwrd=scan.nextLine();
				newManagerAcct.setPassword(passwrd);
				System.out.print("Enter your Name: ");
				name=scan.nextLine();
				newManagerAcct.setName(name);
				try {
					mangServ.addManager(newManagerAcct);
					
				} catch (ConnectionToDatabaseFailed e) {
			
					log.warn(e.getMessage(),e);
				}}
				else System.out.println("You provided the Wrong code, please enter 777 before continuing.");
				
			}
			break;
			case 4:{
				System.out.println("Bye!!!");
				System.exit(0);
			}
			default:{
				System.out.println("Register as: \n\t1. Employee \n\t2. Customer \n\t3. Manager \n\t4. Exit");
				Integer.valueOf(scan.nextLine());
				}
			
			
			}
		}
			break;
		case 3:{
			System.out.println("Bye!");
			System.exit(0);}
			break;
		default:{
			
			System.out.println("Please Select a CHOICE from the Menu.");
						outterMenu();
						outter_User_Choice=Integer.valueOf(scan.nextLine());
						log.info("Wrong selection was entered");
						}
			
			
		}
		}// the main while loop ends here
		
		}while(activeUser);
		
		
		scan.close();
		log.info("scanner closed");
	}
	
	
}
