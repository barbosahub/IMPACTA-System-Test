package pages;

import support.DriverQA;

public class LoginFailImpacta extends BasePage {

    public LoginFailImpacta(DriverQA stepsDriver){
        super(stepsDriver);
    }

    public String getResult() {
        return driver.getText("result");
    }
}
