package persistence;

import utilities.constantUtilities;

public class ConnectionRepository {
	
	private static BBDDConnection connection; 
	
	static BBDDConnection getConnection() throws Exception {
		if (connection == null) 
			connection = new BBDDConnection(constantUtilities.USARNAME_BBDD, constantUtilities.PASSWORD_BBDD);
		return connection;
	}

}
