import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class player {
	
	private String name;
	private double moneyWon;
    int total = 0;
	
   boolean ship = false, 
           captain = false,
           crew = false;
    //Create Dice  
	Random rand  = new Random();
	//int diceFace[] = new  int [5];
	ArrayList <Integer>diceFace = new ArrayList<Integer>(5);
	
//variable methods
	
	public player()
	{
		name = "ConstructoruserName";
	}

	public void setName(String inputname)
	{
		name = inputname;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void addWinnings(double money)
	{
		moneyWon += money;
	}
	
	public double getMoneyWon()
	{
		return moneyWon;
	}

	public void getDice()
	{
		System.out.println("Your dice are ");
		for(int i = 0; i < 5; i++)
		System.out.print(diceFace.get(i) + " ");
		
         System.out.println("\n");
	}
	
	public void getDice456()
	{
		System.out.println("Your dice are ");
		for(int i = 0; i < 2; i++)
		{
			System.out.print(diceFace.get(i) + " ");
			total += diceFace.get(i);  
		}
         System.out.println("\n");
	}
	
	public void getDice56()
	{
		System.out.println("Your dice are ");
		for(int i = 0; i < 3; i++)
		System.out.print(diceFace.get(i) + " ");
		
         System.out.println("\n");
	}
	
	public void getDice6()
	{
		System.out.println("Your dice are ");
		for(int i = 0; i < 4; i++)
		System.out.print(diceFace.get(i) + " ");
		
         System.out.println("\n");
	}
	
	public void newTurn()
	{
		ship = false;
		captain = false;
		crew = false;
	}
	
	
//action methods
	
	public void Roll()
	{
		
		//roll with all 3
            if (ship && captain && crew)
            {
            	
                 for(int i = 0; i < 2; i++)
                {
                	//System.out.println("rolling with ship cap and crew");
                    diceFace.add(i, rand.nextInt(6)+1); 
                    diceFace.set(2, 444);
                	diceFace.set(3, 555);
                	diceFace.set(4, 666);
                                      
                }
                 getDice456();
            }
            
        //roll with first 2
            if(ship && captain && !crew)
            {
            	
            	for (int i = 0; i < 3; i++)
            	{
            		//System.out.println("rolling with ship and cap");
            		diceFace.add(i,rand.nextInt(6)+1);
            		diceFace.set(3, 5);
                	diceFace.set(4, 6);
               		
            	}
            	checkForCrew();
            	getDice56();
            }
            
         //roll with first only
            if(ship && !captain && !crew)
            {
            	
            	for (int i = 0; i < 4; i++)
            	{
            		//System.out.println("rolling with ship");
            		diceFace.add(i, rand.nextInt(6)+1);
            		diceFace.set(4, 6);
              		
            	}
            	checkForCaptainCrew();
            	getDice6();
            }
            
         //roll with none
            if(!ship && !captain && ! crew)
            {
            	for(int i = 0; i < 5; i++)
                	{
            		diceFace.add(i, rand.nextInt(6)+1);
                	}
            	getDice();
            	checkDiceInitial();
            }
            
            
            System.out.println("Your score is " + total);
	}

        public void checkDiceInitial()
        {
            //check for Ship
            boolean exitShip = false;
            int i = 0;
            
            while(!exitShip)
            {
            	
                if (diceFace.get(i) == 6)
                {
                    System.out.println("You have ship!");
                    ship = true;
                    exitShip = true;  //dont know why but this has to be here
                    Collections.swap(diceFace, 4, i);                    
                }
                
                ++i;
                
                if(i == 5)
                {
                	exitShip = true;
                }
            }
            
            i = 0;
             //And then captain
               if(ship)
                  {
                    boolean exitCap = false;
            
                    while(!exitCap )
                       {
                           if (diceFace.get(i) == 5)
                           {
                        	   System.out.println("you have captain!");
                               captain = true;
                               exitCap = true; //dont know why but this has to be here
                               Collections.swap(diceFace, 3, i);
                           }
                     ++i;
                                
                     if(i == 4)
                     {
                    	 exitCap = true;
                     }
                         }
                   }
            i = 0;
            //and then crew
                if(captain)
                {
                    boolean exitCrew = false;
            
                        while(!exitCrew)
                        {
                             if (diceFace.get(i) == 4)
                            {
                                System.out.println("You have Crew!");
                                crew = true;
                                exitCrew = true; //dont know why but this has to be here
                                Collections.swap(diceFace, 2, i);
                                total += diceFace.get(0) +  diceFace.get(1);
                             }
                        ++i;
                        if(i == 3)
                        {
                        	exitCrew = true;
                        }
                      }
                }
                
                if(ship == false)
                	System.out.println("No ship");
            
        }
        
        public void checkForCaptainCrew()
        {
        	
        	int i = 0;
        	
        	//And then captain
            if(ship)
               {
                 boolean exitCap = false;
         
                 while(!exitCap )
                    {
                        if (diceFace.get(i) == 5)
                        {
                     	   System.out.println("you have captain!");
                            captain = true;
                            exitCap = true; //dont know why but this has to be here
                            Collections.swap(diceFace, 3, i);
                         }
                  ++i;
                             
                  if(i == 4)
                  {
                 	 exitCap = true;
                  }
                      }
                }
         i = 0;
         
         //and then crew
             if(captain)
             {
                 boolean exitCrew = false;
         
                     while(!exitCrew)
                     {
                          if (diceFace.get(i) == 4)
                         {
                             System.out.println("You have Crew!");
                             crew = true;
                             exitCrew = true; //dont know why but this has to be here
                             Collections.swap(diceFace, 2, i);
                             total += diceFace.get(0) +  diceFace.get(1);
                          }
                     ++i;

                     if(i == 3)
                     {
                     	exitCrew = true;
                     }
                   }
             }
        	
        }
        
       public void checkForCrew()
       {
    	   int i = 0;
    	   
           //and then crew
           if(captain)
           {
               boolean exitCrew = false;
       
                   while(!exitCrew)
                   {
                        if (diceFace.get(i) == 4)
                       {
                           System.out.println("You have Crew!");
                           crew = true;
                           exitCrew = true; //dont know why but this has to be here
                           Collections.swap(diceFace, 2, i);
                           total += diceFace.get(0) +  diceFace.get(1);
                        }
                   ++i;

                   if(i == 3)
                   {
                   	exitCrew = true;
                   }
                 }
           }
       }

}
