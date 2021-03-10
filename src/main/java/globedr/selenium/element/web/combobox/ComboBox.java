package globedr.selenium.element.web.combobox;

import globedr.selenium.element.By;
import globedr.selenium.driver.DriverUtils;
import globedr.selenium.element.Element;
import globedr.selenium.events.EventListener;
import globedr.selenium.element.web.WebElement;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ComboBox extends WebElement {


    public ComboBox(By by) {
        super(by);
    }

    public ComboBox(By by, By iframe) {
        super(by, iframe);
    }

    public ComboBox(org.openqa.selenium.WebElement webElement) {
        super(webElement);
    }

    private Select getComboBox() {
        return new Select(getWebElement().findElement(getBySelector()));
    }

    protected List<WebElement> getOptions() {
        List<WebElement> rads = new ArrayList<>();
        for (org.openqa.selenium.WebElement element : getComboBox().getOptions()) {
            rads.add(new WebElement(element));
        }
        return rads;
    }

    protected List<WebElement> getWebElements() {
        List<WebElement> rads = new ArrayList<>();
        for (org.openqa.selenium.WebElement element : DriverUtils.findElements(getBySelector())) {
            rads.add(new WebElement(element));
        }
        return rads;
    }

    public void selectValue(String value) {
        EventListener.getEvent().beforeSelectValue(this, value);
        getComboBox().selectByValue(value);
        EventListener.getEvent().afterSelectValue(this, value);
    }

    public void selectText(String text) {
        EventListener.getEvent().beforeSelectText(this, text);
        getComboBox().selectByVisibleText(text);
        EventListener.getEvent().afterSelectText(this, text);
    }

    public void waitOptionsExisted() {
        waitOptionsExisted(1);
    }

    public void waitOptionsExisted(int totalOptions) {
        try {
            Wait wait = fluentWait();
            wait.until(new Function<WebDriver, Boolean>() {
                public Boolean apply(WebDriver driver) {
                    return (getOptions().size() > totalOptions);
                }
            });
        } catch (Exception e) {
            System.out.println((String.format("%s '%s' on %s. Exception %s"
                    , Thread.currentThread().getStackTrace()[1].getMethodName()
                    , totalOptions
                    , this.toString()
                    , e.getMessage())));
        }
    }

    public void waitOptionsExistedText(String text) {
        try {
            Wait wait = fluentWait();
            wait.until(new Function<WebDriver, Boolean>() {
                public Boolean apply(WebDriver driver) {

                    for (Element e : getOptions()) {
                        if (e.getWebElement().getText().equalsIgnoreCase(text)) {
                            return true;
                        }
                    }
                    return false;
                }
            });
        } catch (Exception e) {
            System.out.println(String.format("%s '%s' on %s. Exception %s"
                    , Thread.currentThread().getStackTrace()[1].getMethodName()
                    , text
                    , this.toString()
                    , e.getMessage()));
        }
    }

    public void waitOptionsExistedValue(String text) {
        try {
            Wait wait = fluentWait();
            wait.until(new Function<WebDriver, Boolean>() {
                public Boolean apply(WebDriver driver) {
                    for (Element e : getOptions()) {
                        if (e.getWebElement().getAttribute("value").equalsIgnoreCase(text)) {
                            return true;
                        }
                    }
                    return false;
                }
            });
        } catch (Exception e) {
            System.out.println(String.format("%s '%s' on %s. Exception %s"
                    , Thread.currentThread().getStackTrace()[1].getMethodName()
                    , text
                    , this.toString()
                    , e.getMessage()));
        }
    }

    @Override
    public String getText() {
        EventListener.getEvent().beforeGetText(this);
        String text = getComboBox().getFirstSelectedOption().getText();
        EventListener.getEvent().afterGetText(this);
        return text;
    }


}
