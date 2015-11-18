package ie.murph.java.objects;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class User 
{
	//Composite Pattern Used
	private String m_name;
	private int m_chips;
	private int m_cardValue;
	private List<User> m_players;
	
	public User(){}
	
	public User(String name, int chips)
	{
		this.m_name = name;
		this.m_chips = chips;
		this.m_players = new ArrayList<User>();
	}
	
	public String getUser()
	{
		return this.m_name;
	}
	
	public void setUser(String name)
	{
		this.m_name = name;
	}
	
	public int getChips()
	{
		//TODO TIDY THIS UP - Add the subtracted chips to the winners chips. Also not great taking 10 here
		return this.m_chips;
	}
	
	public void setChips(int chips)
	{
		this.m_chips = chips;
	}
	
	public void removeChips(int bet)
	{
		this.m_chips -= bet;
	}
	
	public void addChips(int winnings)
	{
		this.m_chips += winnings;
	}
	
	public int getCardValue()
	{
		return this.m_cardValue;
	}
	
	// Check to see if the user has under 21, 21 or bust
	public void checkUserCardValue(int value)
	{
		//TODO TIDY THIS UP to relevant bet placed by player
		if(value > 21)
		{
			System.out.println(this.getUser() + " - BUST WITH: " + value);
			this.removeChips(10);
		}
		else if(value == 21)
		{
			System.out.println(this.getUser() + " - BLACKJACK: " + value);
			addChips(10);
		}
		else if(value <= 21)
		{
			System.out.println(this.getUser() + " - HAS: " + value);
		}
	}
	
	public void addCardNumbersTotal(Map<Integer, CardSuit> card) 
	{
		for(int number : card.keySet())
		{
			m_cardValue = m_cardValue + number;
		}
	}
	
	public void addAUserPlayer(User user) 
	{
	      this.m_players.add(user);
	}

   public void removeAUserPlayer(User user) 
   {
      this.m_players.remove(user);
   }

   public List<User> getAUserPlayers()
   {
     return this.m_players;
   }

   //TODO Delete - Currently not being used
   public void printAllUsers(User p_user)
   {
	   System.out.println(p_user);
	   for (User headplayer : p_user.getAUserPlayers()) 
	   {
         System.out.println(headplayer);
         for (User user : headplayer.getAUserPlayers()) 
         {
            System.out.println(user);
         }
       }		
   }

	@Override
	public String toString() 
	{
		String user = "Name: " + m_name +
					  "\nChips: " + m_chips + "\n";
		return user;
	}
}
