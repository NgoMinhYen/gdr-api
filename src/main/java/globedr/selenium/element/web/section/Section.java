package globedr.selenium.element.web.section;


import globedr.selenium.element.By;
import globedr.selenium.element.web.WebElement;

public class Section extends WebElement {


    public Section(By by) {
        super(by);
    }

    public Section(By by, By iframe) {
        super(by, iframe);
    }

    public Section(org.openqa.selenium.WebElement webElement) {
        super(webElement);
    }


}
