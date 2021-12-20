package ortelius.task.Applications;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.AnonymousPerformableFunction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.screenplay.ui.Image;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.hamcrest.CoreMatchers;
import org.hamcrest.core.IsNull;
import org.openqa.selenium.By;
import ortelius.task.CommonObject;
import ortelius.utilities.ReusableMethod;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;


public class DetailsTab {

    public static By lstFullDomainName = By.name("fulldomain_val");
    public static By txtName = By.name("name_val");
    public static By txtDescription = By.name("summary_val");
    public static By lstChangeRequestDataSource = By.name("bt_datasource_val");
    public static By lstPreAction = By.name("preaction_val");
    public static By lstPostAction = By.name("postaction_val");
    public static By lstCustomAction = By.name("customaction_val");
    public static By lstSuccessfulDeploymentTemplate = By.name("template_val");
    public static By lstFailedDeploymentTemplate = By.name("fail_template_val");

    // Labels
    public static By lblFullDomainName = By.xpath("//td[text()='Full Domain:']/following::td[1]");
    public static By lblName = By.xpath("//td[text()='Name:']/following::td[1]");
    public static By lblDescription = By.xpath("//td[text()='Description:']/following::td[1]");
    public static By lblChangeRequestDataSource = By.xpath("//td[text()='Change Request Data Source:']/following::td[1]");
    public static By lblPreAction = By.xpath("//td[text()='Pre-Action:']/following::td[1]");
    public static By lblPostAction = By.xpath("//td[text()='Post-Action:']/following::td[1]");
    public static By lblCustomAction = By.xpath("//td[text()='Custom Action:']/following::td[1]");
    public static By lblSuccessfulDeploymentTemplate = By.xpath("//td[text()='Successful Deployment Template:']/following::td[1]");
    public static By lblFailedDeploymentTemplate = By.xpath("//td[text()='Failed Deployment Template:']/following::td[1]");

    public static Performable openVersionFromWebTable(String version) {

        By locCheckbox = By.xpath(ApplicationHomePage.chkSpecificVersion.replace("<VERSION>", version));
        By locRow = By.xpath(ApplicationHomePage.chkSpecificRow.replace("<VERSION>", version));

        WebElementFacade chk = BrowseTheWeb.as(OnStage.theActorInTheSpotlight()).$(locCheckbox);
        WebElementFacade row = BrowseTheWeb.as(OnStage.theActorInTheSpotlight()).$(locRow);

        return  Task.where("{0} Open Specific Version " + version,
                  WaitUntil.the(CommonObject.iconHangOn, isEmpty())
                        .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("maxWait").trim()))
                        .seconds(),
                  MoveMouse.to(locCheckbox).andThen(action -> action.click(chk)),
                  MoveMouse.to(locRow).andThen(action -> action.doubleClick(row))
            );

    }

    public static Performable clickOnEditButton() {

        return  Task.where("Click on Edit Button ",

                WaitUntil.the(Button.called("Edit"), isEnabled())
                        .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("maxWait").trim()))
                        .seconds(),

                JavaScriptClick.on(Button.called("Edit")),

                WaitUntil.the(CommonObject.iconHangOn, isEmpty())
                        .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("maxWait").trim()))
                        .seconds(),

                WaitUntil.the(Button.called("Save"), isClickable())
                        .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("maxWait").trim()))
                        .seconds(),

                WaitUntil.the(CommonObject.iconHangOn, isNotVisible())
                        .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("maxWait").trim()))
                        .seconds()
        );
    }

    public static Performable clickOnSaveButton() {
        return  Task.where("Click on Save Button ",

                Click.on(Button.called("Save")),

                WaitUntil.the(CommonObject.iconHangOn, isNotVisible())
                        .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("maxWait").trim()))
                        .seconds(),

                WaitUntil.the(Button.called("Edit"), isEnabled())
                        .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("maxWait").trim()))
                        .seconds()
        );
    }

    public static Performable verifyChangeValues(DataTable dataTable) {

        List<Map<String, String>> details = dataTable.asMaps(String.class, String.class);

        String fullDomainName = details.get(0).get("Full Domain");
        String name = details.get(0).get("Name");
        String description = details.get(0).get("Description");
        String changeRequestDataSource = details.get(0).get("Change Request Data Source");
        String preAction = details.get(0).get("Pre-Action");
        String postAction = details.get(0).get("Post-Action");
        String customAction= details.get(0).get("Custom-Action");
        String successfullDeploymentTemplate = details.get(0).get("Successfull Deployment Template");
        String failedDeploymentTemplate = details.get(0).get("Failed Deployment Template");

        AnonymousPerformableFunction where = Task.where("Verify Details Tab",

                (Consumer<Actor>) seeThat("Verify fullDomainName",
                        Text.of(lblFullDomainName),
                        CoreMatchers.is(fullDomainName))
        );

        AnonymousPerformableFunction where1 = Task.where("Verify Details Tab",

                (Consumer<Actor>) seeThat("Verify Name",
                        Text.of(lblName),
                        CoreMatchers.is(name))
        );

        return null;
    }

    public static Performable changeValues(DataTable dataTable) {

        List<Map<String, String>> details = dataTable.asMaps(String.class, String.class);

        String fullDomainName = details.get(0).get("Full Domain");
        String name = details.get(0).get("Name");
        String description = details.get(0).get("Description");
        String changeRequestDataSource = details.get(0).get("Change Request Data Source");
        String preAction = details.get(0).get("Pre-Action");
        String postAction = details.get(0).get("Post-Action");
        String customAction= details.get(0).get("Custom-Action");
        String successfullDeploymentTemplate = details.get(0).get("Successfull Deployment Template");
        String failedDeploymentTemplate = details.get(0).get("Failed Deployment Template");

        return  Task.where("Enter values in Details Tab ",

                Check.whether(Objects.nonNull(fullDomainName))
                        .andIfSo(ReusableMethod.jsSelectByVisibleText(lstFullDomainName,
                                fullDomainName)),

                Check.whether(Objects.nonNull(name))
                        .andIfSo(ReusableMethod.jsEnterValue(txtName, name)),

                Check.whether(Objects.nonNull(description))
                        .andIfSo(ReusableMethod.jsEnterValue(txtDescription, description)),

                Check.whether(Objects.nonNull(changeRequestDataSource))
                        .andIfSo(ReusableMethod.jsSelectByVisibleText(lstChangeRequestDataSource,
                                changeRequestDataSource)),

                Check.whether(Objects.nonNull(preAction))
                        .andIfSo(ReusableMethod.jsSelectByVisibleText(lstPreAction,preAction)),

                Check.whether(Objects.nonNull(postAction))
                        .andIfSo(ReusableMethod.jsSelectByVisibleText(lstPostAction,postAction)),

                Check.whether(Objects.nonNull(customAction))
                        .andIfSo(ReusableMethod.jsSelectByVisibleText(lstCustomAction,customAction)),

                Check.whether(Objects.nonNull(successfullDeploymentTemplate))
                        .andIfSo(ReusableMethod.jsSelectByVisibleText(lstSuccessfulDeploymentTemplate,
                                successfullDeploymentTemplate)),

                Check.whether(Objects.nonNull(failedDeploymentTemplate))
                        .andIfSo(ReusableMethod.jsSelectByVisibleText(lstFailedDeploymentTemplate,
                                failedDeploymentTemplate))
        );
    }

}

