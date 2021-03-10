package listeners;


import com.rest.core.Logger;
import globedr.selenium.driver.DriverUtils;
import globedr.selenium.enums.DriverType;
import io.cucumber.plugin.event.*;


public class ListenerWebPlugin extends ListenerPlugin {

    @Override
    public void testCaseStarted(TestCaseStarted event) {
        Logger.info("**********************************");
        Logger.info("Scenario tags: " + String.join(", ", event.getTestCase().getTags()));
        Logger.info("Scenario name: " + event.getTestCase().getKeyword() + " " + event.getTestCase().getName());
        Logger.info("**********************************");
        Logger.info("Clear all data");
        resultOfPreStep = null;

    }

    @Override
    public void testCaseFinished(TestCaseFinished event) {
        Logger.info("Close all browser");
        DriverUtils.quit();
    }




}
