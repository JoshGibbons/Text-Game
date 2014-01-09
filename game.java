
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class game {
	
	
	
	static Scanner input = new Scanner(System.in);
	static boolean quit = false;
	//get players 
	static int players = getplayers();
	//create an array of players
	static ArrayList<player> playerArray = new ArrayList<player>(players);
	//static player []playerArray = new player[players];
	//create pot
    static pot Winnings = new pot();
        
	public static void main (String[] args) throws IOException
	{
				
	do{	
		
		gameSetup();
		
		
		for (int i = 0; i < 5 ; i++)
		{
			bet(i%players);
			voyage(i);
		}	
		
		System.out.print("The winner is: ");
		GetWinner();
		
		choice();	
			
		}while(quit != true);	
	}		
	
	public static int getplayers()
	{
		System.out.println("How many players? ");
		players = input.nextInt();
		return players;
	}
	
	public static boolean choice()
	{
		System.out.println("\nPlay again (yes/no)?");
		String choice = input.next();
		
		if (choice.equals("yes"))
		{
			quit = false;
			getplayers();			
		}
		else
		{
			System.out.println("Thanks for playing!");
			quit = true;
		}		
		
		return quit;
	}

	public static void gameSetup()
	{
		Winnings.tablePot = 0;
		
		for(int i = 0; i < players; i++)
		{
			System.out.println("Name of player " + (i+1) + " : ");
			playerArray.add(new player());
			playerArray.get(i).total = 0;
			//playerArray(i) = new player();
			playerArray.get(i).setName(input.next());
		}
	
		
		//Test array
		System.out.print("\n\nWelcome ");
		for (int i = 0; i < players; i++)
		{
			if (i == players - 1)
				System.out.print("and " + playerArray.get(i).getName());
			else
				System.out.print(playerArray.get(i).getName() + ", ");
		}	
	}

	public static void bet(int dealer)
	{	
		double money;
		
		//dealer bet
		do{
		System.out.println("\n\n" + playerArray.get(dealer).getName() + ", How much would you like to bet this round? ");
		while(!input.hasNextDouble()){
			System.out.println("NOT A VALID VALUE");
			input.next();
		}
		money = input.nextDouble();
		}while (money <= 0);
		
		pot.addToPot(money);
	
				
		//others call or fold
		int count = 0;
		for(int i = dealer + 1; i < players; i++)
		{
			count += 1;
			System.out.println(playerArray.get(i).getName() + ", Call or Fold (call/fold)? ");
			String check = input.next();
			
			if(check.equals("call"))
				Winnings.addToPot(money);
			else
			{
				Collections.swap(playerArray, i, dealer);
				playerArray.remove(i);
				players = players - 1;
			}
		}
		
		for(int i = dealer - count; i > -1; i--)
		{
			System.out.println(playerArray.get(i).getName() + ", Call or Fold (call/fold)? ");
			String check = input.next();
			
			if(check.equals("call"))
				Winnings.addToPot(money);
			else
			{
				Collections.swap(playerArray, i, dealer);
				playerArray.remove(i);	
				players = players - 1;
			}
				
		}
	}
	
	
	public static void voyage (int count) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		System.out.println("\nRound "+ (count+1));
		
		for(int i = 0; i < players; i++)
		{
			System.out.println("******" + playerArray.get(i).getName() + "'s turn: " + "*******");
			playerArray.get(i).newTurn();
			
			for(int j = 0; j < 3; j++)
			{
				playerArray.get(i).Roll();
				System.out.println("press enter");
				String line = br.readLine();
			}
			
		}
	}

	public static void GetWinner()
	{
		int highest = 0;
		
		//get winning total
		for (int i = 0; i < players; i++)
		{
			if(playerArray.get(i).total > highest)
			{
				highest = playerArray.get(i).total;
			}
		}
		
			
		//get winners Name
		for (int i = 0; i < players; i++)
		{
			if(playerArray.get(i).total == highest)
			{
				System.out.print(playerArray.get(i).getName() + " ");
				Winnings.sendToWinner(highest);
				System.out.print(" with " + playerArray.get(i).getMoneyWon());
			}
		}
			
	}	
			
}
