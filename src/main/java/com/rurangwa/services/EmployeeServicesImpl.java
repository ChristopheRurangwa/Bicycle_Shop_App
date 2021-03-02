package com.rurangwa.services;

import com.rurangwa.beans.Employee;
import com.rurangwa.data.connection.DatabaseConnector;
import com.rurangwa.exceptions.ConnectionToDatabaseFailed;

public class EmployeeServicesImpl implements EmployeeServices {

	DatabaseConnector employeeDAO=new DatabaseConnector();
	
	@Override
	public void addEmployee(Employee empl) throws ConnectionToDatabaseFailed {
		employeeDAO.connect(empl.getPassword(),empl.getEmail().toLowerCase(),empl.getName(),false,false,7);// <--user sequence used here to prevent the insertion methods from running
		
	}
	
	@Override
	public void getEmployeeEmailAndPassword(Employee empl) throws ConnectionToDatabaseFailed {
		employeeDAO.connect(empl.getPassword(), empl.getEmail().toLowerCase(),empl.getName(), false,false,1);
		
	}


}
