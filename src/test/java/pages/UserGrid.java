package pages;

import org.openqa.selenium.By;
import support.DriverQA;

public class UserGrid extends BasePage{

    public UserGrid(DriverQA stepDriver){
        super(stepDriver);
    }

    public void clickNewUser() throws InterruptedException {
        driver.click("#btn-new", "css");
    }

    public void clickShow(String lastUser) {
        String idName = "btn-show_" + lastUser;
        driver.click(idName);
    }

    public void clickEdit(String lastUser) {
        String idName = "btn-edit_" + lastUser;
        driver.click(idName);
    }

    public void clickDelete(String lastUser) {
        String idName = "btn-delete_" + lastUser;
        driver.click(idName);
    }

    public void clickConfirmDelete() {
        driver.ChooseOkOnNextConfirmation();
    }

    public boolean existUser(String lastUser) {
        String idName = "btn-delete_" + lastUser;
        return driver.getDriver().getPageSource().contains(idName);
    }

    public void waitDeleteButton(String lastUser) {
        String idName = "btn-delete_" + lastUser;
        driver.waitElement(idName);
    }
}
