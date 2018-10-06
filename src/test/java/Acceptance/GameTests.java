package Acceptance;

import junit.framework.TestCase;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import Model.*;
import Strategy.Exchange;
import Strategy.HandIdentifier;

public class GameTests extends TestCase {
	
	public void testReadingFromFile() throws IOException {
		Card[][] gameHands = HandsFromInputFile.onLineNumber(1);
		
		assertTrue(HandIdentifier.isRoyalFlush(gameHands[0]));
		assertTrue(HandIdentifier.isFourOfAKind(gameHands[1]));
	}
	
	public void testExchangeNoCardsStrategy() throws IOException {
		Card[][] gameHands = HandsFromInputFile.onLineNumber(1);
		
		Card[] aipHand = gameHands[0];
		
		ExchangeResponse response = Exchange.analyze(aipHand);
		assertTrue(HandIdentifier.isRoyalFlush(aipHand));
		assertEquals(0, response.getNumExchanges());
		assertTrue(Arrays.equals(new boolean[]{false, false, false, false, false}, response.getCardsToExchange()));
	}
	
	public void testExchangeOneCardsStrategy() throws IOException {
		Card[][] gameHands = HandsFromInputFile.onLineNumber(2);
		
		Card[] aipHand = gameHands[0];
		Card[] exchangeCards = gameHands[2];
		
		ExchangeResponse orignalResponse = Exchange.analyze(aipHand);
		assertEquals(1, orignalResponse.getNumExchanges());
		Card[] newAIPHand = Exchange.exchange(aipHand, exchangeCards);
		assertFalse(HandIdentifier.isStraightFlush(aipHand));
		assertTrue(HandIdentifier.isStraightFlush(newAIPHand));
	}
	
	public void testExchangeTwoCardsStrategy() throws IOException {
		Card[][] gameHands = HandsFromInputFile.onLineNumber(3);
		
		Card[] aipHand = gameHands[0];
		Card[] exchangeCards = gameHands[2];
		
		ExchangeResponse orignalResponse = Exchange.analyze(aipHand);
		assertEquals(2, orignalResponse.getNumExchanges());
		Card[] newAIPHand = Exchange.exchange(aipHand, exchangeCards);
		assertFalse(HandIdentifier.isStraight(aipHand));
		assertTrue(HandIdentifier.isStraight(newAIPHand));
	}
	
	public void testExchangeThreeCardsStrategy() throws IOException {
		Card[][] gameHands = HandsFromInputFile.onLineNumber(4);
		
		Card[] aipHand = gameHands[0];
		Card[] exchangeCards = gameHands[2];
		
		ExchangeResponse orignalResponse = Exchange.analyze(aipHand);
		assertEquals(3, orignalResponse.getNumExchanges());
		Card[] newAIPHand = Exchange.exchange(aipHand, exchangeCards);
		assertFalse(HandIdentifier.isTwoPair(aipHand));
		assertTrue(HandIdentifier.isTwoPair(newAIPHand));
	}
	
}
