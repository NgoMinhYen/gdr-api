package stepdefinition;

import globedr.selenium.element.web.Alert;
import globedr.selenium.driver.DriverUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.SeleniumEasyPage;

public class TestSteps {

    SeleniumEasyPage seleniumEasyPage = new SeleniumEasyPage();
    @When("On Web, I open url {string}")
    public void onWebIOpenUrl(String url) {
        DriverUtils.openUrl(url);
    }


    @And("I drag {string} and drop to drop zone")
    public void iDragAndDropToDropZone(String name) {
        seleniumEasyPage.dragAndDropToDropZone(name);
    }

    @And("I drag and drop")
    public void iDragAndDrop() {
        seleniumEasyPage.dragAndDropToAmount();
    }


    @And("I set grey slider is {int}")
    public void iSetGreySliderIs(int number) {
        seleniumEasyPage.setSliderGrey(number);
    }

    @And("I upload file {string}")
    public void iUploadFile(String path) {
        seleniumEasyPage.upload(path);
    }

    @And("I click on Java Script Alert Box")
    public void iClickOnJavaScriptAlertBox() {
        seleniumEasyPage.openAlertBox();
    }


    @And("I get Text on Alert")
    public void iGetTextOnAlert() {
        Alert.waitAlertIsPresent();
        System.out.println("!!!! " + Alert.getText());
    }

    @And("I click on Alert")
    public void iClickOnAlert() {
        Alert.accept();

    }

    @And("I cancel on Alert")
    public void iCancelOnAlert() {
        Alert.dismiss();
    }


    @And("I sendkey {string} on Alert")
    public void iSendkey(String content) {
        Alert.waitAlertIsPresent();
        Alert.sendKeys(content);
    }


    @And("I click on Java Script Confirm Box")
    public void iClickOnJavaScriptConfirmBox() {
        seleniumEasyPage.openConfirmBox();
    }

    @And("I click on Java Script Prompt Box")
    public void iClickOnJavaScriptPromptBox() {
        seleniumEasyPage.openPromptBox();
    }

    @Given("open url {string}, user {string}, pass {string}")
    public void openUrlUserPass(String url, String user, String pass) {
        DriverUtils.loginOnBasicAuthPopUp(url, user, pass);
    }

    @Given("I test table")
    public void iTestTable(DataTable table) {

    }
}
