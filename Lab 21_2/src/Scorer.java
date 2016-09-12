import java.util.Scanner;

public class Scorer {
	
	private static int visitorScore;
	private static int homeScore;
	private static int inning;
	private static int batter;

	public static void initialize ( ) {
			visitorScore = 0;
			homeScore = 0;
			inning = 0;
			batter = 1;
	}

	public static void readScores (Scanner scores) {
		while (!gameIsOver ( )) {
			if(batter == 1){
				visitorScore += scores.nextInt();
				batter++;
			}
			else{
				homeScore += scores.nextInt();
				batter--;
				inning++;
			}
			
			
			
			if(inning >= 8 && batter != 1 && homeScore > visitorScore)
				gameIsOver();
			else if(inning >= 8 && homeScore > visitorScore)
				gameIsOver();
		}
	}
	
	public static boolean gameIsOver ( ) {
		if(inning > 9){
			if(batter == 1)
				if(homeScore != visitorScore)
					return true;
		else if(inning == 9)
			if(batter == 2)
				if(homeScore > visitorScore)
					return true;
		}
		return false;
	}
	
	public static String result ( ) {
		if (visitorScore > homeScore) {
			return "The visiting team won " 
					+ visitorScore + " to " + homeScore
					+ " in " + (inning - 1) + " innings.";
		} 
		if (batter == 1) {
			return "The home team won " 
					+ homeScore + " to " + visitorScore
					+ " in " + (inning -1) + " innings.";
		} 
		if (batter == 2) {
			return "The home team won " 
					+ homeScore + " to " + visitorScore
					+ " in " + inning + " innings.";
		}
		return "";
	}

	public static void main (String [ ] args) {

		System.out.print("Enter the baseball inning scores: ");
		initialize();
		// Testing initialize 
		// System.out.println("Initialize called. VisitorScore: " + visitorScore + ", homeScore: " + homeScore + ", inning: " + inning + ", batter: " + batter);
		readScores (new Scanner (System.in));
		System.out.println (result ( ));	

		
	}
}