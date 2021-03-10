package globedr.selenium.element.web;

import globedr.selenium.configuration.SysConfig;
import globedr.selenium.driver.DriverUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Alert {

    private static org.openqa.selenium.Alert getAlert(){
        return DriverUtils.switchTo().alert();
    }

    public static void dismiss() {
        getAlert().dismiss();
    }


    public static void accept() {
        getAlert().accept();
    }


    public static String getText() {
        return getAlert().getText();
    }

    public static void sendKeys(String keysToSend) {
        getAlert().sendKeys(keysToSend);
    }

    public static void waitAlertIsPresent() {
        WebDriverWait wait = new WebDriverWait(DriverUtils.getDriver(), Duration.ofMillis(SysConfig.getTimeOutElement()));
        wait.until(ExpectedConditions.alertIsPresent());
    }



}
