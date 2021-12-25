package ortelius.stepdefinitions.Applications;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ortelius.task.Applications.AuditTrailPage;
import ortelius.task.Applications.KeyValueConfigurationTab;
import ortelius.task.CommonObject;
import ortelius.utilities.ReusableMethod;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;

public class AuditTrailTab_stepDefinition {

    @When("{actor} is enter {string} value in message in Audit Trail text box")
    public void user_is_enter_value_in_message_in_audit_trail_text_box(Actor actor, String message) {
        actor.attemptsTo(
                WaitUntil.the(CommonObject.iconHangOn, isNotVisible())
                        .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("maxWait").trim()))
                        .seconds().then(AuditTrailPage.enterValueInMessageTextBox(message)));
    }

    @When("{actor} is click on Add Message button in Audit Trail tab")
    public void user_is_click_on_add_message_button_in_audit_trail_tab(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(CommonObject.iconHangOn, isNotVisible())
                        .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("maxWait").trim()))
                        .seconds().then(AuditTrailPage.clickOnAddMessageButton()));
    }

    @Then("{actor} is able to see {string} value in Event details tab")
    public void user_is_able_to_see_value_in_event_details_tab(Actor actor, String message) {
        actor.attemptsTo(
                WaitUntil.the(CommonObject.iconHangOn, isNotVisible())
                        .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("maxWait").trim()))
                        .seconds().then(AuditTrailPage.verifyMessge(message)));
    }
}
