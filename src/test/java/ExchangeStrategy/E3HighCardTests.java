package ExchangeStrategy;

import java.util.Arrays;
import Model.Card;
import Model.ExchangeResponse;
import Strategy.Exchange;
import junit.framework.TestCase;

public class E3HighCardTests extends TestCase {
	
	public void testHighCardKingJackExchangesThreeCards() {
		Card[] hand = new Card[5];
		hand[0] = new Card(8, 1); //8D **
		hand[1] = new Card(11, 1); //JD
		hand[2] = new Card(4, 2); //4C **
		hand[3] = new Card(13, 4); //KH
		hand[4] = new Card(6, 2); //6C **
		
		ExchangeResponse response = Exchange.analyze(hand);
		assertEquals(3, response.getNumExchanges());
		assertTrue(Arrays.equals(new boolean[]{true, false, true, false, true}, response.getCardsToExchange()));
	}
	
	public void testHighCardAceTenExchangesThreeCards() {
		Card[] hand = new Card[5];
		hand[0] = new Card(14, 1); //AD
		hand[1] = new Card(2, 1); //2D **
		hand[2] = new Card(4, 2); //4C **
		hand[3] = new Card(10, 4); //10H
		hand[4] = new Card(6, 2); //6C **
		
		ExchangeResponse response = Exchange.analyze(hand);
		assertEquals(3, response.getNumExchanges());
		assertTrue(Arrays.equals(new boolean[]{false, true, true, false, true}, response.getCardsToExchange()));
	}
	
}
