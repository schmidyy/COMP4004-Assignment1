package ExchangeStrategy;

import java.util.Arrays;
import Model.Card;
import Model.ExchangeResponse;
import Strategy.Exchange;
import junit.framework.TestCase;

public class E1OneAwayTests extends TestCase {
	
	public void testOneAwayFromRoyalFlushExchangesOneCard() {
		Card[] hand = new Card[5];
		hand[0] = new Card(10, 1); //10D
		hand[1] = new Card(11, 1); //JD
		hand[2] = new Card(7, 2); //7C **
		hand[3] = new Card(13, 1); //KD
		hand[4] = new Card(1, 1); //AD
		
		ExchangeResponse response = Exchange.analyze(hand);
		assertEquals(1, response.getNumExchanges());
		assertTrue(Arrays.equals(new boolean[]{false, false, true, false, false}, response.getCardsToExchange()));
	}
	
	public void testOneAwayFromStraightFlushExchangesOneCard() {
		Card[] hand = new Card[5];
		hand[0] = new Card(1, 1); //AD
		hand[1] = new Card(2, 1); //2D
		hand[2] = new Card(3, 1); //3D
		hand[3] = new Card(4, 1); //4D
		hand[4] = new Card(8, 2); //8C **
		
		ExchangeResponse response = Exchange.analyze(hand);
		assertEquals(1, response.getNumExchanges());
		assertTrue(Arrays.equals(new boolean[]{false, false, false, false, true}, response.getCardsToExchange()));
	}
	
	public void testOneAwayFromFullHouseExchangesOneCard() {
		Card[] hand = new Card[5];
		hand[0] = new Card(13, 1); //KD
		hand[1] = new Card(13, 2); //KC
		hand[2] = new Card(13, 3); //KH
		hand[3] = new Card(5, 4); //5S
		hand[4] = new Card(1, 1); //AD **
		
		ExchangeResponse response = Exchange.analyze(hand);
		assertEquals(1, response.getNumExchanges());
		assertTrue(Arrays.equals(new boolean[]{false, false, false, false, true}, response.getCardsToExchange()));
	}
	
	public void testOneAwayFromFlushExchangesOneCard() {
		Card[] hand = new Card[5];
		hand[0] = new Card(5, 1); //5D
		hand[1] = new Card(7, 1); //7D
		hand[2] = new Card(3, 2); //3C **
		hand[3] = new Card(9, 1); //9D
		hand[4] = new Card(10, 1); //10D
		
		ExchangeResponse response = Exchange.analyze(hand);
		assertEquals(1, response.getNumExchanges());
		assertTrue(Arrays.equals(new boolean[]{false, false, true, false, false}, response.getCardsToExchange()));
	}
	
	public void testOneAwayFromStraightExchangesOneCard() {
		Card[] hand = new Card[5];
		hand[0] = new Card(2, 1); //2D ***
		hand[1] = new Card(7, 3); //7H
		hand[2] = new Card(8, 2); //8C
		hand[3] = new Card(9, 2); //9C
		hand[4] = new Card(10, 1); //10D
		
		ExchangeResponse response = Exchange.analyze(hand);
		assertEquals(1, response.getNumExchanges());
		assertTrue(Arrays.equals(new boolean[]{true, false, false, false, false}, response.getCardsToExchange()));
	}
	
}
