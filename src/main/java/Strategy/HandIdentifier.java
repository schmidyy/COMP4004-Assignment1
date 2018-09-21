package Strategy;

import java.util.Arrays;
import Model.Card;

public class HandIdentifier {
	
	public boolean isStraight(Card[] hand) {
		if (hand == null || hand.length != 5) {
	        return false;
	    }
		
		int[] ranks = new int[5];
		for (int i = 0; i < hand.length; i++) {
			ranks[i] = hand[i].getRank();
		}
		Arrays.sort(ranks);
		
		// Need to check for 10 to A straight first
		if (ranks[0] == 1 && ranks[1] == 10 && ranks[2] == 11 && ranks[3] == 12 && ranks[4] == 13) {
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
	
	public boolean isFlush(Card[] hand) {
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
	
}
