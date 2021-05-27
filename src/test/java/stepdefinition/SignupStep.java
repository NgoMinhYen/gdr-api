package stepdefinition;

import dataObject.Country;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.DashboardPersonalPage;
import pages.LoginPage;
import pages.SignupPage;
import pages.VerifyCodePage;

import java.util.ArrayList;
import java.util.Arrays;

public class SignupStep {

    SignupPage signupPage = new SignupPage();
    LoginPage loginPage = new LoginPage();
    VerifyCodePage verifyCodePage = new VerifyCodePage();
    DashboardPersonalPage dashboardPersonalPage = new DashboardPersonalPage();

    @And("I enter verification code with code {string}")
    public void iEnterVerificationCodeWithCode(String code) {
        String[] codeSplit = code.split("");
        ArrayList<String> codeList = new ArrayList<>(Arrays.asList(codeSplit));
        verifyCodePage.verifyCode(codeList.get(0), codeList.get(1), codeList.get(2), codeList.get(3));
    }

    @Then("I check on dashboad page have name {string}")
    public void iCheckOnDashboadPageHaveName(String name) {
        Assert.assertTrue(name.equals(dashboardPersonalPage.getDisplayNameOnDashboar()));
    }

    @When("On Web, I open signup account with username is {string}, password is {string}, full name {string} and country {string}")
    public void onWebIOpenSignupAccountWithUsernameIsPasswordIsFullNameAndCountry(String numberPhone, String password, String name, String countryName) {
       loginPage.openSignupPage();
        signupPage.signUp(numberPhone, password, name, countryName);
    }
}
