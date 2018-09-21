package IdentifyHands;

import junit.framework.TestCase;
import Model.Card;
import Strategy.HandIdentifier;

public class IdentifyFullHouseTests extends TestCase {
	
	public void testThreeAcesTwoKings() {
		Card[] hand = new Card[5];
		hand[0] = new Card(1, 1); //AD
		hand[1] = new Card(1, 2); //AC
		hand[2] = new Card(1, 3); //AH
		hand[3] = new Card(13, 4); //KS
		hand[4] = new Card(13, 1); //KD
		
		assertTrue(HandIdentifier.isFullHouse(hand));
	}
	
	public void testThreeKingsTwoAces() {
		Card[] hand = new Card[5];
		hand[0] = new Card(13, 1); //KD
		hand[1] = new Card(13, 2); //KC
		hand[2] = new Card(13, 3); //KH
		hand[3] = new Card(1, 4); //AS
		hand[4] = new Card(1, 1); //AD
		
		assertTrue(HandIdentifier.isFullHouse(hand));
	}
	
	public void testFakeFullHouse() {
		Card[] hand = new Card[5];
		hand[0] = new Card(13, 1); //KD
		hand[1] = new Card(9, 2); //9C
		hand[2] = new Card(3, 3); //3H
		hand[3] = new Card(1, 4); //AS
		hand[4] = new Card(1, 1); //AD
		
		assertFalse(HandIdentifier.isFullHouse(hand));
	}
	
}
