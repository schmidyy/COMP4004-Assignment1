package Acceptance;

import java.io.IOException;
import Model.Card;
import Model.HandsFromInputFile;
import Strategy.Exchange;
import Model.Calculator;
import junit.framework.TestCase;

public class WinningTests extends TestCase {
	
	public void testRoyalFlushBeatsEveryHand() throws IOException {
		Card[] royalFlushHand = HandsFromInputFile.onLineNumber(1)[0];
		Card[][] straightFlushGame = HandsFromInputFile.onLineNumber(2);
		Card[] straightFlushHand = Exchange.exchange(straightFlushGame[0], straightFlushGame[2]);
		Card[] fourOfAKindHand = HandsFromInputFile.onLineNumber(1)[1];
		
		assertTrue(Calculator.score(royalFlushHand) > Calculator.score(straightFlushHand));
		assertTrue(Calculator.score(royalFlushHand) > Calculator.score(fourOfAKindHand));
	}
	
	public void testStraightFlushBeatsAllButRF() throws IOException {
		Card[] royalFlushHand = HandsFromInputFile.onLineNumber(1)[0];
		Card[][] straightFlushGame = HandsFromInputFile.onLineNumber(2);
		Card[] straightFlushHand = Exchange.exchange(straightFlushGame[0], straightFlushGame[2]);
		Card[] fourOfAKindHand = HandsFromInputFile.onLineNumber(1)[1];
		Card[] fullHouseHand = HandsFromInputFile.onLineNumber(7)[0];
		
		assertFalse(Calculator.score(straightFlushHand) > Calculator.score(royalFlushHand));
		assertTrue(Calculator.score(straightFlushHand) > Calculator.score(fourOfAKindHand));
		assertTrue(Calculator.score(straightFlushHand) > Calculator.score(fullHouseHand));
	}
	
	public void testFourOfAKindBeatsAllButRFandSF() throws IOException {
		Card[] royalFlushHand = HandsFromInputFile.onLineNumber(1)[0];
		Card[][] straightFlushGame = HandsFromInputFile.onLineNumber(2);
		Card[] straightFlushHand = Exchange.exchange(straightFlushGame[0], straightFlushGame[2]);
		Card[] fourOfAKindHand = HandsFromInputFile.onLineNumber(1)[1];
		Card[] fullHouseHand = HandsFromInputFile.onLineNumber(7)[0];
		Card[] flushHand = HandsFromInputFile.onLineNumber(7)[1];
		
		assertFalse(Calculator.score(fourOfAKindHand) > Calculator.score(royalFlushHand));
		assertFalse(Calculator.score(fourOfAKindHand) > Calculator.score(straightFlushHand));
		assertTrue(Calculator.score(fourOfAKindHand) > Calculator.score(fullHouseHand));
		assertTrue(Calculator.score(fourOfAKindHand) > Calculator.score(flushHand));
	}
	
	public void testFullHouseBeatsAllButRFSFand4K() throws IOException {
		Card[][] straightFlushGame = HandsFromInputFile.onLineNumber(2);
		Card[] straightFlushHand = Exchange.exchange(straightFlushGame[0], straightFlushGame[2]);
		Card[] fourOfAKindHand = HandsFromInputFile.onLineNumber(1)[1];
		Card[] fullHouseHand = HandsFromInputFile.onLineNumber(7)[0];
		Card[] flushHand = HandsFromInputFile.onLineNumber(7)[1];
		Card[] straightHand = HandsFromInputFile.onLineNumber(8)[0];
		
		assertFalse(Calculator.score(fullHouseHand) > Calculator.score(straightFlushHand));
		assertFalse(Calculator.score(fullHouseHand) > Calculator.score(fourOfAKindHand));
		assertTrue(Calculator.score(fullHouseHand) > Calculator.score(flushHand));
		assertTrue(Calculator.score(fullHouseHand) > Calculator.score(straightHand));
	}
	
