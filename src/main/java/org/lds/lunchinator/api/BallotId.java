package org.lds.lunchinator.api;

public class BallotId
{
	// need a better way to generate guids
	private static long ballotguid = 1234568l;
	private String ballotId;

	public BallotId()
	{
		ballotId = Long.toString(ballotguid);
		ballotguid = ballotguid +1l;
	}
	
	public String getBallotId()
	{
		return this.ballotId;
	}
}
