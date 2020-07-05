package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.MenuImpacta;
import pages.ProcessGrid;
import pages.ProcessNew;
import pages.ProcessShow;
import support.BaseSteps;

public class ProcessStep extends BaseSteps {

    private MenuImpacta menu = new MenuImpacta(driver);
    private ProcessNew processNew = new ProcessNew(driver);
    private ProcessGrid processGrid = new ProcessGrid(driver);
    private ProcessShow processShow = new ProcessShow(driver);



    @And("^the user clicks on Process menu$")
    public void theUserClicksOnProcessMenu() {
        menu.clickProcess();
    }

    @And("^the user clicks on new process button$")
    public void theUserClicksOnNewProcessButton() {
        processGrid.clickNewProcess();
    }

    @And("^the user fills \"([^\"]*)\" with the value equal \"([^\"]*)\" on the process page$")
    public void theUserFillWithTheValueEqualOnTheProcessPage(String field, String value) throws Throwable {
        processNew.FillField(field, value);
    }

    @When("^the user clicks on save button on the process page$")
    public void theUserClicksOnSaveButtonOnTheProcessPage() {
        processNew.clicksave();
        processShow.setLastCode();

    }



    @Then("^the user should see \"([^\"]*)\" with value equal \"([^\"]*)\" on the process page$")
    public void theUserShouldSeeWithValueEqualOnTheProcessPage(String arg0, String arg1) throws Throwable {

    }

    @Then("^the user should see \"([^\"]*)\" into view process page$")
    public void theUserShouldSeeIntoViewProcessPage(String message) throws Throwable {
        Assert.assertEquals(message, processShow.getNotice());
    }


    @And("^the user selects urgency with the value equal \"([^\"]*)\" on the process page$")
    public void theUserSelectsUrgencyWithTheValueEqualOnTheProcessPage(String urgency) throws Throwable {
        processNew.selectUrgency(urgency);
    }

    @And("^the user clicks on arbitramento equals \"([^\"]*)\"$")
    public void theUserClicksOnArbitramentoEquals(String res) throws Throwable {
        processNew.clickArbitramento(res);
    }

    @When("^the user clicks on back button into process show page$")
    public void theUserClicksOnBackButtonIntoProcessShowPage() {
        processShow.clickBack();
    }

    @Then("^the user should see last code on the process grid page$")
    public void theUserShouldSeeLastCodeOnTheProcessGridPage() {
        Assert.assertEquals(processShow.getLastCode(), processGrid.getCode(processShow.getLastCode()));

    }

    @And("^the user should see \"([^\"]*)\" with value \"([^\"]*)\" on the process grid page$")
    public void theUserShouldSeeWithValueOnTheProcessGridPage(String field, String value) throws Throwable {
         Assert.assertEquals(value, processGrid.getFieldValue(field, processShow.getLastCode()));
    }

    @And("^the user clicks on edit process button$")
    public void theUserClicksOnEditProcessButton() {
        processGrid.clickEdit(processShow.getLastCode());
    }

    @And("^the user clicks on delete button process button$")
    public void theUserClicksOnDeleteButtonProcessButton() {
        processGrid.clickDelete(processShow.getLastCode());
    }

    @Then("^the user should not see last process code$")
    public void theUserShouldNotSeeLastProcessCode() {
        Assert.assertFalse("ERROR: There is an user with this code" + processShow.getLastCode(),
            processGrid.existProcess(processShow.getLastCode()));
    }


    @And("^the user should see <\"([^\"]*)\"> with value$")
    public void theUserShouldSeeWithValue(String field, String value) throws Throwable {
        Assert.assertEquals(value, processGrid.getFieldValue(field, processShow.getLastCode()));

    }


    @And("^the user fill \"([^\"]*)\" with value equal vara \"([^\"]*)\"$")
    public void theUserFillWithValueEqualVara(String field, String value) throws Throwable {
        processNew.FillField(field, value);
    }
}


