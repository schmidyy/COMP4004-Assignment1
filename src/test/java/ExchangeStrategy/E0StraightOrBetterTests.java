package ExchangeStrategy;

import junit.framework.TestCase;

import java.util.Arrays;
import Model.Card;
import Model.ExchangeResponse;
import Strategy.Exchange;

public class E0StraightOrBetterTests extends TestCase {
	
	public void testRoyalFlushExchangesNoCards() {
		Card[] hand = new Card[5];
		hand[0] = new Card(10, 1); //10D
		hand[1] = new Card(11, 1); //JD
		hand[2] = new Card(12, 1); //QD
		hand[3] = new Card(13, 1); //KD
		hand[4] = new Card(1, 1); //AD
		
		ExchangeResponse response = Exchange.analyze(hand);
		assertEquals(0, response.getNumExchanges());
		assertTrue(Arrays.equals(new boolean[]{false, false, false, false, false}, response.getCardsToExchange()));
	}
	
	public void testStraightFlushExchangesNoCards() {
		Card[] hand = new Card[5];
		hand[0] = new Card(1, 1); //AD
		hand[1] = new Card(2, 1); //2D
		hand[2] = new Card(3, 1); //3D
		hand[3] = new Card(4, 1); //4D
		hand[4] = new Card(5, 1); //5D
		
		ExchangeResponse response = Exchange.analyze(hand);
		assertEquals(0, response.getNumExchanges());
		assertTrue(Arrays.equals(new boolean[]{false, false, false, false, false}, response.getCardsToExchange()));
	}
	
	public void testFourOfAKindExchangesNoCards() {
		Card[] hand = new Card[5];
		hand[0] = new Card(1, 1); //AD
		hand[1] = new Card(2, 1); //2D
		hand[2] = new Card(3, 1); //3D
		hand[3] = new Card(4, 1); //4D
		hand[4] = new Card(5, 1); //5D
		
		ExchangeResponse response = Exchange.analyze(hand);
		assertEquals(0, response.getNumExchanges());
		assertTrue(Arrays.equals(new boolean[]{false, false, false, false, false}, response.getCardsToExchange()));
	}
	
	public void testFullHouseExchangesNoCards() {
		Card[] hand = new Card[5];
		hand[0] = new Card(1, 1); //AD
		hand[1] = new Card(2, 1); //2D
		hand[2] = new Card(3, 1); //3D
		hand[3] = new Card(4, 1); //4D
		hand[4] = new Card(5, 1); //5D
		
		ExchangeResponse response = Exchange.analyze(hand);
		assertEquals(0, response.getNumExchanges());
		assertTrue(Arrays.equals(new boolean[]{false, false, false, false, false}, response.getCardsToExchange()));
	}
	
	public void testFlushExchangesNoCards() {
		Card[] hand = new Card[5];
		hand[0] = new Card(1, 1); //AD
		hand[1] = new Card(2, 1); //2D
		hand[2] = new Card(3, 1); //3D
		hand[3] = new Card(4, 1); //4D
		hand[4] = new Card(5, 1); //5D
		
		ExchangeResponse response = Exchange.analyze(hand);
		assertEquals(0, response.getNumExchanges());
		assertTrue(Arrays.equals(new boolean[]{false, false, false, false, false}, response.getCardsToExchange()));
	}
	
	public void testStraightExchangesNoCards() {
		Card[] hand = new Card[5];
		hand[0] = new Card(1, 1); //AD
		hand[1] = new Card(2, 1); //2D
		hand[2] = new Card(3, 1); //3D
		hand[3] = new Card(4, 1); //4D
		hand[4] = new Card(5, 1); //5D
		
		ExchangeResponse response = Exchange.analyze(hand);
		assertEquals(0, response.getNumExchanges());
		assertTrue(Arrays.equals(new boolean[]{false, false, false, false, false}, response.getCardsToExchange()));
	}
	
}
