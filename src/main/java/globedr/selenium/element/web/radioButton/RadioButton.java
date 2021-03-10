package globedr.selenium.element.web.radioButton;


import com.google.common.base.Strings;
import globedr.selenium.element.By;
import globedr.selenium.driver.DriverUtils;
import globedr.selenium.events.EventListener;
import globedr.selenium.element.web.WebElement;


import java.util.ArrayList;
import java.util.List;

public class RadioButton extends WebElement {


    public RadioButton(By by) {
        super(by);
    }

    public RadioButton(By by, By iframe) {
        super(by, iframe);
    }

    public RadioButton(org.openqa.selenium.WebElement webElement) {
        super(webElement);
    }

    public void check(String attribute, String withValue) {
        check(attribute, withValue);
    }

    public void check(List<String> attributes, String withValue) {
        EventListener.getEvent().beforeCheck(this, attributes, withValue);
        if (!isChecked(attributes, withValue)) {
            getWebElement(attributes, withValue).click();
        }
        EventListener.getEvent().afterCheck(this, attributes, withValue);
    }

    public void check(String value) {
        check(getAttributeNames(), value);
    }

    public boolean isChecked(List<String> attributes, String withValue) {
        return getWebElement(attributes, withValue).isSelected();
    }

    public boolean isChecked(String value) {
        return isChecked(getAttributeNames(), value);
    }

    protected WebElement getWebElement(List<String> attributes, String value) {
        List<WebElement> rads = getWebElements();
        for (int i = 0; i < rads.size(); i++) {
            for (String name : attributes) {
                String attr = Strings.nullToEmpty(rads.get(i).getAttribute(name));
                if (attr.equalsIgnoreCase(value)) {
                    return rads.get(i);
                }
            }
        }
        return null;
    }

    protected List<WebElement> getWebElements() {
        List<WebElement> rads = new ArrayList<>();
        for (org.openqa.selenium.WebElement element : DriverUtils.findElements(getBySelector())) {
            rads.add(new WebElement(element));
        }
        return rads;
    }


}
