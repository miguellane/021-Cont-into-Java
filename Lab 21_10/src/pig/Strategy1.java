package pig;

public class Strategy1 extends Player{

	int reroll = 0;
	
	public boolean throwAgain(Player opponent){
		reroll++;
		 
		if(reroll < 3)
			return true;
		else{
			reroll = 0;
			return false;
		}
	
	}

}
