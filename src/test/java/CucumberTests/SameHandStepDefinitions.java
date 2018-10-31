package CucumberTests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;

import static org.junit.Assert.assertTrue;

import Model.Calculator;
import Model.Card;
import Model.HandsFromInputFile;

public class SameHandStepDefinitions {
	Card[] aipHand = new Card[5];
	Card[] htbHand = new Card[5];
	String winner;
	
	@Given("The AIP hand is \"([^\"]*)\"$")
	public void aipHand(String aipString) throws Throwable {		
		aipHand = HandsFromInputFile.handFromHandString(aipString);
	}
	
	@And("The HTB hand is \"([^\"]*)\"$")
	public void htbHand(String htbString) throws Throwable {		
		htbHand = HandsFromInputFile.handFromHandString(htbString);
	}
	
	@When("The hands are compared$")
	public void compareHands() throws Throwable {
		if (Calculator.score(aipHand) > Calculator.score(htbHand) ) {
			winner = "AIP";
		} else {
			winner = "HTB";
		}
	}
	
	@Then("The winner is \"([^\"]*)\"$")
	public void checkForWinner(String winnerString) throws Throwable {
		assertTrue(winner.toLowerCase().contains(winnerString.toLowerCase()));
	}
}
