package ortelius.task;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.ui.Button;
import ortelius.utilities.ReusableMethod;

public class GeneralComponents {
    public static Performable loginPage()
    {
        return Task.where("Navigate to Home Page",
            Open.url(ReusableMethod.getEnvironmentValue("serenity.base.url").trim()));
    }

    public static Performable clickOnButton(String buttonName) {

        return Task.where("Click on "+ buttonName +"Button ",
         Click.on(Button.called(buttonName)));
    }
}
