package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.*;
import support.BaseSteps;

public class LogimImpactaSteps extends BaseSteps {

    private LoginImpacta login = new LoginImpacta(driver);
    private LoginSucessImpacta loginSucess = new LoginSucessImpacta(driver);
    private LoginFailImpacta loginFail = new LoginFailImpacta(driver);

    @Given("^the user is on the login page$")
    public void theUserIsOnTheLoginPage() {

        login.openPage();
    }

    @And("^the user fills login equal \"([^\"]*)\"$")
    public void theUserFillsLoginEqual(String user) throws Throwable {
        login.fillLogin(user);
    }

    @And("^the user fills password equal \"([^\"]*)\"$")
    public void theUserFillsPasswordEqual(String password) throws Throwable {
        login.fillPassword(password);
    }

    @When("^the user clicks on login button$")
    public void theUserClicksOnLoginButton() {
        login.clickLogin();
    }

    @Then("^the user should see \"([^\"]*)\" into sucess page$")
    public void theUserShouldSeeIntoSucessPage(String message) throws Throwable {
        Assert.assertEquals(message, loginSucess.getResult());

    }

    @Then("^the user should see \"([^\"]*)\" into fail page$")
    public void theUserShouldSeeIntoFailPage(String message) throws Throwable {
        Assert.assertEquals(message, loginFail.getResult());
    }

    @Then("^the user should see \"([^\"]*)\" into \"([^\"]*)\" page$")
    public void theUserShouldSeeIntoPage(String message, String page) throws Throwable {
        String res = "";
        if (page.equals("fail")) {
            res = loginFail.getResult();
        } else {
            res = loginSucess.getResult();
        }
        Assert.assertEquals(message, res);
    }


}