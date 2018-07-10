package ro.emanuel.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ro.emanuel.project.helper.DBHelper;
import ro.emanuel.project.pojo.BloodGroup;

public class BloodGroupDAO {

	// CREATE
	public static void createBloodGroup(BloodGroup bg) throws SQLException {

		Connection conn = DBHelper.createConnection();

		String insertString = "INSERT INTO " + "blood_groups(type,rh,description)" + "values(?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(insertString);

		stmt.setString(1, bg.getType());
		stmt.setString(2, bg.getRh());
		stmt.setString(3, bg.getDescription());

		stmt.executeUpdate();

		DBHelper.closeConnection(conn);
	}

	// READ
	public static ArrayList<BloodGroup> getBloodGroups() throws SQLException {
		ArrayList<BloodGroup> result = new ArrayList<BloodGroup>();

		Connection conn = DBHelper.createConnection();

		String selectString = "select * from blood_groups";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(selectString);

		while (rs.next()) {
			int id = rs.getInt("id");
			String type = rs.getString("type");
			String rh = rs.getString("rh");
			String description = rs.getString("description");

			BloodGroup bg = new BloodGroup(id, type, rh, description);

			result.add(bg);
		}
		DBHelper.closeConnection(conn);
		return result;
	}

	public static BloodGroup getBloodGroupById(int bloodGroupId) throws SQLException {

		BloodGroup bloodGroup = null;

		Connection conn = DBHelper.createConnection();

		String selectString = "select * from blood_groups where id=?";
		PreparedStatement stmt = conn.prepareStatement(selectString);
		stmt.setInt(1, bloodGroupId);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			int id = rs.getInt("id");
			String type = rs.getString("type");
			String rh = rs.getString("rh");
			String description = rs.getString("description");

			bloodGroup = new BloodGroup(id, type, rh, description);
		}

		DBHelper.closeConnection(conn);
		return bloodGroup;
	}

	// UPDATE
	public static void updateBloodGroup(BloodGroup bg) throws SQLException {

		Connection conn = DBHelper.createConnection();

		String updateString = "UPDATE blood_groups SET " + "type=?, rh=?, description=?" + "where id=?";
		PreparedStatement stmt = conn.prepareStatement(updateString);

		stmt.setString(1, bg.getType());
		stmt.setString(2, bg.getRh());
		stmt.setString(3, bg.getDescription());
		stmt.setInt(4, bg.getId());

		stmt.executeUpdate();

		DBHelper.closeConnection(conn);
	}

	// DELETE
	public static void deleteBloodGroup(BloodGroup bg) throws SQLException {

		Connection conn = DBHelper.createConnection();

		String deleteString = " DELETE from blood_groups where id=?";
		PreparedStatement stmt = conn.prepareStatement(deleteString);
		stmt.setInt(1, bg.getId());

		stmt.executeUpdate();

		DBHelper.closeConnection(conn);
	}

	public static void deleteBloodGroupById(int id) throws SQLException {

		Connection conn = DBHelper.createConnection();

		String deleteString = "DELETE from blood_groups where id=?";
		PreparedStatement stmt = conn.prepareStatement(deleteString);
		stmt.setInt(1, id);

		stmt.executeUpdate();

		DBHelper.closeConnection(conn);
	}

}
