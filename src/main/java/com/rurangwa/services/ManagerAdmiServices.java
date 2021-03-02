package com.rurangwa.services;

import java.sql.Connection;

import com.rurangwa.beans.Manager;
import com.rurangwa.exceptions.ConnectionToDatabaseFailed;

public interface ManagerAdmiServices {
	
	public void addManager(Manager mana) throws ConnectionToDatabaseFailed;
	public void getManagerEmailAndPassword(Manager mana) throws ConnectionToDatabaseFailed;

	

	
	
	
}
