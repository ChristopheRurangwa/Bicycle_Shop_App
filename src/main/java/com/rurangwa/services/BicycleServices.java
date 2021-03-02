package com.rurangwa.services;

import java.sql.Connection;
import java.util.Set;

import com.rurangwa.beans.Bicycle;

public interface BicycleServices {



public Set<Bicycle>getAvailableBicycles(Connection con);
public Set<Bicycle>getMyBicycles(Connection con);


}
