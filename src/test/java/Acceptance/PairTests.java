package Acceptance;

import java.io.IOException;
import Model.Card;
import Model.HandsFromInputFile;
import Model.Calculator;
import junit.framework.TestCase;

public class PairTests extends TestCase {
	
	public void testPairScoring() throws IOException {
		Card[][] gameHands = HandsFromInputFile.onLineNumber(6);
		Card[] hand = gameHands[0]; //DK HK HA C6 S4
		
		long score = Calculator.score(hand);
		assertEquals(113131406043L, score);
	}
	
	public void testPairComparator() throws IOException {
		Card[][] gameHands = HandsFromInputFile.onLineNumber(6);
		
		Card[] aipHand = gameHands[0];
		Card[] opponentHand = gameHands[1];
		
		assertTrue(Calculator.score(aipHand) > Calculator.score(opponentHand));
	}
	
}
