package globedr.selenium.element.web.link;


import globedr.selenium.element.By;
import globedr.selenium.element.web.WebElement;

public class Link extends WebElement {


    public Link(By by) {
        super(by);
    }

    public Link(By by, By iframe) {
        super(by, iframe);
    }

    public Link(org.openqa.selenium.WebElement webElement) {
        super(webElement);
    }
}
