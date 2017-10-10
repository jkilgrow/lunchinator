package org.lds.lunchinator.model;

import java.util.ArrayList;

public class BallotResult
{
	// after the voting deadline
	private WinningRestaurant winner;
	private ArrayList<RestaurantVote> choices;
	
	public BallotResult()
	{
		
	}
	
	public BallotResult(Ballot ballot)
	{
		this.winner = ballot.getWinningRestaurant();
		this.choices = ballot.getRestaurantVotes();
	}

	public WinningRestaurant getWinner()
	{
		return winner;
	}

	public void setWinner(WinningRestaurant winner)
	{
		this.winner = winner;
	}

	public ArrayList<RestaurantVote> getChoices()
	{
		return choices;
	}

	public void setChoices(ArrayList<RestaurantVote> restaurantVote)
	{
		this.choices = restaurantVote;
	}

}
