package ortelius.utilities;

import com.github.javafaker.Faker;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ReusableMethod {

    public static String getEnvironmentValue(String key)
    {
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        return EnvironmentSpecificConfiguration.from(variables).getProperty(key);
    }

    public static String getDynamicString(int numberOfCharacter)
    {
        Faker faker = new Faker();
        return faker.random().hex(numberOfCharacter);
    }

    public static Performable jsEnterValue(By locator, String value)
    {
        Performable obj = new Performable() {
            @Override
            @Step("{0} enter value:")
            public <T extends Actor> void performAs(T actor) {
                  Performable  performable = (Performable) BrowseTheWeb.as(actor)
                            .evaluateJavascript("arguments[0].value='" + value + "';"
                                    , BrowseTheWeb.as(actor).$(locator));
            }
        };
       return obj;
    }

    public static Performable jsEnterValue(Target target, String value)
    {
        Performable obj = new Performable() {
            @Override
            @Step("{0} enter value:")
            public <T extends Actor> void performAs(T actor) {
                Performable  performable = (Performable) BrowseTheWeb.as(actor)
                        .evaluateJavascript("arguments[0].value='" + value + "';"
                                , target.resolveFor(actor));
            }
        };
        return obj;
    }

    public static Performable jsEnterValue(WebElement element, String value)
    {
        Performable obj = new Performable() {
            @Override
            @Step("{0} enter value:")
            public <T extends Actor> void performAs(T actor) {
                Performable  performable = (Performable) BrowseTheWeb.as(actor)
                        .evaluateJavascript("arguments[0].value='" + value + "';"
                                ,element);
            }
        };
        return obj;
    }

    public static Performable jsSelectByVisibleText(By locator, String value) {
        Performable obj = new Performable() {
            @Override
            @Step("{0} select value from Dropdown:")
            public <T extends Actor> void performAs(T actor) {

                    WebElementFacade select = BrowseTheWeb.as(actor).$(locator);
                    Performable performable = (Performable) BrowseTheWeb.as(actor)
                            .evaluateJavascript(
                                    "var select = arguments[0]; "
                                            + "for(var i = 0; i < select.options.length; i++)"
                                            + "{ if(select.options[i].text == arguments[1])"
                                            + "{ select.options[i].selected = true; } }"
                                    , select, value);

            }
        };
        return obj;
    }

    public static Performable jsSelectByVisibleText(Target target, String value) {
        Performable obj = new Performable() {
            @Override
            @Step("{0} select value from Dropdown:")
            public <T extends Actor> void performAs(T actor) {

                WebElementFacade select = target.resolveFor(actor);
                Performable performable = (Performable) BrowseTheWeb.as(actor)
                        .evaluateJavascript(
                                "var select = arguments[0]; "
                                        + "for(var i = 0; i < select.options.length; i++)"
                                        + "{ if(select.options[i].text == arguments[1])"
                                        + "{ select.options[i].selected = true; } }"
                                , select, value);

            }
        };
        return obj;
    }
}

