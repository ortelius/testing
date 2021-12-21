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

        BrowseTheWeb.as(OnStage.theActorInTheSpotlight()).$(locCheckbox).waitUntilEnabled();
        WebElementFacade chk = BrowseTheWeb.as(OnStage.theActorInTheSpotlight()).$(locCheckbox);
        WebElementFacade row = BrowseTheWeb.as(OnStage.theActorInTheSpotlight()).$(locRow);

        return  Task.where("{0} Open Specific Version " + version,
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

    public static Performable modifyFullDomainName(String fullDomianName) {

        return  Task.where("Modify Full Domain Name in Details Tab ",
                Check.whether(Objects.nonNull(fullDomianName))
                        .andIfSo(ReusableMethod.jsSelectByVisibleText(lstFullDomainName,
                                fullDomianName)));
    }

    public static Performable modifyFullName(String name) {
        return  Task.where("Modify Name in Details Tab ",
                Check.whether(Objects.nonNull(name))
                        .andIfSo(ReusableMethod.jsEnterValue(txtName,
                                name)));
    }

    public static Performable modifyDescription(String description) {
        return  Task.where("Modify Description in Details Tab ",
                Check.whether(Objects.nonNull(description))
                        .andIfSo(ReusableMethod.jsEnterValue(txtDescription,
                                description)));
    }

    public static Performable modifyChangeRequestDataSource(String changeRequestDataSource) {
        return  Task.where("Modify Change Request Data Source in Details Tab ",
                Check.whether(Objects.nonNull(changeRequestDataSource))
                        .andIfSo(ReusableMethod.jsSelectByVisibleText(lstChangeRequestDataSource,
                                changeRequestDataSource)));
    }

    public static Performable modifyPreAction(String preAction) {
        return  Task.where("Modify Pre Action in Details Tab ",
                Check.whether(Objects.nonNull(preAction))
                        .andIfSo(ReusableMethod.jsSelectByVisibleText(lstPreAction,
                                preAction)));
    }

    public static Performable modifyPostAction(String postAction) {
        return  Task.where("Modify Post Action in Details Tab ",
                Check.whether(Objects.nonNull(postAction))
                        .andIfSo(ReusableMethod.jsSelectByVisibleText(lstPostAction,
                                postAction)));
    }

    public static Performable modifyCustomAction(String customAction) {
        return  Task.where("Modify Custom Action in Details Tab ",
                Check.whether(Objects.nonNull(customAction))
                        .andIfSo(ReusableMethod.jsSelectByVisibleText(lstCustomAction,
                                customAction)));
    }

    public static Performable modifySuccessfullDeploymentTemplate(String successfullDeploymentTemplate) {
        return  Task.where("Modify successfull Deployment Template in Details Tab ",
                Check.whether(Objects.nonNull(successfullDeploymentTemplate))
                        .andIfSo(ReusableMethod.jsSelectByVisibleText(lstSuccessfulDeploymentTemplate,
                                successfullDeploymentTemplate)));
    }

    public static Performable modifyFailedDeploymentTemplate(String failedDeploymentTemplate) {
        return  Task.where("Modify failed Deployment Template in Details Tab ",
                Check.whether(Objects.nonNull(failedDeploymentTemplate))
                        .andIfSo(ReusableMethod.jsSelectByVisibleText(lstFailedDeploymentTemplate,
                                failedDeploymentTemplate)));
    }
}

