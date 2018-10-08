package Acceptance;

import java.io.IOException;
import Model.Card;
import Model.HandsFromInputFile;
import Strategy.Exchange;
import Model.Calculator;
import junit.framework.TestCase;

public class BoundaryTests extends TestCase {
	
	public void testHighestSuitRoyalFlushWins() throws IOException {
		Card[] spadesRoyalFlushHand = HandsFromInputFile.onLineNumber(1)[0];
		Card[] clubsRoyalFlushHand = HandsFromInputFile.onLineNumber(10)[0];
		
		long score1 = Calculator.score(spadesRoyalFlushHand);
		long score2 = Calculator.score(clubsRoyalFlushHand);
		
		assertTrue(score1 > score2);
	}
	
	public void testHighestStraightFlushWins() throws IOException {
		Card[] sixHighStraightFlush = HandsFromInputFile.onLineNumber(17)[1];
		Card[] tenHighStraightFlush = HandsFromInputFile.onLineNumber(10)[1];
		
		long score1 = Calculator.score(tenHighStraightFlush);
		long score2 = Calculator.score(sixHighStraightFlush);
		
		assertTrue(score1 > score2);
	}
	
	public void testStraightFlushHighestSuitWins() throws IOException {
		Card[] tenHighStraightFlushHearts = HandsFromInputFile.onLineNumber(10)[1];
		Card[] tenHighStraightFlushSpades = HandsFromInputFile.onLineNumber(11)[0];
		
		long score1 = Calculator.score(tenHighStraightFlushSpades);
		long score2 = Calculator.score(tenHighStraightFlushHearts);
		
		assertTrue(score1 > score2);
	}
	
	public void testHighestFourOfAKindWins() throws IOException {
		Card[] nineFourOfAKind = HandsFromInputFile.onLineNumber(1)[1];
		Card[] fourFourOFAKind = HandsFromInputFile.onLineNumber(11)[1];
		
		long score1 = Calculator.score(nineFourOfAKind);
		long score2 = Calculator.score(fourFourOFAKind);
		
		assertTrue(score1 > score2);
	}
	
	public void testHighestTripletInFHWins() throws IOException {
		Card[] eightTripletFH = HandsFromInputFile.onLineNumber(7)[0];
		Card[] sixTripletFH = HandsFromInputFile.onLineNumber(12)[0];
		
		long score1 = Calculator.score(eightTripletFH);
		long score2 = Calculator.score(sixTripletFH);
		
		assertTrue(score1 > score2);
	}
	
	public void testHighestTripletWins() throws IOException {
		Card[] jackTriplet = HandsFromInputFile.onLineNumber(8)[1];
		Card[] threeTriplet = HandsFromInputFile.onLineNumber(12)[1];
		
		long score1 = Calculator.score(jackTriplet);
		long score2 = Calculator.score(threeTriplet);
		
		assertTrue(score1 > score2);
	}
	
	public void testHighestSuitedStraightWins() throws IOException {
		Card[] eightClubsHighStraight = HandsFromInputFile.onLineNumber(8)[0];
		Card[] eightSpadesHighStraight = HandsFromInputFile.onLineNumber(13)[0];
		
		long score1 = Calculator.score(eightSpadesHighStraight);
		long score2 = Calculator.score(eightClubsHighStraight);
		
		assertTrue(score1 > score2);
	}
	
	public void testHighestRankedStraightWins() throws IOException {
		Card[] eightHighStraight = HandsFromInputFile.onLineNumber(8)[0];
		Card[] queenHighStraight = HandsFromInputFile.onLineNumber(13)[1];
		
		long score1 = Calculator.score(queenHighStraight);
		long score2 = Calculator.score(eightHighStraight);
		
		assertTrue(score1 > score2);
	}
	
	public void testHighestSuitedTwoPairWins() throws IOException {
		Card[] queenEightTwoPair = HandsFromInputFile.onLineNumber(9)[0];
		Card[] jackTenTwoPair = HandsFromInputFile.onLineNumber(14)[0];
		
		long score1 = Calculator.score(queenEightTwoPair);
		long score2 = Calculator.score(jackTenTwoPair);
		
		assertTrue(score1 > score2);
	}
	
