package ie.murph.test.objects;


import ie.murph.java.gui.Dealhand;
import ie.murph.java.objects.Card;
import ie.murph.java.objects.Deck;
import ie.murph.java.objects.Table;
import ie.murph.java.objects.User;

public class Cardtest 
{
	public static void main(String[] args)
	{
		Card card = new Card();
		Deck deck = new Deck(card);
		User dealer = new User("Dealer", 10000);
		Table table = new Table(deck, dealer);
		Dealhand deal = null;
		
		//Read in a player or let user join through console input
//		Scanner scanner = new Scanner(System.in);
//		String userInput = scanner.nextLine();
		
//		User cascinoManager = new User("Manager", 0);
		//TODO Set up a scanner to read players names in
		//TODO Set up a client/server class to add players one at a time to the table
		User user0 = new User("Player1", 200);
		User user1 = new User("Player2", 150);
		table.addUserToTable(user0);
		table.addUserToTable(user1);
//		cascinoManager.printAllUsers(cascinoManager);
		
		for(User user : table.getUsers())
		{
			deal = new Dealhand(deck, user);
		}
		
		//Deal all players at the table two cards, dealing one card to each player at a time
		for(int x = 0; x<2; x++)
		{
			for(User user : table.getUsers())
			{
				deal = new Dealhand(deck, user);
				for(int y = 0; y<1; y++)
				{
					deal.dealPlayersOneCard();
					deck.getAmountOfCardsInTeDeck();
				}
				printOutUserAndCardTotal(user);
				System.out.println("");
			}
		}
		
		//Ask each player if they want more cards
		for(User user : table.getUsers())
		{
			deal = new Dealhand(deck, user);
			printOutUserAndCardTotal(user);
			deal.askToDealOrStick();
			deck.getAmountOfCardsInTeDeck();
			user.getChips();
		}
	}
	
	private static void printOutUserAndCardTotal(User user)
	{
		int value1 = user.getCardValue();
		String player1 = user.getUser();
		System.out.println(player1 + " has: " + value1);
	}
}
