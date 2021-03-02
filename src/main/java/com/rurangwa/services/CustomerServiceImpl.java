package com.rurangwa.services;

import com.rurangwa.beans.Customer;
import com.rurangwa.data.connection.DatabaseConnector;
import com.rurangwa.exceptions.ConnectionToDatabaseFailed;

public class CustomerServiceImpl implements CustomerServices {
	

	DatabaseConnector customerDAO=new DatabaseConnector();
	@Override
	public void addCustomer(Customer cust) throws ConnectionToDatabaseFailed {
		customerDAO.connect(cust.getPassword(), cust.getEmail().toLowerCase(),cust.getName(), true,false,7);
		
	}



	@Override
	public void getCustomerEmailAndPassword(Customer cust) throws ConnectionToDatabaseFailed {
	
		customerDAO.connect(cust.getPassword(), cust.getEmail().toLowerCase(),cust.getName(), true,false,2);
	}


	

}
