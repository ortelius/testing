package ortelius;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        //features = "src/test/resources/features/Applications"
        features = "src/test/resources/features/Login.feature"
)
public class CucumberTestSuite {}
