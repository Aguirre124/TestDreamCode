package us.zippopotam.api.questions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;

public class VerifyStatusCode implements Question<Boolean> {

    private final int statusCode;

    public VerifyStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(ResponseConsequence
                .seeThatResponse("Status Code", responseCode -> responseCode.statusCode(statusCode))
        );
        return true;
    }

    public static VerifyStatusCode is(int statusCode) {
        return new VerifyStatusCode(statusCode);
    }
}
