import java.util.Scanner;

public class ScorerArr {
	
	private static int[] visitorScores;
	private static int[] homeScores;
	private static int inning;
	private static int batter;
	// the number of innings in a regulation game (after which only tie scores continue)
	// in MLB, this is 9.  A smaller number will make manual testing easier.
	public static final int REGULATION_NUM_INNINGS = 9;
	// assume game can never go over this number of innings (used when allocating arrays)
	public static final int MAX_BOX_SCORE_LENGTH = 20;
	// value in a boxScore: an indicator that a half-inning hasn't been played yet
	// this need to be distinguishable from a baseball score
	private static final int SENTINEL = -999;

	public static void initialize ( ) {
		visitorScores = new int[MAX_BOX_SCORE_LENGTH];
		homeScores = new int[MAX_BOX_SCORE_LENGTH];
		for(int i = 0; i < MAX_BOX_SCORE_LENGTH; i++){
			visitorScores[i] = SENTINEL;
			homeScores[i] = SENTINEL;
		}
		inning = 1;
		batter = 1;
	}

	// Read the scores for each half of each inning until the end of the game.
	// The scanner returns first the visiting team's score in the first half
	// of the first inning, then the home team's score in the second half of 
	// the first inning, then the visiting team's score in the first half of 
	// second inning, and so on. If the game is over, no more values remain 
	// to be returned from the scanner.
	// The return value is 1 if the visiting team wins the game and 2 if the 
	// home team wins. 
	// *** You supply the body of the while loop.
	public static void readScores(Scanner scores) {
		while (!gameIsOver ( )) {
			//System.out.println("in Read Scores");
			if(batter == 1){
				visitorScores[inning - 1] = scores.nextInt();
				batter++;
			}
			else{
				homeScores[inning - 1] = scores.nextInt();
				batter--;
				inning++;
			}
			gameIsOver();
		}
	}
	
	
	public static int gameScore(int[] teamBoxScore) {
		int output = 0;
		for (int v : teamBoxScore) {
			if (v != SENTINEL) {
				output += v;
			}
		}
		return output;
	}
	
	// Determine if the game is over, that is, either we've played
	// at least nine complete innings and the score isn't tied,
	// or eight-and-a-half innings and the home team is ahead.0
	// batter contains 1 if the visitors are about to bat (and thus
	// we've completed both halves of the inning), and contains 2 
	// if the home team is about to bat (and thus we've completed
	// only the first half of the inning).

	public static boolean gameIsOver ( ) {
		// Generic expression based on REGULATION_NUM_INNINGS so shorter games can be tested
		return (inning > REGULATION_NUM_INNINGS && batter == 1 && gameScore(visitorScores) != gameScore(homeScores))
		|| (inning == REGULATION_NUM_INNINGS && batter == 2 && gameScore(visitorScores) < gameScore(homeScores));
	}
	
	// Print out the Boxscore for each valid half inning in the teamBoxScore array
	public static void printBoxScore(int[] teamBoxScore) {
		for(int v : teamBoxScore){
			if(v != SENTINEL)
				System.out.print(v);
		}
	}
	
	// The game is over. Return a string that describes the outcome.
	// *** You replace the strings of underscores. 
	public static String result ( ) {
		System.out.print(" Visitor: ");
		printBoxScore(visitorScores);
		System.out.println();
		System.out.print("    Home: ");
		printBoxScore(homeScores);
		System.out.println();
		
		if (gameScore(visitorScores) > gameScore(homeScores)) {
			return "The visiting team won " 
					+ gameScore(visitorScores) + " to " + gameScore(homeScores)
					+ " in " + (inning - 1) + " innings.";
		} 
		if (batter == 1) {
			return "The home team won " 
					+ gameScore(homeScores) + " to " + gameScore(visitorScores)
					+ " in " + (inning - 1) + " innings.";
		} 
		if (batter == 2) {
			return "The home team won " 
					+ gameScore(homeScores) + " to " + gameScore(visitorScores)
					+ " in " + inning + " innings.";
		}
		return "";
	}

	
	// *** Main calls initialize, then calls readScores, then calls result
	// *** and prints the result of the game. It has been filled in for you similar to Lab 2
	public static void main (String [ ] args) {
		System.out.print("Enter the baseball inning scores: ");

		initialize ( );
		readScores (new Scanner (System.in));
		System.out.println (result ( ));
		
		// This can be uncommented to test whether your arrays have been set correctly
/*		for (int v : visitorScores)
			System.out.print(v + " ");
		System.out.println();
		for (int v : homeScores)
			System.out.print(v + " ");
		System.out.println();  
		0 2 0 0 0 0 0 0 1 0 0 0 3 0 0 0 0 1
*/

	}
}