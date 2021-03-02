package com.rurangwa.services;

import java.sql.Connection;
import java.util.Set;

import com.rurangwa.beans.Bicycle;
import com.rurangwa.data.connection.BicycleConnect;

public class BicycleServiceImpl implements BicycleServices{
private BicycleConnect bicycle=new BicycleConnect();

	@Override
	public Set<Bicycle> getAvailableBicycles(Connection con) {
		
	return bicycle.availabeBic(con);
	}

	@Override
	public Set<Bicycle> getMyBicycles(Connection con) {
			
		return bicycle.myBikes(con);
	}
	
	}


