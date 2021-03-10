package globedr.selenium.element.mobile;

import globedr.selenium.element.By;
import globedr.selenium.element.Element;
import org.openqa.selenium.WebElement;


public class MobileElement extends Element {


    public MobileElement(By by) {
        super(by);
    }

    public MobileElement(WebElement webElement) {
        super(webElement);
    }

    public MobileElement(By by, By byIFrame) {
        super(by, byIFrame);
    }

    @Override
    protected void goInIframe() {

    }

    @Override
    protected void goOutIframe() {

    }

    @Override
    public void dragAndDropByRobot(Element dest) {

    }


    public String toString() {
        if (getBySelector() != null) return String.format("%s(%s)", this.getClass().getSimpleName(), getBySelector());
        if (this.webElement != null) return String.format("%s", this.webElement);
        return null;
    }

}
