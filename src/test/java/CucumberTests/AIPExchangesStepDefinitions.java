package CucumberTests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import Model.Calculator;
import Model.Card;
import Model.HandsFromInputFile;
import Strategy.Exchange;

public class AIPExchangesStepDefinitions {
	Card[] aipHand = new Card[5];
	Card[] newAIPHand = new Card[5];
	
	@Given("My original AIP hand is \"([^\"]*)\"$")
	public void aipHand(String aipString) throws Throwable {		
		aipHand = HandsFromInputFile.handFromHandString(aipString);
	}
	
	@When("My AIP hand is exchanged with \"([^\"]*)\"$")
	public void exchangeHand(String exchangeCardsString) throws Throwable {
		String[] cards = exchangeCardsString.split("\\s+");
		Card[] exchangeCards = new Card[cards.length];
		for (int i = 0; i < cards.length; i++) {
			exchangeCards[i] = new Card(cards[i]);
		}
		
		newAIPHand = Exchange.exchange(aipHand, exchangeCards);
	}
	
	@Then("My new AIP hand \"([^\"]*)\" against \"([^\"]*)\"$")
	public void compareHands(String wins, String opponentHand) throws Throwable {
		Card[] htbHand = HandsFromInputFile.handFromHandString(opponentHand);
		if (wins.toLowerCase().contains("Yes".toLowerCase())) {
			assertTrue(Calculator.score(newAIPHand) > Calculator.score(htbHand));
		} else {
			assertFalse(Calculator.score(newAIPHand) > Calculator.score(htbHand));
		}
	}
}