	public void testHighestRankedTwoPairWins() throws IOException {
		Card[] queenEightTwoPair = HandsFromInputFile.onLineNumber(9)[0];
		Card[] jackTenTwoPair = HandsFromInputFile.onLineNumber(14)[0];
		
		long score1 = Calculator.score(queenEightTwoPair);
		long score2 = Calculator.score(jackTenTwoPair);
		
		assertTrue(score1 > score2);
	}
	
	public void testHighestSuitedPairWins() throws IOException {
		Card[] kingPair = HandsFromInputFile.onLineNumber(6)[0];
		Card[] ninePair = HandsFromInputFile.onLineNumber(9)[1];
		
		long score1 = Calculator.score(kingPair);
		long score2 = Calculator.score(ninePair);
		
		assertTrue(score1 > score2);
	}
	
	public void testHighestRankedPairWins() throws IOException {
		Card[] kingPair = HandsFromInputFile.onLineNumber(6)[0];
		Card[] ninePair = HandsFromInputFile.onLineNumber(9)[1];
		
		long score1 = Calculator.score(kingPair);
		long score2 = Calculator.score(ninePair);
		
		assertTrue(score1 > score2);
	}
	
	public void testHighestSuitedHighCardWins() throws IOException {
		Card[] aceSpadesHighCard = HandsFromInputFile.onLineNumber(4)[1];
		Card[] aceDiamondsHighCard = HandsFromInputFile.onLineNumber(5)[1];
		
		long score1 = Calculator.score(aceSpadesHighCard);
		long score2 = Calculator.score(aceDiamondsHighCard);
		
		assertTrue(score1 > score2);
	}
	
	public void testHighestRankedHighCardWins() throws IOException {
		Card[] aceHighCard = HandsFromInputFile.onLineNumber(4)[1];
		Card[] jackHighCard = HandsFromInputFile.onLineNumber(5)[1];
		
		long score1 = Calculator.score(aceHighCard);
		long score2 = Calculator.score(jackHighCard);
		
		assertTrue(score1 > score2);
	}
	
	public void testSameRankedFlushHighestSuitWins() throws IOException {
		Card[] aceSpadesHighFlush= HandsFromInputFile.onLineNumber(7)[1];
		Card[] aceDiamondsHighFlush = HandsFromInputFile.onLineNumber(15)[0];
		
		long score1 = Calculator.score(aceSpadesHighFlush);
		long score2 = Calculator.score(aceDiamondsHighFlush);
		
		assertTrue(score1 > score2);
	}
	
	public void testSameFlushExcpetLowestOneCard() throws IOException {
		Card[] lowestCardThreeFlush = HandsFromInputFile.onLineNumber(15)[0];
		Card[] lowestCardTwoFlush= HandsFromInputFile.onLineNumber(15)[1];
		
		long score1 = Calculator.score(lowestCardThreeFlush);
		long score2 = Calculator.score(lowestCardTwoFlush);
		
		assertTrue(score1 > score2);
	}
	
	public void testSameFlushExcpetLowestTwoCard() throws IOException {
		Card[] secondLowestCardEightFlush = HandsFromInputFile.onLineNumber(15)[0];
		Card[] secondLowestCardSixFlush= HandsFromInputFile.onLineNumber(16)[0];
		
		long score1 = Calculator.score(secondLowestCardEightFlush);
		long score2 = Calculator.score(secondLowestCardSixFlush);
		
		assertTrue(score1 > score2);
	}
	
	public void testSameFlushExcpetLowestThreeCard() throws IOException {
		Card[] thirdLowestCardNineFlush = HandsFromInputFile.onLineNumber(15)[0];
		Card[] thirdLowestCardSixFlush= HandsFromInputFile.onLineNumber(16)[1];
		
		long score1 = Calculator.score(thirdLowestCardNineFlush);
		long score2 = Calculator.score(thirdLowestCardSixFlush);
		
		assertTrue(score1 > score2);
	}
	
	public void testSameFlushExcpetLowestFourCard() throws IOException {
		Card[] fourthLowestCardTenFlush = HandsFromInputFile.onLineNumber(15)[0];
		Card[] fourthLowestCardJackFlush= HandsFromInputFile.onLineNumber(17)[0];
		
		long score1 = Calculator.score(fourthLowestCardJackFlush);
		long score2 = Calculator.score(fourthLowestCardTenFlush);
		
		assertTrue(score1 > score2);
	}
}
