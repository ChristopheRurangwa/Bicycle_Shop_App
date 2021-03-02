package com.rurangwa.data.connection;

import com.rurangwa.exceptions.ConnectionToDatabaseFailed;

public interface DatabaseConn {

	public void connect(String passwrd, String email,String name,boolean run,boolean run2,int userSequence) throws ConnectionToDatabaseFailed;
	}
