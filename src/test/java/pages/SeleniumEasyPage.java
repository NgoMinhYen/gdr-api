package pages;


import globedr.selenium.constants.FilePath;
import globedr.selenium.element.Actions;
import globedr.selenium.element.By;
import globedr.selenium.element.web.button.Button;
import globedr.selenium.element.web.fileUpload.FileUpload;
import globedr.selenium.element.web.fileUpload.FileUploadFactory;
import globedr.selenium.element.web.section.Section;
import globedr.selenium.element.web.slider.Slider;

import java.time.Duration;

public class SeleniumEasyPage {


    private Section sctMydropzone = new Section(By.id("mydropzone"));

    private Slider slGrey = new Slider(By.xpath("//input[@onchange='range.value=value']"));

    private FileUpload up = FileUploadFactory.getElement(By.xpath("//form"));
    private Button btnAlertBox = new Button(By.xpath("//button[@onclick='myAlertFunction()']"));
    private Button btnConfirmBox = new Button(By.xpath("//button[@onclick='myConfirmFunction()']"));
    private Button btnPromptBox = new Button(By.xpath("//button[@onclick='myPromptFunction()']"));

    private Button btn5000 = new Button(By.xpath("(//a[@class='button button-orange'])[2]"));
    private Section sctAmount= new Section(By.id("amt7"));


    public void dragAndDropToAmount(){

        btn5000.waitElementToBeClickable();
        sctAmount.waitVisibilityOfElementLocated();

        Actions actions = btn5000.actions().moveToElement(btn5000)
                .clickAndHold()
                .moveByOffset(100,100)
                .pause(Duration.ofSeconds(5));
        actions.release().build().perform();

    }


    public void dragAndDropToDropZone(String name) {
        Button btnDraggable1 = new Button(By.xpath(String.format("//span[.='%s']", name)));
        btnDraggable1.waitElementToBeClickable();
        sctMydropzone.waitVisibilityOfElementLocated();

        btnDraggable1.dragAndDropByRobot(sctMydropzone);

    }

    public void setSliderGrey(int number) {
        slGrey.waitVisibilityOfElementLocated();
        slGrey.sliderToLeft(100);
        slGrey.sliderToRight(number - 1);
    }

    public void upload(String path) {
        up.waitVisibilityOfElementLocated();
        up.uploadFileByDragAndDrop(FilePath.PROJECT +path);
    }

    public void openAlertBox() {
        btnAlertBox.waitPresenceOfElementLocated();
        btnAlertBox.click();
    }


    public void openConfirmBox() {
        btnConfirmBox.waitPresenceOfElementLocated();
        btnConfirmBox.click();
    }

    public void openPromptBox() {
        btnPromptBox.waitPresenceOfElementLocated();
        btnPromptBox.click();
    }


}
