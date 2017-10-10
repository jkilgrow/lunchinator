package org.lds.lunchinator.model;

public class RestaurantVote
{
	private int id;
	private String name;
	private int votes;
	
	public RestaurantVote()
	{
		
	}
	
	public RestaurantVote(int id, String name, int votes)
	{
		this.id = id;
		this.name = name;
		this.votes = votes;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getVotes()
	{
		return votes;
	}

	public void setVotes(int votes)
	{
		this.votes = votes;
	}
	
}
