package pages;

import support.DriverQA;

public class UserShow extends BasePage {

    private String lastUser;

    public UserShow(DriverQA stepsDriver){ super(stepsDriver); }

    public String getNotice() {
        return driver.getText("notice");
    }

    public void saveIdLastUser(){

        setLastUser(driver.getText("codigo"));
    }

    private void setLastUser(String codigo) {
        lastUser = codigo;
    }

    public String getLastUser(){
        return lastUser;
    }

    public void clickBack() {
        driver.click(".ls-btn-primary-danger", "css");
    }

    public String getField(String field) {
        return driver.getText(field);
    }
}
