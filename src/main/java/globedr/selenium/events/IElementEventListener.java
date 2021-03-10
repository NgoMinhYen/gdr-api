package globedr.selenium.events;

import java.util.List;

public interface IElementEventListener {

    void beforeSendKeys(globedr.selenium.element.Element element, CharSequence... keysToSend);

    void afterSendKeys(globedr.selenium.element.Element element, CharSequence... keysToSend);

    void beforeClick(globedr.selenium.element.Element element);

    void afterClick(globedr.selenium.element.Element element);

    void beforeSubmit(globedr.selenium.element.Element element);

    void afterSubmit(globedr.selenium.element.Element element);

    void beforeClear(globedr.selenium.element.Element element);

    void afterClear(globedr.selenium.element.Element element);

    void beforeGetTagName(globedr.selenium.element.Element element);

    void afterGetTagName(globedr.selenium.element.Element element);

    void beforeGetAttribute(globedr.selenium.element.Element element, String name);

    void afterGetAttribute(globedr.selenium.element.Element element, String name);

    void beforeIsSelected(globedr.selenium.element.Element element);

    void afterIsSelected(globedr.selenium.element.Element element);

    void beforeIsEnabled(globedr.selenium.element.Element element);

    void afterIsEnabled(globedr.selenium.element.Element element);

    void beforeGetText(globedr.selenium.element.Element element);

    void afterGetText(globedr.selenium.element.Element element);


    void beforeIsDisplayed(globedr.selenium.element.Element element);

    void afterIsDisplayed(globedr.selenium.element.Element element);

    void beforeGetLocation(globedr.selenium.element.Element element);

    void afterGetLocation(globedr.selenium.element.Element element);

    void beforeGetSize(globedr.selenium.element.Element element);

    void afterGetSize(globedr.selenium.element.Element element);

    void beforeGetRect(globedr.selenium.element.Element element);

    void afterGetRect(globedr.selenium.element.Element element);


    void beforeGetCssValue(globedr.selenium.element.Element element, String propertyName);

    void afterGetCssValue(globedr.selenium.element.Element element, String propertyName);

    void beforeDragAndDropTo(globedr.selenium.element.Element source, globedr.selenium.element.Element dest);

    void afterDragAndDropTo(globedr.selenium.element.Element source, globedr.selenium.element.Element dest);

    void beforeDragAndDropByRobot(globedr.selenium.element.Element source, globedr.selenium.element.Element dest);

    void afterDragAndDropByRobot(globedr.selenium.element.Element source, globedr.selenium.element.Element dest);


    void beforeDragAndDropBy(globedr.selenium.element.Element source, int xOffset, int yOffset);

    void afterDragAndDropBy(globedr.selenium.element.Element source, int xOffset, int yOffset);

    void beforeHoldAndDropTo(globedr.selenium.element.Element source, globedr.selenium.element.Element dest, int xOffset, int yOffset);

    void afterHoldAndDropTo(globedr.selenium.element.Element source, globedr.selenium.element.Element dest, int xOffset, int yOffset);

    void beforeGetScreenshotAs(globedr.selenium.element.Element element);

    void afterGetScreenshotAs(globedr.selenium.element.Element element);

    void beforeSelectValue(globedr.selenium.element.Element element, String value);

    void afterSelectValue(globedr.selenium.element.Element element, String value);

    void beforeSelectText(globedr.selenium.element.Element element, String text);

    void afterSelectText(globedr.selenium.element.Element element, String text);

    void beforeUploadFile(globedr.selenium.element.Element element, String path);

    void afterUploadFile(globedr.selenium.element.Element element, String path);

    void beforeCheck(globedr.selenium.element.Element element, List<String> attributes, String withValue);

    void afterCheck(globedr.selenium.element.Element element, List<String> attributes, String withValue);

    void beforeSliderToRight(globedr.selenium.element.Element element, Integer number);

    void afterSliderToRight(globedr.selenium.element.Element element, Integer number);

    void beforeSliderToLeft(globedr.selenium.element.Element element, Integer number);

    void afterSliderToLeft(globedr.selenium.element.Element element, Integer number);

    void beforeSwitchInIframe(globedr.selenium.element.Element iframe);

    void afterSwitchInIframe(globedr.selenium.element.Element iframe);

    void beforeSwitchOutIframe();

    void afterSwitchOutIframe();

    void beforeSetAttributeByJavascript(globedr.selenium.element.Element element, String attributeName, String value);

    void afterSetAttributeByJavascript(globedr.selenium.element.Element element, String attributeName, String value);

    void beforeClickJS(globedr.selenium.element.Element element);

    void afterClickJS(globedr.selenium.element.Element element);

    void beforeGetValue(globedr.selenium.element.Element element);

    void afterGetValue(globedr.selenium.element.Element element);


}
