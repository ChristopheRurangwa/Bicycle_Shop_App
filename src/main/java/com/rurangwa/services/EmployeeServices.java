package com.rurangwa.services;


import com.rurangwa.beans.Employee;
import com.rurangwa.exceptions.ConnectionToDatabaseFailed;

public interface EmployeeServices {
	
	public void addEmployee(Employee empl) throws ConnectionToDatabaseFailed;
	public void getEmployeeEmailAndPassword(Employee empl) throws ConnectionToDatabaseFailed;

}
