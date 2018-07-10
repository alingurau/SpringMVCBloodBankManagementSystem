package ro.emanuel.project.pojo;

public class Donor {

	private int id;
	private String nume;
	private String prenume;
	private String cnp;
	private String adresa;
	private String email;
	private String numarTelefon;

	public Donor() {

	}

	public Donor(int id, String nume, String prenume, String cnp, String adresa, String email, String numarTelefon) {
		super();
		this.id = id;
		this.nume = nume;
		this.prenume = prenume;
		this.cnp = cnp;
		this.adresa = adresa;
		this.email = email;
		this.numarTelefon = numarTelefon;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumarTelefon() {
		return numarTelefon;
	}

	public void setNumarTelefon(String numarTelefon) {
		this.numarTelefon = numarTelefon;
	}
}