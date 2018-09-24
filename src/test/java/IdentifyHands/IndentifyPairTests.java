package IdentifyHands;

import junit.framework.TestCase;
import Model.Card;
import Strategy.HandIdentifier;

public class IndentifyPairTests extends TestCase {
	
	public void testPairOfAces() {
		Card[] hand = new Card[5];
		hand[0] = new Card(14, 1); //AD
		hand[1] = new Card(14, 2); //AC
		hand[2] = new Card(11, 3); //JH
		hand[3] = new Card(7, 4); //7S
		hand[4] = new Card(5, 1); //5D
		
		assertTrue(HandIdentifier.isPair(hand));
	}
	
	public void testPairOfSevens() {
		Card[] hand = new Card[5];
		hand[0] = new Card(14, 1); //AD
		hand[1] = new Card(7, 2); //7C
		hand[2] = new Card(11, 3); //JH
		hand[3] = new Card(7, 4); //7S
		hand[4] = new Card(5, 1); //5D
		
		assertTrue(HandIdentifier.isPair(hand));
	}
	
	public void testFakePair() {
		Card[] hand = new Card[5];
		hand[0] = new Card(14, 1); //AD
		hand[1] = new Card(7, 2); //7C
		hand[2] = new Card(11, 3); //JH
		hand[3] = new Card(6, 4); //6S
		hand[4] = new Card(5, 1); //5D
		
		assertFalse(HandIdentifier.isPair(hand));
	}
	
}
