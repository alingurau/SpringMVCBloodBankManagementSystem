package ro.emanuel.project.pojo;

public class BloodGroup {

	private int id;
	private String type;
	private String rh;
	private String description;

	public BloodGroup() {

	}

	public BloodGroup(int id, String type, String rh, String description) {
		super();
		this.id = id;
		this.type = type;
		this.rh = rh;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRh() {
		return rh;
	}

	public void setRh(String rh) {
		this.rh = rh;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
