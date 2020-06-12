package persistence;

import utilities.constantUtilities;

public class ConnectionRepository {
	
	private static ConnectionBBDD connection; 
	
	static ConnectionBBDD getConnection() throws Exception {
		if (connection == null) 
			connection = new ConnectionBBDD(constantUtilities.USARNAME_BBDD, constantUtilities.PASSWORD_BBDD);
		return connection;
	}

}
