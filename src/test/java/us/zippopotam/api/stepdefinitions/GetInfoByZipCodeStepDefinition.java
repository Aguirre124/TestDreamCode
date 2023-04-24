package us.zippopotam.api.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import us.zippopotam.api.questions.VerifyCityName;
import us.zippopotam.api.questions.VerifyStatusCode;
import us.zippopotam.api.tasks.GetByZipCode;
import us.zippopotam.api.tasks.Load;
import us.zippopotam.api.utils.resources.WebServicesEndPoints;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class GetInfoByZipCodeStepDefinition {

    @Given("load the data for the test")
    public void load_the_data_for_the_test(List<Map<String, String>> data) {
        theActorInTheSpotlight().wasAbleTo(
                Load.testData(data.get(0))
        );
    }

    @When("use the service with the zip code of the city as a parameter")
    public void use_the_service_with_the_zip_code_of_the_city_as_a_parameter() {
        theActorInTheSpotlight().attemptsTo(
                GetByZipCode.service(WebServicesEndPoints.URI.getUrl())
        );
    }

    @Then("see the status code is {int}")
    public void see_the_status_code_is(Integer responseCode) {
        theActorInTheSpotlight().should(seeThat(VerifyStatusCode.is(responseCode)));
    }

    @Then("validate the city name")
    public void validateTheCityName() {
        theActorInTheSpotlight()
                .should(seeThat(VerifyCityName.is()));
    }
}
