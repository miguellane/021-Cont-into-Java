package pig;

public class Strategy2 extends Player{

	int reroll = 0;
	
	public boolean throwAgain(Player opponent){
		reroll++;
		 
		if(reroll < 7)
			return true;
		else{
			reroll = 0;
			return false;
		}
	
	}

}
