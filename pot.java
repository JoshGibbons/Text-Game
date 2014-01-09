public class pot {

	public static double tablePot;
	
	public static void addToPot(double bet)
	{
		tablePot += bet;
	}
	
	public double getPot()
	{
		return tablePot;
	}
	
	public void sendToWinner(int playerNum)
	{
		game.playerArray.get(playerNum).addWinnings(tablePot);		
	}
	
}
