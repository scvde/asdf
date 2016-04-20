package game;

import java.util.Random;

public class Room {

	
	private String Title;
	private String Description;
	private Item item;
	private boolean isStart;
	private boolean containsPlayer;
	
	private boolean northExit;
	private boolean eastExit;
	private boolean southExit;
	private boolean westExit;
	
	private int exitCount;
	Random r = new Random();
	
	public Room(boolean north, boolean east, boolean south, boolean west)
	{
		// initialize the room exits
		this.northExit = north;
		this.eastExit = east;
		this.southExit = south;
		this.westExit = west;
	}
	
	public String getTitle()
	{
		return this.Title;
	}
	
	public void setTitle(String Title)
	{
		this.Title = Title;
	}
	
	public String getDescription()
	{
		return this.Description;
	}
	
	public void setDescription(String Description)
	{
		this.Description = Description;
	}
	
	public void setItem(Item item)
	{
		this.item = item;
	}
	
	public Item getItem()
	{
		return this.item;
	}
	
	public boolean hasItem(String itemName)
	{
		if(this.item.getName().equals(itemName))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean hasPlayer()
	{
		return containsPlayer;
	}
	
	public void setPlayer(Boolean containsPlayer)
	{
		this.containsPlayer = containsPlayer;
	}
	
	public void setStart(boolean isStart)
	{
		this.isStart = isStart;
	}
	
	public boolean isStart()
	{
		return this.isStart;
	}
	
	public boolean checkExit(String exit)
	{
		switch(exit)
		{
		case "north":
			return northExit;
		case "east":
			return eastExit;
		case "south":
			return southExit;
		case "west":
			return westExit;
		default:
			return false;
		}
	}
	
	public void checkExits()
	{
		exitCount = 0;
		
		System.out.print("available exits in this room: ");
		if(northExit)
		{
			if(exitCount > 0)
			{
				System.out.print(", ");
			}
			System.out.print("north");
			exitCount++;
		}
		if(eastExit)
		{
			if(exitCount > 0)
			{
				System.out.print(", ");
			}
			System.out.print("east");
			exitCount++;
		}
		if(southExit)
		{
			if(exitCount > 0)
			{
				System.out.print(", ");
			}
			System.out.print("south");
			exitCount++;
		}
		if(westExit)
		{
			if(exitCount > 0)
			{
				System.out.print(", ");
			}
			System.out.print("west");
			exitCount++;
		}
		
		System.out.println(".");
		
		if(this.item != null)
		{
			System.out.println("There is a `" + this.getItem().getName() + "` on the floor.");
		}
	}
	
	public void getRoomDescription()
	{
		System.out.println(this.Description);
	}

}
