package pages;

import support.DriverQA;

public class LoginSucessImpacta extends BasePage {

    public LoginSucessImpacta(DriverQA stepdriver){
        super(stepdriver);
    }

    public String getResult() {
        return driver.getText("result");
    }
}
