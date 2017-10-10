package org.lds.lunchinator.model;

public class Vote
{
	private int id;
	private String ballotId;
	private String voterName;
	private String emailAddress;
	
	public Vote()
	{
		
	}
	
	public Vote(int id, String ballotId, String voterName, String emailAddress)
	{
		this.id = id;
		this.ballotId = ballotId;
		this.voterName = voterName;
		this.emailAddress = emailAddress;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getBallotId()
	{
		return ballotId;
	}

	public void setBallotId(String ballotId)
	{
		this.ballotId = ballotId;
	}

	public String getVoterName()
	{
		return voterName;
	}

	public void setVoterName(String voterName)
	{
		this.voterName = voterName;
	}

	public String getEmailAddress()
	{
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress)
	{
		this.emailAddress = emailAddress;
	}
	
}
