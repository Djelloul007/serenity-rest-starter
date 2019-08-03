package starter.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Before;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class CheckAppStatus {

    @Before
    public void setbaseurl(){
        RestAssured.baseURI="http://localhost:8080";
    }

    @Given("^(?:.*)the application is running$")
    public void the_application_is_running() {
        // Write code here that turns the phrase above into concrete actions
        //throw new cucumber.api.PendingException();
    }

    @When("I check the application status")
    public void i_check_the_application_status() {
        SerenityRest.given()
                .when().get("/api/status")
                .then().statusCode(200);
    }

    @Then("the API should return {string}")
    public void the_API_should_return(String string) {
        String Response= SerenityRest.lastResponse().body().asString();
        assertThat(Response).isEqualTo("BDDTrader running against DEV");
    }
}
