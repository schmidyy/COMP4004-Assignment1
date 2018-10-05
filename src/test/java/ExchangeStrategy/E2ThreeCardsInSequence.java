package ExchangeStrategy;

import java.util.Arrays;
import Model.Card;
import Model.ExchangeResponse;
import Strategy.Exchange;
import junit.framework.TestCase;

public class E2ThreeCardsInSequence extends TestCase {
	
	public void testSequenceOfThreeMidRangeExchangesTwoCards() {
		Card[] hand = new Card[5];
		hand[0] = new Card(10, 1); //10D
		hand[1] = new Card(11, 1); //JD
		hand[2] = new Card(4, 2); //4C **
		hand[3] = new Card(9, 4); //9H
		hand[4] = new Card(14, 2); //AC **
		
		ExchangeResponse response = Exchange.analyze(hand);
		assertEquals(2, response.getNumExchanges());
		assertTrue(Arrays.equals(new boolean[]{false, false, true, false, true}, response.getCardsToExchange()));
	}
	
	public void testSequenceOfThreeLowRangeExchangesTwoCards() {
		Card[] hand = new Card[5];
		hand[0] = new Card(10, 1); //10D **
		hand[1] = new Card(11, 1); //JD **
		hand[2] = new Card(4, 2); //4C
		hand[3] = new Card(3, 4); //3H
		hand[4] = new Card(2, 2); //2C
		
		ExchangeResponse response = Exchange.analyze(hand);
		assertEquals(2, response.getNumExchanges());
		assertTrue(Arrays.equals(new boolean[]{true, true, false, false, false}, response.getCardsToExchange()));
	}
	
}
