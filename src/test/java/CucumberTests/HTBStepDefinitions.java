package CucumberTests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

import Model.Calculator;
import Model.Card;
import Model.HandsFromInputFile;

public class HTBStepDefinitions {
	
	Card[] htbHand = new Card[5];
	long htbScore;
	
	@Given("My HTB hand is \"([^\"]*)\"$")
	public void htbHand(String htbString) throws Throwable {		
		htbHand = HandsFromInputFile.handFromHandString(htbString);
	}
	
	@When("My HTB hand is scored$")
	public void scoreHand() throws Throwable {
		htbScore = Calculator.score(htbHand);
	}
	
	@Then("My hand beats \"([^\"]*)\"$")
	public void compareHands(String handString) throws Throwable {
		Card[] aipHand = HandsFromInputFile.handFromHandString(handString);
		assertTrue(htbScore > Calculator.score(aipHand));
	}

}
