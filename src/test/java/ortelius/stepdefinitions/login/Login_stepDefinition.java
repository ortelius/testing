package ortelius.stepdefinitions.login;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ortelius.task.CommonObject;
import ortelius.task.GeneralComponents;
import ortelius.task.login.Login;
import ortelius.task.applications.ApplicationHomePage;
import ortelius.utilities.ReusableMethod;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static ortelius.task.login.Login.txtPasswrod;

public class Login_stepDefinition {

    @Given("{actor} is navigate to Login Page")
    public void user_is_navigate_to_login_page(Actor actor) {
        actor.attemptsTo(GeneralComponents.loginPage());
    }

    @When("{actor} is entered username in username text box")
    public void user_is_entered_username_in_username_text_box(Actor actor) {

        String appUsername = ReusableMethod.getEnvironmentValue("app.username").trim();
        actor.attemptsTo(Login.fillUserName(appUsername));
        Ensure.that(Login.txtUserName).text()
                .isEqualTo(appUsername);
    }

    @When("{actor} is entered password in password text box")
    public void user_is_entered_password_in_password_text_box(Actor actor) {

        String appPassword = ReusableMethod.getEnvironmentValue("app.password").trim();
        actor.attemptsTo(Login.fillPassword(appPassword));
        Ensure.that(txtPasswrod).text()
                .isEqualTo(appPassword);
    }

    @And("{actor} click on login button")
    public void userClickOnLoginButton(Actor actor) {
        actor.attemptsTo(Login.clickOnLoginButton());
    }

    @Then("{actor} is able to view Home page")
    public void userIsAbleToViewHomePage(Actor actor) throws InterruptedException {

        WaitUntil.the(CommonObject.iconHangOn, isNotVisible())
                .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("maxWait").trim()))
                .seconds();

        // Handle application Sync issue
        BrowseTheWeb.as(OnStage.theActorInTheSpotlight()).waitForTextToDisappear("No data available in table");
        BrowseTheWeb.as(OnStage.theActorInTheSpotlight()).waitForTextToDisappear("Loading");
        BrowseTheWeb.as(OnStage.theActorInTheSpotlight()).shouldContainText("Deployed");

        actor.should(seeThat(WebElementQuestion.the(ApplicationHomePage.tblDomain),
                WebElementStateMatchers.isNotEmpty()));
    }
}
