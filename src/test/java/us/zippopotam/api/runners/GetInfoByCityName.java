package us.zippopotam.api.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = "src/test/resources/features/getInformationByZipCode.feature",
        glue = {
                "us.zippopotam.api.stepdefinitions.hook",
                "us.zippopotam.api.stepdefinitions"
        }
)
public class GetInfoByCityName {
}