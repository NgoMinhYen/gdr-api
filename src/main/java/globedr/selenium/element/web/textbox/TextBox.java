package globedr.selenium.element.web.textbox;

import globedr.selenium.element.By;
import globedr.selenium.element.web.WebElement;

public class TextBox extends WebElement {

    public TextBox(By by) {
        super(by);
    }

    public TextBox(By by, By iframe) {
        super(by, iframe);
    }

    public TextBox(org.openqa.selenium.WebElement webElement) {
        super(webElement);
    }
}
