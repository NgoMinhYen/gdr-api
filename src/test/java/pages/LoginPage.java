package pages;

import globedr.selenium.element.By;
import globedr.selenium.element.web.button.Button;
import globedr.selenium.element.web.combobox.ComboBox;
import globedr.selenium.element.web.label.Label;
import globedr.selenium.element.web.radioButton.RadioButton;
import globedr.selenium.element.web.textbox.TextBox;

public class LoginPage {
    public final HeaderGuest headerGuest = new HeaderGuest();
    private final TextBox txtUser = new TextBox(By.id("UserName"));
    private final TextBox txtPass = new TextBox(By.id("Password"));
    private final Button btnLogin = new Button(By.xpath("//button[contains(@class,'btn')]"));
    private final ComboBox cbCountry = new ComboBox(By.xpath("//select"));
    private final RadioButton radLikeSite = new RadioButton(By.xpath("//input[@name='like']/following-sibling::label"));
    private final By iframe = By.xpath("//iframe[@name='oddcouple']");
    private final Label lblTitlePage = new Label(By.xpath("//h2[@translate='signIn']"));

    public String getTitlePage(){
        lblTitlePage.waitTextIsDisplayed();
        return lblTitlePage.getText();
    }


    public void login(String user, String pass, String country){
        enterUser(user);
        enterPass(pass);
        selectCountry(country);
        clickLogin();
    }

    public void enterUser(String user){
        txtUser.waitElementToBeClickable();
        txtUser.sendKeys(user);
    }

    public void enterPass(String pass){
        txtPass.sendKeys(pass);
    }

    public void selectCountry(String country){
        cbCountry.waitOptionsExisted();
        cbCountry.selectText(country);
    }

    public void clickLogin(){
        btnLogin.waitElementToBeClickable();
        btnLogin.click();
    }

    public void likeSite(String name){
        radLikeSite.check( name);
    }


}
