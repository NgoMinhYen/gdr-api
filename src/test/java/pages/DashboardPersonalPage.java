package pages;

import enums.MenuDBPersonal;
import globedr.selenium.element.By;
import globedr.selenium.element.web.button.Button;
import globedr.selenium.element.web.label.Label;

public class DashboardPersonalPage {

    private Label lblTitlePage = new Label(By.xpath("//span[@translate='personalPage']"));
    String xMenuDashboard = "//a[@href='%s']";
    private Label lblDisplayName = new Label(By.xpath("//div[@class='por mr5']/following-sibling::span"));


    public void openMenu(MenuDBPersonal menu) {
        Button btnMenu = new Button(By.xpath(String.format(xMenuDashboard, menu.toString())));
        btnMenu.waitElementToBeClickable();
        btnMenu.click();
    }
    public String getDisplayNameOnDashboar(){
        lblDisplayName.waitVisibilityOfElementLocated();
       return lblDisplayName.getText();
    }
    public void openMenuAskDoctor(){

        Button btnAskDoctor = new Button(By.xpath(String.format(xMenuDashboard,MenuDBPersonal.ASK_DOCTOR)));
        btnAskDoctor.waitElementToBeClickable();
        btnAskDoctor.click();
    }

}
