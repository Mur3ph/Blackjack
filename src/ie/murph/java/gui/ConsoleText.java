package ie.murph.java.gui;

public enum ConsoleText 
{
	WELCOME("Hello, Welcome to Spudy Casino"),
	QUESTIONTOPLAYER("Would the player like another card!?"),
	QUESTIONTODEALER("Would the dealer like another card!?"),
	GOODBYE("Thank you, good bye!");
	
	private final String text;

    private ConsoleText(final String text) 
    {
        this.text = text;
    }

    @Override
    public String toString() 
    {
        return this.text;
    }
	
}
