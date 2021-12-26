package ortelius.stepdefinitions.applications;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ortelius.task.applications.KeyValueConfigurationTabPage;
import ortelius.task.CommonObject;
import ortelius.utilities.ReusableMethod;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;

public class KeyValueConfigurationTab_stepDefinition {

    @When("{actor} is click on Add button in Key value configuration tab")
    public void user_is_click_on_add_button_in_key_value_configuration_tab(Actor actor) {
        actor.attemptsTo(KeyValueConfigurationTabPage.clickOnAddButton());
    }

    @When("{actor} is entered {string} value in Name text box in Key value configuration tab")
    public void user_is_entered_value_in_name_text_box_in_key_value_configuration_tab(Actor actor, String name) throws InterruptedException {
        actor.attemptsTo(KeyValueConfigurationTabPage.enterName(name));
    }

    @When("{actor} is entered {string} value in Value text box in Key value configuration tab")
    public void user_is_entered_value_in_value_text_box_in_key_value_configuration_tab(Actor actor, String value) {
        actor.attemptsTo(KeyValueConfigurationTabPage.enterValue(value));
    }

    @When("{actor} is click on Save button in Key value configuration tab")
    public void user_is_click_on_save_button_in_key_values_configuration_tab(Actor actor) {
        actor.attemptsTo(KeyValueConfigurationTabPage.clickOnSaveButton());
    }

    @Then("{actor} is able to see {string} and {string} in Key value configuration table")
    public void user_is_able_to_see_and_in_key_value_configuration_table(Actor actor, String name, String value) {
        actor.attemptsTo(
                WaitUntil.the(CommonObject.iconHangOn, isNotVisible())
                        .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("maxWait").trim()))
                        .seconds().then(KeyValueConfigurationTabPage.verifyKeyAndValue(name, value)));
    }

    @When("{actor} is select all key and value check box")
    public void userIsSelectAllKeyAndValueCheckBox(Actor actor) {

        actor.attemptsTo(
        WaitUntil.the(CommonObject.iconHangOn, isNotVisible())
                .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("maxWait").trim()))
                .seconds().then(KeyValueConfigurationTabPage.clickOnAllCheckBox()));

    }

    @And("{actor} is click on Delete button in Key value configuration table")
    public void userIsClickOnDeleteButtonInKeyValueConfigurationTable(Actor actor) {
        actor.attemptsTo(KeyValueConfigurationTabPage.clickOnDeleteButton());
    }

    @Then("{actor} is verify empty table in Key value configuration table")
    public void userIsVerifyEmptyTableInKeyValueConfigurationTable(Actor actor) {
        actor.attemptsTo(KeyValueConfigurationTabPage.verifyAllKeyAndValueDeletedInTable());
    }
}
