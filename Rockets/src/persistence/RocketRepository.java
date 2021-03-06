package persistence;

import java.security.InvalidParameterException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domain.Rocket;
import domain.Thruster;

public class RocketRepository {
	
	public static void storeRocket(Rocket rocket) throws Exception {
		ConnectionBBDD connection =  ConnectionRepository.getConnection();
		try {
			String sql = "Insert into ROCKETS_JAIME (ID, NAME) values (?,?)";
			
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.clearParameters();
			pst.setString(1, rocket.getID());
			pst.setString(2, rocket.getName());
			//pst.setObject(3, rocket.getFuel());
			if(pst.executeUpdate() != 1) {
				throw new InvalidParameterException();
			}
		}catch(Exception e) {
			throw new Exception("Error connection", e);
		}
	}
	
	public static Rocket getRocket(String rocketID) throws Exception {
		ConnectionBBDD connection =  ConnectionRepository.getConnection();
		try {
			String sql = "SELECT * FROM ROCKETS WHERE ID=?";
			
			PreparedStatement pst = connection.prepareStatement(sql);		
			pst.clearParameters();
			pst.setString(1, rocketID);
			ResultSet rs = pst.executeQuery();

			if(rs.next()) {
				String id = rs.getString("ID");
				String name = rs.getString("NAME");
				Double fuel = rs.getDouble("FUEL");
				ArrayList<Thruster> thrusters = (ArrayList<Thruster>) rs.getArray("THRUSTERS");
				return new Rocket(id, name, fuel, thrusters);
			}
			throw new InvalidParameterException();
		}catch(SQLException e) {
			e.printStackTrace();
			throw new InvalidParameterException();
		}
	}
	
	public static void updateRocket(Rocket rocket) throws Exception {
		ConnectionBBDD connection =  ConnectionRepository.getConnection();
		try {
			String sql = "UPDATE ROCKETS SET FUEL=?, NAME=? WHERE ID=?";
			
			PreparedStatement pst = connection.prepareStatement(sql);		
			pst.clearParameters();
			pst.setObject(1, rocket.getFuel());
			pst.setObject(2, rocket.getName());
			pst.setString(3, rocket.getID());
			
			if(pst.executeUpdate() != 1) {
				throw new InvalidParameterException();
			}
		}catch(SQLException e) {
			e.printStackTrace();
			throw new InvalidParameterException();
		}
	}

}
