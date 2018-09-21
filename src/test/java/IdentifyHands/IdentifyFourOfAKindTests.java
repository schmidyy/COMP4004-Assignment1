package IdentifyHands;

import junit.framework.TestCase;
import Model.Card;
import Strategy.HandIdentifier;

public class IdentifyFourOfAKindTests extends TestCase {
	
	public void testFourAces() {
		Card[] hand = new Card[5];
		hand[0] = new Card(1, 1); //AD
		hand[1] = new Card(1, 2); //AC
		hand[2] = new Card(1, 3); //AH
		hand[3] = new Card(1, 4); //AS
		hand[4] = new Card(5, 1); //5D
		
		assertTrue(HandIdentifier.isFourOfAKind(hand));
	}
	
	public void testFourFours() {
		Card[] hand = new Card[5];
		hand[0] = new Card(4, 1); //4D
		hand[1] = new Card(4, 2); //4C
		hand[2] = new Card(4, 3); //4H
		hand[3] = new Card(4, 4); //4S
		hand[4] = new Card(5, 1); //5D
		
		assertTrue(HandIdentifier.isFourOfAKind(hand));
	}
	
	public void testFourKings() {
		Card[] hand = new Card[5];
		hand[0] = new Card(13, 1); //KD
		hand[1] = new Card(13, 2); //KC
		hand[2] = new Card(13, 3); //KH
		hand[3] = new Card(13, 4); //KS
		hand[4] = new Card(5, 1); //5D
		
		assertTrue(HandIdentifier.isFourOfAKind(hand));
	}
	
	public void testFakeFourOfAKind() {
		Card[] hand = new Card[5];
		hand[0] = new Card(11, 1); //JD
		hand[1] = new Card(5, 2); //5C
		hand[2] = new Card(3, 3); //3H
		hand[3] = new Card(1, 4); //AS
		hand[4] = new Card(5, 1); //5D
		
		assertFalse(HandIdentifier.isFourOfAKind(hand));
	}
	
}
