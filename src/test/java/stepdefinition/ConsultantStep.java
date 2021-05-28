package stepdefinition;

import io.cucumber.java.en.And;
import pages.ConsultantPage;
import pages.DashboardPersonalPage;

import java.util.Map;

public class ConsultantStep {
    ConsultantPage consultantPage = new ConsultantPage();
    DashboardPersonalPage dashboardPersonalPage = new DashboardPersonalPage();
    @And("I create new question with below info")
    public void iCreateNewQuestionWithBelowInfo(Map<String,String> dataTable) {
        dashboardPersonalPage.openMenuAskDoctor();
        consultantPage.createNewQuestion(dataTable.get("height"),dataTable.get("weight")
        ,dataTable.get("temperature"),dataTable.get("question"));
    }
}
