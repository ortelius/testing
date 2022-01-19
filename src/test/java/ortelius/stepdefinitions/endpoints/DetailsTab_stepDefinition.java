package ortelius.stepdefinitions.endpoints;

import com.sun.istack.NotNull;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.pages.components.HtmlTable;
import ortelius.task.CommonObject;
import ortelius.task.endpoints.DetailsTabPage;
import ortelius.utilities.ReusableMethod;

import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.asynchttpclient.util.MiscUtils.isEmpty;
import static org.jsoup.internal.StringUtil.isBlank;
import static ortelius.task.endpoints.DetailsTabPage.tableEndPoint;

public class DetailsTab_stepDefinition {

    String dynamicName;
    @When("{actor} is click on Endpoints button in Endpoint details tab")
    public void user_is_click_on_endpoints_button_in_endpoint_details_tab(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(CommonObject.iconHangOn, isNotVisible())
                        .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("maxWait").trim()))
                        .seconds().then(DetailsTabPage.clickOnEndpointTab()));

    }
    @When("{actor} is select {string} value from Full Domain list box")
    public void user_is_select_value_from_full_domain_list_box(Actor actor, String fullDomain) {
        actor.attemptsTo(
                WaitUntil.the(CommonObject.iconHangOn, isNotVisible())
                        .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("maxWait").trim()))
                        .seconds().then(DetailsTabPage.selectFullDomainValue(fullDomain)));
        
    }
    @When("{actor} is enter {string} value in Name text box")
    public void user_is_enter_value_in_name_text_box(Actor actor, String name) {
        dynamicName = ReusableMethod.getDynamicString(10);
        actor.attemptsTo(
                WaitUntil.the(CommonObject.iconHangOn, isNotVisible())
                        .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("maxWait").trim()))
                        .seconds().then(DetailsTabPage.enterName(isBlank(name) ? dynamicName : name)));

    }
    @When("{actor} is enter {string} value in Description text box")
    public void user_is_enter_value_in_description_text_box(Actor actor, String description) {
        actor.attemptsTo(
                WaitUntil.the(CommonObject.iconHangOn, isNotVisible())
                        .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("maxWait").trim()))
                        .seconds().then(DetailsTabPage.enterDescription(description)));
        
    }
    @When("{actor} is select {string} value from Endpoint Operating System list box")
    public void user_is_select_value_from_endpoint_operating_system_list_box(Actor actor, String endpointOperatingSystem) {
        actor.attemptsTo(
                WaitUntil.the(CommonObject.iconHangOn, isNotVisible())
                        .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("maxWait").trim()))
                        .seconds().then(DetailsTabPage.selectEndpointOperatingSystem(endpointOperatingSystem)));
        
    }
    @When("{actor} is select {string} value from Endpoint Types list box")
    public void user_is_select_value_from_endpoint_types_list_box(Actor actor, String endporintTypes) {
        actor.attemptsTo(
                WaitUntil.the(CommonObject.iconHangOn, isNotVisible())
                        .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("maxWait").trim()))
                        .seconds().then(DetailsTabPage.selectEndpointTypes(endporintTypes)));
        
    }
    @When("{actor} is enter {string} value in Hostname text box")
    public void user_is_enter_value_in_hostname_text_box(Actor actor, String hostname) {
        actor.attemptsTo(
                WaitUntil.the(CommonObject.iconHangOn, isNotVisible())
                        .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("maxWait").trim()))
                        .seconds().then(DetailsTabPage.enterHostname(hostname)));
        
    }
    @When("{actor} is select {string} value from Protocal list box")
    public void user_is_select_value_from_protocal_list_box(Actor actor, String protocal) {
        actor.attemptsTo(
                WaitUntil.the(CommonObject.iconHangOn, isNotVisible())
                        .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("maxWait").trim()))
                        .seconds().then(DetailsTabPage.selectProtocal(protocal)));
    }
    @When("{actor} is enter {string} value in SSH Port Number text box")
    public void user_is_enter_value_in_ssh_port_number_text_box(Actor actor, String sshPortNumber) {
        actor.attemptsTo(
                WaitUntil.the(CommonObject.iconHangOn, isNotVisible())
                        .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("maxWait").trim()))
                        .seconds().then(DetailsTabPage.enterSSHportNumber(sshPortNumber)));
    }
    @When("{actor} is enter {string} value in Base Directory text box")
    public void user_is_enter_value_in_base_directory_text_box(Actor actor, String baseDirectory) {
        actor.attemptsTo(
                WaitUntil.the(CommonObject.iconHangOn, isNotVisible())
                        .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("maxWait").trim()))
                        .seconds().then(DetailsTabPage.enterBaseDirectory(baseDirectory)));
        
    }
    @When("{actor} is select {string} value from Credential list box")
    public void user_is_select_value_from_credential_list_box(Actor actor, String credential) {
        actor.attemptsTo(
                WaitUntil.the(CommonObject.iconHangOn, isNotVisible())
                        .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("maxWait").trim()))
                        .seconds().then(DetailsTabPage.selectCredential(credential)));
        
    }
    @When("{actor} is select {string} value from Ping Failure Template list box")
    public void user_is_select_value_from_ping_failure_template_list_box(Actor actor, String pingFailureTemplate) {
        actor.attemptsTo(
                WaitUntil.the(CommonObject.iconHangOn, isNotVisible())
                        .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("maxWait").trim()))
                        .seconds().then(DetailsTabPage.selectPingFailureTemplate(pingFailureTemplate)));
        
    }
    @When("{actor} is click on Save button in Endpoint details tab")
    public void user_is_click_on_save_button_in_endpoint_details_tab(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(CommonObject.iconHangOn, isNotVisible())
                        .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("maxWait").trim()))
                        .seconds().then(DetailsTabPage.clickOnSaveButtonTab()));
    }


    @And("{actor} is click on Add button in Endpoint details tab")
    public void userIsClickOnAddButtonInEndpointDetailsTab(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(CommonObject.iconHangOn, isNotVisible())
                        .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("maxWait").trim()))
                        .seconds()
                        .then(DetailsTabPage.clickAddButtonEndpointTab()));
    }

    @Then("{actor} is able to see {string} value Endpoint Table")
    public void user_is_able_to_see_value_endpoint_table(Actor actor, String name) {

        actor.attemptsTo(
                WaitUntil.the(CommonObject.iconHangOn, isNotVisible())
                        .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("maxWait").trim()))
                        .seconds());

        actor.attemptsTo(
                WaitUntil.the(CommonObject.iconHangOn, isNotVisible())
                        .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("maxWait").trim()))
                        .seconds()
                        .then(DetailsTabPage.verifyEndpointDetailInTable(isBlank(name) ? dynamicName : name)));
    }

    @And("{actor} is select {string} value from Show entry list box")
    public void userIsSelectValueFromShowEntryListBox(Actor actor, String showEntryOption) {
        actor.attemptsTo(
                WaitUntil.the(CommonObject.iconHangOn, isNotVisible())
                        .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("maxWait").trim()))
                        .seconds()
                        .then(DetailsTabPage.selectValueFromShowEntriesListBox(showEntryOption))
        );
    }

    @When("{actor} is able to filter {string} on Endpoints table")
    public void user_is_able_to_filter_on_endpoints_table(Actor actor, String endPointName) {
        actor.attemptsTo(
                WaitUntil.the(CommonObject.iconHangOn, isNotVisible())
                        .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("maxWait").trim()))
                        .seconds()
                        .then(DetailsTabPage.filterEndPointInEndpointWebTable(isBlank(endPointName) ? dynamicName : endPointName)));
    }
    @When("{actor} is select {string} checkbox on Endpoints table")
    public void user_is_select_checkbox_on_endpoints_table(Actor actor, String recordNumber) {
        actor.attemptsTo(
                WaitUntil.the(CommonObject.iconHangOn, isNotVisible())
                        .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("maxWait").trim()))
                        .seconds()
                        .then(DetailsTabPage.selectCheckboxinEndpointWebTable(recordNumber)));
    }
    @When("{actor} is click on Delete button in Endpoint details tab")
    public void user_is_click_on_delete_button_in_endpoint_details_tab(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(CommonObject.iconHangOn, isNotVisible())
                        .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("maxWait").trim()))
                        .seconds()
                        .then(DetailsTabPage.clickOnDeleteButtonInEndpointTab()));
        
    }
    @When("{actor} is click on Ok button in Delete confirmation pop up in Endpoint details tab")
    public void user_is_click_on_ok_button_in_delete_confirmation_pop_up_in_endpoint_details_tab(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(CommonObject.iconHangOn, isNotVisible())
                        .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("maxWait").trim()))
                        .seconds()
                        .then(DetailsTabPage.clickOkButtonInConfirmationPopUp()));
    }
    @Then("{actor} is able to see {string} word in Endpoints table")
    public void user_is_able_to_see_word_in_endpoints_table(Actor actor, String message) {
        actor.attemptsTo(
                WaitUntil.the(CommonObject.iconHangOn, isNotVisible())
                        .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("maxWait").trim()))
                        .seconds()
                        .then(DetailsTabPage.verifyMessageInEndpointTable(message)));
    }
}
