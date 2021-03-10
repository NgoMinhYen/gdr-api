package stepdefinition;

import com.rest.core.Report;
import globedr.selenium.driver.DriverUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HookSteps {
    @Before
    public void start(Scenario scenario) {
        Report.setScenario(scenario);
    }


    @After
    public void end(Scenario scenario) {
        if(scenario.isFailed()){
            Report.attach(DriverUtils.takeScreenShot());
        }
    }
}
