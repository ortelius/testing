package ortelius.task.endpoints;

import io.cucumber.java.af.En;
import io.cucumber.java.en.But;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import ortelius.task.CommonObject;
import ortelius.utilities.ReusableMethod;

import java.security.Key;
import java.util.stream.Collectors;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class DetailsTabPage {

    public static final Target btnNext =
            Target.the("Next")
                    .located(By.id("endpointlist_next"));

    public static Target tabEndPoint = Target.the("Endpoint Tab")
            .located(By.cssSelector("button[class*='tablinks verttab_endpoint']"));

    public static Target tableEndPoint = Target.the("Endpoint Table")
            .located(By.cssSelector("table[id='endpointlist']"));

    public static Target tableEndPointRecord = Target.the("Endpoint Column")
            .located(By.cssSelector("table[id='endpointlist'] tr td[class='sorting_1']"));

    public static Target btnAdd = Target.the("Add Button")
            .located(By.cssSelector("div[id='endpointlist_pane'] button[onclick*='addRow']"));

    public static Target btnEdit = Target.the("Edit Button")
            .located(By.cssSelector("div[id='summ_header_buttons'] button[onclick*='EditSummaryButton']"));

    public static Target btnSave = Target.the("Save Button")
            .located(By.cssSelector("div[id='summ_header_buttons'] button[onclick*='summOK']"));

    public static Target lstFullDomain = Target.the("Full Domain")
            .located(By.name("fulldomain_val"));

    public static Target txtName = Target.the("Name")
            .located(By.name("name_val"));

    public static Target txtDescription = Target.the("Description")
            .located(By.name("summary_val"));

    public static Target lstEndpointOperatingSystem = Target.the("Endpoint Operating System")
            .located(By.name("servertype_val"));

    public static Target lstEndpointType = Target.the("Endpoint Type")
            .located(By.name("servercomptype_val"));

    public static Target txtHostname = Target.the("Hostname")
            .located(By.name("hostname_val"));

    public static Target lstProtocal = Target.the("Protocol")
            .located(By.name("protocol_val"));

    public static Target txtSSHPortNumber = Target.the("SSH Port Number")
            .located(By.name("sshport_val"));

    public static Target txtBaseDirectory = Target.the("Base Directory")
            .located(By.name("basedirectory_val"));

    public static Target lstCredential = Target.the("Credential")
            .located(By.name("credential_val"));

    public static Target lstPingFailureTemplate = Target.the("Ping Failure Template")
            .located(By.name("template_val"));

    public static Target lstShowEntries = Target.the("Show Entries")
            .located(By.name("endpointlist_length"));

    public static Target tblEndpointTableEmptyRecord = Target.the("Endpoint Table Empty Record")
            .locatedBy("table[id='endpointlist'] td[class='dataTables_empty']");

    public static Target btnDeleteConfirmationOkButton = Target.the("Delete confirmation Ok button")
            .locatedBy("//div[@aria-describedby='modal']/descendant::button[2]");

    public static Target btnDelete = Target.the("Delete Button")
            .located(By.cssSelector("div[id='endpointlist_pane'] button[onclick*='delRow']"));

    public static Target btnAllCheckbox = Target.the("Endpoint Checkbox")
            .located(By.cssSelector("table[id='endpointlist'] td[class=' select-checkbox']"));

    public static Target lblFilter = Target.the("Endpoint Checkbox")
            .located(By.cssSelector("div[id='endpointlist_filter_area'] div[class='VS-search-inner'] input"));

    public static Target txtFilter = Target.the("Endpoint Checkbox")
            .located(By.cssSelector("div[class='search_facet_input_container'] input"));

    public static Target lnkEndPoint = Target.the("Endpoint Link")
            .located(By.linkText("Endpoint"));

    public static Target lnkClearFilter = Target.the("Clear Filter")
            .locatedBy("div[id='endpoint_search_box_container'] div[title='clear search']");

    public static Performable clickOnEndpointTab() {
        return Task.where("Click On Endpoint Tab",
                Click.on(tabEndPoint)
        );
    }

    public static Performable selectFullDomainValue(String fullDomain) {
        return Task.where("Click On Endpoint Tab",
                ReusableMethod.jsSelectByVisibleText(lstFullDomain, fullDomain)
        );
    }

    public static Performable enterName(String name) {
        return Task.where("Enter name",
                ReusableMethod.jsEnterValue(txtName, name)
        );
    }

    public static Performable enterDescription(String description) {
        return Task.where("Enter Description",
                ReusableMethod.jsEnterValue(txtDescription, description)
        );
    }

    public static Performable selectEndpointOperatingSystem(String endpointOperatingSystem) {
        return Task.where("Select Endpoint Operating System",
                ReusableMethod.jsSelectByVisibleText(lstEndpointOperatingSystem, endpointOperatingSystem)
        );
    }

    public static Performable selectEndpointTypes(String endporintTypes) {
        return Task.where("Select Endpoint Type",
                ReusableMethod.jsSelectByVisibleText(lstEndpointType, endporintTypes)
        );
    }

    public static Performable enterHostname(String hostname) {
        return Task.where("Select Hostname Type",
                ReusableMethod.jsEnterValue(txtHostname, hostname));

    }

    public static Performable selectProtocal(String protocal) {
        return Task.where("Select Protocal",
                ReusableMethod.jsSelectByVisibleText(lstProtocal, protocal)
        );
    }

    public static Performable enterSSHportNumber(String sshPortNumber) {
        return Task.where("Enter Hostname Type",
                ReusableMethod.jsEnterValue(txtSSHPortNumber, sshPortNumber));
    }

    public static Performable enterBaseDirectory(String baseDirectory) {
        return Task.where("Enter Base Directory Type",
                ReusableMethod.jsEnterValue(txtBaseDirectory, baseDirectory));
    }

    public static Performable selectCredential(String credential) {
        return Task.where("Select Credential",
                ReusableMethod.jsSelectByVisibleText(lstCredential, credential)
        );
    }

    public static Performable selectPingFailureTemplate(String pingFailureTemplate) {
        return Task.where("Select Ping Failure Template",
                ReusableMethod.jsSelectByVisibleText(lstPingFailureTemplate, pingFailureTemplate)
        );
    }

    public static Performable verifyEndpointDetailInTable(String name) {
        return Task.where("{0} Verify Endpoint Detail in Table :" + name,
                Ensure.that(tableEndPointRecord.resolveAllFor(BrowseTheWeb.as(OnStage.theActorInTheSpotlight())
                                .waitForAllTextToAppear(name))
                        .stream().filter(e -> e.getText().contains(name))
                        .peek(e -> System.out.println("New Created Row : " + e.getText()))
                        .collect(Collectors.toList())).isNotEmpty()
        );
    }

    public static Performable clickAddButtonEndpointTab() {
        return Task.where("Click On Add Button Endpoint Tab",
                JavaScriptClick.on(btnAdd)
        );
    }

    public static Performable clickOnSaveButtonTab() {
        return Task.where("Click On Save Button Endpoint Tab",
                JavaScriptClick.on(btnSave)
        );
    }

    public static Performable selectValueFromShowEntriesListBox(String showEntryOption) {
        return Task.where("Select {0} value from Show Entries List Box " + showEntryOption,

                // Clear Existing Filter
                Click.on(lnkClearFilter),

                WaitUntil.the(CommonObject.iconHangOn, isNotVisible())
                        .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("maxWait").trim()))
                        .seconds(),

                SelectFromOptions.byVisibleText(showEntryOption).from(lstShowEntries),
                Hit.the(Keys.ENTER).into(lstShowEntries)
        );

    }

    public static Performable verifyMessageInEndpointTable(String message) {
        return Task.where("Verify message in Endpoint Table :" + message,
                WaitUntil.the(tblEndpointTableEmptyRecord, WebElementStateMatchers.containsText(message))
                        .forNoMoreThan(10).seconds(),
                Ensure.that(tblEndpointTableEmptyRecord).textContent().contains(message));

    }

    public static Performable clickOkButtonInConfirmationPopUp() {
        return Task.where("Click on Ok Button Delete Confirmation Pop Up",
                Click.on(btnDeleteConfirmationOkButton));
    }

    public static Performable clickOnDeleteButtonInEndpointTab() {
        return Task.where("Click Delete Button",
                Click.on(btnDelete));
    }

    public static Performable selectCheckboxinEndpointWebTable(String recordNumber) {

        WebElementFacade element = btnAllCheckbox.resolveAllFor(BrowseTheWeb.as(OnStage.theActorInTheSpotlight()))
                .get(Integer.valueOf(recordNumber) - 1);

        return Task.where("Select CheckBox",
                Click.on(element));
    }

    public static Performable filterEndPointInEndpointWebTable(String endPointName) {
        return Task.where("Filter Endpoint Name",

                // Clear Existing Filter
                Click.on(lnkClearFilter),

                WaitUntil.the(CommonObject.iconHangOn, isNotVisible())
                        .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("maxWait").trim()))
                        .seconds(),

                Hit.the(Keys.ARROW_DOWN).into(lblFilter),

                WaitUntil.the(lnkEndPoint, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds(),

                Click.on(lnkEndPoint),

                Enter.keyValues(endPointName).into(txtFilter).thenHit(Keys.ENTER),

                WaitUntil.the(btnAllCheckbox, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds()
        );
    }
}
