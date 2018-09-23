package Strategy;

import Model.*;
import Strategy.HandIdentifier;

public class Exchange {
	
	public static ExchangeResponse analyze(Card[] hand) {
		ExchangeResponse response = new ExchangeResponse(null, 0);
		if (isStraightOrBetter(hand)) {
			response.setCardsToExchange(new boolean[]{false, false, false, false, false});
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
	
}
