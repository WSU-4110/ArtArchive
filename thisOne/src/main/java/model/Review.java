package model;

public class Review {
	protected int id;
	protected String review;
	protected String user;
	protected int salesId;
	protected int stars;

	public Review(String user, int salesId) {
		this.user = user;
		this.salesId = salesId;
	}

	public Review(String review, String user, int salesId, int stars) {
		super();
		this.review = review;
		this.user = user;
		this.salesId = salesId;
		this.stars = stars;
	}

	public Review(int id, String review, String user, int salesId, int stars) {
		super();
		this.id = id;
		this.review = review;
		this.user = user;
		this.salesId = salesId;
		this.stars = stars;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public int getSalesID() {
		return salesId;
	}

	public void setSalesID(int salesId) {
		this.salesId = salesId;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public boolean equals(Object review) {
		if (review instanceof Review) {
			Review toCompare = (Review) review;
			return toCompare.getUser().equals(this.user) && toCompare.getSalesID() == this.salesId;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return user.hashCode();
	}

}
