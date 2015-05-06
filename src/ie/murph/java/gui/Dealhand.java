package ie.murph.java.gui;

import ie.murph.java.objects.CardSuit;
import ie.murph.java.objects.Deck;
import ie.murph.java.objects.User;

import java.util.Map;
import java.util.Scanner;

public class Dealhand 
{
	private Deck m_deck;
	private User m_user;
	private final Scanner M_SCANNER = new Scanner(System.in);
	private Map<Integer, CardSuit> m_card;
	
	public Dealhand(Deck deck, User user)
	{
		this.m_deck = deck;
		this.m_user = user;	
	}
	
	//Method to generate / deal players one card at a time 
	public void dealPlayersOneCard()
	{
		this.m_deck.generateRandomNumbersToChooseACardAndASuit();
		this.m_card = this.m_deck.getACardFromDeck();
		this.m_deck.decreaseNumberOfCardsInTheDeck();
		this.m_user.addCardNumbersTotal(this.m_card );
		this.m_deck.removeACardFromTheDeck();
		System.out.println("Player Card: " + this.m_card);
	}
	
	// Method to ask the user if they want to try another card again.
	public void askToDealOrStick()
	{
		System.out.println(ConsoleText.QUESTIONTOPLAYER.toString() + " " + CommonText.QUESTIONTOPLAYER);
		
		String s_continue = this.M_SCANNER.nextLine();
		if(s_continue.equalsIgnoreCase("y") || s_continue.equalsIgnoreCase("yes"))
		{
			this.m_deck.generateRandomNumbersToChooseACardAndASuit();
			this.m_card = this.m_deck.getACardFromDeck();
			this.m_deck.decreaseNumberOfCardsInTheDeck();
			this.m_user.addCardNumbersTotal(this.m_card );
			this.m_deck.removeACardFromTheDeck();
			System.out.println("Player Card: " + this.m_card);
			this.askToDealOrStick();
		}
		else if (s_continue.equalsIgnoreCase("n") || s_continue.equalsIgnoreCase("no"))
		{
			int value = this.m_user.getCardValue();
			this.m_user.checkUserCardValue(value);
		}
		else
			this.askToDealOrStick();
		
//		System.out.println(ConsoleText.GOODBYE.toString());
//		System.exit(0);
	}
	
	//TODO Place bets or not
	public boolean wouldYouLikeToPlaceABet()
	{
		return false;
	}
	
	//TODO Ask the user how many chips they want to place on each bet
	public void howMuchDoYouWantToBet(int bet) 
	{
		this.m_user.removeChips(bet);
	}
	
	//TODO Simple yes or no, does the player want another card
	public boolean doesPlayerWantAnotherCard()
	{
		return false;
	}
	
	//TODO Which player/dealer wins, with hitting 21 or nearest to 21
	public void playerWins()
	{
		
	}
		
}
