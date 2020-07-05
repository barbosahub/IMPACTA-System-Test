package steps;


import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import javafx.collections.FXCollections;
import org.junit.Assert;
import pages.*;
import support.BaseSteps;

public class CRUDUserStep extends BaseSteps {

    private Home home = new Home(driver);
    private MenuImpacta menu = new MenuImpacta(driver);
    private UserGrid userGrid = new UserGrid(driver);
    private UserNew userNew = new UserNew(driver);
    private UserShow userShow = new UserShow(driver);
    private UserEdit userEdit = new UserEdit(driver);

    @Given("^the user is on Agapito Server page$")
    public void theUserIsOnAgapitoServerPage() {
        home.openPage();
    }

    @And("^the user clicks on User menu$")
    public void theUserClicksOnUserMenu() { menu.clickUser(); }

    @And("^the user clicks on new user button$")
    public void theUserClicksOnNewUserButton() throws InterruptedException {
        userGrid.clickNewUser();
    }

    @And("^the user fill \"([^\"]*)\" with value equal \"([^\"]*)\"$")
    public void theUserFillWithValueEqual(String field, String value) throws Throwable {
        userNew.fill(field, value);

    }

    @When("^the user clicks on save button$")
    public void theUserClicksOnSaveButton() {
        userNew.clickSave();
        userShow.saveIdLastUser();
    }


    @Then("^the user should see \"([^\"]*)\" into view user page$")
    public void theUserShouldSeeIntoViewUserPage(String message) throws Throwable {
        Assert.assertEquals(message, userShow.getNotice());
    }

    @And("^the user backs to the user grid$")
    public void theUserBacksToTheUserGrid() {
        userShow.clickBack();
    }

    @When("^the user clicks on show button$")
    public void theUserClicksOnShowButton() {
        userGrid.clickShow(userShow.getLastUser());
    }

    @Then("^the user should see \"([^\"]*)\" with value equal \"([^\"]*)\"$")
    public void theUserShouldSeeWithValueEqual(String field, String value) throws Throwable {
        Assert.assertEquals(value, userShow.getField(field));
    }

    @And("^the user clicks on edit button$")
    public void theUserClicksOnEditButton() {
        userGrid.clickEdit(userShow.getLastUser());
    }

    @And("^the user clicks on edit save button$")
    public void theUserClicksOnEditSaveButton() {
        userEdit.clickSave();
    }

    @When("^the user clicks on delete button$")
    public void theUserClicksOnDeleteButton() {
        userGrid.waitDeleteButton(userShow.getLastUser());
        userGrid.clickDelete(userShow.getLastUser());

    }

    @And("^the user confirms delete$")
    public void theUserConfirmsDelete() {
        userGrid.clickConfirmDelete();
        
    }

    @Then("^the user should not see last user code$")
    public void theUserShouldNotSeeLastUserCode() throws InterruptedException {

        Assert.assertFalse("ERROR: There is an user with this code" + userShow.getLastUser(),
                                      userGrid.existUser(userShow.getLastUser()));
    }
}