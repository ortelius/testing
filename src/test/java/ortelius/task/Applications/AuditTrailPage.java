package ortelius.task.Applications;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class AuditTrailPage {

    public static Target txtAuditTrail = Target.the("Audit Trail TextBox")
            .located(By.id("messageText"));

    public static Target btnAddMessage = Target.the("Audit Trail Add Message Button")
            .located(By.id("addMessage"));

    public static Target lblFirstEvent = Target.the("First Event Message")
            .located(By.xpath("//td[contains(text(),'less than a minute ago by')]"));

    public static Performable enterValueInMessageTextBox(String message) {
        return Task.where("Enter value in Audit Trail text box",
                actor -> actor.attemptsTo(Enter.theValue(message).into(txtAuditTrail)));
    }

    public static Performable clickOnAddMessageButton() {
        return Task.where("Click on Add Message Button",
                JavaScriptClick.on(btnAddMessage));
    }

    public static Performable verifyMessge(String message) {
        return Task.where("Verify Message",
                Ensure.that(Text.of(lblFirstEvent)).contains(message));
    }
}

