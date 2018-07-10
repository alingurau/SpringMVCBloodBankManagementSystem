package ro.emanuel.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ro.emanuel.project.helper.DBHelper;
import ro.emanuel.project.pojo.Clinic;

public class ClinicDAO {

	// CREATE
	public static void createClinic(Clinic c) throws SQLException {

		Connection conn = DBHelper.createConnection();

		String insertString = "INSERT INTO " + "clinics(denumire, adresa, telefon, email)" + "values(?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(insertString);
		stmt.setString(1, c.getDenumire());
		stmt.setString(2, c.getAdresa());
		stmt.setString(3, c.getTelefon());
		stmt.setString(4, c.getEmail());

		stmt.executeUpdate();

		DBHelper.closeConnection(conn);
	}

	// READ
	public static ArrayList<Clinic> getClinics() throws SQLException {

		ArrayList<Clinic> result = new ArrayList<Clinic>();

		Connection conn = DBHelper.createConnection();

		String selectString = "SELECT * from clinics";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(selectString);

		while (rs.next()) {
			int id = rs.getInt("id");
			String denumire = rs.getString("denumire");
			String adresa = rs.getString("adresa");
			String telefon = rs.getString("telefon");
			String email = rs.getString("email");

			Clinic c = new Clinic(id, denumire, adresa, telefon, email);

			result.add(c);
		}
		DBHelper.closeConnection(conn);
		return result;
	}

	public static Clinic getClinicById(int clinicId) throws SQLException {
		Clinic clinic = null;
		Connection conn = DBHelper.createConnection();

		String selectString = "SELECT * from clinics where id=?";
		PreparedStatement stmt = conn.prepareStatement(selectString);
		stmt.setInt(1, clinicId);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			int id = rs.getInt("id");
			String denumire = rs.getString("denumire");
			String adresa = rs.getString("adresa");
			String telefon = rs.getString("telefon");
			String email = rs.getString("email");

			clinic = new Clinic(id, denumire, adresa, telefon, email);
		}
		DBHelper.closeConnection(conn);
		return clinic;
	}

	// UPDATE
	public static void updateClinic(Clinic c) throws SQLException {

		Connection conn = DBHelper.createConnection();

		String updateString = "UPDATE clinics SET " + "denumire=?, adresa=?, telefon=?, email=?" + "where id=?";
		PreparedStatement stmt = conn.prepareStatement(updateString);
		stmt.setString(1, c.getDenumire());
		stmt.setString(2, c.getAdresa());
		stmt.setString(3, c.getTelefon());
		stmt.setString(4, c.getEmail());
		stmt.setInt(5, c.getId());

		stmt.executeUpdate();

		DBHelper.closeConnection(conn);

	}

	// DELETE
	public static void deleteClinic(Clinic c) throws SQLException {

		Connection conn = DBHelper.createConnection();

		String deleteString = "DELETE from clinics where id=?";
		PreparedStatement stmt = conn.prepareStatement(deleteString);
		stmt.setInt(1, c.getId());

		stmt.executeUpdate();
		DBHelper.closeConnection(conn);
	}

	public static void deleteClinicById(int id) throws SQLException {

		Connection conn = DBHelper.createConnection();

		String deleteString = "DELETE from clinics where id=?";
		PreparedStatement stmt = conn.prepareStatement(deleteString);
		stmt.setInt(1, id);

		stmt.executeUpdate();

		DBHelper.closeConnection(conn);
	}
}