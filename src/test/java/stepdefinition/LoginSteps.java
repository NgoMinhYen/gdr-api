package stepdefinition;



import config.ResourceLanguage;
import dataObject.Account;
import dataObject.Lecture;
import dataObject.User;
import globedr.selenium.Assert;
import globedr.selenium.driver.DriverUtils;
import globedr.selenium.enums.DriverType;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;

import java.util.List;


public class LoginSteps {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();


    @Given("On Web, I login account with username is {string}, password is {string}, country is {string}")
    public void onWebILoginAccountWithUsernameIsPasswordIsCountryIs(String user, String pass, String country) {
        loginPage.login(user, pass, country);
    }


    @Then("I see display name {string} on header")
    public void iSeeDisplayNameOnHeader(String expected) {
        Assert.assertEquals(homePage.getDisplayName(), expected);
    }

    @Given("test")
    public void test() {

    }

    @Given("I open chrome")
    public void iOpenChrome() {
        DriverUtils.init(DriverType.FIREFOX);
        DriverUtils.maximum();
    }

    @And("I wait {int} seconds")
    public void iWaitSeconds(int seconds) {
        DriverUtils.sleep(seconds);
    }


    @Given("the list lecture details are")
    public void theListLectureDetailsAre(List<Lecture> rows) {
        for (Lecture a : rows) {
            System.out.println(a.getProfName());
        }
    }

    @Given("I test account")
    public void iHaveTheFollowingBooksInTheStoreByList(DataTable table) {
        List<Account> rows = table.asList(Account.class);

        for (Account a : rows) {
            System.out.println(a.getTitle());
        }

    }

    @When("I search for books by author Erik Larson")
    public void iSearchForBooksByAuthorErikLarson() {
    }

    @Then("I find {int} books")
    public void iFindBooks(int arg0) {
    }

    @When("On Web, I open login page")
    public void onWebIOpenLoginPage() {
        DriverUtils.openUrl("https://web1.globedr.com/signin");
        ResourceLanguage.getInstance().setCurrentLanguage(loginPage.headerGuest.getLanguage());

    }
}
