package ie.murph.java.objects;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Card 
{
	private Set<Integer> m_numbers;
	private List<Integer> m_aQuarterOfDeckNumbersOneToFourteen;
	private List<CardSuit> m_suit;
	
	public Card()
	{
		m_numbers = new HashSet<Integer>();
		m_aQuarterOfDeckNumbersOneToFourteen = new ArrayList<Integer>();
		m_suit = new ArrayList<CardSuit>();
	}
	
	//Could have generated the numbers statically, but where's the fun in that..
	public void generateNumbersOneToElevenIntoASet()
	{
		SecureRandom randomGenerator = new SecureRandom();
		//Set doesn't give duplicates, so loop until I have numbers 2 to 11
		while(this.m_numbers.size() < 10)
		{
			//Generate numbers from 2 to 11
			this.m_numbers.add(randomGenerator.nextInt(10)+2);
		}
	}
	
	//Generate one quarter of the deck of cards, numbers one to eleven
	public void generateNumbersOneToElevenIntoAListWithDuplicates()
	{
		for(int value: this.m_numbers)
		{
			if(value == 10)
			{
				for(int x = 1; x <= 3; x++)
				{
					//Add the value 10 four times to the deck, as each deck has 4 values of 10 (10, J, Q, K)
					this.m_aQuarterOfDeckNumbersOneToFourteen.add(value);
				}
			}
			{
				this.m_aQuarterOfDeckNumbersOneToFourteen.add(value);
			}
		}
	}
	
	public void generateSuits()
	{
		for(CardSuit suit : CardSuit.values())
		{
				this.m_suit.add(suit);
		}
	}
	
	public Set<Integer> getDeckNumbersOneToElevenSet()
	{
		return this.m_numbers;
	}
	public List<Integer> getDeckNumbersOneToFourteenList()
	{
		return this.m_aQuarterOfDeckNumbersOneToFourteen;
	}
	public List<CardSuit> getDeckSuitsList()
	{
//		Collections.shuffle(m_suit);
		return this.m_suit;
	}
	
	//TODO Not being used
	public void printSet(Set<Integer> set)
	{
		for (Integer s : set) 
		{
		    System.out.println(s);
		}
	}
	
	//TODO Not being used
	public void printList(List<Integer> list)
	{
		for (Integer l: list) 
		{
		    System.out.println(l);
		}
	}
}
