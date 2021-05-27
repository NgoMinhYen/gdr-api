
import config.BaseCucumber;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/"},
        monochrome = true,
        // stepdefinition : store all steps of UI
        // com.apis.globedr.stepdefinition : store all steps of api into file "gdr-automation-ws-artifactid.jar"
        // config : define config to convert default data of gherkins to Data Object
        glue = {"stepdefinition", "com.apis.globedr.stepdefinition", "config"},
        tags  = "@consultant_01",
        plugin = {
                // ListenerWebPlugin : is customize listener of gherkins
                "listeners.ListenerWebPlugin",
                // all failed test will saved at rerun.txt
                "rerun:target/rerun.txt",
                // output result.json to generate cucumber report at end run
                "json:target/result.json"
        }
)

public class CucumberRunner extends BaseCucumber {

}


