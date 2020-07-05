package pages;

import support.DriverQA;

public class MenuImpacta extends BasePage{

    public MenuImpacta(DriverQA stepsDriver){
        super(stepsDriver);
    }

    public void clickUser() {
    driver.click("#users", "css");
    }

    public void clickProcess() {
        driver.click("#processos", "css");
    }
}
