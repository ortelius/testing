package ortelius.testsuite;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"ortelius/stepdefinitions"},
        features = "src/test/resources/features/applications/"
        //features = "src/test/resources/features/applications/DetailsTab.feature"
        // features = "src/test/resources/features/applications/KeyValueConfigurationTab.feature"
        // features = "src/test/resources/features/applications/AuditTrailTab.feature"
)

public class ApplicationTestSuite {
}
