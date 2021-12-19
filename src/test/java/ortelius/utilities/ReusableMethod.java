package ortelius.utilities;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.openqa.selenium.By;

public class ReusableMethod {

    public static String getEnvironmentValue(String key)
    {
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        return EnvironmentSpecificConfiguration.from(variables).getProperty(key);
    }

    public static Performable jsEnterValue(By locator, String value)
    {
        Performable obj = new Performable() {
            @Override
            public <T extends Actor> void performAs(T actor) {
              //  if(!value.trim().equals("<NA>")) {
                  Performable  performable = (Performable) BrowseTheWeb.as(actor)
                            .evaluateJavascript("arguments[0].value='" + value + "';"
                                    , BrowseTheWeb.as(actor).$(locator));
               // }
            }
        };
       return obj;
    }

    public static Performable jsSelectByVisibleText(By locator, String value) {
        Performable obj = new Performable() {
            @Override
            public <T extends Actor> void performAs(T actor) {
              //  if (!value.trim().equals("<NA>")) {
                    WebElementFacade select = BrowseTheWeb.as(actor).$(locator);
                    Performable performable = (Performable) BrowseTheWeb.as(actor)
                            .evaluateJavascript(
                                    "var select = arguments[0]; "
                                            + "for(var i = 0; i < select.options.length; i++)"
                                            + "{ if(select.options[i].text == arguments[1])"
                                            + "{ select.options[i].selected = true; } }"
                                    , select, value);
                //}
            }
        };
        return obj;
    }
}
