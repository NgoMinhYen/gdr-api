package config;

import com.apis.globedr.helper.WebserviceBase;
import com.rest.core.DatabaseEvent;
import com.rest.core.Logger;
import com.rest.core.Report;
import com.rest.core.RestEvent;

import com.rest.core.events.RestCoreEventListener;
import com.rest.core.events.StatementEventListener;
import globedr.selenium.events.EventListener;
import listeners.ListenerSelenium;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import net.masterthought.cucumber.presentation.PresentationMode;
import net.masterthought.cucumber.reducers.ReducingMethod;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BaseCucumber {


    @BeforeClass
    public static void beforeClass() {

        Logger.info("Adding observers for rest core");

        // API event
        RestEvent restEvent = new RestEvent();
        restEvent.attach(new com.rest.core.Logger());
        restEvent.attach(new Report());
        restEvent.attach(new WebserviceBase());

        // DB event
        DatabaseEvent databaseEvent = new DatabaseEvent();
        databaseEvent.attach(new com.rest.core.Logger());
        databaseEvent.attach(new Report());

        // Selenium event
        ListenerSelenium listenerSelenium = new ListenerSelenium();
        listenerSelenium.attach(new Report());
        listenerSelenium.attach(new Logger());

        Logger.info("Register all event listeners");

        RestCoreEventListener.register(restEvent);
        StatementEventListener.register(databaseEvent);
        EventListener.register(listenerSelenium);

    }

    @AfterClass
    public static void afterClass() {
        System.out.println("!!! afterClass");

        File reportOutputDirectory = new File("target");
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("target/result.json");
        String projectName = "cucumberProject";

        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        configuration.addPresentationModes(PresentationMode.RUN_WITH_JENKINS);
        configuration.addReducingMethod(ReducingMethod.SKIP_EMPTY_JSON_FILES);

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        Reportable report = reportBuilder.generateReports();

    }
}
