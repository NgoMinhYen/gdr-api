package globedr.selenium.element.web.slider;

import globedr.selenium.element.By;
import globedr.selenium.events.EventListener;
import globedr.selenium.element.web.WebElement;
import org.openqa.selenium.Keys;

public class Slider extends WebElement {

    public Slider(By by) {
        super(by);
    }

    public Slider(By by, By iframe) {
        super(by, iframe);
    }

    public Slider(org.openqa.selenium.WebElement webElement) {
        super(webElement);
    }

    public void sliderToRight(Integer number) {
        EventListener.getEvent().beforeSliderToRight(this, number);
        for (int i = 0; i < number; i++) {
            sendKeys(Keys.ARROW_RIGHT);
        }
        EventListener.getEvent().afterSliderToRight(this, number);
    }

    public void sliderToLeft(Integer number) {
        EventListener.getEvent().beforeSliderToLeft(this, number);
        for (int i = 0; i < number; i++) {
            sendKeys(Keys.ARROW_LEFT);
        }
        EventListener.getEvent().afterSliderToLeft(this, number);
    }
}
