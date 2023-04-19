package us.zippopotam.api.interactions;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;
import us.zippopotam.api.models.TestData;


public class ExecuteGetByZipCode implements Interaction {

    private final String resource;

    public ExecuteGetByZipCode(String resource) {
        this.resource = resource;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.reset();
        actor.attemptsTo(
                Get.resource(resource).with(
                        request -> request
                                .contentType(ContentType.JSON)
                                .queryParam("zip", TestData.getData().get("zip").toString())
                                .relaxedHTTPSValidation().log().all()
                )
        );
    }

    public static ExecuteGetByZipCode service(String resource) {
        return Tasks.instrumented(ExecuteGetByZipCode.class, resource);
    }
}
