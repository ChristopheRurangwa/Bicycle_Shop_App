package com.rurangwa.beans;

public class Bicycle {
	
	private String type;
	private String color;
	private String availBikes;
	private String myBikes;
	private Integer id;
	
	
	public Bicycle() {
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getAvailBikes() {
		return availBikes;
	}


	public void setAvailBikes(String availBikes) {
		this.availBikes = availBikes;
	}


	public String getMyBikes() {
		return myBikes;
	}


	public void setMyBikes(String myBikes) {
		this.myBikes = myBikes;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((availBikes == null) ? 0 : availBikes.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((myBikes == null) ? 0 : myBikes.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Bicycle other = (Bicycle) obj;
		if (availBikes == null) {
			if (other.availBikes != null)
				return false;
		} else if (!availBikes.equals(other.availBikes))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (myBikes == null) {
			if (other.myBikes != null)
				return false;
		} else if (!myBikes.equals(other.myBikes))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Bicycle [type=" + type + ", color=" + color + ", availBikes=" + availBikes + ", myBikes=" + myBikes
				+ ", id=" + id + "]";
	}



}
