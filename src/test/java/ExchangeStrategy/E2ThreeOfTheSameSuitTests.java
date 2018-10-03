package ExchangeStrategy;

import java.util.Arrays;
import Model.Card;
import Model.ExchangeResponse;
import Strategy.Exchange;
import junit.framework.TestCase;

public class E2ThreeOfTheSameSuitTests extends TestCase {
	
	public void testThreeOfTheSameSuitDiamonds() {
		Card[] hand = new Card[5];
		hand[0] = new Card(10, 1); //10D
		hand[1] = new Card(11, 1); //JD
		hand[2] = new Card(7, 2); //7C **
		hand[3] = new Card(13, 4); //KH **
		hand[4] = new Card(14, 1); //AD
		
		ExchangeResponse response = Exchange.analyze(hand);
		assertEquals(2, response.getNumExchanges());
		assertTrue(Arrays.equals(new boolean[]{false, false, true, true, false}, response.getCardsToExchange()));
	}
	
	public void testThreeOfTheSameSuitSpades() {
		Card[] hand = new Card[5];
		hand[0] = new Card(10, 1); //10D **
		hand[1] = new Card(11, 3); //JS
		hand[2] = new Card(7, 3); //7S
		hand[3] = new Card(13, 3); //KS
		hand[4] = new Card(14, 1); //AD **
		
		ExchangeResponse response = Exchange.analyze(hand);
		assertEquals(2, response.getNumExchanges());
		assertTrue(Arrays.equals(new boolean[]{true, false, false, false, true}, response.getCardsToExchange()));
	}
	
}
