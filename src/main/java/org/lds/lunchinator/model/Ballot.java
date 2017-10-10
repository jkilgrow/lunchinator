package org.lds.lunchinator.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import org.lds.lunchinator.api.BallotId;

public class Ballot
{
	private BallotId ballotId;
	private String endTime;
	private Calendar ballotEndTime;
	private ArrayList<Person> voters;
	
	private RestaurantReview review = new RestaurantReview();
	private ArrayList<Restaurant> choices = new ArrayList<Restaurant>();
	private HashMap<Integer, Integer> restaurantVotes;
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
	
	public Ballot()
	{
		// always create a new BallotId object or we will die
		this.ballotId = new BallotId();

		// construct a RestaurantReview object
		// logic to call the /api/reviews service (but for now we will just mock it...)
		this.review = this.createMockReview();
		
		// construct an ArrayList of Restaurants
		// logic to call the /api/restaurants service (but for now we will just mock it...)
		this.choices = this.createRestaurants();
	}
	
	public Ballot(String endTime, ArrayList<Person> voters)
	{
		this();
		this.setEndTime(endTime);
		this.setVoters(voters);
	}
	
	public void setEndTime(String endTime)
	{
		// transform endTime into a Calendar object
		this.endTime = endTime;
		this.ballotEndTime = new GregorianCalendar();
		
		
		try
		{
			// I would actually use the endTime here instead
			ballotEndTime.setTime(dateFormat.parse(endTime));
		}
		catch (ParseException badDate)
		{
			// now what? I might have to build a custom exception and throw it with a nice message.
			System.out.println(endTime + " date parsing blew up: " + badDate.toString());
		}
	}
	
	public void setVoters(ArrayList<Person> voters)
	{
		// probably some validation here
		this.voters = voters;
	}
	
	public String getEndTime()
	{
		// get the formatted endTime from the calendar object
		return this.endTime;
	}
	
	public ArrayList<Person> getVoters()
	{
		return this.voters;
	}
	
	public Person getPerson(int index)
	{
		// probably some validation here to make sure there are enough persons in the ArrayList to get that one
		return this.voters.get(index);
	}
	
	public BallotId getBallotId()
	{
		return this.ballotId;
	}

	public RestaurantReview getReview()
	{
		return review;
	}

	public void setReview(RestaurantReview review)
	{
		this.review = review;
	}

	public ArrayList<Restaurant> getChoices()
	{
		return choices;
	}

	public void setChoices(ArrayList<Restaurant> choices)
	{
		this.choices = choices;
	}
	
	private RestaurantReview createMockReview()
	{
		RestaurantReview review = new RestaurantReview();
		review.setId(10);
		review.setRating("5");
		review.setRestaurant("Pluckers");
		review.setReview("It is good...REAL good!");
		review.setReviewer("Jason");
		
		return review;
	}
	
	private ArrayList<Restaurant> createRestaurants()
	{
		ArrayList<Restaurant> choices = new ArrayList<Restaurant>();
		Restaurant restaurant1 = new Restaurant(11, "CFA", 5, new String[] {"fast"}, null, "chicken sandwiches");
		Restaurant restaurant2 = new Restaurant(12, "Taco Bueno", 5, new String[] {"texmex"}, null, "mexican");
		choices.add(restaurant1);
		choices.add(restaurant2);
		
		return choices;
	}
	
	public void voteForRestaurant(int restaurantId)
	{
		// let's make sure the restaurant being voted on is actually in the list
		if (isRestaurantInList(restaurantId))
		{
			// just construct a new Integer object because it will bug me otherwise
			Integer restaurantIdObj = new Integer(restaurantId);
			
			// see if this restaurant has been voted for yet
			Integer upVote = restaurantVotes.get(restaurantIdObj);
			if (upVote != null)
			{
				upVote++;
			}
			else
			{
				upVote = new Integer(1);
			}
			
			restaurantVotes.put(restaurantIdObj, upVote);
			
		}
	}
	
	private boolean isRestaurantInList(int restaurantId)
	{
		boolean foundIt = false;
		
		for (Restaurant restaurantChoice : choices)
		{
			if (restaurantId == restaurantChoice.getId())
			{
				foundIt = true;
				break;
			}
		}
		
		return foundIt;
	}
	
	public WinningRestaurant getWinningRestaurant()
	{
		Integer winningRestaurantId = 0;
		Integer winningVoteValue = 0;
		Integer runningValue = 0;
		
		WinningRestaurant winner = new WinningRestaurant();
		
		for (Map.Entry<Integer, Integer> entry : this.restaurantVotes.entrySet())
		{
			runningValue = entry.getValue();
			if (runningValue.intValue() > winningVoteValue.intValue())
			{
				winningVoteValue = runningValue;
				winningRestaurantId = entry.getKey();
			}
		}
		
		winner.setId(winningRestaurantId.intValue());
		Date theEnd = new Date();
		GregorianCalendar cal = new GregorianCalendar();
		cal.setLenient(false);
		cal.setTime(theEnd);
		String theEndStr = dateFormat.format(theEnd);
		winner.setDateTime(theEndStr);
		winner.setName(choices.get(winningRestaurantId.intValue()).getName());
		winner.setNumVotes(winningVoteValue.intValue());
		
		return winner;
	}
	
	public ArrayList<RestaurantVote> getRestaurantVotes()
	{
		ArrayList<RestaurantVote> restaurantVotes = new ArrayList<RestaurantVote>();
		Integer restaurantId = 0;
		Integer numVotes = 0;
		String restaurantName = "";
		RestaurantVote restaurantVote = new RestaurantVote();
		
		for (Map.Entry<Integer, Integer> entry : this.restaurantVotes.entrySet())
		{
			restaurantId = entry.getKey();
			numVotes = entry.getValue();
			restaurantName = choices.get(restaurantId.intValue()).getName();
			restaurantVote = new RestaurantVote(restaurantId.intValue(), restaurantName, numVotes.intValue());
			restaurantVotes.add(restaurantVote);
		}
		
		return restaurantVotes;
	}
	
	public boolean isVotingClosed()
	{
		boolean votingClosed = false;
		try
		{
			System.out.println("endTime: " + endTime);
			Date votingCloseDate = dateFormat.parse(endTime);
			GregorianCalendar endCal = new GregorianCalendar();
			endCal.setLenient(false);
			endCal.setTime(votingCloseDate);
			
			GregorianCalendar nowCal = new GregorianCalendar();
			nowCal.setLenient(false);
			nowCal.setTime(new Date());
			
			System.out.println("now time: " + dateFormat.format(new Date()));
			
			if (nowCal.after(endCal))
			{
				System.out.println("this says nowCal is after endCal");
				votingClosed = true;
			}
		}
		catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("votingClosed: " + votingClosed);
		return votingClosed;
	}
}
