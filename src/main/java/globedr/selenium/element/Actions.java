package globedr.selenium.element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Interaction;

import java.time.Duration;

public class Actions {
    private org.openqa.selenium.interactions.Actions actions;

    public Actions(WebDriver webDriver) {
        actions = new org.openqa.selenium.interactions.Actions(webDriver);
    }

    public Actions moveToElement(Element element) {
        actions = actions.moveToElement(element.getWebElement(), 0, 0);
        return this;
    }

    public Actions moveToElement(Element element, int xOffset, int yOffset) {
        actions = actions.moveToElement(element.getWebElement());
        return this;
    }


    public Actions clickAndHold(Element element) {
        actions = actions.clickAndHold(element.getWebElement());
        return this;
    }

    public Actions dragAndDropBy(Element source, int xOffset, int yOffset) {
        actions = actions.dragAndDropBy(source.getWebElement(), xOffset, yOffset);
        return this;
    }

    public Actions dragAndDrop(Element source, Element target) {
        actions = actions.dragAndDrop(source.getWebElement(), target.getWebElement());
        return this;
    }



    public Actions clickAndHold() {
        actions = actions.clickAndHold();
        return this;
    }

    public Actions click(Element element) {
        actions = actions.click(element.getWebElement());
        return this;
    }

    public Actions click() {
        actions = actions.click();
        return this;
    }


    public Actions pause(Duration duration) {
        actions = actions.pause(duration);
        return this;
    }

    public Actions pause(long duration) {
        actions = actions.pause(duration);
        return this;
    }


    public Actions moveByOffset(int xOffset, int yOffset) {
        actions = actions.moveByOffset(xOffset, yOffset);
        return this;
    }


    public Action build() {
        return actions.build();
    }

    public Actions release() {
        actions = actions.release();
        return this;
    }


    public Actions contextClick(Element element) {
        actions = actions.contextClick(element.getWebElement());
        return this;
    }

    public Actions contextClick() {
        actions = actions.contextClick();
        return this;
    }

    public Actions doubleClick() {
        actions = actions.doubleClick();
        return this;
    }

    public Actions doubleClick(Element element) {
        actions = actions.doubleClick(element.getWebElement());
        return this;
    }

    public Actions keyDown(CharSequence key) {
        actions = actions.keyDown(key);
        return this;
    }

    public Actions keyDown(Element target, CharSequence key) {
        actions = actions.keyDown(target.getWebElement(),key);
        return this;
    }


    public Actions keyUp(CharSequence key) {
        actions = actions.keyUp(key);
        return this;
    }

    public Actions keyUp(Element target, CharSequence key) {
        actions = actions.keyUp(target.getWebElement(),key);
        return this;
    }


    public Actions tick(Interaction... acts) {
        actions = actions.tick(acts);
        return this;
    }

    public Actions tick(Action act) {
        actions = actions.tick(act);
        return this;
    }



}
