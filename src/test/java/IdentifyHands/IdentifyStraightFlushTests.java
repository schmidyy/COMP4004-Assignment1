package IdentifyHands;

import junit.framework.TestCase;
import Model.Card;
import Strategy.HandIdentifier;

public class IdentifyStraightFlushTests extends TestCase {
	
	public void testAto5StraightFlush() {
		Card[] hand = new Card[5];
		hand[0] = new Card(1, 1); //AD
		hand[1] = new Card(2, 1); //2D
		hand[2] = new Card(3, 1); //3D
		hand[3] = new Card(4, 1); //4D
		hand[4] = new Card(5, 1); //5D
		
		assertTrue(HandIdentifier.isStraightFlush(hand));
	}
	
	public void testMidRangeStraightFlush() {
		Card[] hand = new Card[5];
		hand[0] = new Card(6, 3); //6H
		hand[1] = new Card(7, 3); //7H
		hand[2] = new Card(8, 3); //8H
		hand[3] = new Card(9, 3); //9H
		hand[4] = new Card(10, 3); //10H
		
		assertTrue(HandIdentifier.isStraightFlush(hand));
	}
	
	public void testFlushButNotStraight() {
		Card[] hand = new Card[5];
		hand[0] = new Card(3, 1); //3D
		hand[1] = new Card(7, 1); //7D
		hand[2] = new Card(10, 1); //10D
		hand[3] = new Card(1, 1); //AD
		hand[4] = new Card(13, 1); //KD
		
		assertFalse(HandIdentifier.isStraightFlush(hand));
	}
	
	public void testStraightButNotFlush() {
		Card[] hand = new Card[5];
		hand[0] = new Card(6, 1); //6D
		hand[1] = new Card(7, 4); //7S
		hand[2] = new Card(8, 3); //8H
		hand[3] = new Card(9, 3); //9H
		hand[4] = new Card(10, 2); //10C
		
		assertFalse(HandIdentifier.isStraightFlush(hand));
	}
	
	public void testFakeStraightFlush() {
		Card[] hand = new Card[5];
		hand[0] = new Card(6, 1); //6D
		hand[1] = new Card(2, 4); //2S
		hand[2] = new Card(13, 3); //KH
		hand[3] = new Card(9, 3); //9H
		hand[4] = new Card(10, 2); //10C
		
		assertFalse(HandIdentifier.isStraightFlush(hand));
	}
	
}
