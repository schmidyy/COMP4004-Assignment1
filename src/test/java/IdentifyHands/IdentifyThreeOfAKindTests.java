package IdentifyHands;

import junit.framework.TestCase;
import Model.Card;
import Strategy.HandIdentifier;

public class IdentifyThreeOfAKindTests extends TestCase {
	
	public void testThreeJacks() {
		Card[] hand = new Card[5];
		hand[0] = new Card(11, 1); //JD
		hand[1] = new Card(11, 2); //JC
		hand[2] = new Card(11, 3); //JH
		hand[3] = new Card(14, 4); //AS
		hand[4] = new Card(5, 1); //5D
		
		assertTrue(HandIdentifier.isThreeOfAKind(hand));
	}
	
	public void testThreeSixes() {
		Card[] hand = new Card[5];
		hand[0] = new Card(6, 1); //6D
		hand[1] = new Card(6, 2); //6C
		hand[2] = new Card(6, 3); //6H
		hand[3] = new Card(14, 4); //AS
		hand[4] = new Card(5, 1); //5D
		
		assertTrue(HandIdentifier.isThreeOfAKind(hand));
	}
	
	public void testFakeThreeOfAKind() {
		Card[] hand = new Card[5];
		hand[0] = new Card(11, 1); //JD
		hand[1] = new Card(14, 2); //AC
		hand[2] = new Card(9, 3); //9H
		hand[3] = new Card(14, 4); //AS
		hand[4] = new Card(5, 1); //5D
		
		assertFalse(HandIdentifier.isThreeOfAKind(hand));
	}
	
}
