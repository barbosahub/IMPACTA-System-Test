package pages;

import support.DriverQA;

public class ProcessGrid extends BasePage{

    public ProcessGrid(DriverQA stepsDriver) {
        super(stepsDriver);
    }

    public void clickNewProcess() {
        driver.click("btn-novo");
    }


    public String getCode(String code) {
        return driver.getText("codigo_"+ code);
    }

    public String getFieldValue(String field, String lastCode) {
        return driver.getText(field+ "_" + lastCode);
    }

    public void clickEdit(String lastProcess) {
        String idName = "btn-edit_" + lastProcess;
        driver.click(idName);
    }

    public void clickDelete(String lastCode) {
            String idName = "btn-delete_" + lastCode;
            driver.click(idName);
        }

    public boolean existProcess(String lastCode) {
        String idName = "btn-delete_" + lastCode;
        return driver.getDriver().getPageSource().contains(idName);
    }
}

