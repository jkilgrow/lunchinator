package org.lds.lunchinator.model;

public class WinningRestaurant
{
	private int id;
	private String dateTime;
	private String name;
	private int numVotes;
	
	public WinningRestaurant()
	{
		
	}
	
	public WinningRestaurant(int id, String dateTime, String name, int numVotes)
	{
		this.id = id;
		this.dateTime = dateTime;
		this.name = name;
		this.numVotes = numVotes;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getDateTime()
	{
		return dateTime;
	}

	public void setDateTime(String dateTime)
	{
		this.dateTime = dateTime;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getNumVotes()
	{
		return numVotes;
	}

	public void setNumVotes(int numVotes)
	{
		this.numVotes = numVotes;
	}
	
}
