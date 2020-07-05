package pages;

import support.DriverQA;

public class ProcessNew extends BasePage  {
    public ProcessNew(DriverQA stepsDriver){
        super(stepsDriver);
    }


    public void clicksave() {
        driver.click("btn-save");
    }

    public void FillField(String field, String value) {
        driver.sendKeys(value, field);
    }

    public void selectUrgency(String urgency) {
        driver.selectByText(urgency,"processo_urgente");
    }

    public void clickArbitramento(String res) {
        if (res.equals("sim")){
            driver.click("processo_arbitramento_s");

        } else{
            driver.click("processo_arbitramento_n");
        }
    }
}
