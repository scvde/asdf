package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Game {

	private Player m_player;
	private Room tempRoom;
	private Item tempItem;
	
	private int playerPosX;
	private int playerPosY;
	private String currentPos;
	private String nextPos;
	private boolean moved;
	private boolean usable;
	
	private HashMap<String, Room> map = new HashMap<String, Room>();
	private ArrayList<Item> itemList = new ArrayList<Item>();
	
	private Scanner scanner = new Scanner(System.in);
	
	private boolean gameIsFinished;
	
	private String roomtitle;
	private String command;
	private String extra;
	private String[] splitString;
	
	
	public Game()
	{
		gameIsFinished = false;
		
		m_player = new Player();
		m_player.setLocH(1);
		m_player.setLocV(1);
		
		// Initialize game (player, rooms, items you want in rooms) and run the run() command.
		// I'll be creating 6 items and adding them to an ArrayList so it's easier to check for their variables
		
		
		Item item1 = new Item();
		item1.setName("jammie dodger");
		item1.setText("After eating about half of the jammie dodger you feel like something might explode.\nYou don't continue eating the jammie dodger.");
		item1.setUnique(true);
		item1.setWinCondition(false);
		
		Item item2 = new Item();
		item2.setName("pack of tea biscuits");
		item2.setText("You eat the biscuits.\nThey're bland, but they really bring out the brit inside.");
		item2.setUnique(false);
		item2.setWinCondition(false);
		
		Item item3 = new Item();
		item3.setName("cookie cookbook");
		item3.setText("Quite a page-turner.\nThis may seem like a holy bible, but the title says otherwise.");
		item3.setUnique(false);
		item3.setWinCondition(false);
		
		Item item4 = new Item();
		item4.setName("dinosaur shaped cookie");
		item4.setText("It's too cute to be eaten, so you keep holding on to it.\n...\nIt's been too long, the cookie is spoiled.\nYou throw the dinosaur shaped cookie in the trash bin.");
		item4.setUnique(false);
		item4.setWinCondition(false);
		
		Item item5 = new Item();
		item5.setName("cookie dough");
		item5.setText("You eat the cookie.\nIt's not exactly a cookie, but good enough.");
		item5.setUnique(false);
		item5.setWinCondition(false);
		
		Item item6 = new Item();
		item6.setName("cookie monster's cookie stash");
		item6.setText("Legends say this stash of cookies has been feeding cookie addicts for years!\nSafely escort this back home!");
		item6.setUnique(false);
		item6.setWinCondition(true);
		
		itemList.add(item1);
		itemList.add(item2);
		itemList.add(item3);
		itemList.add(item4);
		itemList.add(item5);
		itemList.add(item6);
		

		//
		// Three rows of rooms, four rooms per row, total of 12 rooms
		// After creation these rooms get added to the 'map' HashMap, which allows for an easy time to look up specific rooms with their room codes
		//
		
		Room room1_1 = new Room(false, true, true, false);
		room1_1.setStart(true);
		room1_1.setTitle("Room 1-1");
		room1_1.setDescription("This room is the start of the maze.\nAbove the door you see a faded sign, it reads \"Cookie Monster's Crack House\"");
		
		Room room1_2 = new Room(false, true, false, true);
		room1_2.setStart(false);
		room1_2.setTitle("Room 1-2");
		room1_2.setDescription("A long corridor that is still being illuminated by the entrance, you wonder what's ahead of you.");
		room1_2.setItem(item3);

		Room room1_3 = new Room(false, false, true, true);
		room1_3.setStart(false);
		room1_3.setTitle("Room 1-3");
		room1_3.setDescription("The room is filled with cookie crumbs, what kind of people could have lived in this mansion?");
		
		Room room1_4 = new Room(false, false, true, false);
		room1_4.setStart(false);
		room1_4.setTitle("Room 1-4");
		room1_4.setDescription("The end of the hallway, the walls are filled with faded portraits of a seemingly blue creature.");
		room1_4.setItem(item6);
		
		Room room2_1 = new Room(true, true, false, false);
		room2_1.setStart(false);
		room2_1.setTitle("Room 2-1");
		room2_1.setDescription("The floor of this room is sort of slanted, leading you deeper down the mansion as it goes along.\nCould this be leading you to a basement of sorts?");
		
		Room room2_2 = new Room(false, true, true, true);
		room2_2.setStart(false);
		room2_2.setTitle("Room 2-2");
		room2_2.setDescription("You feel as though your vision is going blurry, could it be all the cookie dust lying on the floor?");
		room2_2.setItem(item1);
		
		Room room2_3 = new Room(true, true, false, true);
		room2_3.setStart(false);
		room2_3.setTitle("Room 2-3");
		room2_3.setDescription("This room seems to be some sort of kitchen, you see all sorts of baking appliances and cookie cutters.");
		room2_3.setItem(item4);
		
		Room room2_4 = new Room(true, false, true, true);
		room2_4.setStart(false);
		room2_4.setTitle("Room 2-4");
		room2_4.setDescription("Between the old rooms this one has been kept clean very neatly, as if someone has been living here all this time.");
		
		Room room3_1 = new Room(false, true, false, false);
		room3_1.setStart(false);
		room3_1.setTitle("Room 3-1");
		room3_1.setDescription("This room has doors leading to both male- and female toilets, it's surprisingly clean.");
		room3_1.setItem(item2);
		
		Room room3_2 = new Room(true, true, false, true);
		room3_2.setStart(false);
		room3_2.setTitle("Room 3-2");
		room3_2.setDescription("You find three mattresses scattered across the room, two of which have been torn up by vermin that roams the mansion.");
		
		Room room3_3 = new Room(false, true, false, true);
		room3_3.setStart(false);
		room3_3.setTitle("Room 3-3");
		room3_3.setDescription("There are spoons and lighters all over the floor, it's almost like someone tried to desperately cook the dough without proper appliances.");
		room3_3.setItem(item5);
		
		Room room3_4 = new Room(true, false, false, true);
		room3_4.setStart(false);
		room3_4.setTitle("Room 3-4");
		room3_4.setDescription("This corridor has doors to both the deepest part of the basement and the first floor.");

		map.put("1-1", room1_1);
		map.put("1-2", room1_2);
		map.put("1-3", room1_3);
		map.put("1-4", room1_4);
		
		map.put("2-1", room2_1);
		map.put("2-2", room2_2);
		map.put("2-3", room2_3);
		map.put("2-4", room2_4);
		
		map.put("3-1", room3_1);
		map.put("3-2", room3_2);
		map.put("3-3", room3_3);
		map.put("3-4", room3_4);

		
		//
		// Execute the run command as listed below here
		//
		
		run();
	}
	
	
	private void run()
	{
		try
		{
			//
			//	First introduce the player to the game and ask them to input their name.
			//
			
			System.out.println("Welcome to crippling cookie addiction simulator 2016, what is your name?");
			System.out.print(">");
			m_player.setName(scanner.nextLine());
			System.out.println("Welcome " + m_player.getName() + ".");
			System.out.println("You enter the mansion in search for the legendary cookie stash left by a certain person with the initials \"C. M.\"");
			
			System.out.println("You are now in room 1-1");
			System.out.println(map.get("1-1").getDescription());
			
			// As long as the command isn't to quit:
			// get the next input line and handle it. (With handleCommand.)
			// handleCommand will check which of the required functions is necessary using both a switch statement and multiple if-statements
			while(!gameIsFinished)
			{
				this.currentPos = this.calcRoomKey(m_player.getLocH(), m_player.getLocV());
				System.out.print(">");
				handleCommand(scanner.nextLine());
			}
			
		}
		catch(Exception e)
		{
			// Game broke, tell user (this shouldn't be happening, but it's a nice safety net to have anyway.)
			e.printStackTrace();
		}
	}
	
	private void handleCommand(String userInput)
	{
		
		// Split the player's input into two variables to check for the actual command and any added information (item names, directions)
		splitString = userInput.split(" ", 2);
		command = splitString[0].toLowerCase(); // always get everything lower case so case sensitivity with .equals() is not an issue
		
		// if statement to prevent array errors (in case the command is only one word long, leaving extra information as null)
		if(splitString.length > 1)
		{
			extra = splitString[1].toLowerCase();
		}
		
		// First an if-statement to check all the commands that require extra information
		if(extra != null)
		{
			switch (command)
			{
			case "use":
				handleUseCommand(extra);
				break;
			case "drop":
				handleDropCommand(extra);
				break;
			case "get":
				handleGetCommand(extra);
				break;
			case "go":
				handleGoCommand(extra);
				break;
			default:
				System.out.println("That command does not exist, please try again.");
			}
		}
		// Next go through the one-word long commands
		else if(command.equals("quit"))
		{
			System.exit(0);
		}
		else if(command.equals("help"))
		{
			System.out.println("Available commands: \nGo: Move towards a new room. \nUse: Use an item that is either in your backpack or on the floor. \nDrop: Drop an item from your backpack on the floor. \nGet: Pick up an item and put it in your backpack. \nLook: Look around the room. \nPack: Check the contents of your backpack. \nHelp: Shows all the available commands, as you can see right now! \nQuit: Stop the game.");
		}
		else if(command.equals("pack"))
		{
			String temp = m_player.showBp();
			if (temp.equals("%EMPTY%"))
			{
				System.out.println("Your backpack is empty!");
			}
			else
			{
				System.out.println("Your backpack contains: " + temp);
			}
		}
		else if(command.equals("look"))
		{
			handleLookCommand();
		}
		// if none of the commands matched the user input, tell the user.
		else
		{
			System.out.println("Incorrect input, try again.");
		}
		// Clearing the strings to avoid trouble with re-using them later
		command = null;
		extra = null;
		
	}
	
	private void handleLookCommand()
	{
		// Get the player's position
		playerPosX = m_player.getLocH();
		playerPosY = m_player.getLocV();
		
		// get the room code using the player's position and the calcRoomKey(int x, int y) function
		currentPos = this.calcRoomKey(playerPosX, playerPosY);
		// check which of the room's directions has an open exit and list them
		map.get(currentPos).checkExits();
	}
	
	private void handleGoCommand(String directionName)
	{
		// get player's current position
		playerPosX = m_player.getLocH();
		playerPosY = m_player.getLocV();
		
		// calc current room code
		currentPos = this.calcRoomKey(playerPosX, playerPosY);
		tempRoom = map.get(currentPos);
		
		// check if the desired direction is open, if so move the player towards that direction.
		switch (directionName)
		{
		case "north":
			if(tempRoom.checkExit("north"))
			{
				nextPos = this.calcRoomKey(playerPosX - 1,  playerPosY);
				m_player.setLocV(playerPosY - 1);
				map.get(currentPos).setPlayer(false);
				map.get(nextPos).setPlayer(true);
				this.moved = true;
			}
			else
			{
				System.out.println("This direction has no exit!");
				this.moved = false;
			}
			break;
		case "east":
			if(tempRoom.checkExit("east"))
			{
				nextPos = this.calcRoomKey(playerPosX,  playerPosY + 1);
				m_player.setLocH(playerPosY + 1);
				map.get(currentPos).setPlayer(false);
				map.get(nextPos).setPlayer(true);
				this.moved = true;
			}
			// if the direction does not have an open exit, tell them and do not move the player
			else
			{
				System.out.println("This direction has no exit!");
				this.moved = false;
			}
			break;
		case "south":
			if(tempRoom.checkExit("south"))
			{
				nextPos = this.calcRoomKey(playerPosX + 1,  playerPosY);
				m_player.setLocV(playerPosY+1);
				map.get(currentPos).setPlayer(false);
				map.get(nextPos).setPlayer(true);
				this.moved = true;
			}
			// if the direction does not have an open exit, tell them and do not move the player
			else
			{
				System.out.println("This direction has no exit!");
				this.moved = false;
			}
			break;
		case "west":
			if(tempRoom.checkExit("west"))
			{
				nextPos = this.calcRoomKey(playerPosX,  playerPosY - 1);
				map.get(currentPos).setPlayer(false);
				map.get(nextPos).setPlayer(true);
				this.moved = true;
			}
			// if the direction does not have an open exit, tell them and do not move the player
			else
			{
				System.out.println("This direction has no exit!");
				this.moved = false;
			}
			break;
			// Default case in the switch to tell the user their direction was invalid
		default:
			System.out.println("That is not a valid direction.");
			this.moved = false;
		}
		
		// if the player was moved, update the player's coordinates
		if(this.moved)
		{
			m_player.setLocH(this.getRoomX(map.get(nextPos)));
			m_player.setLocV(this.getRoomY(map.get(nextPos)));
			System.out.println("You are now in room " + nextPos);
			
			// check the new room's information (room code and description)
			map.get(this.calcRoomKey(m_player.getLocH(), m_player.getLocV())).checkExits();
			map.get(this.calcRoomKey(m_player.getLocH(), m_player.getLocV())).getRoomDescription();
			
			// check if the player has taken the win condition to the start of the map (room 1-1), if so finish the game
			if(map.get(this.calcRoomKey(m_player.getLocH(), m_player.getLocV())).isStart() && m_player.checkBp("cookie monster's cookie stash"))
			{
				System.out.println("You have safely taken the legendary cookie stash with you back out the mansion.");
				System.out.println("A feeling of relief engulfs your body as you open the bag to take a peek, only to find out that most of the cookies have almonds in them.");
				System.out.println("The one thing you're allergic for.");
				
				System.out.println("\nCongratulations, you have beaten Crippling Cookie Addiction Simulator 2016!\nThank you for playing.");
				
				this.gameIsFinished = true;
			}
			
		}
		
		
	}
	
	
	private void handleUseCommand(String itemName)
	{
		// get current room coordinates
		playerPosX = m_player.getLocH();
		playerPosY = m_player.getLocV();
		
		currentPos = this.calcRoomKey(playerPosX, playerPosY);
		usable = true;
		
		// check if item that is to be used is the win condition, if so, do not let the player use it
		for(Item i : itemList)
		{
			if(i.getWinCondition() && i.getName().equals(itemName))
			{
				this.usable = false;
			}
			else if (!i.getWinCondition() && i.getName().equals(itemName))
			{
				this.usable = true;
			}
			
		}
		
		// if its in the player's backpack, use it from there.
		if(m_player.checkBp(itemName) && usable)
		{
			System.out.println("You use the " + itemName);
			System.out.println(m_player.getItem(itemName).getText());
			m_player.removeFromBp(itemName);
		}
		// if it's not in the player's backpack but on the floor in the room, remove the item from the room and use it
		else if(map.get(currentPos).getItem() != null && map.get(currentPos).getItem().getName().equals(itemName) && this.usable)
		{
			m_player.addToBp(map.get(currentPos).getItem());
			map.get(currentPos).setItem(null);
			this.handleUseCommand(itemName);
			m_player.removeFromBp(itemName);
		}
		else if(!usable)
		{
			System.out.println("You cannot use this item, you need to bring it back to the start of the maze!");
		}
		// if the item is not in the player's backpack or on the floor, tell the player
		else
		{
			System.out.println("You do not have that item!");
		}
	}
	
	public void handleDropCommand(String itemName)
	{
		// get current room
		playerPosX = m_player.getLocH();
		playerPosY = m_player.getLocV();
		
		currentPos = this.calcRoomKey(playerPosX, playerPosY);
		tempItem = null;
		
		// if item exists, get its name and description
		for(Item i : itemList)
		{
			if(itemName.equals(i.getName()))
			{
				tempItem = i;
			}
		}
		
		// if the item exists in the itemList, take it out of the player's inventory and add it to the room's floor.
		if(tempItem != null)
		{
			if(m_player.checkBp(itemName))
			{
				map.get(currentPos).setItem(tempItem);
				m_player.removeFromBp(itemName);
				System.out.println("You dropped the " + itemName + " on the floor.");
			}
			else
			{
				System.out.println("You do not have that item!");
			}
		}
		else
		{
			System.out.println("That item does not exist!");
		}	
	}
	
	private void handleGetCommand(String itemName)
	{
		// get room information
		playerPosX = m_player.getLocH();
		playerPosY = m_player.getLocV();
		
		currentPos = this.calcRoomKey(playerPosX, playerPosY);
		
		// check if room has an item, if so remove it from the room and add it to the player's inventory
		if(map.get(currentPos).getItem() != null)
		{
			m_player.addToBp(map.get(currentPos).getItem());
			map.get(currentPos).setItem(null);
		}
	}
	
	// small method to put together the key for the HashMap, using the player's coordinates
	private String calcRoomKey(int x, int y)
	{
		return x + "-" + y;
	}
	
	// Use the room's title to get the coordinates by splitting it up and taking the numbers
	private int getRoomX(Room room)
	{
		roomtitle = room.getTitle();
		splitString = roomtitle.split("");
		return Integer.parseInt(splitString[5]);
	}
	
	private int getRoomY(Room room)
	{
		roomtitle = room.getTitle();
		splitString = roomtitle.split("");
		return Integer.parseInt(splitString[7]);
	}

	
	
}
