package ortelius.task.applications;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class AuditTrailPage {

    public static String chkRecordVersion = "//table[@id='applist']/descendant::td[<RECORD_NUMBER>]";
    public static String chkRecordRow = "//table[@id='applist']/descendant::tr[<RECORD_NUMBER>]";

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

    public static Performable openVersionBasedOnRecordNumber(String recordNumber) {
        By locCheckbox = By.xpath(chkRecordVersion.replace("<RECORD_NUMBER>", recordNumber));
        By locRow = By.xpath(chkRecordRow.replace("<RECORD_NUMBER>", String.valueOf(Integer.valueOf(recordNumber)+1)));

        BrowseTheWeb.as(OnStage.theActorInTheSpotlight()).$(locCheckbox).waitUntilEnabled();
        WebElementFacade chk = BrowseTheWeb.as(OnStage.theActorInTheSpotlight()).$(locCheckbox);
        WebElementFacade row = BrowseTheWeb.as(OnStage.theActorInTheSpotlight()).$(locRow);

        return  Task.where("{0} Open Version Record Number : " + recordNumber,

                MoveMouse.to(locCheckbox).andThen(Actions::click),
                MoveMouse.to(locRow).andThen(Actions::doubleClick)
        );
    }
}

