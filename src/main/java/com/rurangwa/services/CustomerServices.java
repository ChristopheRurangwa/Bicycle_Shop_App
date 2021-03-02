package com.rurangwa.services;

import com.rurangwa.beans.Customer;
import com.rurangwa.exceptions.ConnectionToDatabaseFailed;

public interface CustomerServices {
	public void addCustomer(Customer cust) throws ConnectionToDatabaseFailed;

	public void getCustomerEmailAndPassword(Customer cust) throws ConnectionToDatabaseFailed;
	


}
