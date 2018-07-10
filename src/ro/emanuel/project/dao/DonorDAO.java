package ro.emanuel.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ro.emanuel.project.helper.DBHelper;
import ro.emanuel.project.pojo.Donor;

public class DonorDAO {

	// CREATE
	public static void createDonor(Donor d) throws SQLException {

		Connection conn = DBHelper.createConnection();

		String insertString = "INSERT INTO " + "donors(nume, prenume, cnp, adresa, email, numar_telefon)"
				+ "values(?,?,?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(insertString);
		stmt.setString(1, d.getNume());
		stmt.setString(2, d.getPrenume());
		stmt.setString(3, d.getCnp());
		stmt.setString(4, d.getAdresa());
		stmt.setString(5, d.getEmail());
		stmt.setString(6, d.getNumarTelefon());

		stmt.executeUpdate();

		DBHelper.closeConnection(conn);
	}

	// READ
	public static ArrayList<Donor> getDonors() throws SQLException {

		ArrayList<Donor> result = new ArrayList<Donor>();

		Connection conn = DBHelper.createConnection();

		String selectString = "select * from donors";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(selectString);

		while (rs.next()) {

			int id = rs.getInt("id");
			String nume = rs.getString("nume");
			String prenume = rs.getString("prenume");
			String cnp = rs.getString("cnp");
			String adresa = rs.getString("adresa");
			String email = rs.getString("email");
			String numarTelefon = rs.getString("numar_telefon");

			Donor d = new Donor(id, nume, prenume, cnp, adresa, email, numarTelefon);

			result.add(d);
		}
		DBHelper.closeConnection(conn);
		return result;
	}

	public static Donor getDonorById(int donorId) throws SQLException {

		Donor donor = null;

		Connection conn = DBHelper.createConnection();

		String selectString = "select * from donors where id = ?";
		PreparedStatement stmt = conn.prepareStatement(selectString);
		stmt.setInt(1, donorId);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			int id = rs.getInt("id");
			String nume = rs.getString("nume");
			String prenume = rs.getString("prenume");
			String cnp = rs.getString("cnp");
			String adresa = rs.getString("adresa");
			String email = rs.getString("email");
			String numarTelefon = rs.getString("numar_telefon");

			donor = new Donor(id, nume, prenume, cnp, adresa, email, numarTelefon);
		}
		DBHelper.closeConnection(conn);
		return donor;
	}

	// UPDATE
	public static void updateDonor(Donor d) throws SQLException {

		Connection conn = DBHelper.createConnection();

		String updateString = "UPDATE donors SET " + "nume=?, prenume=?, cnp=?, adresa=?, email=?, numar_telefon=?"
				+ "where id=?";
		PreparedStatement stmt = conn.prepareStatement(updateString);

		stmt.setString(1, d.getNume());
		stmt.setString(2, d.getPrenume());
		stmt.setString(3, d.getCnp());
		stmt.setString(4, d.getAdresa());
		stmt.setString(5, d.getEmail());
		stmt.setString(6, d.getNumarTelefon());
		stmt.setInt(7, d.getId());

		stmt.executeUpdate();

		DBHelper.closeConnection(conn);
	}

	// DELETE
	public static void deleteDonor(Donor d) throws SQLException {

		Connection conn = DBHelper.createConnection();

		String deleteString = "DELETE from donors where id=?";
		PreparedStatement stmt = conn.prepareStatement(deleteString);
		stmt.setInt(1, d.getId());

		stmt.executeUpdate();

		DBHelper.closeConnection(conn);
	}

	public static void deleteDonorById(int id) throws SQLException {

		Connection conn = DBHelper.createConnection();

		String deleteString = "DELETE from donors where id=?";
		PreparedStatement stmt = conn.prepareStatement(deleteString);
		stmt.setInt(1, id);

		stmt.executeUpdate();

		DBHelper.closeConnection(conn);
	}
}
