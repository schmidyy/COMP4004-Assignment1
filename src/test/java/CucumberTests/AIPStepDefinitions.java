package CucumberTests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

import Model.Calculator;
import Model.Card;
import Model.HandsFromInputFile;

public class AIPStepDefinitions {
	
	Card[] aipHand = new Card[5];
	long aipScore;
	
	@Given("My AIP hand is \"([^\"]*)\"$")
	public void aipHand(String aipString) throws Throwable {		
		aipHand = HandsFromInputFile.handFromHandString(aipString);
	}
	
	@When("My AIP hand is scored$")
	public void scoreHand() throws Throwable {
		aipScore = Calculator.score(aipHand);
	}
	
	@Then("My hand holds against \"([^\"]*)\"$")
	public void compareHands(String handString) throws Throwable {
		Card[] htbHand = HandsFromInputFile.handFromHandString(handString);
		assertTrue(aipScore > Calculator.score(htbHand));
	}

}
