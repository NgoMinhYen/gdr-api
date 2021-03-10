package globedr.selenium.element.web.label;


import globedr.selenium.element.By;
import globedr.selenium.element.web.WebElement;

public class Label extends WebElement {


    public Label(By by) {
        super(by);
    }

    public Label(By by, By iframe) {
        super(by, iframe);
    }

    public Label(org.openqa.selenium.WebElement webElement) {
        super(webElement);
    }
}
