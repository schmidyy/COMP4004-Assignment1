package IdentifyHands;

import junit.framework.TestCase;
import Model.Card;
import Strategy.HandIdentifier;

public class IdentifyRoyalFlushTests extends TestCase {
	
	public void testDiamondsRoyalFlush() {
		Card[] hand = new Card[5];
		hand[0] = new Card(10, 1); //10D
		hand[1] = new Card(11, 1); //JD
		hand[2] = new Card(12, 1); //QD
		hand[3] = new Card(13, 1); //KD
		hand[4] = new Card(14, 1); //AD
		
		assertTrue(HandIdentifier.isRoyalFlush(hand));
	}
	
	public void testClubsRoyalFlush() {
		Card[] hand = new Card[5];
		hand[0] = new Card(10, 2); //10C
		hand[1] = new Card(11, 2); //JC
		hand[2] = new Card(12, 2); //QC
		hand[3] = new Card(13, 2); //KC
		hand[4] = new Card(14, 2); //AC
		
		assertTrue(HandIdentifier.isRoyalFlush(hand));
	}
	
	public void testHeartsRoyalFlush() {
		Card[] hand = new Card[5];
		hand[0] = new Card(10, 3); //10H
		hand[1] = new Card(11, 3); //JH
		hand[2] = new Card(12, 3); //QH
		hand[3] = new Card(13, 3); //KH
		hand[4] = new Card(14, 3); //AH
		
		assertTrue(HandIdentifier.isRoyalFlush(hand));
	}
	
	public void testSpadesRoyalFlush() {
		Card[] hand = new Card[5];
		hand[0] = new Card(10, 4); //10S
		hand[1] = new Card(11, 4); //JS
		hand[2] = new Card(12, 4); //QS
		hand[3] = new Card(13, 4); //KS
		hand[4] = new Card(14, 4); //AS
		
		assertTrue(HandIdentifier.isRoyalFlush(hand));
	}
	
	public void test10toAStraightNotRoyal() {
		Card[] hand = new Card[5];
		hand[0] = new Card(10, 3); //10H
		hand[1] = new Card(11, 4); //JS
		hand[2] = new Card(12, 2); //QC
		hand[3] = new Card(13, 1); //KD
		hand[4] = new Card(14, 4); //AS
		
		assertFalse(HandIdentifier.isRoyalFlush(hand));
	}
	
	public void testFlushNotRoyal() {
		Card[] hand = new Card[5];
		hand[0] = new Card(10, 4); //10S
		hand[1] = new Card(11, 4); //JS
		hand[2] = new Card(4, 4); //4S
		hand[3] = new Card(13, 4); //KS
		hand[4] = new Card(14, 4); //AS
		
		assertFalse(HandIdentifier.isRoyalFlush(hand));
	}
	
}
