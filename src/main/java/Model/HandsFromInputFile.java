package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import Model.Card;

public class HandsFromInputFile {
	
	public static Card[][] onLineNumber(int lineNumber) throws IOException {
		String inputFile = readFile("src/test/resources/GameTests.txt");
		String lines[] = inputFile.split("\\r?\\n");
		
		String line = lines[lineNumber - 1];
		String[] cards = line.split("\\s+");
		
		Card[] aipCards = new Card[5];
		Card[] opponentCards = new Card[5];
		Card[] exchangeCards = new Card[3];
		
		for (int i = 0; i < cards.length; i++) {
			if (i <= 4) {
				aipCards[i] = new Card(cards[i]);
			} else if (i > 4 && i <= 9) {
				opponentCards[i - 5] = new Card(cards[i]);
			} else  {
				exchangeCards[i - 10] = new Card(cards[i]);
			}
		}
		
		return (new Card[][]{aipCards, opponentCards, exchangeCards});
	}
	
	public static int lineCount() throws IOException {
		String inputFile = readFile("src/test/resources/GameTests.txt");
		String lines[] = inputFile.split("\\r?\\n");
		
		return lines.length;
	}
	
	static String readFile(String fileName) throws IOException {
	    BufferedReader br = new BufferedReader(new FileReader(fileName));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	        return sb.toString();
	    } finally {
	        br.close();
	    }
	}
}
