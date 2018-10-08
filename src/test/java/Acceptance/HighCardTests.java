package Acceptance;

import java.io.IOException;

import Model.Card;
import Model.HandsFromInputFile;
import Model.Calculator;
import junit.framework.TestCase;

public class HighCardTests extends TestCase {
	
	public void testHighCardScoring() throws IOException {
		Card[][] gameHands = HandsFromInputFile.onLineNumber(4);
		Card[] hand = gameHands[1]; //SA CQ D6 H9 S2
		
		long score = Calculator.score(hand);
		assertEquals(score, 14120906024L);
	}
	
	public void testHighCardComparator() throws IOException {
		Card[][] gameHands = HandsFromInputFile.onLineNumber(5);
		
		Card[] aipHand = gameHands[0];
		Card[] opponentHand = gameHands[1];
		
		assertTrue(Calculator.score(aipHand) > Calculator.score(opponentHand));
	}
	
}
