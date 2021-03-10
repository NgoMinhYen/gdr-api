package globedr.selenium.element.web.button;


import globedr.selenium.element.By;
import globedr.selenium.element.web.WebElement;

public class Button extends WebElement {


    public Button(By by) {
        super(by);
    }

    public Button(By by, By iframe) {
        super(by, iframe);
    }

    public Button(org.openqa.selenium.WebElement webElement) {
        super(webElement);
    }
}
