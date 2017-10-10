package org.lds.lunchinator.model;

public class Person
{
	private String name;
	private String emailAddress;
	
	public Person()
	{
		// no-arg constructor
	}
	
	public Person(String name, String emailAddress)
	{
		this.setName(name);
		this.setEmailAddress(emailAddress);
	}
	
	public void setName(String name)
	{
		if (name != null)
		{
			// validate other things like punctuation and other special characters
			this.name = name;
		}
	}
	
	public void setEmailAddress(String emailAddress)
	{
		if (emailAddress != null)
		{
			// validate legal email address format
			this.emailAddress = emailAddress;
		}
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getEmailAddress()
	{
		return this.emailAddress;
	}
}
