package pages;

import support.DriverQA;

public class UserEdit extends BasePage {

    public UserEdit(DriverQA stepsDriver) {
        super(stepsDriver);
    }

    public void clickSave() {
        driver.click("btn-save");
    }
}
