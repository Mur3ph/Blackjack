package ie.murph.java.objects;

import java.util.ArrayList;
import java.util.List;

public class Table 
{
	private User m_dealer;
	private int m_numberOfPlayers;
	private List<User> m_users;
	private Deck m_deck;
	private int m_numberOfDecksForTheGame = 1;
	
	//TODO Set 8 and 6 seater tables 
	public Table(Deck deck, User user)
	{
		//TODO Create the dealer somewhere else
		this.m_dealer = user;
		this.m_users = new ArrayList<User>();
		if(!m_users.contains(this.m_dealer))
		{
			this.addUserToTable(this.m_dealer);
		}
		this.m_deck = deck;
		this.m_deck.generateADeckOfCards(this.m_numberOfDecksForTheGame);
	}
	
	//Adding players to sit at the table //TODO Create server and scanner to add players
	public void addUserToTable(User user)
	{
		this.m_numberOfPlayers++;
		int first = 0;
		//Adding new user to the start of the first, so that the dealer is always last
		this.m_users.add(first, user);
		first++;
	}
	
	public void removeAUserToTable(User user) 
	{
	      this.m_users.remove(user);
	}
	
	//TODO 
	public boolean leaveTable()
	{
		return false;
	}
	
	public List<User> getUsers()
	{
		return this.m_users;
	}
	
	public int getNumberOfPlayersSittingAtTable()
	{
		return this.m_numberOfPlayers;
	}
	
	//TODO
	public void dealTwoCardsForAllPlayersAtTable()
	{
		
	}
}
