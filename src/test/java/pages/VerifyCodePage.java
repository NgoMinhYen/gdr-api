package pages;

import globedr.selenium.element.By;
import globedr.selenium.element.web.button.Button;
import globedr.selenium.element.web.textbox.TextBox;

public class VerifyCodePage {
    private final TextBox txtNumber1 = new TextBox(By.id("code_1"));
    private final TextBox txtNumber2 = new TextBox(By.id("code_2"));
    private final TextBox txtNumber3 = new TextBox(By.id("code_3"));
    private final TextBox txtNumber4 = new TextBox(By.id("code_4"));
    private final Button btnVerifyCode = new Button(By.xpath("//button[@translate='verifyCode']"));

    public void inputCodeNumber1(String code_1) {
        txtNumber1.waitPresenceOfElementLocated();
        txtNumber1.sendKeys(code_1);
    }

    public void inputCodeNumber2(String code_2){
        txtNumber2.waitPresenceOfElementLocated();
        txtNumber2.sendKeys(code_2);
    }

    public void inputCodeNumber3(String code_3){
        txtNumber3.waitPresenceOfElementLocated();
        txtNumber3.sendKeys(code_3);
    }

    public void inputCodeNumber4(String code_4){
        txtNumber4.waitPresenceOfElementLocated();
        txtNumber4.sendKeys(code_4);
    }
    public void clickButtonVerifyCode(){
        btnVerifyCode.click();
    }
    public void verifyCode(String code1,String code2, String code3, String code4){
        inputCodeNumber1(code1);
        inputCodeNumber2(code2);
        inputCodeNumber3(code3);
        inputCodeNumber4(code4);
        clickButtonVerifyCode();
    }

}
