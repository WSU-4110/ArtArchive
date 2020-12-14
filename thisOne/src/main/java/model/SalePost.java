package model;

import javax.sql.rowset.serial.SerialBlob;

public class SalePost {
	protected int id;
	protected String name;
	protected String description;
	protected String user;
	protected String file;

	public SalePost() {
	}

	public SalePost(String name, String description, String user, String file) {
		super();
		this.name = name;
		this.description = description;
		this.user = user;
		this.file = file;
	}

	public SalePost(int id, String name, String description, String user, String file) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.user = user;
		this.file = file;
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
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
}
