package Strategy;

import java.util.HashMap;
import java.util.Map.Entry;
import Model.*;
import Strategy.HandIdentifier;

public class Exchange {
	
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
		}
		return response;
	}
	
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
