package Model;

import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

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
		String ranksString = "";
		
		ArrayList<Integer> pairRanks = new ArrayList<Integer>();
		ArrayList<Integer> soloRanks = new ArrayList<Integer>();
		HashMap<Integer, Integer>  cardCount = HandIdentifier.cardsPerRank(hand);
		
		for (Entry<Integer, Integer> entry : cardCount.entrySet()) {
			if (entry.getValue() == 4) {
				for (int i = 0; i < 4; i++) {
					ranksString += String.format("%02d", entry.getKey());
				}
			} else if (entry.getValue() == 3) {
				for (int i = 0; i < 3; i++) {
					ranksString += String.format("%02d", entry.getKey());
				}
			} else if (entry.getValue() == 2) {
				pairRanks.add(entry.getKey());
			} else {
				soloRanks.add(entry.getKey());
			}
		}
		
		Collections.sort(pairRanks);
		Collections.reverse(pairRanks);
		Collections.sort(soloRanks);
		Collections.reverse(soloRanks);
		
		for (int i : pairRanks) {
			String formatedString = String.format("%02d", i);
			ranksString += formatedString + formatedString;
		}
		
		for (int i : soloRanks) {
			String formatedString = String.format("%02d", i);
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
	
	public static String suitToScore(int suit) {
		switch (suit) {
		case 1: return "2";
		case 2: return "1";
		case 3: return "3";
		case 4: return "4";
		default: return "";
		}
	}
}
