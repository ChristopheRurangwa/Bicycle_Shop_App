package com.rurangwa.beans;

public class StoreFinances {

	
	private double remainPayment;
	private double allPayments;
	private double weeklyPayment;
	private double  offer;
	private int id;
	
	
	
	
	
	public StoreFinances() {
	}





	public double getRemainPayment() {
		return remainPayment;
	}





	public void setRemainPayment(double remainPayment) {
		this.remainPayment = remainPayment;
	}





	public double getAllPayments() {
		return allPayments;
	}





	public void setAllPayments(double allPayments) {
		this.allPayments = allPayments;
	}





	public double getWeeklyPayment() {
		return weeklyPayment;
	}





	public void setWeeklyPayment(double weeklyPayment) {
		this.weeklyPayment = weeklyPayment;
	}





	public double getOffer() {
		return offer;
	}





	public void setOffer(double offer) {
		this.offer = offer;
	}





	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(allPayments);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		temp = Double.doubleToLongBits(offer);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(remainPayment);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(weeklyPayment);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StoreFinances other = (StoreFinances) obj;
		if (Double.doubleToLongBits(allPayments) != Double.doubleToLongBits(other.allPayments))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(offer) != Double.doubleToLongBits(other.offer))
			return false;
		if (Double.doubleToLongBits(remainPayment) != Double.doubleToLongBits(other.remainPayment))
			return false;
		if (Double.doubleToLongBits(weeklyPayment) != Double.doubleToLongBits(other.weeklyPayment))
			return false;
		return true;
	}





	@Override
	public String toString() {
		return "StoreFinances [remainPayment=" + remainPayment + ", allPayments=" + allPayments + ", weeklyPayment="
				+ weeklyPayment + ", offer=" + offer + ", id=" + id + "]";
	}




	
}
