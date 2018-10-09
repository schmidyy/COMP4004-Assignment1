package ExchangeStrategy;

import java.io.IOException;
import java.util.Arrays;
import Model.Card;
import Model.ExchangeResponse;
import Model.HandsFromInputFile;
import Strategy.Exchange;
import junit.framework.TestCase;

public class ComplexOneAwayTests extends TestCase {
	
	public void testOneAwayFromStraightMiddleCardMissing() throws IOException {
		Card[] oneAwayFromStraightHand = HandsFromInputFile.complexFileOnLineNumber(1)[0]; // 4 5 7 8 J
		
		ExchangeResponse response = Exchange.analyze(oneAwayFromStraightHand);
		assertTrue(Arrays.equals(new boolean[]{false, false, false, false, true}, response.getCardsToExchange()));
	}
	
	public void testOneAwayFromStraightAceToFive() throws IOException {
		Card[] oneAwayFromStraightHand = HandsFromInputFile.complexFileOnLineNumber(1)[1]; // A 2 3 4 7
		
		ExchangeResponse response = Exchange.analyze(oneAwayFromStraightHand);
		assertTrue(Arrays.equals(new boolean[]{false, false, false, false, true}, response.getCardsToExchange()));
	}
	
	public void testOneAwayFromStraightTenToAce() throws IOException {
		Card[] oneAwayFromStraightHand = HandsFromInputFile.complexFileOnLineNumber(2)[0]; // 3 J Q K A
		
		ExchangeResponse response = Exchange.analyze(oneAwayFromStraightHand);
		assertTrue(Arrays.equals(new boolean[]{true, false, false, false, false}, response.getCardsToExchange()));
	}
	
	public void testOneAwayFromStraightRandomOrder() throws IOException {
		Card[] oneAwayFromStraightHand = HandsFromInputFile.complexFileOnLineNumber(2)[1]; // 8 6 2 7 9
		
		ExchangeResponse response = Exchange.analyze(oneAwayFromStraightHand);
		assertTrue(Arrays.equals(new boolean[]{false, false, true, false, false}, response.getCardsToExchange()));
	}
	
}
