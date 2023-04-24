package us.zippopotam.api.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;
import org.hamcrest.Matchers;
import us.zippopotam.api.models.TestData;

public class VerifyCityName implements Question<Boolean> {


    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
                ResponseConsequence
                        .seeThatResponse("Fields get service API response exists",
                                response -> response
                                        .assertThat().log().all()
                                .body("places[0].'place name'", Matchers.equalTo(TestData.getData().get("cityName"))
                )));
        return true;
    }

    public static VerifyCityName is() {
        return new VerifyCityName();
    }
}
