package model;

public class User {
	protected int id;
	protected String name;
	protected String email;
	protected String country;
	protected String password;
	protected String firstName;
	protected String lastName;
	protected String description;
	protected String favoriteColor;
	
	public User() {
	}
	
	public User(String name, String email, String country, String password, String firstName, String lastName, String description, String favoriteColor) {
		super();
		this.name = name;
		this.email = email;
		this.country = country;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.description = description;
		this.favoriteColor = favoriteColor;
	}

	public User(int id, String name, String email, String country, String password, String firstName, String lastName, String description, String favoriteColor) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.country = country;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.description = description;
		this.favoriteColor = favoriteColor;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() { return firstName; }
	public void setFirstName(String firstName) { this.firstName = firstName; }
	public String getLastName() { return lastName; }
	public void setLastName(String lastName) { this.lastName = lastName; }
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	public String getFavoriteColor() { return favoriteColor; }
	public void setFavoriteColor(String favoriteColor) { this.favoriteColor = favoriteColor; }

}
