package com.rurangwa.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.rurangwa.beans.Bicycle;
import com.rurangwa.beans.StoreFinances;
import com.rurangwa.data.connection.StoreConnct;
import com.rurangwa.data.connection.UpdatingAndRetrievingData;

public class StoreFinancesServices implements StoreFinancesServicesImpl{
private StoreConnct  shop=new StoreConnct ();

	@Override
	public void makeAnOffer(double offer,Connection con) {
		
		shop.offersMade(offer, con);
	
	}

	@Override
	public double viewRemainPayments(Connection con, int id) {
		
		
	return shop.paymentsToBeMade(con, id);
		
	}

	@Override
	public Set<StoreFinances> getAllPayments(Connection con) {
		
		
		
		return shop.paymentsSummary(con);
	}

	@Override
	public void rejecOffer(Connection con, int id) {
		
	shop.offerRejections(con, id);
		
		
	}

	@Override
	public Set<StoreFinances>acceptOffer(Connection con) {
	
		shop.approveOffers(con);
		
		return null;
	
		
	}


	
	

}
