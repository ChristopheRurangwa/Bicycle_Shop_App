package com.rurangwa.exceptions;

@SuppressWarnings("serial")
public class ConnectionToDatabaseFailed extends Exception {
	
	public ConnectionToDatabaseFailed() {
		
		super("The connection you are trying to make failed, please check your connection again.");
		
	}
}
