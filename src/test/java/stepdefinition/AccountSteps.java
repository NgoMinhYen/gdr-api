package stepdefinition;

import com.apis.globedr.helper.Common;
import com.rest.core.Report;
import config.ResourceLanguage;
import dataObject.Account;
import globedr.selenium.constants.FilePath;
import globedr.selenium.driver.DriverUtils;
import globedr.selenium.enums.DriverType;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AccountSteps {

    AccountPage accountPage = new AccountPage();


//    @When("On Web, I update my account with below info")
//    public void onWebIUpdateMyAccountWithBelowInfo(Map<String, Object> dataTable) {
//
//        Map<String, Object> body = Common.getMap(dataTable);
//        accountPage.waitLoadCompleted();
//        accountPage.updateProfile(
//                body.get("yourName").toString(),
//                body.get("title").toString(),
//                body.get("email").toString(),
//                body.get("dob").toString(),
//                body.get("gender").toString(),
//                body.get("visitCountry").toString(),
//                body.get("country").toString(),
//                body.get("region").toString(),
//                body.get("city").toString(),
//                body.get("address").toString(),
//                body.get("phoneNumber").toString(),
//                body.get("workPhone").toString()
//        );
//    }

    @When("On Web, I update my account with below info")
    public void onWebIUpdateMyAccountWithBelowInfo(Map<String, Object> dataTable) {

        Map<String, Object> body = Common.getMap(dataTable);
        accountPage.waitLoadCompleted();
        //accountPage.updateProfile(accountList.get(0));
        accountPage.updateProfile(
                body.get("yourName").toString(),
                body.get("title").toString(),
                body.get("email").toString(),
                body.get("dob").toString(),
                ResourceLanguage.getInstance().translate(body.get("gender").toString()),
                body.get("visitCountry").toString(),
                body.get("country").toString(),
                body.get("region").toString(),
                body.get("city").toString(),
                body.get("address").toString(),
                body.get("phoneNumber").toString(),
                body.get("workPhone").toString()
        );

    }



    @When("On Web, I update my avatar with image {string}")
    public void onWebIUpdateMyAvatarWithImage(String filePath) {
        accountPage.uploadAvatar(filePath);
    }

    @Then("When On Web, I see my account with below info")
    public void whenOnWebISeeMyAccountWithBelowInfo(Map<String, Object> dataTable) {
        Map<String, Object> body = Common.getMap(dataTable);
        accountPage.checkProfile(
                body.get("yourName").toString(),
                body.get("title").toString(),
                body.get("email").toString(),
                body.get("dob").toString(),
                ResourceLanguage.getInstance().translate(body.get("gender").toString()),
                body.get("visitCountry").toString(),
                body.get("country").toString(),
                body.get("region").toString(),
                body.get("city").toString(),
                body.get("address").toString(),
                body.get("phoneNumber").toString(),
                body.get("workPhone").toString()
        );
    }


}
