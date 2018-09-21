package IdentifyHands;

import junit.framework.TestCase;
import Model.Card;

public class IdentifyStraightTests extends TestCase {
	
	public void testAto5Straight() {
		HandIdentifier identifier = new HandIdentifier();
		Card[] hand = new Card[5];
		hand[0] = new Card(1, 1); //AD
		hand[1] = new Card(2, 3); //2H
		hand[2] = new Card(3, 2); //3C
		hand[3] = new Card(4, 2); //4C
		hand[4] = new Card(5, 1); //5D
		
		assertTrue(identifier.isStraight(hand));
	}
	
	public void testMidRangeStraight() {
		HandIdentifier identifier = new HandIdentifier();
		Card[] hand = new Card[5];
		hand[0] = new Card(6, 1); //6D
		hand[1] = new Card(7, 3); //7H
		hand[2] = new Card(8, 2); //8C
		hand[3] = new Card(9, 2); //9C
		hand[4] = new Card(10, 1); //10D
		
		assertTrue(identifier.isStraight(hand));
	}
	
	public void test10toAStraight() {
		HandIdentifier identifier = new HandIdentifier();
		Card[] hand = new Card[5];
		hand[0] = new Card(10, 1); //10D
		hand[1] = new Card(11, 3); //JH
		hand[2] = new Card(12, 2); //QC
		hand[3] = new Card(13, 2); //KC
		hand[4] = new Card(1, 1); //AD
		
		assertTrue(identifier.isStraight(hand));
	}
	
	public void testFakeStraight() {
		HandIdentifier identifier = new HandIdentifier();
		Card[] hand = new Card[5];
		hand[0] = new Card(6, 1); //6D
		hand[1] = new Card(3, 3); //3H
		hand[2] = new Card(9, 2); //9C
		hand[3] = new Card(12, 2); //QC
		hand[4] = new Card(10, 1); //10D
		
		assertFalse(identifier.isStraight(hand));
	}
	
}
