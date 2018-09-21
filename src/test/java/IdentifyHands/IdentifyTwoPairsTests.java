package IdentifyHands;

import junit.framework.TestCase;
import Model.Card;
import Strategy.HandIdentifier;

public class IdentifyTwoPairsTests extends TestCase {
	
	public void testTwoAcesTwoFives() {
		Card[] hand = new Card[5];
		hand[0] = new Card(1, 1); //AD
		hand[1] = new Card(1, 2); //AC
		hand[2] = new Card(11, 3); //JH
		hand[3] = new Card(5, 4); //5S
		hand[4] = new Card(5, 1); //5D
		
		assertTrue(HandIdentifier.isTwoPair(hand));
	}
	
	public void testTwoJacksTwoKings() {
		Card[] hand = new Card[5];
		hand[0] = new Card(1, 1); //AD
		hand[1] = new Card(11, 2); //JC
		hand[2] = new Card(11, 3); //JH
		hand[3] = new Card(13, 4); //KS
		hand[4] = new Card(13, 1); //KD
		
		assertTrue(HandIdentifier.isTwoPair(hand));
	}
	
	public void testFakeTwoPair() {
		Card[] hand = new Card[5];
		hand[0] = new Card(1, 1); //AD
		hand[1] = new Card(7, 2); //7C
		hand[2] = new Card(11, 3); //JH
		hand[3] = new Card(5, 4); //5S
		hand[4] = new Card(5, 1); //5D
		
		assertFalse(HandIdentifier.isTwoPair(hand));
	}
	
}
