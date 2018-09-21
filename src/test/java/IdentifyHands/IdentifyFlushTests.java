package IdentifyHands;

import junit.framework.TestCase;
import Model.Card;
import Strategy.HandIdentifier;

public class IdentifyFlushTests extends TestCase {
	
	public void testDiamondsFlush() {
		HandIdentifier identifier = new HandIdentifier();
		Card[] hand = new Card[5];
		hand[0] = new Card(5, 1); //5D
		hand[1] = new Card(7, 1); //7D
		hand[2] = new Card(3, 1); //3D
		hand[3] = new Card(9, 1); //9D
		hand[4] = new Card(10, 1); //10D
		
		assertTrue(identifier.isFlush(hand));
	}
	
	public void testClubsFlush() {
		HandIdentifier identifier = new HandIdentifier();
		Card[] hand = new Card[5];
		hand[0] = new Card(5, 2); //5C
		hand[1] = new Card(7, 2); //7C
		hand[2] = new Card(3, 2); //3C
		hand[3] = new Card(9, 2); //9C
		hand[4] = new Card(10, 2); //10C
		
		assertTrue(identifier.isFlush(hand));
	}
	
	public void testHeartsFlush() {
		HandIdentifier identifier = new HandIdentifier();
		Card[] hand = new Card[5];
		hand[0] = new Card(5, 3); //5H
		hand[1] = new Card(7, 3); //7H
		hand[2] = new Card(3, 3); //3H
		hand[3] = new Card(9, 3); //9H
		hand[4] = new Card(10, 3); //10H
		
		assertTrue(identifier.isFlush(hand));
	}
	
	public void testSpadesFlush() {
		HandIdentifier identifier = new HandIdentifier();
		Card[] hand = new Card[5];
		hand[0] = new Card(5, 4); //5S
		hand[1] = new Card(7, 4); //7S
		hand[2] = new Card(3, 4); //3S
		hand[3] = new Card(9, 4); //9S
		hand[4] = new Card(10, 4); //10S
		
		assertTrue(identifier.isFlush(hand));
	}
	
	public void testFakeFlush() {
		HandIdentifier identifier = new HandIdentifier();
		Card[] hand = new Card[5];
		hand[0] = new Card(5, 3); //5H
		hand[1] = new Card(7, 4); //7S
		hand[2] = new Card(3, 2); //3C
		hand[3] = new Card(9, 1); //9D
		hand[4] = new Card(10, 4); //10S
		
		assertFalse(identifier.isFlush(hand));
	}
	
}
