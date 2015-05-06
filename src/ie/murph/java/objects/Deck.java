package ie.murph.java.objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Deck 
{
	private Card m_cardObj;
	private List<CardSuit> m_listOfAllSuits;
	private List<Integer> m_listOfAllNumbers;
	private Map<Integer, CardSuit> m_mapWithASingleCard;
	private int m_cardDeckIndexForBothSuitAndNumber;
	
	private int NUMBER_OF_CARDS_IN_THE_DECK = 52;
	
	public Deck(Card card)
	{
		this.m_cardObj = card;
		this.m_listOfAllSuits = new ArrayList<CardSuit>();
		this.m_listOfAllNumbers = new ArrayList<Integer>();
		this.m_mapWithASingleCard =  new HashMap<Integer, CardSuit>();
	}
	
	public void generateADeckOfCards(int numberOfDecks)
	{	
		List<Integer> list = this.m_cardObj.getDeckNumbersOneToFourteenList();
		List<CardSuit> suits = this.m_cardObj.getDeckSuitsList();

		this.m_cardObj.generateNumbersOneToElevenIntoASet();
		this.m_cardObj.generateNumbersOneToElevenIntoAListWithDuplicates();
		
		this.m_cardObj.generateSuits();
		
//		int count=1;
		for(int decks = 0 ; decks < numberOfDecks ; decks++)
		{
			for(CardSuit suit : suits)
			{
				for(int number : list)
				{
//					System.out.println(count + " - Deck: " + number + " of " + suit);
					this.m_listOfAllSuits.add(suit);
					this.m_listOfAllNumbers.add(number);
//					count++;
				}
			}
		}
	}
	
	//To randomly choose a card from the deck
	public void generateRandomNumbersToChooseACardAndASuit()
	{
		//TODO Check to see for a bug here, it might be choosing 0 to 51
		Random randomGenerator = new Random();
		this.m_cardDeckIndexForBothSuitAndNumber = randomGenerator.nextInt(this.NUMBER_OF_CARDS_IN_THE_DECK);
	}
	
	//Every time a card dealth to player, decrease the number of cards in the deck to choose from..
	public void decreaseNumberOfCardsInTheDeck()
	{
		this.NUMBER_OF_CARDS_IN_THE_DECK--;
	}
	
	//Show number of cards left in the deck
	public void getAmountOfCardsInTeDeck()
	{
		System.out.println("***" + this.NUMBER_OF_CARDS_IN_THE_DECK + "***");
	}
	
	//Getting the card number and it's suit from the deck of cards and then deleting it from map for next number and suit
	public Map<Integer, CardSuit> getACardFromDeck()
	{
//		Collections.shuffle(m_suit);
		int number = this.m_listOfAllNumbers.get(this.m_cardDeckIndexForBothSuitAndNumber);
		CardSuit suit = this.m_listOfAllSuits.get(this.m_cardDeckIndexForBothSuitAndNumber);
		
		this.m_mapWithASingleCard.clear();
		this.m_mapWithASingleCard.put(number, suit);
		
		return m_mapWithASingleCard;
	}
	
	//Remove the number and corresponding suit from the deck once randomly chosen for each player
	public void removeACardFromTheDeck()
	{
		this.m_listOfAllNumbers.remove(this.m_cardDeckIndexForBothSuitAndNumber);
		this.m_listOfAllSuits.remove(this.m_cardDeckIndexForBothSuitAndNumber);
	}
	
	public void printOutCardsNumberAndSuit()
	{
		int count = 1;
			for(int x = 0; x < this.m_listOfAllNumbers.size(); x++)
			{
				System.out.println(count + " - Deck: " + this.m_listOfAllNumbers.get(x) + " of " + this.m_listOfAllSuits.get(x));
				count++;
			}
	}
}
