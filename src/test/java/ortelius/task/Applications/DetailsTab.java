package ortelius.task.Applications;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.AnonymousPerformableFunction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.hamcrest.CoreMatchers;
import org.openqa.selenium.By;
import ortelius.task.CommonObject;
import ortelius.utilities.ReusableMethod;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;


public class DetailsTab {

    public static Target lstFullDomainName = Target.the("Full Domain Name").located(By.name("fulldomain_val"));
    public static Target txtName = Target.the("Name").located(By.name("name_val"));
    public static Target txtDescription = Target.the("Description").located(By.name("summary_val"));

    public static Target lstChangeRequestDataSource = Target.the("Change Request Data Soruce")
            .located(By.name("bt_datasource_val"));

    public static Target lstPreAction = Target.the("Pre Action").located(By.name("preaction_val"));
    public static Target lstPostAction = Target.the("Post Action").located(By.name("postaction_val"));
    public static Target lstCustomAction = Target.the("Custom Action").located(By.name("customaction_val"));

    public static Target lstSuccessfulDeploymentTemplate = Target.the("Successful Deployment Template")
            .located(By.name("template_val"));

    public static Target lstFailedDeploymentTemplate = Target.the("Failed Deployment Template")
            .located(By.name("fail_template_val"));

    public static By tblDetail = By.id("summ");
    public static String chkSpecificVersion = "//table[@id='applist']/descendant::td[text()='<VERSION>']/ancestor::tr[1]/td[1]";
    public static String chkSpecificRow = "//table[@id='applist']/descendant::td[text()='<VERSION>']/ancestor::tr[1]";

    public static Performable openVersionFromWebTable(String version) {

        By locCheckbox = By.xpath(chkSpecificVersion.replace("<VERSION>", version));
        By locRow = By.xpath(chkSpecificRow.replace("<VERSION>", version));

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
                        .seconds()

        );
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

        return Task.where("Enter values in Detail tab",

                Check.whether(fullDomainName == "null")
                        .otherwise(SelectFromOptions.byVisibleText(fullDomainName)
                               .from(lstFullDomainName)),

                Check.whether(name== "null")
                        .otherwise(SelectFromOptions.byVisibleText(name)
                                .from(txtName)),

                Check.whether(description== "null")
                        .otherwise(SelectFromOptions.byVisibleText(description)
                                .from(txtDescription)),

                Check.whether(changeRequestDataSource== "null")
                        .otherwise(SelectFromOptions.byVisibleText(changeRequestDataSource)
                                .from(lstChangeRequestDataSource)),

                Check.whether(preAction== "null")
                        .otherwise(SelectFromOptions.byVisibleText(preAction)
                                .from(lstPreAction)),

                Check.whether(postAction== "null")
                        .otherwise(SelectFromOptions.byVisibleText(postAction)
                                .from(lstPostAction)),

                Check.whether(customAction== "null")
                        .otherwise(SelectFromOptions.byVisibleText(customAction)
                                .from(lstCustomAction)),

                Check.whether(successfullDeploymentTemplate== "null")
                        .otherwise(SelectFromOptions.byVisibleText(successfullDeploymentTemplate)
                                .from(lstSuccessfulDeploymentTemplate)),

                Check.whether(failedDeploymentTemplate== "null")
                        .otherwise(SelectFromOptions.byVisibleText(failedDeploymentTemplate)
                                .from(lstFailedDeploymentTemplate))
                );
    }

    public static Performable clickOnSaveButton() {
        return  Task.where("Click on Save Button ", Click.on(Button.called("Save")));
    }

    public static void verifyChangeValues(DataTable dataTable) {

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
                        Text.of(lstFullDomainName),
                        CoreMatchers.is(fullDomainName))
        );

        AnonymousPerformableFunction where1 = Task.where("Verify Details Tab",

                (Consumer<Actor>) seeThat("Verify Name",
                        Text.of(txtName),
                        CoreMatchers.is(name))
        );
    }
}
