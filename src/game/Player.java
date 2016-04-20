package game;

import java.util.ArrayList;

public class Player {

	private ArrayList<Item> backpack = new ArrayList<Item>();
	private String name;
	private int locV;
	private int locH;
	
	public Player()
	{
		
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setLocV(int i)
	{
		this.locV = i;
	}
	
	public void setLocH(int i)
	{
		this.locH = i;
	}
	
	public int getLocV()
	{
		return this.locV;
	}
	
	public int getLocH()
	{
		return this.locH;
	}
	
	public void moveUp()
	{
		this.locV++;
	}
	
	public void moveDown()
	{
		this.locV--;
	}
	
	public void moveLeft()
	{
		this.locH--;
	}
	
	public void moveRight()
	{
		this.locH++;
	}
	
	public boolean checkBp(String itemName)
	{
		boolean alreadyHave = false;
		
		for(Item i: backpack)
		{
			if(i.getName().equals(itemName))
			{
				alreadyHave = true;
			}
		}
		return alreadyHave;
	}
	
	public String showBp()
	{
		String temp = "";
		int itemCount = 0;
		for(Item i : backpack)
		{
			if(backpack.indexOf(i) == 0)
			{
				temp += i.getName();
				itemCount++;
			}
			else
			{
				temp += ", " + i.getName();
				itemCount++;
			}
		}
		
		if(itemCount == 0)
		{
			temp = "%EMPTY%";
		}
		return temp;
	}
	
	public Item removeFromBp(String itemName)
	{
		Item i = null;
		
		// check if item is in backpack (comparing names)
		for(Item a : backpack)
		{
			if(a.getName().equals(itemName))
			{
				i = a;
			}
		}
		// remove the item from backpack if its in there
		if(i != null)
		{
			backpack.remove(i);
		}
		
		// return the removed item as an object, as it's going to be used
		return i;
	}
	
	public void addToBp(Item item)
	{
		backpack.add(item);
		System.out.println("You pick up the `" + item.getName() + "`!");
	}
	
	public Item getItem(String itemName)
	{
		Item temp = null;
		for(Item i : backpack)
		{
			if(itemName.equals(i.getName()))
			{
				temp = i;
			}
		}
		return temp;
		
	}
	
	
}
