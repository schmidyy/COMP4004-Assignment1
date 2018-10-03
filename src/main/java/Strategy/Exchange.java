package Strategy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.stream.IntStream;

import Model.*;
import Strategy.HandIdentifier;

public class Exchange {
	
	// Public Methods:
	public static ExchangeResponse analyze(Card[] hand) {
		ExchangeResponse response = new ExchangeResponse(null, 0);
		if (isStraightOrBetter(hand)) {
			response.setCardsToExchange(new boolean[]{false, false, false, false, false});
		} else if (isOneAwayFromFlush(hand)) {
			response.setCardsToExchange(getMissingFlushCard(hand));
			response.setNumExchanges(1);
		} else if (isOneAwayFromFullHouse(hand)) {
			response.setCardsToExchange(getMissingFullHouseCard(hand));
			response.setNumExchanges(1);
		} else if (isOneAwayFromStraight(hand)) {
			response.setCardsToExchange(getMissingStraightCard(hand));
			response.setNumExchanges(1);
		} else if (isThreeOfTheSameSuit(hand)) {
			response.setCardsToExchange(getMissingThreeOfTheSameSuitCards(hand));
			response.setNumExchanges(2);
		}
		return response;
	}
	
	// Private Methods:
	// Identifying cases:
	private static boolean isStraightOrBetter(Card[] hand) {
		return (HandIdentifier.isRoyalFlush(hand) || 
				HandIdentifier.isStraightFlush(hand) ||
				HandIdentifier.isFourOfAKind(hand) ||
				HandIdentifier.isFullHouse(hand) ||
				HandIdentifier.isFlush(hand) ||
				HandIdentifier.isStraight(hand));
	}
	
	private static boolean isOneAwayFromFlush(Card[] hand) {
		HashMap<Integer, Integer>  cardCount = cardsPerSuit(hand);
		
		if (cardCount.containsValue(4)) {
			return true;
		}
		return false;
	}
	
	private static boolean isOneAwayFromFullHouse(Card[] hand) {
		return (HandIdentifier.isThreeOfAKind(hand) || HandIdentifier.isTwoPair(hand));
	}
	
	private static boolean isOneAwayFromStraight(Card[] hand) {
		int[] ranks = new int[5];
		for (int i = 0; i < hand.length; i++) {
			ranks[i] = hand[i].getRank();
		}
		Arrays.sort(ranks);
		
		int min = ranks[0];
		int max = ranks[ranks.length - 1];
		
		int count1 = 0, count2 = 0, count3 = 0;
		int[] aceToFiveRanks = {14, 2, 3, 4, 5};
		
		for (int i = 0; i < 5; i++) {
			if (contains(ranks, min + i)) {
				count1++;
			}
			
			if (contains(ranks, max - i)) {
				count2++;
			}
			
			if (contains(ranks, aceToFiveRanks[i])) {
				count3++;
			}
		}
		
		return (count1 == 4 || count2 == 4 || count3 == 4);
	} 
	
	private static boolean isThreeOfTheSameSuit(Card[] hand) {
		HashMap<Integer, Integer>  cardCount = cardsPerSuit(hand);
		
		if (cardCount.containsValue(3)) {
			return true;
		}
		return false;		
	}
	
	// Array building methods:
	private static boolean[] getMissingThreeOfTheSameSuitCards(Card[] hand) {
		HashMap<Integer, Integer>  cardCount = cardsPerSuit(hand);
		
		Entry<Integer, Integer> max = null;
		int maxSuit = 0;
		for (Entry<Integer, Integer> entry : cardCount.entrySet()) {
		    if (entry.getValue() == 3) {
		        maxSuit = entry.getKey();
		    }
		}
		
		boolean[] cardsToExchange = new boolean[5];
		for (int i = 0; i < hand.length; i++) {
			if (hand[i].getSuit() != maxSuit) {
				cardsToExchange[i] = true;
			} else {
				cardsToExchange[i] = false;
			}
		}
		
		return cardsToExchange;
	}
	