	public void testFlushBeatsAllButAboveHands() throws IOException {
		Card[] fourOfAKindHand = HandsFromInputFile.onLineNumber(1)[1];
		Card[] fullHouseHand = HandsFromInputFile.onLineNumber(7)[0];
		Card[] flushHand = HandsFromInputFile.onLineNumber(7)[1];
		Card[] straightHand = HandsFromInputFile.onLineNumber(8)[0];
		Card[] threeOfAKindHand = HandsFromInputFile.onLineNumber(8)[1];
		
		assertFalse(Calculator.score(flushHand) > Calculator.score(fourOfAKindHand));
		assertFalse(Calculator.score(flushHand) > Calculator.score(fullHouseHand));
		assertTrue(Calculator.score(flushHand) > Calculator.score(straightHand));
		assertTrue(Calculator.score(flushHand) > Calculator.score(threeOfAKindHand));
	}
	
	public void testStraightBeatsAllButAboveHands() throws IOException {
		Card[] fullHouseHand = HandsFromInputFile.onLineNumber(7)[0];
		Card[] flushHand = HandsFromInputFile.onLineNumber(7)[1];
		Card[] straightHand = HandsFromInputFile.onLineNumber(8)[0];
		Card[] threeOfAKindHand = HandsFromInputFile.onLineNumber(8)[1];
		Card[] twoPairHand = HandsFromInputFile.onLineNumber(9)[0];
		
		assertFalse(Calculator.score(straightHand) > Calculator.score(fullHouseHand));
		assertFalse(Calculator.score(straightHand) > Calculator.score(flushHand));
		assertTrue(Calculator.score(straightHand) > Calculator.score(threeOfAKindHand));
		assertTrue(Calculator.score(straightHand) > Calculator.score(twoPairHand));
	}

	public void testThreeOfAKindBeats2PPairAndNothingElse() throws IOException {
		Card[] flushHand = HandsFromInputFile.onLineNumber(7)[1];
		Card[] straightHand = HandsFromInputFile.onLineNumber(8)[0];
		Card[] threeOfAKindHand = HandsFromInputFile.onLineNumber(8)[1];
		Card[] twoPairHand = HandsFromInputFile.onLineNumber(9)[0];
		Card[] pairHand = HandsFromInputFile.onLineNumber(9)[1];
		
		assertFalse(Calculator.score(threeOfAKindHand) > Calculator.score(flushHand));
		assertFalse(Calculator.score(threeOfAKindHand) > Calculator.score(straightHand));
		assertTrue(Calculator.score(threeOfAKindHand) > Calculator.score(twoPairHand));
		assertTrue(Calculator.score(threeOfAKindHand) > Calculator.score(pairHand));
	}
	
	public void test2PairBeatsPairHCAndNothingElse() throws IOException {
		Card[] straightHand = HandsFromInputFile.onLineNumber(8)[0];
		Card[] threeOfAKindHand = HandsFromInputFile.onLineNumber(8)[1];
		Card[] twoPairHand = HandsFromInputFile.onLineNumber(9)[0];
		Card[] pairHand = HandsFromInputFile.onLineNumber(9)[1];
		Card[] highCardHand = HandsFromInputFile.onLineNumber(4)[1];
		
		assertFalse(Calculator.score(twoPairHand) > Calculator.score(straightHand));
		assertFalse(Calculator.score(twoPairHand) > Calculator.score(threeOfAKindHand));
		assertTrue(Calculator.score(twoPairHand) > Calculator.score(pairHand));
		assertTrue(Calculator.score(threeOfAKindHand) > Calculator.score(highCardHand));
	}
	
	public void testPairBeatsHighCardAndNothingElse() throws IOException {
		Card[] threeOfAKindHand = HandsFromInputFile.onLineNumber(8)[1];
		Card[] twoPairHand = HandsFromInputFile.onLineNumber(9)[0];
		Card[] pairHand = HandsFromInputFile.onLineNumber(9)[1];
		Card[] highCardHand = HandsFromInputFile.onLineNumber(4)[1];
		
		assertFalse(Calculator.score(pairHand) > Calculator.score(threeOfAKindHand));
		assertFalse(Calculator.score(pairHand) > Calculator.score(twoPairHand));
		assertTrue(Calculator.score(pairHand) > Calculator.score(highCardHand));
	}
}
