package Strategy;

import java.util.Arrays;
import java.util.HashMap;
import Model.Card;

public class HandIdentifier {
	
	// Private methods
	private static boolean is10toA(int[] ranks) {
		Arrays.sort(ranks);
		return (ranks[0] == 10 && ranks[1] == 11 && ranks[2] == 12 && ranks[3] == 13 && ranks[4] == 14);
	}
	
	public static HashMap<Integer, Integer> cardsPerRank(Card[] hand) {
		// [Card rank : Number of occurrences]
		HashMap<Integer, Integer>  cardCount = new HashMap<>();
		for (int i = 0; i < hand.length; i++) {
			int rank = hand[i].getRank();
			Integer count = cardCount.get(rank);
			if (count == null) {
				cardCount.put(rank, 1);
			} else {
				cardCount.put(rank, count + 1);
			}
		}
		return cardCount;
	}
	
	// Public methods
	public static boolean isStraight(Card[] hand) {
		if (hand == null || hand.length != 5) {
	        return false;
	    }
		
		int[] ranks = new int[5];
		for (int i = 0; i < hand.length; i++) {
			ranks[i] = hand[i].getRank();
		}
		Arrays.sort(ranks);
		
		// Need to check for A to 5 straight first
		if (ranks[0] == 2 && ranks[1] == 3 && ranks[2] == 4 && ranks[3] == 5 && ranks[4] == 14) {
			return true;
		} else {
			for (int i = 0; i < ranks.length - 1; i++) {
				if (ranks[i] + 1 != ranks[i + 1]) {
					return false;
				}
			}
			return true;
		}
	}
	
	public static boolean isFlush(Card[] hand) {
		if (hand == null || hand.length != 5) {
	        return false;
	    }
		
		for (int i = 0; i < hand.length - 1; i++) {
			if (hand[i].getSuit() != hand[i + 1].getSuit()) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isStraightFlush(Card[] hand) {
		return (isStraight(hand) && isFlush(hand));
	}
	
	public static boolean isRoyalFlush(Card[] hand) {
		int[] ranks = new int[5];
		for (int i = 0; i < hand.length; i++) {
			ranks[i] = hand[i].getRank();
		}
		
		return (isStraightFlush(hand) && is10toA(ranks));
	}
	
	public static boolean isFourOfAKind(Card[] hand) {
		HashMap<Integer, Integer>  cardCount = cardsPerRank(hand);
		
		if (cardCount.containsValue(4)) {
			return true;
		}
		return false;
	}
	
	public static boolean isFullHouse(Card[] hand) {
		HashMap<Integer, Integer>  cardCount = cardsPerRank(hand);
		
		if (cardCount.containsValue(3) && cardCount.containsValue(2)) {
			return true;
		}
		return false;
	}
	
	public static boolean isThreeOfAKind(Card[] hand) {
		HashMap<Integer, Integer>  cardCount = cardsPerRank(hand);
		
		if (cardCount.containsValue(3) && !isFourOfAKind(hand) && !isFullHouse(hand)) {
			return true;
		}
		return false;
	}
	
	public static boolean isTwoPair(Card[] hand) {
		HashMap<Integer, Integer>  cardCount = cardsPerRank(hand);
		
		int numPairs = 0;
		for (Integer count : cardCount.values()) {
			if (count == 2) {
				numPairs++;
			}
		}
		return (numPairs == 2);
	}
	
	public static boolean isPair(Card[] hand) {
		HashMap<Integer, Integer>  cardCount = cardsPerRank(hand);
		
		int numPairs = 0;
		for (Integer count : cardCount.values()) {
			if (count == 2) {
				numPairs++;
			}
		}
		return (numPairs == 1 && !isFullHouse(hand));
	}
	
}
