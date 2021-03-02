package com.rurangwa.services;

import java.sql.Connection;

import com.rurangwa.beans.Manager;
import com.rurangwa.data.connection.DatabaseConnector;
import com.rurangwa.exceptions.ConnectionToDatabaseFailed;

public class ManagerAdmiServicesImpl implements ManagerAdmiServices {

	DatabaseConnector manaDAO=new DatabaseConnector();	
	

	@Override
	public void addManager(Manager mana) throws ConnectionToDatabaseFailed {
		
		manaDAO.connect(mana.getPassword(), mana.getEmail().toLowerCase(), mana.getName(), false, true,7);
	}



	@Override
	public void getManagerEmailAndPassword(Manager mana) throws ConnectionToDatabaseFailed {
		manaDAO.connect(mana.getPassword(), mana.getEmail().toLowerCase(), mana.getName(), false, true,3);
		
	}

	

}
