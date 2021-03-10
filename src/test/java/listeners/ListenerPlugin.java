package listeners;

import com.apis.globedr.helper.WebserviceBase;
import com.rest.core.Logger;
import com.rest.core.Report;
import globedr.selenium.constants.FilePath;
import globedr.selenium.driver.DriverUtils;
import globedr.selenium.enums.DriverType;
import io.cucumber.messages.Messages;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.List;

public abstract class ListenerPlugin implements ConcurrentEventListener {

    Result resultOfPreStep = null;

    public void testRunStarted(TestRunStarted event) {

    }

    public void testSourceRead(TestSourceRead event) {

    }

    abstract void testCaseStarted(TestCaseStarted event);

    public void testStepStarted(TestStepStarted event) {

        if (resultOfPreStep == null || resultOfPreStep.getStatus().is(Status.PASSED)) {
            if (event.getTestStep() instanceof PickleStepTestStep) {
                PickleStepTestStep testStep = (PickleStepTestStep) event.getTestStep();

                String stepText = testStep.getStep().getKeyword() + testStep.getStep().getText();

                if (testStep.getStepArgument() != null) {
                    if (testStep.getStepArgument() instanceof DataTableArgument) {
                        stepText += "\n" + getTableString((DataTableArgument) testStep.getStepArgument());
                    }

                    if (testStep.getStepArgument() instanceof DocStringArgument) {
                        DocStringArgument data = (DocStringArgument) testStep.getStepArgument();
                        stepText += "\n" + data.getContent() + "\n";

                    }
                }
                Logger.info(stepText);
            }
        }

    }

    public void stepDefinedEvent(StepDefinedEvent event) {
    }

    public void testStepFinished(TestStepFinished event) {
        resultOfPreStep = event.getResult();
    }


    abstract void testCaseFinished(TestCaseFinished event);

    public void testRunFinished(TestRunFinished event) {



    }

    public void embedEvent(EmbedEvent event) {



    }

    public void writeEvent(WriteEvent event) {

    }

    public void snippetsSuggestedEvent(SnippetsSuggestedEvent event) {

    }

    @Override
    public void setEventPublisher(EventPublisher eventPublisher) {


        eventPublisher.registerHandlerFor(TestRunStarted.class, this::testRunStarted);
        eventPublisher.registerHandlerFor(TestSourceRead.class, this::testSourceRead);
        eventPublisher.registerHandlerFor(TestCaseStarted.class, this::testCaseStarted);

        eventPublisher.registerHandlerFor(TestStepStarted.class, this::testStepStarted);
        eventPublisher.registerHandlerFor(TestStepFinished.class, this::testStepFinished);
        eventPublisher.registerHandlerFor(TestCaseFinished.class, this::testCaseFinished);

        eventPublisher.registerHandlerFor(TestRunFinished.class, this::testRunFinished);

        eventPublisher.registerHandlerFor(EmbedEvent.class, this::embedEvent);
        eventPublisher.registerHandlerFor(WriteEvent.class, this::writeEvent);
        eventPublisher.registerHandlerFor(StepDefinedEvent.class, this::stepDefinedEvent);
        eventPublisher.registerHandlerFor(SnippetsSuggestedEvent.class, this::snippetsSuggestedEvent);
    }


    private int getMaxLengthContent(List<List<String>> table, int collumnIndex) {
        int max = 0;
        for (List<String> row : table) {
            if (max < row.get(collumnIndex).length()) {
                max = row.get(collumnIndex).trim().length();
            }
        }

        return max;
    }

    private String contentWithPadRight(String content, int paddingOffset) {
        return String.format(" %-" + paddingOffset + "s|", content.trim());
    }

    private String getTableString(DataTableArgument dataTableArgument) {
        StringBuilder table = new StringBuilder();
        for (List<String> row : dataTableArgument.cells()) {
            String r = "|";
            for (int index = 0; index < row.size(); index++) {
                int rangePadding = getMaxLengthContent(dataTableArgument.cells(), index) + 5;
                r += String.format(contentWithPadRight(row.get(index).replace("%", "%%"), rangePadding));
            }
            table.append(r + "\n");
        }
        return table.toString();
    }


}
