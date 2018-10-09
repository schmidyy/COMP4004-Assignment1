package Acceptance;

import junit.framework.TestCase;
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
	
	public void testSuitsAreCorrectlyRanked() {
		assertEquals("4", Calculator.suitToScore(4));
		assertEquals("3", Calculator.suitToScore(3));
		assertEquals("2", Calculator.suitToScore(1));
		assertEquals("1", Calculator.suitToScore(2));
	}
	
	public void testRanksAreCorrectlyRanked() {
		assertTrue(Card.ACE > Card.KING &&
				   Card.KING > Card.QUEEN &&
				   Card.QUEEN > Card.JACK &&
				   Card.JACK > Card.TEN &&
				   Card.TEN > Card.NINE &&
				   Card.NINE > Card.EIGHT &&
				   Card.EIGHT > Card.SEVEN &&
				   Card.SEVEN > Card.SIX &&
				   Card.SIX > Card.FIVE &&
				   Card.FIVE > Card.FOUR &&
				   Card.FOUR > Card.THREE &&
				   Card.THREE > Card.DEUCE);
	}
	
	public void testHandRankingIsIndependantOfPlayer() throws IOException {
		Card[][] gameHands = HandsFromInputFile.onLineNumber(18);
		
		Card[] aipHand = gameHands[0];
		Card[] opponentHand = gameHands[1];
		
		assertEquals(Calculator.score(aipHand), Calculator.score(opponentHand));
	}
	
	public void testHandRankingIsIndependantOfExchange() throws IOException {
		Card[][] gameHands = HandsFromInputFile.onLineNumber(18);
		
		Card[] aipHand = gameHands[0];
		Card[] exchangeCards = gameHands[2];
		Card[] newAIPHand = Exchange.exchange(aipHand, exchangeCards);
		
		assertEquals(Calculator.score(aipHand), Calculator.score(newAIPHand));
	}
	
}
