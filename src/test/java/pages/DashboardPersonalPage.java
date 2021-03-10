package pages;

import enums.MenuDBPersonal;
import globedr.selenium.element.By;
import globedr.selenium.element.web.button.Button;
import globedr.selenium.element.web.label.Label;

public class DashboardPersonalPage {

    private Label lblTitlePage = new Label(By.xpath("//span[@translate='personalPage']"));
    String xMenuDashboard = "//a[@href='%s']";

    public void openMenu(MenuDBPersonal menu) {
        Button btnMenu = new Button(By.xpath(String.format(xMenuDashboard, menu.toString())));
        btnMenu.waitElementToBeClickable();
        btnMenu.click();
    }


}
