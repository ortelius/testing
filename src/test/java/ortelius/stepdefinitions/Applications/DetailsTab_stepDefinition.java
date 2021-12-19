package ortelius.stepdefinitions.Applications;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.Text;
import org.openqa.selenium.By;
import ortelius.task.Applications.DetailsTab;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.hasValue;

public class DetailsTab_stepDefinition {

    @When("{actor} is opened {string} version")
    public void user_is_opened_version(Actor actor, String version) {
        actor.attemptsTo(DetailsTab.openVersionFromWebTable(version));
    }

    @When("{actor} is click on Edit button in details tab")
    public void user_is_click_on_edit_button_in_details_tab(Actor actor) {
        actor.attemptsTo(DetailsTab.clickOnEditButton());
    }

    @When("{actor} is modified below values in Details tab")
    public void user_is_modified_below_values_in_details_tab(Actor actor, io.cucumber.datatable.DataTable dataTable) {
        actor.attemptsTo(DetailsTab.changeValues(dataTable));
    }

    @When("{actor} click on Save button")
    public void user_click_on_save_button(Actor actor) {
        actor.attemptsTo(DetailsTab.clickOnSaveButton());
    }

    @Then("{actor} is able to see updated values in details tab")
    public void user_is_able_to_see_updated_values_in_details_tab(Actor actor, io.cucumber.datatable.DataTable dataTable) {
       // actor.attemptsTo(DetailsTab.verifyChangeValues(dataTable));
    }
}
