package pages;

import dataObject.Country;
import globedr.selenium.driver.DriverUtils;
import globedr.selenium.element.By;
import globedr.selenium.element.Element;
import globedr.selenium.element.web.WebElement;
import globedr.selenium.element.web.button.Button;
import globedr.selenium.element.web.combobox.ComboBox;
import globedr.selenium.element.web.textbox.TextBox;
import org.openqa.selenium.JavascriptExecutor;

import java.util.List;

public class SignupPage {
    Country country = new Country();
    private final ComboBox cbCountry = new ComboBox(By.xpath("//div[@id='SignIn']//select"));
    private final TextBox txtUserName = new TextBox(By.id("UserName"));
    private final TextBox txtPassword = new TextBox(By.id("Password"));
    private final TextBox txtName = new TextBox(By.id("Name"));
    private final Button btnSignUp = new Button(By.xpath("//button[@translate='signUp']"));

    public void signUp (String phoneNumber, String pass, String name, String country){
        selectCountry(country);
        enterUserName(phoneNumber);
        enterPassword(pass);
        enterFullName(name);
        clickButtonSignUp();

    }

    public void enterUserName (String userName){
        txtUserName.waitElementToBeClickable();
        txtUserName.sendKeys(userName);
    }

    public void enterPassword(String pass){
        txtPassword.waitElementToBeClickable();
        txtPassword.sendKeys(pass);
    }

    public void enterFullName(String name){
        txtName.waitElementToBeClickable();
        txtName.sendKeys(name);
    }
    public void selectCountry(String countryName){

        cbCountry.waitOptionsExisted();
        cbCountry.selectText("+"+country.readFileJsonAndGetCountryCode(countryName));

    }
    public void clickButtonSignUp(){
        btnSignUp.click();
    }


}
