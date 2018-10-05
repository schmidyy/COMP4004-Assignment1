package ExchangeStrategy;

import java.util.Arrays;
import Model.Card;
import Model.ExchangeResponse;
import Strategy.Exchange;
import junit.framework.TestCase;

public class E3OnePairTests extends TestCase {
	
	public void testPairExchangesThreeCards() {
		Card[] hand = new Card[5];
		hand[0] = new Card(18, 1); //8D **
		hand[1] = new Card(11, 1); //JD **
		hand[2] = new Card(4, 2); //4C
		hand[3] = new Card(4, 4); //4H
		hand[4] = new Card(10, 2); //10C **
		
		ExchangeResponse response = Exchange.analyze(hand);
		assertEquals(1, response.getNumExchanges());
		assertTrue(Arrays.equals(new boolean[]{false, true, false, false, false}, response.getCardsToExchange()));
	}
	
	public void testPairAcesExchangesThreeCards() {
		Card[] hand = new Card[5];
		hand[0] = new Card(14, 1); //AD
		hand[1] = new Card(11, 1); //JD **
		hand[2] = new Card(4, 2); //4C **
		hand[3] = new Card(8, 4); //8H **
		hand[4] = new Card(14, 2); //AC
		
		ExchangeResponse response = Exchange.analyze(hand);
		assertEquals(1, response.getNumExchanges());
		assertTrue(Arrays.equals(new boolean[]{false, true, false, false, false}, response.getCardsToExchange()));
	}
	
}