package org.lds.lunchinator.api;

import java.util.HashMap;

import org.lds.lunchinator.model.Ballot;
import org.lds.lunchinator.model.BallotResult;
import org.lds.lunchinator.model.BallotSelection;
import org.lds.lunchinator.model.Vote;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BallotResource
{
	// persist the ballots a bit...TODO: persist them for real in a database
	private static HashMap<String, Ballot> ballotMap = new HashMap<String, Ballot>();
	
	// let's have a way to do a bit of DI here...
	public static void setBallotMap(HashMap<String, Ballot> ballotMap)
	{
		// TODO: really should do some validation on this...ugh! no time!
		BallotResource.ballotMap = ballotMap;
	}
	
	@RequestMapping(
			value="/create-ballot",
			method=RequestMethod.POST,
			consumes="application/json",
			produces="application/json")
	public ResponseEntity<BallotId> createBallot(@RequestBody Ballot ballot)
	{
		// why "I_AM_A_TEAPOT"? because i found it humorous.
		ResponseEntity<BallotId> respEnt = new ResponseEntity<BallotId>(new BallotId(), HttpStatus.I_AM_A_TEAPOT);
		
		// TODO: test multi threading. maybe even comment out synchronized until i can test it.
		if(ballot != null)
		{
			BallotId ballotId = ballot.getBallotId();
			String ballotIdStr = ballotId.getBallotId();
			BallotResource.ballotMap.put(ballotIdStr, ballot);
			respEnt = new ResponseEntity<BallotId>(ballot.getBallotId(), HttpStatus.OK);
		}
		
		return respEnt; 

	}
	
	@RequestMapping(
			value="/ballot/{ballotId}",
			method=RequestMethod.GET,
			produces="application/json")
	public ResponseEntity<?> getBallot(@PathVariable("ballotId") String ballotId)
	{
		// find the ballot in the "persistence" ;-) layer
		// TODO: use the real persistence layer someday
		Ballot ballot = BallotResource.ballotMap.get(ballotId);

		// make it as realistic as possible
		long ballotguid = Long.parseLong(ballot.getBallotId().getBallotId());

		// we have to mock the date/time logic for now 
		if (ballot.isVotingClosed())
		{
			// construct a ballot result from the ballot
			BallotResult ballotResult = new BallotResult(ballot);
			
			return new ResponseEntity<BallotResult>(ballotResult, HttpStatus.OK);
		}
		else
		{
			// construct a ballotselection from the ballot
			BallotSelection ballotSelection = new BallotSelection(ballot);
			
			return new ResponseEntity<BallotSelection>(ballotSelection, HttpStatus.OK);
		}
		
	}
	
	@RequestMapping(
			value="/vote",
			method=RequestMethod.POST,
			produces="application/json")
	public int vote(
			@RequestParam("id") int id,
			@RequestParam("ballotId") String ballotId,
			@RequestParam("voterName") String voterName,
			@RequestParam("emailAddress") String emailAddress)
	{
		int returnStatusCode = HttpStatus.NOT_FOUND.value();
		Vote vote = new Vote(id, ballotId, voterName, emailAddress);
		
		// find the ballotID in our persistence layer
		Ballot ballot = BallotResource.ballotMap.get(ballotId);
		
		// if the ballot was found vote for the restaurant
		if (ballot != null)
		{
			ballot.voteForRestaurant(id);
			returnStatusCode = HttpStatus.OK.value();
		}
		
		return returnStatusCode;
	}
}
