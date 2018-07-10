package ro.emanuel.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ro.emanuel.project.helper.DBHelper;
import ro.emanuel.project.pojo.Receiver;

public class ReceiverDAO {

	// CREATE
	public static void createReceiver(Receiver r) throws SQLException {

		Connection conn = DBHelper.createConnection();

		String insertString = "INSERT INTO " + "receivers(nume, prenume, gen, cnp, adresa, email, numar_telefon)"
				+ "values(?,?,?,?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(insertString);
		stmt.setString(1, r.getNume());
		stmt.setString(2, r.getPrenume());
		stmt.setString(3, r.getGen());
		stmt.setString(4, r.getCnp());
		stmt.setString(5, r.getAdresa());
		stmt.setString(6, r.getEmail());
		stmt.setString(7, r.getNumarTelefon());

		stmt.executeUpdate();

		DBHelper.closeConnection(conn);
	}

	// READ
	public static ArrayList<Receiver> getReceivers() throws SQLException {

		ArrayList<Receiver> result = new ArrayList<Receiver>();

		Connection conn = DBHelper.createConnection();

		String selectString = "select * from receivers";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(selectString);

		while (rs.next()) {
			int id = rs.getInt("id");
			String nume = rs.getString("nume");
			String prenume = rs.getString("prenume");
			String gen = rs.getString("gen");
			String cnp = rs.getString("cnp");
			String adresa = rs.getString("adresa");
			String email = rs.getString("email");
			String numarTelefon = rs.getString("numar_telefon");

			Receiver r = new Receiver(id, nume, prenume, gen, cnp, adresa, email, numarTelefon);

			result.add(r);
		}
		DBHelper.closeConnection(conn);
		return result;
	}

	public static Receiver getReceiverById(int receiverId) throws SQLException {

		Receiver receiver = null;

		Connection conn = DBHelper.createConnection();

		String selectString = "select * from receivers where id=?";
		PreparedStatement stmt = conn.prepareStatement(selectString);
		stmt.setInt(1, receiverId);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			int id = rs.getInt("id");
			String nume = rs.getString("nume");
			String prenume = rs.getString("prenume");
			String gen = rs.getString("gen");
			String cnp = rs.getString("cnp");
			String adresa = rs.getString("adresa");
			String email = rs.getString("email");
			String numarTelefon = rs.getString("numar_telefon");

			receiver = new Receiver(id, nume, prenume, gen, cnp, adresa, email, numarTelefon);
		}
		DBHelper.closeConnection(conn);
		return receiver;
	}

	// UPDATE
	public static void updateReceiver(Receiver r) throws SQLException {

		Connection conn = DBHelper.createConnection();

		String updateString = "UPDATE receivers SET "
				+ "nume=?, prenume=?, gen=?, cnp=?, adresa=?, email=?, numar_telefon=?" + "where id=?";
		PreparedStatement stmt = conn.prepareStatement(updateString);
		stmt.setString(1, r.getNume());
		stmt.setString(2, r.getPrenume());
		stmt.setString(3, r.getGen());
		stmt.setString(4, r.getCnp());
		stmt.setString(5, r.getAdresa());
		stmt.setString(6, r.getEmail());
		stmt.setString(7, r.getNumarTelefon());
		stmt.setInt(8, r.getId());

		stmt.executeUpdate();

		DBHelper.closeConnection(conn);
	}

	// DELETE
	public static void deleteReceiver(Receiver r) throws SQLException {

		Connection conn = DBHelper.createConnection();

		String deleteString = "DELETE from receivers where id=?";
		PreparedStatement stmt = conn.prepareStatement(deleteString);
		stmt.setInt(1, r.getId());

		stmt.executeUpdate();

		DBHelper.closeConnection(conn);
	}

	public static void deleteReceiverById(int id) throws SQLException {

		Connection conn = DBHelper.createConnection();

		String deleteString = "DELETE from receivers where id=?";
		PreparedStatement stmt = conn.prepareStatement(deleteString);
		stmt.setInt(1, id);

		stmt.executeUpdate();

		DBHelper.closeConnection(conn);
	}

}
