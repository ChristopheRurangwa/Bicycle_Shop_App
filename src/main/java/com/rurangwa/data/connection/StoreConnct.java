package com.rurangwa.data.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.rurangwa.beans.Bicycle;
import com.rurangwa.beans.Customer;
import com.rurangwa.beans.StoreFinances;
import com.rurangwa.controller.AppDriver;

public class StoreConnct  {

	private static Logger log = Logger.getLogger(StoreConnct.class);
	
	private StoreFinances sto=new StoreFinances();
	
	private AppDriver appScan= new AppDriver();//<-- scanner use only

	
	
public void offersMade(double offer, Connection con) {

	 
		
	try {
		String sql="INSERT INTO SHOP_FIN(OFFER)"
				
					+ "VALUES('"+offer+"')";
			
			Statement statement=con.createStatement();
			
			statement.executeUpdate(sql);
			
		statement.close();
		
			System.out.println("$"+offer+", offer was successfully made.");
			
	} catch (SQLException e) {
		log.warn(e.getMessage());
	}
}


public double paymentsToBeMade(Connection con, int id) {
	
	double bal=0;
	try {
		String sql="SELECT REMNPAYMNT FROM SHOP_FIN WHERE ID="+id;
		
		Statement st= con.createStatement();
		
		ResultSet res= st.executeQuery(sql);
		if(res.next()) {
			
			bal= res.getDouble("REMNPAYMNT");
	
		}
	} catch (SQLException e) {
		log.warn(e.getMessage());
	}
	return bal;

	
	
}

public void approveOffers(Connection con) {
	
	
	try {
		
		String sql="SELECT OFFER FROM SHOP_FIN";
		
		Statement st= con.createStatement();
		// here we compare, customer ids with shop_fin table ids, the shop_fin id corresponds to the to the payments(these include offers and remaining payments and payments )
		
		ResultSet rs1=st.executeQuery("SELECT* FROM CUSTOMERS JOIN SHOP_FIN on SHOP_FIN.ID=CUSTOMERS.ID;");
		
		ResultSet res= st.executeQuery(sql);
		
		while(res.next()&&rs1.next()) {
			
			StoreFinances stor=new StoreFinances();
			
		stor.setOffer(res.getDouble("OFFER"));
	
	
		System.out.println("  "+rs1.getInt("id")+"    "+" |---offers----> $"+stor.getOffer()+" ");
		

		}
		
		
	} catch (SQLException e) {
		
		log.warn(e.getMessage());
	}
	
	
}

public void offerRejections(Connection con, int id) {
	String response=null;
	
int []arr=new int[1];// will contain the int  that we dont want to increment.
	
	try {
		Statement stm=con.createStatement();
		ResultSet rs=stm.executeQuery("SELECT* FROM SHOP_FIN ORDER BY ID;");
	
		System.out.print(" Enter A to ACCEPT an offer or R to REJECT all offers: -->");
		response=appScan.getScan().nextLine();
		
		while(rs.next()) {
			

			sto.setId(rs.getInt("id"));// setting the id here.
			
			sto.setOffer(rs.getDouble("OFFER"));
			
			
				arr[0]=id;// store the id into the array
			
			if(response.toLowerCase().equals("r")) {
				
				
				
					if(arr[0]==id ) {// the stored id used
						
						
			// will insert the value into the rejectedOffered column.
						String sql="INSERT INTO SHOP_FIN (REJECTEDOFFER)"
				
											+ "VALUES('"+sto.getOffer()+"')";
						
						
		
									stm.executeUpdate(sql);
							}
					}
			
			else if (response.toLowerCase().equals("a")) {
				
			System.out.print("Enter the amount of the offer you want to ACCEPT here: -->$");
			double offer=Double.valueOf(appScan.getScan().nextLine());
				if(id==arr[0] ) {
					
				double fixedPrice=575;
				
					String sql="UPDATE SHOP_FIN SET ALLPAYMNT=?,WEEKLY_PAYMNT=?,ACCEPTEDOFFER=?,REMNPAYMNT=? WHERE ID="+arr[0];
							
												

					PreparedStatement prep = con.prepareStatement(sql);

					prep.setDouble(3, offer);
					prep.setDouble(2, offer);
					prep.setDouble(1, offer);
					prep.setDouble(4,(fixedPrice-offer));	
					
					prep.executeUpdate();

				
				
			}
			
		
		break;
		
		}
			else {
				System.out.println("The character you entered is different from A and R, try again.");
						log.info("wrong character was entered.");
			break;
			}
				
		}

stm.close();


} catch (SQLException e) {
	log.warn(e.getMessage());
}
	
}

public Set<StoreFinances> paymentsSummary(Connection con) {

	Set<StoreFinances> pymt= new HashSet<>();
	
	try {
		
		
		String sql1="SELECT ID FROM SHOP_FIN"; 
		
		String sql="SELECT ALLPAYMNT FROM SHOP_FIN"; 
		Statement st= con.createStatement();
		
		ResultSet res1= st.executeQuery(sql1);
		
		ResultSet res= st.executeQuery(sql);
		
		while(res.next()&&res1.next()) {
			
			StoreFinances fn=new StoreFinances();
			
			fn.setAllPayments(res.getDouble("ALLPAYMNT"));	
			
			System.out.println("| |"+res1.getInt("id")+"  |   $"+fn.getAllPayments()+" ||");
			
			pymt.add(fn);
			
		}
		
	} catch (SQLException e) {
		log.warn(e.getMessage());
	}
	return pymt;
	
}

public void rejectAllOfferes(Connection con) {
	
			String sql;
			try {
				Statement stm=con.createStatement();
				sql = "UPDATE SHOP_FIN SET REJECTEDOFFER=OFFER ";
				String sql1= "UPDATE SHOP_FIN SET OFFER=NULL ";
						
				stm.executeUpdate(sql);
				
				stm.executeUpdate(sql1);
				stm.close();
		} catch (Exception e) {
			log.warn(e.getMessage());
		}
	
	
}

public double weeklySum(Connection con) {
	double total=0;
	

	
	try {
		String sql= "SELECT SUM(weekly_paymnt) as total FROM SHOP_FIN";
		Statement statement=con.createStatement();
		ResultSet res =statement.executeQuery(sql);
		
		while(res.next()) {
	
			sto.setWeeklyPayment(res.getDouble("total"));
			
			total=total+sto.getWeeklyPayment();
			
		}
	} catch (SQLException e) {
		
		log.info(e.getMessage());
		
	}
	
	return total;
	
	
}

public void giveBikeOwnerShip(Connection con) {
	
	
	String sql,sql3;
	try {
		Statement stm=con.createStatement();
	
	
		
		
		 sql= "SELECT * FROM SHOP_FIN JOIN BICYCLES on SHOP_FIN.ID=BICYCLES.ID";
		 sql3= "SELECT * FROM CUSTOMERS JOIN BICYCLES on CUSTOMERS.ID=BICYCLES.ID";
		 
		 ResultSet res =stm.executeQuery(sql);
		 ResultSet res1 =stm.executeQuery(sql3);
			
			while(res.next()&&res1.next()) {
				Customer cust=new Customer();
				Bicycle bi=new Bicycle();
				
				cust.setName(res1.getString("NAME"));
				bi.setId(res.getInt("ID"));//Common id
		
			
				
				String sql1="UPDATE BICYCLES SET AVAILABLE_BIKES=NULL WHERE ID="+bi.getId();
				String sql2="UPDATE BICYCLES SET MY_BIKES= AVAILABLE_BIKES WHERE ID="+bi.getId();
				
				
				stm.executeUpdate(sql2);
				
				stm.executeUpdate(sql1);
				
				bi.setMyBikes(res.getString("MY_BIKES"));
				
				bi.setColor(res.getString("COLOR"));
				System.out.println("The details below confirms that "+cust.getName()+" is the owner of the bicycle described below.\n");
				System.out.println(" "+"IDs"+ "       Customer Name(s) "+  "   Bicycle(s) Color      "+"Bicycle Name/Type \n");
				System.out.println(" "+bi.getId()+"             "+cust.getName()+"                      "+bi.getColor()+"               "+bi.getMyBikes()+"\n");
				
				
		
	
		stm.close();}
} catch (Exception e) {
	log.warn(e.getMessage());
}

	
}

	



	
}
