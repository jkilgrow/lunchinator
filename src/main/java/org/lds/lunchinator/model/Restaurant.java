package org.lds.lunchinator.model;

public class Restaurant
{
	private int id;
	private String name;
	private int waitTimeMinutes;
	private String[] types;
	private String image;
	private String description;
	
	public Restaurant()
	{
		// no-arg constructor for safety
	}
	
	public Restaurant(int id, String name, int waitTimeMinutes, String[] types, String image, String description)
	{
		// please do validations
		this.id = id;
		this.name = name;
		this.waitTimeMinutes = waitTimeMinutes;
		this.types = types;
		this.image = image;
		this.description = description;
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

	public int getWaitTimeMinutes()
	{
		return waitTimeMinutes;
	}

	public void setWaitTimeMinutes(int waitTimeMinutes)
	{
		this.waitTimeMinutes = waitTimeMinutes;
	}

	public String[] getTypes()
	{
		return types;
	}

	public void setTypes(String[] types)
	{
		this.types = types;
	}

	public String getImage()
	{
		return image;
	}

	public void setImage(String image)
	{
		this.image = image;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}
	
}
