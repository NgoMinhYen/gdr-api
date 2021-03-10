package globedr.selenium.element.web;

import globedr.selenium.element.By;
import globedr.selenium.driver.DriverUtils;
import globedr.selenium.element.Element;
import globedr.selenium.events.EventListener;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.*;
import java.util.List;

public class WebElement extends Element {

    public WebElement(By by) {
        super(by);
    }

    public WebElement(By by, By iframe) {
        super(by, iframe);
    }

    public WebElement(org.openqa.selenium.WebElement webElement) {
        super(webElement);
    }

    private JavascriptExecutor jsExecutor() {
        try {
            if (DriverUtils.getDriver() != null) {
                return (JavascriptExecutor) DriverUtils.getDriver();
            }
        } catch (WebDriverException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    protected <T> T executeScript(String script, Object... args) {
        T result = null;
        try {

            result = (T) jsExecutor().executeScript(script, args);
            return result;
        } catch (Exception e) {

        }
        return result;
    }


    @Override
    protected void goInIframe() {
        if (this.byIFrame != null) {

            WebElement iframe = new WebElement(this.byIFrame);
            EventListener.getEvent().beforeSwitchInIframe(iframe);
            iframe.waitVisibilityOfElementLocated();
            DriverUtils.switchToIframe(this.byIFrame.getBySelector());
            EventListener.getEvent().afterSwitchInIframe(iframe);
        }
    }

    @Override
    protected void goOutIframe() {
        if (this.byIFrame != null) {
            EventListener.getEvent().beforeSwitchOutIframe();
            DriverUtils.switchToDefault();
            EventListener.getEvent().afterSwitchOutIframe();
        }
    }


    public void setAttributeJS(String attributeName, String value) {
        EventListener.getEvent().beforeSetAttributeByJavascript(this, attributeName, value);
        executeScript(String.format("arguments[0].setAttribute(%s,%s);", attributeName, value), getWebElement());
        EventListener.getEvent().afterSetAttributeByJavascript(this, attributeName, value);
    }

    public String getInnerHTML() {
        return executeScript(String.format("return arguments[0].innerHTML;"), getWebElement());
    }

    public String getOuterHTML() {
        return executeScript(String.format("return arguments[0].outerHTML;"), getWebElement());
    }

    public String getAttributesAsString() {
        Object result = null;
        try {
            result = executeScript(
                    "var items = {}; " +
                            "for (index = 0; index < arguments[0].attributes.length; ++index) " +
                            "{ items[arguments[0].attributes[index].name] = arguments[0].attributes[index].value }; " +
                            "return items;", getWebElement());
        } catch (WebDriverException e) {
            System.out.println(e);
        }
        return result.toString();
    }

    public Map<String, String> getAttributes() {
        Map<String, String> ats = new HashMap<>();
        for (String pair : Arrays.asList(getAttributesAsString()
                .replaceAll("\\{", "")
                .replaceAll("\\}", "")
                .split(","))) {
            String[] entry = pair.split("=");
            ats.put(entry[0].trim(), entry[1].trim());
        }
        return ats;
    }

    public List<String> getAttributeNames() {
        List<String> list = new ArrayList<>();
        for (String pair : Arrays.asList(getAttributesAsString()
                .replaceAll("\\{", "")
                .replaceAll("\\}", "")
                .split(","))) {
            String[] entry = pair.split("=");
            list.add(entry[0].trim());
        }
        return list;
    }


    public String getValue() {
        goInIframe();
        EventListener.getEvent().beforeGetValue(this);
        String result = getWebElement().getAttribute("value");
        EventListener.getEvent().afterGetValue(this);
        goOutIframe();
        return result;
    }

    public void clickJS() {
        goInIframe();
        EventListener.getEvent().beforeClickJS(this);
        executeScript("arguments[0].click();", getWebElement());
        EventListener.getEvent().afterClickJS(this);
        goOutIframe();
    }


    public void dragAndDropByRobot(Element dest) {
        EventListener.getEvent().beforeDragAndDropByRobot(this, dest);
        //Setup robot
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        robot.setAutoDelay(50);

        /*
         *  This method is used for Case: Source and Destination Element are changed while draging or droping
         *  while using Actions.dragAndDrop, script is hang
         *
         *
         */

        // must scroll to top screen before using this method

        //Fullscreen page so selenium coordinates work
        String code = "return window.outerHeight - window.innerHeight;";
        long offsetX = executeScript("return window.screenX + (window.outerWidth - window.innerWidth) / 2 - window.scrollX;");
        long offsetY = executeScript("return window.screenY + (window.outerHeight - window.innerHeight) - window.scrollY;");


        //Move mouse to drag from location

        int sourceX = getLocation().x + (getRect().width / 2) + (int) offsetX;
        int sourceY = getLocation().y + (getRect().height / 2) + (int) offsetY;
        robot.mouseMove(sourceX , sourceY );


        //Click and drag
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        DriverUtils.sleep(1);
        int desX = dest.getLocation().x + (dest.getRect().width / 2) + (int) offsetX;
        int desY = dest.getLocation().y + (dest.getRect().height / 2) + (int) offsetY;

        //Move to final position
        DriverUtils.sleep(1);
        robot.mouseMove(desX , desY );
        // Must move 2 times
        DriverUtils.sleep(1);

        robot.mouseMove(desX + 1, desY + 1);
        DriverUtils.sleep(1);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);

        EventListener.getEvent().afterDragAndDropByRobot(this, dest);

    }

    public String toString() {
        if (getBySelector() != null) return String.format("%s(%s)", this.getClass().getSimpleName(), getBySelector());
        if (this.webElement != null) return String.format("%s", getOuterHTML());
        return null;
    }

}