	private static boolean[] getMissingFullHouseCard(Card[] hand) {
		boolean[] cardsToExchange = new boolean[5];
		HashMap<Integer, Integer>  cardCount = HandIdentifier.cardsPerRank(hand);
		
		// Find entry with lowest value
		Entry<Integer, Integer> min = null;
		for (Entry<Integer, Integer> entry : cardCount.entrySet()) {
		    if (min == null || min.getValue() > entry.getValue()) {
		        min = entry;
		    }
		}
		
		int lowestRank = min.getKey();
		for (int i = 0; i < hand.length; i++) {
			if (hand[i].getRank() == lowestRank) {
				cardsToExchange[i] = true;
			} else {
				cardsToExchange[i] = false;
			}
		}
		
		return cardsToExchange;
	}
	
	private static boolean[] getMissingStraightCard(Card[] hand) {
		boolean[] cardsToExchange = new boolean[5];
		
		int[] ranks = new int[5];
		for (int i = 0; i < hand.length; i++) {
			ranks[i] = hand[i].getRank();
		}
		Arrays.sort(ranks);
		
		int min = ranks[0];
		int max = ranks[ranks.length - 1];
		
		int count1 = 0, count2 = 0, count3 = 0;
		int missingIndex1 = 0, missingIndex2 = 0, missingIndex3 = 0;
		int[] aceToFiveRanks = {14, 2, 3, 4, 5};
		
		for (int i = 0; i < 5; i++) {
			if (contains(ranks, min + i)) {
				count1++;
			} else {
				missingIndex1 = i;
			}
			
			if (contains(ranks, max - i)) {
				count2++;
			} else {
				missingIndex2 = 4 - i;
			}
			
			if (contains(ranks, aceToFiveRanks[i])) {
				count3++;
			} else {
				missingIndex3 = i;
			}
		}
		
		int succesfullState;
		if (count1 == 4) {
			succesfullState = 1;
		} else if (count2 == 4) {
			succesfullState = 2;
		} else {
			succesfullState = 3;
		}
		
		int missingIndex = 0;
		if (succesfullState == 1) {
			missingIndex = missingIndex1;
		} else if (succesfullState == 2) {
			missingIndex = missingIndex2;
		} else if (succesfullState == 3) {
			missingIndex = missingIndex3;
		}
		
		int rankOfMissingIndex = ranks[missingIndex];
		int originalOrderMissingIndex = 0;
		for (int i = 0; i < 5; i++) {
			if (hand[i].getRank() == rankOfMissingIndex) {
				originalOrderMissingIndex = i;
			}
		}
		
		for (int i = 0; i < 5; i++) {
			if (i == originalOrderMissingIndex) {
				cardsToExchange[i] = true;
			} else {
				cardsToExchange[i] = false;
			}
		}
		
		return cardsToExchange;
	}
	
	private static boolean[] getMissingFlushCard(Card[] hand) {
		HashMap<Integer, Integer>  cardCount = cardsPerSuit(hand);
		
		// Find entry with lowest value
		Entry<Integer, Integer> min = null;
		for (Entry<Integer, Integer> entry : cardCount.entrySet()) {
		    if (min == null || min.getValue() > entry.getValue()) {
		        min = entry;
		    }
		}
		int suit = min.getKey();
		
		// Build response array
		boolean[] cardsToExchange = new boolean[5];
		for (int i = 0; i < hand.length; i++) {
			if (hand[i].getSuit() == suit) {
				cardsToExchange[i] = true;
			} else {
				cardsToExchange[i] = false;
			}
		}
		
		return cardsToExchange;
	}
	
	// Helper Methods
	private static boolean contains(final int[] array, final int key) {  
	     return IntStream.of(array).anyMatch(x -> x == key);
	}
	
	private static HashMap<Integer, Integer> cardsPerSuit(Card[] hand) {
		// [Card suit : Number of occurrences]
		HashMap<Integer, Integer>  cardCount = new HashMap<>();
		for (int i = 0; i < hand.length; i++) {
			int suit = hand[i].getSuit();
			Integer count = cardCount.get(suit);
			if (count == null) {
				cardCount.put(suit, 1);
			} else {
				cardCount.put(suit, count + 1);
			}
		}
		return cardCount;
	}
}
