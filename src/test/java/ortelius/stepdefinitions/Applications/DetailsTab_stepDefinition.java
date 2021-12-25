package ortelius.stepdefinitions.Applications;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import ortelius.task.Applications.DetailsTab;

public class DetailsTab_stepDefinition {

    @When("{actor} is opened {string} version")
    public void user_is_opened_version(Actor actor, String version) {
        actor.attemptsTo(DetailsTab.openVersionFromWebTable(version));
    }

    @When("{actor} is click on Edit button in details tab")
    public void user_is_click_on_edit_button_in_details_tab(Actor actor) {
        actor.attemptsTo(DetailsTab.clickOnEditButton());
    }

    @When("{actor} click on Save button")
    public void user_click_on_save_button(Actor actor) {
        actor.attemptsTo(DetailsTab.clickOnSaveButton());
    }

    @When("{actor} is modified {string} value in Full Domain Dropdown")
    public void user_is_modified_value_in_full_domain_dropdown(Actor actor, String fullDomianName) {
        actor.attemptsTo(DetailsTab.modifyFullDomainName(fullDomianName));
    }

    @When("{actor} is modified {string} value in Name text box")
    public void user_is_modified_value_in_name_text_box(Actor actor, String name) {
        actor.attemptsTo(DetailsTab.modifyFullName(name));
    }

    @When("{actor} is modified {string} value in Description text box")
    public void user_is_modified_value_in_description_text_box(Actor actor, String description) {
        actor.attemptsTo(DetailsTab.modifyDescription(description));
    }

    @When("{actor} is modified {string} value in Change Request Data Source Dropdown")
    public void user_is_modified_value_in_change_request_data_source_dropdown(Actor actor, String changeRequestDataSource) {
        actor.attemptsTo(DetailsTab.modifyChangeRequestDataSource(changeRequestDataSource));
    }

    @When("{actor} is modified {string} value in Pre Action Dropdown")
    public void user_is_modified_value_in_pre_action_dropdown(Actor actor, String preAction) {
        actor.attemptsTo(DetailsTab.modifyPreAction(preAction));
    }

    @When("{actor} is modified {string} value in Post Action Dropdown")
    public void user_is_modified_value_in_post_action_dropdown(Actor actor, String postAction) {
        actor.attemptsTo(DetailsTab.modifyPostAction(postAction));
    }

    @When("{actor} is modified {string} value in Custom Action Dropdown")
    public void user_is_modified_value_in_custom_action_dropdown(Actor actor, String customAction) {
        actor.attemptsTo(DetailsTab.modifyCustomAction(customAction));
    }

    @When("{actor} is modified {string} value in Successfull Deployment Template Dropdown")
    public void user_is_modified_value_in_successfull_deployment_template_dropdown(Actor actor, String successfullDeploymentTemplate) {
        actor.attemptsTo(DetailsTab.modifySuccessfullDeploymentTemplate(successfullDeploymentTemplate));
    }

    @When("{actor} is modified {string} value in Failed Deployment Template Dropdown")
    public void user_is_modified_value_in_failed_deployment_template_dropdown(Actor actor, String failedDeploymentTemplate) {
        actor.attemptsTo(DetailsTab.modifyFailedDeploymentTemplate(failedDeploymentTemplate));
    }

    @Then("{actor} is able to see updated {string} value in Full Domain Dropdown")
    public void user_is_able_to_see_updated_value_in_full_domain_dropdown(Actor actor, String fullDomain) {
        Ensure.that(DetailsTab.lblFullDomainName).text().isEqualTo(fullDomain);
    }

    @Then("{actor} is able to see updated {string} value in Name text box")
    public void user_is_able_to_see_updated_value_in_name_text_box(Actor actor, String name) {
        Ensure.that(DetailsTab.txtName).text().isEqualTo(name);
    }

    @Then("{actor} is able to see updated {string} value in Description text box")
    public void user_is_able_to_see_updated_value_in_description_text_box(Actor actor, String description) {
        Ensure.that(DetailsTab.lblDescription).text().isEqualTo(description);
    }

    @Then("{actor} is able to see updated {string} value in Change Request Data Source Dropdown")
    public void user_is_able_to_see_updated_value_in_change_request_data_source_dropdown(Actor actor, String changeRequestDataSource) {
        Ensure.that(DetailsTab.lstChangeRequestDataSource).text().isEqualTo(changeRequestDataSource);
    }

    @Then("{actor} is able to see updated {string} value in Pre Action Dropdown")
    public void user_is_able_to_see_updated_value_in_pre_action_dropdown(Actor actor, String preAction) {
        Ensure.that(DetailsTab.lstPreAction).text().isEqualTo(preAction);
    }

    @Then("{actor} is able to see updated {string} value in Post Action Dropdown")
    public void user_is_able_to_see_updated_value_in_post_action_dropdown(Actor actor, String postAction) {
        Ensure.that(DetailsTab.lstPostAction).text().isEqualTo(postAction);
    }

    @Then("{actor} is able to see updated {string} value in Custom Action Dropdown")
    public void user_is_able_to_see_updated_value_in_custom_action_dropdown(Actor actor, String customAction) {
        // Write code here that turns the phrase above into concrete actions
        Ensure.that(DetailsTab.lstCustomAction).text().isEqualTo(customAction);
    }

    @Then("{actor} is able to see updated {string} value in Successfull Deployment Template Dropdown")
    public void user_is_able_to_see_updated_value_in_successfull_deployment_template_dropdown(Actor actor, String successfulDeploymentTemplate) {
        Ensure.that(DetailsTab.lstSuccessfulDeploymentTemplate).text().isEqualTo(successfulDeploymentTemplate);
    }

    @Then("{actor} is able to see updated {string} value in Failed Deployment Template Dropdown")
    public void user_is_able_to_see_updated_value_in_failed_deployment_template_dropdown(Actor actor, String failedDeploymentTemplate) {
        Ensure.that(DetailsTab.lstFailedDeploymentTemplate).text().isEqualTo(failedDeploymentTemplate);
    }


}
