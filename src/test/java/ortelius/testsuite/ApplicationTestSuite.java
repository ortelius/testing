package ortelius.testsuite;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"ortelius/stepdefinitions"},
        features = "src/test/resources/features/Applications/"
        //features = "src/test/resources/features/Applications/DetailsTab.feature"
        //features = "src/test/resources/features/Applications/KeyValueConfiguration.feature"
        //features = "src/test/resources/features/Applications/AuditTrail.feature"
)

public class ApplicationTestSuite {
}
