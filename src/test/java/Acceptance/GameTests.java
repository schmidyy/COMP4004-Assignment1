package Acceptance;

import junit.framework.TestCase;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import Model.*;
import Strategy.HandIdentifier;

public class GameTests extends TestCase {
	
	public void testReadingFromFile() throws IOException {
		Card[][] gameHands = HandsFromInputFile.onLineNumber(1);
		
		assertTrue(HandIdentifier.isRoyalFlush(gameHands[0]));
		assertTrue(HandIdentifier.isFourOfAKind(gameHands[1]));
	}
	
}
