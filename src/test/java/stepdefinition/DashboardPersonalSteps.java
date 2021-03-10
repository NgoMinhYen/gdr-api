package stepdefinition;


import enums.MenuDBPersonal;
import io.cucumber.java.en.Given;
import pages.DashboardPersonalPage;

public class DashboardPersonalSteps  {

    DashboardPersonalPage dbPersonalPage = new DashboardPersonalPage();


    @Given("On Dashboard Personal, I open Account Menu")
    public void onDashboardPersonalIOpenAccountMenu() {
        dbPersonalPage.openMenu(MenuDBPersonal.ACCOUNT);
    }

}
