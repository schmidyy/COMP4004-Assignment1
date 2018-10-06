package Acceptance;

import java.io.IOException;

import Model.Card;
import Model.ExchangeResponse;
import Model.HandsFromInputFile;
import Strategy.Exchange;
import junit.framework.TestCase;

public class HighCardTests extends TestCase {
	
	public void testHighCardScoring() throws IOException {
		Card[][] gameHands = HandsFromInputFile.onLineNumber(4);
		Card[] hand = gameHands[1]; //SA CQ D6 H9 S2
		
		long score = Calculator.score(hand);
		assertEquals(score, 1412090602L);
	}
	
	public void testHighCardComparator() throws IOException {
		Card[][] gameHands = HandsFromInputFile.onLineNumber(5);
		
		Card[] aipHand = gameHands[0];
		Card[] opponentHand = gameHands[2];
		
		assertTrue(Calculator.score(aipHand) > Calculator.score(opponentHand));
	}
	
}
