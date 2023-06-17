package com.virgingames.cucumber.steps;

import com.virgingames.steps.JackpotSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.parsing.Parser;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

import static org.hamcrest.CoreMatchers.hasItems;

public class MyStepdefs {

    static ValidatableResponse response;

    @Steps
    JackpotSteps jackpotSteps;

    @When("^I send a Get request to lobby feed endpoint$")
    public void iSendAGetRequestToLobbyFeedEndpoint() {
        response = jackpotSteps.getLobbyFeedInfo().parser("text/plain", Parser.JSON);
    }

    @Then("^I must get a valid response code 200$")
    public void iMustGetAValidResponseCode() {
        response.statusCode(200);
    }

    @And("^I verify default frequency is GBP$")
    public void iVerifyDefaultFrequencyIsGBP() {
      response.body("data.pots.currency", hasItems("GBP"));

    }
}
