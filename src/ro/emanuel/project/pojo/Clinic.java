package ro.emanuel.project.pojo;

public class Clinic {

	private int id;
	private String denumire;
	private String adresa;
	private String telefon;
	private String email;

	public Clinic() {

	}

	public Clinic(int id, String denumire, String adresa, String telefon, String email) {
		super();
		this.id = id;
		this.denumire = denumire;
		this.adresa = adresa;
		this.telefon = telefon;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDenumire() {
		return denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
