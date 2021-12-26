package ortelius.task.endpoints;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.components.HtmlTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ortelius.utilities.ReusableMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DetailsTabPage {

    public static Target tabEndPoint = Target.the("Endpoint Tab")
            .located(By.cssSelector("button[class*='tablinks verttab_endpoint']"));

    public static Target tableEndPoint = Target.the("Endpoint Table")
            .located(By.cssSelector("table[id='endpointlist']"));

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


    public static Performable clickOnEndpointTab() {
        return Task.where("Click On Endpoint Tab",
                    Click.on(tabEndPoint)
                );
    }

    public static Performable selectFullDomainValue(String fullDomain) {
        return Task.where("Click On Endpoint Tab",
                ReusableMethod.jsSelectByVisibleText(lstFullDomain,fullDomain)
        );
    }

    public static Performable enterName(String name) {
        return Task.where("Enter name",
                ReusableMethod.jsEnterValue(txtName,name)
        );
    }

    public static Performable enterDescription(String description) {
        return Task.where("Enter Description",
                ReusableMethod.jsEnterValue(txtDescription,description)
        );
    }

    public static Performable selectEndpointOperatingSystem(String endpointOperatingSystem) {
        return Task.where("Select Endpoint Operating System",
                ReusableMethod.jsSelectByVisibleText(lstEndpointOperatingSystem,endpointOperatingSystem)
        );
    }

    public static Performable selectEndpointTypes(String endporintTypes) {
        return Task.where("Select Endpoint Type",
                ReusableMethod.jsSelectByVisibleText(lstEndpointType,endporintTypes)
        );
    }

    public static Performable enterHostname(String hostname) {
        return Task.where("Select Hostname Type",
                ReusableMethod.jsEnterValue(txtHostname,hostname));

    }

    public static Performable selectProtocal(String protocal) {
        return Task.where("Select Protocal",
                ReusableMethod.jsSelectByVisibleText(lstProtocal,protocal)
        );
    }

    public static Performable enterSSHportNumber(String sshPortNumber) {
        return Task.where("Enter Hostname Type",
                ReusableMethod.jsEnterValue(txtSSHPortNumber,sshPortNumber));
    }

    public static Performable enterBaseDirectory(String baseDirectory) {
        return Task.where("Enter Base Directory Type",
                ReusableMethod.jsEnterValue(txtBaseDirectory,baseDirectory));
    }

    public static Performable selectCredential(String credential) {
        return Task.where("Select Credential",
                ReusableMethod.jsSelectByVisibleText(lstCredential,credential)
        );
    }

    public static Performable selectPingFailureTemplate(String pingFailureTemplate) {
        return Task.where("Select Ping Failure Template",
                ReusableMethod.jsSelectByVisibleText(lstPingFailureTemplate,pingFailureTemplate)
        );
    }

    public static Performable verifyEndpointDetailInTable(String name) {

        HtmlTable table = new HtmlTable(tableEndPoint.resolveFor(BrowseTheWeb.as(OnStage.theActorInTheSpotlight())));
        List<String> allRowsValues =
                table.getRowElements().stream().map(e -> e.getText()).collect(Collectors.toList());

        return Task.where("{0} Verify Endpoint Detail in Table" + name,
                Ensure.that(allRowsValues.stream().anyMatch(s -> s.contains(name))).isTrue()

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
}
