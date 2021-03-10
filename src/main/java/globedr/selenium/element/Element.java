package globedr.selenium.element;

import globedr.selenium.configuration.SysConfig;
import globedr.selenium.driver.DriverUtils;
import globedr.selenium.events.EventListener;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public abstract class Element {
    protected By by;
    protected By byIFrame;
    protected org.openqa.selenium.WebElement webElement;
    protected org.openqa.selenium.WebElement eIframe;


    public Element(By by) {
        this.by = by;
    }

    public Element(org.openqa.selenium.WebElement webElement) {
        this.webElement = webElement;
    }

    public Element(By by, By byIFrame) {
        this(by);
        this.byIFrame = byIFrame;
    }

    public Element(org.openqa.selenium.WebElement webElement, org.openqa.selenium.WebElement eIframe) {
        this(webElement);
        this.eIframe = eIframe;
    }

    public WebElement getWebElement() {
        return this.webElement != null ? this.webElement : DriverUtils.findElement(getBySelector());
    }

    protected WebElement getIframeElement() {
        return this.eIframe != null ? this.eIframe : DriverUtils.findElement(getByIframeSelector());
    }

    //  protected abstract WebElement getWebElements();

    protected abstract void goInIframe();

    protected abstract void goOutIframe();

    public void sendKeys(CharSequence... keysToSend) {
        goInIframe();
        EventListener.getEvent().beforeSendKeys(this, keysToSend);
        getWebElement().sendKeys(keysToSend);
        EventListener.getEvent().afterSendKeys(this, keysToSend);
        goOutIframe();
    }

    public void click() {
        goInIframe();
        EventListener.getEvent().beforeClick(this);

        getWebElement().click();
        EventListener.getEvent().afterClick(this);
        goOutIframe();
    }

    public void submit() {
        goInIframe();
        EventListener.getEvent().beforeSubmit(this);
        getWebElement().submit();
        EventListener.getEvent().afterSubmit(this);
        goOutIframe();

    }

    public void clear() {
        goInIframe();
        EventListener.getEvent().beforeClear(this);
        getWebElement().clear();
        EventListener.getEvent().afterClear(this);
        goOutIframe();

    }

    public String getTagName() {
        goInIframe();
        EventListener.getEvent().beforeGetTagName(this);
        String result = getWebElement().getTagName();
        EventListener.getEvent().afterGetTagName(this);
        goOutIframe();
        return result;
    }

    public String getAttribute(String name) {
        goInIframe();
        EventListener.getEvent().beforeGetAttribute(this, name);
        String result = getWebElement().getAttribute(name);
        EventListener.getEvent().afterGetAttribute(this, name);
        goOutIframe();
        return result;
    }

    public boolean isSelected() {
        goInIframe();
        EventListener.getEvent().beforeIsSelected(this);
        boolean result = getWebElement().isSelected();
        EventListener.getEvent().afterIsSelected(this);
        goOutIframe();
        return result;
    }

    public boolean isEnabled() {
        goInIframe();
        EventListener.getEvent().beforeIsEnabled(this);
        boolean result = getWebElement().isEnabled();
        EventListener.getEvent().afterIsEnabled(this);
        goOutIframe();
        return result;
    }

    public String getText() {
        goInIframe();
        EventListener.getEvent().beforeGetText(this);
        String result = getWebElement().getText();
        EventListener.getEvent().afterGetText(this);
        goOutIframe();
        return result;
    }


    public boolean isDisplayed() {
        goInIframe();
        EventListener.getEvent().beforeIsDisplayed(this);
        boolean result = getWebElement().isDisplayed();
        EventListener.getEvent().afterIsDisplayed(this);
        goOutIframe();
        return result;
    }

    public Point getLocation() {
        goInIframe();
        EventListener.getEvent().beforeGetLocation(this);
        Point result = getWebElement().getLocation();
        EventListener.getEvent().afterGetLocation(this);
        goOutIframe();
        return result;
    }

    public Dimension getSize() {
        goInIframe();
        EventListener.getEvent().beforeGetSize(this);
        Dimension result = getWebElement().getSize();
        EventListener.getEvent().afterGetSize(this);
        goOutIframe();
        return result;
    }

    public Rectangle getRect() {
        goInIframe();
        EventListener.getEvent().beforeGetRect(this);
        Rectangle result = getWebElement().getRect();
        EventListener.getEvent().afterGetRect(this);
        goOutIframe();
        return result;
    }

    public String getCssValue(String propertyName) {
        goInIframe();
        EventListener.getEvent().beforeGetCssValue(this, propertyName);
        String result = getWebElement().getCssValue(propertyName);
        EventListener.getEvent().afterGetCssValue(this, propertyName);
        goOutIframe();
        return result;
    }

    public Actions actions() {
        return new Actions(DriverUtils.getDriver());
    }


    public void dragAndDropBy(int xOffset, int yOffset) {
        goInIframe();
        EventListener.getEvent().beforeDragAndDropBy(this, xOffset, yOffset);

        actions().dragAndDropBy(this, xOffset, yOffset).build().perform();

        EventListener.getEvent().afterDragAndDropBy(this, xOffset, yOffset);
        goOutIframe();
    }

    public void dragAndDropTo(Element dest) {
        goInIframe();
        EventListener.getEvent().beforeDragAndDropTo(this, dest);

        actions().dragAndDrop(this, dest).build().perform();

        EventListener.getEvent().afterDragAndDropTo(this, dest);
        goOutIframe();
    }

    public void holdAndDropTo(Element dest) {
        holdAndDropTo(dest, 0, 0, 0);
    }
    public void holdAndDropTo(Element dest, int xOffset, int yOffset) {
        holdAndDropTo(dest, xOffset, yOffset, 0);
    }


    public void holdAndDropTo(Element dest, int xOffset, int yOffset, int delayInSeconds) {
        goInIframe();
        EventListener.getEvent().beforeHoldAndDropTo(this, dest, xOffset, yOffset);

        actions().moveToElement(this)
                .pause(Duration.ofMillis(delayInSeconds * 500))
                .clickAndHold()
                .pause(Duration.ofMillis(delayInSeconds * 500))
                .moveToElement(dest, xOffset, yOffset)
                .pause(Duration.ofMillis(delayInSeconds * 500))
                .release()
                .build().perform();

        EventListener.getEvent().afterHoldAndDropTo(this, dest, xOffset, yOffset);
        goOutIframe();
    }

    public abstract void dragAndDropByRobot(Element dest);

    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        goInIframe();
        EventListener.getEvent().beforeGetScreenshotAs(this);
        X result = getWebElement().getScreenshotAs(target);
        EventListener.getEvent().afterGetScreenshotAs(this);
        goOutIframe();
        return result;
    }


    protected Wait fluentWait() {
        return new FluentWait(DriverUtils.getDriver())
                .withTimeout(Duration.ofMillis(SysConfig.getTimeOutElement()))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(Exception.class);
    }

    protected Wait fluentWait(long timeOutInSecond) {
        return new FluentWait(DriverUtils.getDriver())
                .withTimeout(Duration.ofMillis(timeOutInSecond))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(Exception.class);
    }

    public void waitTextIsDisplayed() {
        goInIframe();
        fluentWait().until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                WebElement e = getWebElement();
                return !e.getText().isEmpty();
            }
        });
        goOutIframe();
    }

    public void waitVisibilityOfElementLocated() {
        goInIframe();
        fluentWait().until(ExpectedConditions.visibilityOfElementLocated(getBySelector()));
        goOutIframe();
    }

    public void waitElementToBeSelected() {
        goInIframe();
        fluentWait().until(ExpectedConditions.elementToBeSelected(getBySelector()));
        goOutIframe();
    }

    public void waitPresenceOfElementLocated() {
        goInIframe();
        fluentWait().until(ExpectedConditions.presenceOfElementLocated(getBySelector()));
        goOutIframe();
    }

    public void waitElementToBeClickable() {
        goInIframe();
        fluentWait().until(ExpectedConditions.elementToBeClickable(getBySelector()));
        goOutIframe();
    }

    public org.openqa.selenium.By getBySelector() {
        if (by != null) return by.getBySelector();
        return null;
    }


    public org.openqa.selenium.By getByIframeSelector() {
        return byIFrame.getBySelector();
    }


    public abstract String toString();

}
