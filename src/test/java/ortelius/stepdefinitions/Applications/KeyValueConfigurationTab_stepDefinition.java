package ortelius.stepdefinitions.Applications;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.*;
import net.thucydides.core.annotations.locators.WaitForWebElements;
import net.thucydides.core.pages.components.HtmlTable;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ortelius.task.Applications.KeyValueConfigurationTab;
import ortelius.task.CommonObject;
import ortelius.utilities.ReusableMethod;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.MINUTES;
import static java.time.temporal.ChronoUnit.SECONDS;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class KeyValueConfigurationTab_stepDefinition {

    @When("{actor} is click on Add button in Key value configuration tab")
    public void user_is_click_on_add_button_in_key_value_configuration_tab(Actor actor) {
        actor.attemptsTo(KeyValueConfigurationTab.clickOnAddButton());
    }

    @When("{actor} is entered {string} value in Name text box in Key value configuration tab")
    public void user_is_entered_value_in_name_text_box_in_key_value_configuration_tab(Actor actor, String name) throws InterruptedException {
        actor.attemptsTo(KeyValueConfigurationTab.enterName(name));
    }

    @When("{actor} is entered {string} value in Value text box in Key value configuration tab")
    public void user_is_entered_value_in_value_text_box_in_key_value_configuration_tab(Actor actor, String value) {
        actor.attemptsTo(KeyValueConfigurationTab.enterValue(value));
    }

    @When("{actor} is click on Save button in Key value configuration tab")
    public void user_is_click_on_save_button_in_key_values_configuration_tab(Actor actor) {
        actor.attemptsTo(KeyValueConfigurationTab.clickOnSaveButton());
    }

    @Then("{actor} is able to see {string} and {string} in Key value configuration table")
    public void user_is_able_to_see_and_in_key_value_configuration_table(Actor actor, String name, String value) {
        actor.attemptsTo(
                WaitUntil.the(CommonObject.iconHangOn, isNotVisible())
                        .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("maxWait").trim()))
                        .seconds().then(WaitUntil.the(KeyValueConfigurationTab.tblKeyValueConfigNowOfRecords, isVisible())
                                .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("maxWait").trim()))
                                .seconds()).then(KeyValueConfigurationTab.verifyKeyAndValue(name, value)));
    }

    @When("{actor} is select all key and value check box")
    public void userIsSelectAllKeyAndValueCheckBox(Actor actor) {

        actor.attemptsTo(
        WaitUntil.the(CommonObject.iconHangOn, isNotVisible())
                .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("maxWait").trim()))
                .seconds().then(KeyValueConfigurationTab.clickOnAllCheckBox()));

    }

    @And("{actor} is click on Delete button in Key value configuration table")
    public void userIsClickOnDeleteButtonInKeyValueConfigurationTable(Actor actor) {
        actor.attemptsTo(KeyValueConfigurationTab.clickOnDeleteButton());
    }

    @Then("{actor} is verify empty table in Key value configuration table")
    public void userIsVerifyEmptyTableInKeyValueConfigurationTable(Actor actor) {
        actor.attemptsTo(KeyValueConfigurationTab.verifyAllKeyAndValueDeletedInTable());
    }
}
