package ortelius.testsuite;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"ortelius/stepdefinitions"},
        //features = "src/test/resources/features/Endpoints/"
        features = "src/test/resources/features/Endpoints/DetailsTab.feature"

)

public class EndpointsTestSuite {
}
