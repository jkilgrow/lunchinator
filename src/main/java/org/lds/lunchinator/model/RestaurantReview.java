package org.lds.lunchinator.model;

public class RestaurantReview
{
	private int id;
	private String restaurant;
	private String reviewer;
	private String rating;
	private String review;
	private String reviewerImage;

	public RestaurantReview()
	{
		// empty constructor for safety
	}
	
	public RestaurantReview(int id, String restaurant, String reviewer, String rating, String review, String reviewerImage)
	{
		this.id = id;
		this.restaurant = restaurant;
		this.reviewer = reviewer;
		this.rating = rating;
		this.review = review;
		this.reviewerImage = reviewerImage;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getRestaurant()
	{
		return restaurant;
	}

	public void setRestaurant(String restaurant)
	{
		this.restaurant = restaurant;
	}

	public String getReviewer()
	{
		return reviewer;
	}

	public void setReviewer(String reviewer)
	{
		this.reviewer = reviewer;
	}

	public String getRating()
	{
		return rating;
	}

	public void setRating(String rating)
	{
		this.rating = rating;
	}

	public String getReview()
	{
		return review;
	}

	public void setReview(String review)
	{
		this.review = review;
	}

	public String getReviewerImage()
	{
		return reviewerImage;
	}

	public void setReviewerImage(String reviewerImage)
	{
		this.reviewerImage = reviewerImage;
	}
	
}
