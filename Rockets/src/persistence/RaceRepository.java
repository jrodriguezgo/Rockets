package persistence;

import java.security.InvalidParameterException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Circuit;

public class RaceRepository {
	
	public static void storeCircuit(Circuit circuit) throws Exception {
		ConnectionBBDD connection =  ConnectionRepository.getConnection();
		try {
			String sql = "Insert into ROCKETS_JAIME (ID, NAME) values (?,?)";
			
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.clearParameters();
			pst.setString(1, circuit.getId());
			pst.setString(2, circuit.getName());
			//pst.setInt(3, circuit.getTime());
			//pst.setInt(4, circuit.getDistance());
			if(pst.executeUpdate() != 1) {
				throw new InvalidParameterException();
			}
		}catch(Exception e) {
			throw new Exception("Error connection", e);
		}
	}
	
	public static Circuit getCircuit(String rocketID) throws Exception {
		ConnectionBBDD connection =  ConnectionRepository.getConnection();
		try {
			String sql = "SELECT * FROM ROCKETS_JAIME WHERE ID=?";
			
			PreparedStatement pst = connection.prepareStatement(sql);		
			pst.clearParameters();
			pst.setString(1, rocketID);
			ResultSet rs = pst.executeQuery();

			if(rs.next()) {
				String id = rs.getString("ID");
				String name = rs.getString("NAME");
				int time = rs.getInt("TIME");
				int distance = rs.getInt("DISTANCE");
				return new Circuit(id, name, time, distance);
			}
			throw new InvalidParameterException();
		}catch(SQLException e) {
			e.printStackTrace();
			throw new InvalidParameterException();
		}
	}
	
	public static void updateCircuit(Circuit circuit) throws Exception {
		ConnectionBBDD connection =  ConnectionRepository.getConnection();
		try {
			String sql = "UPDATE ROCKETS_JAIME SET NAME=? WHERE ID=?";
			
			PreparedStatement pst = connection.prepareStatement(sql);		
			pst.clearParameters();
			//pst.setInt(1, circuit.getDistance());
			//pst.setInt(2, circuit.getTime());
			pst.setString(1, circuit.getName());
			pst.setString(2, circuit.getId());
			
			if(pst.executeUpdate() != 1) {
				throw new InvalidParameterException();
			}
		}catch(SQLException e) {
			e.printStackTrace();
			throw new InvalidParameterException();
		}
	}

}
