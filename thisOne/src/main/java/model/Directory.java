package model;

public class Directory {
	protected int id;
	protected String title;
	protected String description;
	protected String user;
	protected String link;

	public Directory() {
	}

	public Directory(String title, String description, String user, String link) {
		super();
		this.title = title;
		this.description = description;
		this.user = user;
		this.link = link;
	}

	public Directory(int id, String title, String description, String user, String link) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.user = user;
		this.link = link;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getLink() {
		return link;
	}
	public void setLink(String link) { this.link = link;}

}
