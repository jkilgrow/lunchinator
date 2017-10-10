package org.lds.lunchinator.model;

import java.util.ArrayList;

public class BallotSelection
{
	// before the voting deadline
	private RestaurantReview suggestion;
	private ArrayList<Restaurant> choices;

	public BallotSelection()
	{
		
	}
	
	public BallotSelection(Ballot ballot)
	{
		this.suggestion = ballot.getReview();
		this.choices = ballot.getChoices();
	}

	public RestaurantReview getSuggested()
	{
		return suggestion;
	}

	public void setSuggested(RestaurantReview suggested)
	{
		this.suggestion = suggested;
	}

	public ArrayList<Restaurant> getChoices()
	{
		return choices;
	}

	public void setChoices(ArrayList<Restaurant> choices)
	{
		this.choices = choices;
	}
	
}
