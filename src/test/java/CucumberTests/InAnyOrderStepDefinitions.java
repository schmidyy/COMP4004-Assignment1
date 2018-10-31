package CucumberTests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

import Model.Calculator;
import Model.Card;
import Model.ExchangeResponse;
import Model.HandsFromInputFile;
import Strategy.Exchange;
import Strategy.HandIdentifier;

public class InAnyOrderStepDefinitions {
	
	Card[] htbHand = new Card[5];
	Card[] scannedHand = new Card[5];
	ExchangeResponse response;
	
	@Given("My hand is \"([^\"]*)\"$")
	public void userHand(String handString) throws Throwable {		
		scannedHand = HandsFromInputFile.handFromHandString(handString);
	}
	
	@When("My hand is analyzed$")
	public void analyze() throws Throwable {
		response = Exchange.analyze(scannedHand);
	}
	
	@Then("My hand is identified as a Royal Flush$")
	public void checkForRoyalFlush() throws Throwable {
		assertTrue(HandIdentifier.isRoyalFlush(scannedHand));
	}
	
	@Then("My hand is identified as a Straight Flush$")
	public void checkForStraightFlush() throws Throwable {
		assertTrue(HandIdentifier.isStraightFlush(scannedHand));
	}
	
	@Then("My hand is identified as a Four of a kind$")
	public void checkForFourOfAKind() throws Throwable {
		assertTrue(HandIdentifier.isFourOfAKind(scannedHand));
	}
	
	@Then("My hand is identified as a Full House$")
	public void checkForFullHouse() throws Throwable {
		assertTrue(HandIdentifier.isFullHouse(scannedHand));
	}
	
	@Then("My hand is identified as a Flush$")
	public void checkForFlush() throws Throwable {
		assertTrue(HandIdentifier.isFlush(scannedHand));
	}
	
	@Then("My hand is identified as a Straight$")
	public void checkForStraight() throws Throwable {
		assertTrue(HandIdentifier.isStraight(scannedHand));
	}
	
	@Then("My hand is identified as a Three of a kind$")
	public void checkForThreeOfAKind() throws Throwable {
		assertTrue(HandIdentifier.isThreeOfAKind(scannedHand));
	}
	
	@Then("My hand is identified as a Two pair$")
	public void checkForTwoPair() throws Throwable {
		assertTrue(HandIdentifier.isTwoPair(scannedHand));
	}
	
	@Then("My hand is identified as a Pair$")
	public void checkForPair() throws Throwable {
		assertTrue(HandIdentifier.isPair(scannedHand));
	}
	
}
