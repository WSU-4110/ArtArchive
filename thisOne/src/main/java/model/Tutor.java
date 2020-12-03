package model;

public class Tutor {
	protected int id;
	protected String name;
	protected String description;
	protected String user;

	public Tutor() {
	}

	public Tutor(String name, String description, String user) {
		super();
		this.name = name;
		this.description = description;
		this.user = user;
	}

	public Tutor(int id, String name, String description, String user) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.user = user;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
}
