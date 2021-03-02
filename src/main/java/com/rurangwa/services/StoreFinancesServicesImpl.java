package com.rurangwa.services;

import java.sql.Connection;
import java.util.Set;

import com.rurangwa.beans.StoreFinances;

public interface StoreFinancesServicesImpl {
public void makeAnOffer(double offer,Connection con);
public double viewRemainPayments(Connection con,int id);
public Set<StoreFinances> getAllPayments(Connection con);
public void rejecOffer(Connection con,int id);
public Set<StoreFinances> acceptOffer(Connection con);

}
