package Game;

import java.io.IOException;

import Model.HandsFromInputFile;
import Strategy.Exchange;
import Model.Calculator;
import Model.Card;

public class MainGame {

	public static void main(String[] args) throws IOException {
		for (int i = 0; i < HandsFromInputFile.lineCount(); i++) {
			Card[][] cards = HandsFromInputFile.onLineNumber(i + 1);
			Card[] aipHand = cards[0];
			Card[] opponentHand = cards[1];
			Card[] exchangeCards = cards[2];
			
			Card[] newAIPHand = Exchange.exchange(aipHand, exchangeCards);
			
			long aipScore = Calculator.score(newAIPHand);
			long opponentScore = Calculator.score(opponentHand);
			
			System.out.println(String.format("Game #%d: ", i + 1));
			
			System.out.print("Original AIP Hand:  ");
			for (Card card : aipHand) {
				System.out.print(card);
				System.out.print(" ");
			}
			if (Exchange.exchangedCards(aipHand).size() > 0) {
				System.out.print("-> Exchanging ");
				for (Card card : Exchange.exchangedCards(aipHand)) {
					System.out.print(card);
					System.out.print(" ");
				}
				System.out.print("FOR ");
				for (Card card : exchangeCards) {
					if (card != null) {
						System.out.print(card);
						System.out.print(" ");
					}
				}
			}
			System.out.print("\n");
			
			System.out.print("Exchanged AIP Hand: ");
			for (Card card : newAIPHand) {
				System.out.print(card);
				System.out.print(" ");
			}
			System.out.print("\n");
			
			System.out.print("Opponents Hand:     ");
			for (Card card : opponentHand) {
				System.out.print(card);
				System.out.print(" ");
			}
			System.out.print("\n");
			System.out.print("\n");
			
			if (aipScore > opponentScore) {
				System.out.println("Winner: AIP\n");
			} else {
				System.out.println("Winner: Opponent\n");
			}
			
			System.out.println("************************************\n");
		}

	}

}
