import static org.junit.Assert.*;

import org.junit.Test;


public class ScorerComboTest {
	
	// Need to test gameScore, gameIsOver, and result

	@Test
	public void testGameScore ( ) {
		int [ ] teamScore;
		teamScore = new int [ScorerCombo.MAX_BOX_SCORE_LENGTH];
		for (int k=0; k<teamScore.length; k++) {
			teamScore[k] = ScorerCombo.SENTINEL;
		}
		assertEquals (0, ScorerCombo.gameScore (teamScore));
		teamScore[0] = 5;
		assertEquals (5, ScorerCombo.gameScore (teamScore));
		teamScore[1] = 9;
		assertEquals (14, ScorerCombo.gameScore (teamScore));
		for (int k=0; k<teamScore.length; k++) {
			teamScore[k] = k;
		}
		assertEquals (teamScore.length * (teamScore.length-1)/2,
				ScorerCombo.gameScore (teamScore));
		//---------------------------------------------------------------------------------
		teamScore[0] = 0;		teamScore[1] = 0;		teamScore[3] = 0;
		assertEquals (0, ScorerCombo.gameScore (teamScore));

		teamScore[0] = 9;		teamScore[1] = 9;		teamScore[3] = 9;
		assertEquals (27, ScorerCombo.gameScore (teamScore));
		
		teamScore[0] = -6;		teamScore[1] = 6;		teamScore[3] = 0;
		assertEquals (0, ScorerCombo.gameScore (teamScore));

	}

	@Test
	public void testResult ( ) {
		ScorerCombo.MAX_BOX_SCORE_LENGTH = 3;
		ScorerCombo.REGULATION_NUM_INNINGS = 3;
		int [ ] visitors2 = {2, 0, 0, ScorerCombo.SENTINEL};
		int [ ] visitors1 = {1, 0, 0, ScorerCombo.SENTINEL};
		int [ ] home2 = {2, 0, ScorerCombo.SENTINEL, ScorerCombo.SENTINEL};
		int [ ] home1 = {1, 0, 0, ScorerCombo.SENTINEL};
		int [ ] home3 = {3, 0, 0, ScorerCombo.SENTINEL};
		// Calls result Version 1
		assertEquals ("The visiting team won 2 to 1 in 3 innings.", ScorerCombo.result (visitors2, home1));
		assertEquals ("The home team won 2 to 1 in 3 innings.", ScorerCombo.result (visitors1, home2));
		
		// Calls result Version 2
		assertEquals ("The visiting team won 2 to 1 in 3 innings.", ScorerCombo.result (ScorerCombo.innings(visitors2), ScorerCombo.gameScore(visitors2), ScorerCombo.gameScore(home1)));
		assertEquals ("The home team won 2 to 1 in 3 innings.", ScorerCombo.result (ScorerCombo.innings(visitors1), ScorerCombo.gameScore(visitors1), ScorerCombo.gameScore(home2)));
		// add your 3 tests here for result version 2
		assertEquals ("The game ended in a tie after 3 innings.", ScorerCombo.result 		(ScorerCombo.innings(visitors1), ScorerCombo.gameScore(visitors1), ScorerCombo.gameScore(home1)));
		assertEquals ("The game ended in a tie after 3 innings.", ScorerCombo.result (ScorerCombo.innings(visitors1), ScorerCombo.gameScore(visitors2), ScorerCombo.gameScore(home2)));
		assertEquals ("The home team won 3 to 1 in 3 innings.", ScorerCombo.result (ScorerCombo.innings(visitors1), ScorerCombo.gameScore(visitors1), ScorerCombo.gameScore(home3)));

	}
	
	@Test
	public void testGameIsOver ( ) {
		ScorerCombo.MAX_BOX_SCORE_LENGTH = 12;
		ScorerCombo.REGULATION_NUM_INNINGS = 9;
		int [ ] visitors2 = {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		int [ ] visitors1 = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		int [ ] home2 = {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		int [ ] home1 = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		assertEquals ("inning 8, batter 1, tied", false, ScorerCombo.gameIsOver (8, 1, visitors1, home1));
		assertEquals ("inning 8, batter 1, visitors", false, ScorerCombo.gameIsOver (8, 1, visitors2, home1));
		assertEquals ("inning 8, batter 1, home", false, ScorerCombo.gameIsOver (8, 1, visitors1, home2));
		assertEquals ("inning 8, batter 2, tied", false, ScorerCombo.gameIsOver (8, 2, visitors1, home1));
		assertEquals ("inning 8, batter 2, visitors", false, ScorerCombo.gameIsOver (8, 2, visitors2, home1));
		assertEquals ("inning 8, batter 2, home", false, ScorerCombo.gameIsOver (8, 2, visitors1, home2));
		assertEquals ("inning 9, batter 1, tied", false, ScorerCombo.gameIsOver (9, 1, visitors1, home1));
		assertEquals ("inning 9, batter 1, visitors", false, ScorerCombo.gameIsOver (9, 1, visitors2, home1));
		assertEquals ("inning 9, batter 1, home", false, ScorerCombo.gameIsOver (9, 1, visitors1, home2));
		assertEquals ("inning 9, batter 2, tied", false, ScorerCombo.gameIsOver (9, 2, visitors1, home1));
		assertEquals ("inning 9, batter 2, visitors", false, ScorerCombo.gameIsOver (9, 2, visitors2, home1));
		assertEquals ("inning 9, batter 2, home", true, ScorerCombo.gameIsOver (9, 2, visitors1, home2));
		assertEquals ("inning 10, batter 1, tied", false, ScorerCombo.gameIsOver (10, 1, visitors1, home1));
		assertEquals ("inning 10, batter 1, visitors", true, ScorerCombo.gameIsOver (10, 1, visitors2, home1));
		assertEquals ("inning 10, batter 1, home", true, ScorerCombo.gameIsOver (10, 1, visitors1, home2));
		assertEquals ("inning 10, batter 2, tied", false, ScorerCombo.gameIsOver (10, 2, visitors1, home1));
		assertEquals ("inning 10, batter 2, visitors", false, ScorerCombo.gameIsOver (10, 2, visitors2, home1));
		assertEquals ("inning 10, batter 2, home", false, ScorerCombo.gameIsOver (10, 2, visitors1, home2));
		assertEquals ("inning 11, batter 1, tied", false, ScorerCombo.gameIsOver (11, 1, visitors1, home1));
		assertEquals ("inning 11, batter 1, visitors", true, ScorerCombo.gameIsOver (11, 1, visitors2, home1));
		assertEquals ("inning 11, batter 1, home", true, ScorerCombo.gameIsOver (11, 1, visitors1, home2));
		assertEquals ("inning 11, batter 2, tied", false, ScorerCombo.gameIsOver (11, 2, visitors1, home1));
		assertEquals ("inning 11, batter 2, visitors", false, ScorerCombo.gameIsOver (11, 2, visitors2, home1));
		assertEquals ("inning 11, batter 2, home", false, ScorerCombo.gameIsOver (11, 2, visitors1, home2));
		// add your 3 tests here for gameIsOver
		assertEquals ("inning 12, batter 1, tied", false, ScorerCombo.gameIsOver (12, 1, visitors1, home1));
		assertEquals ("inning 12, batter 1, visitors", true, ScorerCombo.gameIsOver (12, 1, visitors2, home1));
		assertEquals ("inning 12, batter 1, home", true, ScorerCombo.gameIsOver (12, 1, visitors1, home2));

	}
}
