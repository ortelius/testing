package ortelius.stepdefinitions.Applications;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import ortelius.task.Applications.KeyValueConfigurationTab;

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
        actor.attemptsTo(KeyValueConfigurationTab.verifyKeyAndValue(name, value));
    }

}
