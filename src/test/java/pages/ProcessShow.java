package pages;

import support.DriverQA;

public class ProcessShow extends BasePage {

    private String lastCode;
    private String lastProcess;

    public ProcessShow(DriverQA stepsDriver) {
        super(stepsDriver);

    }

    public String getNotice() {
        return driver.getText("notice");
    }

    public void clickBack() {
        driver.click(".ls-btn-primary-danger", "css");
    }

    public void setLastCode() {
        lastCode = driver.getText("codigo");
    }

    public String getLastCode() {
        return lastCode;
    }

    public void setLastProcess(String codigo) {
        lastProcess = codigo;
    }

    public String getLastProcess() {
        return lastProcess;
    }


}

