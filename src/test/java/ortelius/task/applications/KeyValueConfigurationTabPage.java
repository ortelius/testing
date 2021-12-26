package ortelius.task.applications;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.pages.components.HtmlTable;
import org.openqa.selenium.By;
import ortelius.utilities.ReusableMethod;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class KeyValueConfigurationTabPage {

    // public static By tblKeyValueConfig = By.cssSelector("table[id='attrib']");

    public static Target tblKeyValueConfig = Target.the("Key Value Config Table")
            .located(By.cssSelector("table[id='attrib']"));

    public static Target tblKeyValueConfigNowOfRecords = Target.the("Key Value Config Table with Records")
            .located(By.cssSelector("table[id='attrib'] tr"));

    public static By btnAdd = By.cssSelector("div[id='attrs-panel'] [class='add_button']");
    public static By btnSave = By.cssSelector("div[id='attrs-panel'] [class='save_button']");
    public static By btnDelete = By.cssSelector("div[id='attrs-panel'] [class='delete_button']");

    //public static By chkAll = By.xpath("//table[@id='attrib']/descendant::input[@type='checkbox']");
    public static Target chkAll = Target.the("All CheckBox")
            .located(By.xpath("//table[@id='attrib']/descendant::input[@type='checkbox']"))
            .waitingForNoMoreThan(Duration.ofSeconds(60));

    public static By txtAllName = By.xpath("//table[@id='attrib-edit']/descendant::input[@type='text' and contains(@id,'attr_key')]");
    public static By txtValue = By.xpath("//table[@id='attrib-edit']/descendant::input[@type='text' and contains(@id,'attr_val')]");

    public static Performable clickOnAddButton() {
        return Task.where("Click on Add Button",

                WaitUntil.the(btnSave, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("maxWait").trim()))
                        .seconds(),

                JavaScriptClick.on(btnAdd)
        );
    }

    public static Performable enterName(String name) throws InterruptedException {

        WaitUntil.the(txtAllName, WebElementStateMatchers.isVisible())
                .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("maxWait").trim()))
                .seconds();

        List<WebElementFacade> elements = BrowseTheWeb.as(OnStage.theActorInTheSpotlight()).$$(txtAllName);

        return Task.where("{0} Enter name :" + name,

                Check.whether(elements.size() > 1)
                        .andIfSo(ReusableMethod.jsEnterValue(elements.get(elements.size() - 1), name)),

                Check.whether(elements.size() == 1)
                        .andIfSo(ReusableMethod.jsEnterValue(elements.get(0), name))
        );
    }

    public static Performable enterValue(String value) {

        WaitUntil.the(txtAllName, WebElementStateMatchers.isPresent())
                .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("maxWait").trim()))
                .seconds();

        List<WebElementFacade> elements = BrowseTheWeb.as(OnStage.theActorInTheSpotlight()).$$(txtValue);
        return Task.where("{0} Enter value :" + value,

                Check.whether(elements.size() > 1)
                        .andIfSo(ReusableMethod.jsEnterValue(elements.get(elements.size() - 1), value)),

                Check.whether(elements.size() == 1)
                        .andIfSo(ReusableMethod.jsEnterValue(elements.get(0), value))
        );
    }

    public static Performable clickOnSaveButton() {
        return Task.where("Click on Save Button",
                JavaScriptClick.on(btnSave)
        );
    }

    public static Performable verifyKeyAndValue(String expName, String expValue) {

        HtmlTable table = new HtmlTable(tblKeyValueConfig.resolveFor(OnStage.theActorInTheSpotlight()).waitUntilVisible());

        return Task.where("{0} name {1} value in Key Value Configuration WebTable",

                Ensure.that(table.getRowElementsFor(new ArrayList<>(List.of("Name")))
                                .stream()
                                .filter(e -> e.getText().contains(expName))
                                .findFirst()
                                .get()
                                .getText())
                        .isNotEmpty(),

                Ensure.that(table.getRowElementsFor(new ArrayList<>(List.of("Value")))
                                .stream()
                                .filter(e -> e.getText().contains(expValue))
                                .findFirst()
                                .get()
                                .getText())
                        .isNotEmpty()
        );

    }

    public static Performable clickOnAllCheckBox() {
        return  Task.where("Click on All Checkbox",
                actor -> chkAll.resolveAllFor(actor).forEach(e->e.waitUntilClickable().click()));
    }

    public static Performable clickOnDeleteButton() {
        return Task.where("Click on Delete Button",
                JavaScriptClick.on(btnDelete));
    }

    public static Performable verifyAllKeyAndValueDeletedInTable() {
        return Task.where("Verify All Key and Values Deleted In Table",
                    Ensure.that(Text.of(tblKeyValueConfigNowOfRecords)).hasLineCount(1));
    }
}

