package us.zippopotam.api.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import us.zippopotam.api.interactions.ExecuteGetByZipCode;

public class GetByZipCode implements Task {
    private final String resource;

    public GetByZipCode(String resource) {
        this.resource = resource;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(ExecuteGetByZipCode.service(resource));
    }

    public static GetByZipCode service(String resource) {
        return Tasks.instrumented(GetByZipCode.class, resource);
    }
}
