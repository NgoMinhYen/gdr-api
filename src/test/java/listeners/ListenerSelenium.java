package listeners;

import com.rest.core.observers.IObserver;
import com.rest.core.observers.Subject;
import globedr.selenium.element.Element;
import globedr.selenium.events.IDriverEventListener;
import globedr.selenium.events.IElementEventListener;
import globedr.selenium.events.IEventListener;


import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class ListenerSelenium extends Subject implements IEventListener {
    private String content;

    public void log(String content) {
        setContent(content);
        notifyAllObserver();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    @Override
    protected void notifyAllObserver() {
        for (IObserver observer : listIObservers) {
            observer.update(getContent());
        }
    }

    @Override
    public void beforeSendKeys(Element element, CharSequence... keysToSend) {
        StringBuilder builder = new StringBuilder();
        for (CharSequence c : keysToSend) {
            builder.append(c);
        }

        log(String.format("%s '%s' on %s", "sendkeys", builder.toString(), element.toString()));
    }

    @Override
    public void afterSendKeys(Element element, CharSequence... keysToSend) {

    }

    @Override
    public void beforeClick(Element element) {
        log(String.format("%s on %s", "click", element.toString()));
    }

    @Override
    public void afterClick(Element element) {

    }

    @Override
    public void beforeSubmit(Element element) {
        log(String.format("%s on %s", "submit", element.toString()));
    }

    @Override
    public void afterSubmit(Element element) {

    }

    @Override
    public void beforeClear(Element element) {
        log(String.format("%s on %s", "clear", element.toString()));
    }

    @Override
    public void afterClear(Element element) {

    }

    @Override
    public void beforeGetTagName(Element element) {
        log(String.format("%s on %s", "getTagName", element.toString()));
    }

    @Override
    public void afterGetTagName(Element element) {

    }

    @Override
    public void beforeGetAttribute(Element element, String name) {
        log(String.format("%s of '%s' on %s", "getAttribute", name, element.toString()));
    }

    @Override
    public void afterGetAttribute(Element element, String name) {

    }

    @Override
    public void beforeIsSelected(Element element) {
        log(String.format("%s on %s", "isSelected", element.toString()));
    }

    @Override
    public void afterIsSelected(Element element) {

    }

    @Override
    public void beforeIsEnabled(Element element) {
        log(String.format("%s on %s", "isEnabled", element.toString()));
    }

    @Override
    public void afterIsEnabled(Element element) {

    }

    @Override
    public void beforeGetText(Element element) {
        log(String.format("%s on %s", "get text", element.toString()));
    }

    @Override
    public void afterGetText(Element element) {

    }

    @Override
    public void beforeIsDisplayed(Element element) {
        log(String.format("%s on %s", "isDisplayed", element.toString()));
    }

    @Override
    public void afterIsDisplayed(Element element) {

    }

    @Override
    public void beforeGetLocation(Element element) {
        log(String.format("%s on %s", "getLocation", element.toString()));
    }

    @Override
    public void afterGetLocation(Element element) {

    }

    @Override
    public void beforeGetSize(Element element) {
        log(String.format("%s on %s", "getSize", element.toString()));
    }

    @Override
    public void afterGetSize(Element element) {

    }

    @Override
    public void beforeGetRect(Element element) {
        log(String.format("%s on %s", "getRect", element.toString()));
    }

    @Override
    public void afterGetRect(Element element) {

    }

    @Override
    public void beforeGetCssValue(Element element, String propertyName) {
        log(String.format("%s of '%s' on %s", "getCssValue", propertyName, element.toString()));
    }

    @Override
    public void afterGetCssValue(Element element, String propertyName) {

    }

    @Override
    public void beforeDragAndDropTo(Element source, Element dest) {
        log(String.format("Drag and drop %s to %s", source.toString(), dest.toString()));
    }

    @Override
    public void afterDragAndDropTo(Element source, Element dest) {

    }

    @Override
    public void beforeDragAndDropByRobot(Element source, Element dest) {
        log(String.format("Use Robot to drag and drop %s to %s", source.toString(), dest.toString()));
    }

    @Override
    public void afterDragAndDropByRobot(Element source, Element dest) {

    }

    @Override
    public void beforeDragAndDropBy(Element source, int xOffset, int yOffset) {
        
    }

    @Override
    public void afterDragAndDropBy(Element source, int xOffset, int yOffset) {

    }

    @Override
    public void beforeHoldAndDropTo(Element source, Element dest, int xOffset, int yOffset) {
        log(String.format("Hold and drop %s to %s with offset(x=%d,y=%d)", source.toString(), dest.toString(), xOffset, yOffset));
    }

    @Override
    public void afterHoldAndDropTo(Element source, Element dest, int xOffset, int yOffset) {

    }

    @Override
    public void beforeGetScreenshotAs(Element element) {
        log(String.format("%s on %s", "getScreenshotAs", element.toString()));
    }

    @Override
    public void afterGetScreenshotAs(Element element) {

    }

    @Override
    public void beforeSelectValue(Element element, String value) {
        log(String.format("%s '%s' on %s", "select value", value, element.toString()));
    }

    @Override
    public void afterSelectValue(Element element, String value) {

    }

    @Override
    public void beforeSelectText(Element element, String text) {
        log(String.format("%s '%s' on %s", "select text", text, element.toString()));
    }

    @Override
    public void afterSelectText(Element element, String text) {

    }

    @Override
    public void beforeUploadFile(Element element, String path) {
        log(String.format("%s '%s' on %s", "upload file", path, element.toString()));
    }

    @Override
    public void afterUploadFile(Element element, String path) {

    }

    @Override
    public void beforeCheck(Element element, List<String> attributes, String withValue) {
        log(String.format("%s '%s' = '%s' on %s", "check all", attributes, withValue, element.toString()));
    }

    @Override
    public void afterCheck(Element element, List<String> attributes, String withValue) {

    }

    @Override
    public void beforeSliderToRight(Element element, Integer number) {
        log(String.format("%s '%d' unit on %s", "slider to right", number, element.toString()));
    }

    @Override
    public void afterSliderToRight(Element element, Integer number) {

    }

    @Override
    public void beforeSliderToLeft(Element element, Integer number) {
        log(String.format("%s '%d' unit on %s", "slider to left", number, element.toString()));
    }

    @Override
    public void afterSliderToLeft(Element element, Integer number) {

    }

    @Override
    public void beforeSwitchInIframe(Element iframe) {
        log(String.format("%s %s", "switch into iframe", iframe.toString()));
    }

    @Override
    public void afterSwitchInIframe(Element iframe) {

    }

    @Override
    public void beforeSwitchOutIframe() {
        log("switch to default");
    }

    @Override
    public void afterSwitchOutIframe() {

    }

    @Override
    public void beforeSetAttributeByJavascript(Element element, String attributeName, String value) {
        log(String.format("%s '%s' = '%s' on %s", "set attribute", attributeName, value, element.toString()));
    }

    @Override
    public void afterSetAttributeByJavascript(Element element, String attributeName, String value) {

    }

    @Override
    public void beforeClickJS(Element element) {
        log(String.format("click on %s by javascript", element.toString()));
    }

    @Override
    public void afterClickJS(Element element) {

    }

    @Override
    public void beforeGetValue(Element element) {
        log(String.format("get value on %s", element.toString()));
    }

    @Override
    public void afterGetValue(Element element) {

    }


    @Override
    public void beforeOpenUrl(String url) {
        log("Browser open url : " + url);
    }

    @Override
    public void afterOpenUrl(String url) {

    }

    @Override
    public void beforeRunCommandLine(String cmd) {
        log("Run command line : " + cmd);
    }

    @Override
    public void afterRunCommandLine(String stdOutput, String stdError) {
        log(stdOutput);
        log(stdError);

    }


}
