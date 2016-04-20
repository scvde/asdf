package game;

public class Item {

	private String name;
	private String usageText;
	private boolean unique;
	private boolean winCondition;
	
	
	public Item()
	{
		
	}
	
	public void generate()
	{
		
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getText()
	{
		return this.usageText;
	}
	
	public void setText(String text)
	{
		this.usageText = text;
	}
	
	public void setUnique(boolean unique)
	{
		this.unique = unique;
	}
	
	public boolean getUnique()
	{
		return this.unique;
	}
	
	public boolean getWinCondition()
	{
		return this.winCondition;
	}
	
	public void setWinCondition(boolean winCondition)
	{
		this.winCondition = winCondition;
	}
	
}
