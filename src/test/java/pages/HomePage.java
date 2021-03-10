package pages;


import globedr.selenium.element.By;
import globedr.selenium.element.web.label.Label;

public class HomePage {


    private final Label lblDisplayName = new Label(By.xpath("//*[@class='header-container']//a[contains(@class, 'text-nowrap')]//span"));
    String xDisplayName = "//*[@class='header-container']//*[contains(.,'%s')]";

    public String getDisplayName(){
        lblDisplayName.waitTextIsDisplayed();
        return lblDisplayName.getText();

    }



}
