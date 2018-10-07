package Model;

import java.util.Arrays;

import Model.Card;
import Strategy.HandIdentifier;

public class Calculator {
	public static long score(Card[] hand) {
		String handScore = handScore(hand);
		String rankScore = rankScore(hand);
		String suitScore = suitScore(hand);
		
		String scoreString = handScore + rankScore + suitScore;
		return Long.parseLong(scoreString);
	}
	
	private static String rankScore(Card[] hand) {
		int[] ranks = new int[5];
		for (int i = 0; i < hand.length; i++) {
			ranks[i] = hand[i].getRank();
		}
		Arrays.sort(ranks);
		
		String ranksString = "";
		for (int i = ranks.length - 1; i >= 0; i--) {
			String formatedString = String.format("%02d", ranks[i]);
			ranksString += formatedString;
		}
		
		return ranksString;
	}
	
	private static String handScore(Card[] hand) {
		if (HandIdentifier.isRoyalFlush(hand)) {
			return "9";
		} else if (HandIdentifier.isStraightFlush(hand)) {
			return "8";
		} else if (HandIdentifier.isFourOfAKind(hand)) {
			return "7";
		} else if (HandIdentifier.isFullHouse(hand)) {
			return "6";
		} else if (HandIdentifier.isFlush(hand)) {
			return "5";
		} else if (HandIdentifier.isStraight(hand)) {
			return "4";
		} else if (HandIdentifier.isThreeOfAKind(hand)) {
			return "3";
		} else if (HandIdentifier.isTwoPair(hand)) {
			return "2";
		} else if (HandIdentifier.isPair(hand)) {
			return "1";
		} else {
			return "";
		}
	}
	
	private static String suitScore(Card[] hand) {
		int[] ranks = new int[5];
		for (int i = 0; i < hand.length; i++) {
			ranks[i] = hand[i].getRank();
		}
		Arrays.sort(ranks);
		
		int highestRank = ranks[4];
		
		for (int i = 0; i < hand.length; i++) {
			if (hand[i].getRank() == highestRank) {
				return suitToScore(hand[i].getSuit());
			}
		}
		return "";
	}
	
	private static String suitToScore(int suit) {
		switch (suit) {
		case 1: return "3";
		case 2: return "4";
		case 3: return "2";
		case 4: return "1";
		default: return "";
		}
	}
}
