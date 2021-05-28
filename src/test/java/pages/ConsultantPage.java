package pages;

import globedr.selenium.driver.DriverUtils;
import globedr.selenium.element.By;
import globedr.selenium.element.web.button.Button;
import globedr.selenium.element.web.textbox.TextBox;

public class ConsultantPage {
    private final Button btnCreateQuestion = new Button(By.xpath("//button[@translate='createNewQuestion']"));
    String xtxtOnCreatQuestion = "//label[@translate='%s']//preceding-sibling::input";
    private final TextBox txtQuestion = new TextBox(By.xpath("//p[@translate='question']//following-sibling::div/textarea"));

    public void createNewQuestion(String height, String weight, String temperature, String question) {
       
        clickButtonCreateQuestion();
        enterHeight(height);
        enterWeight(weight);
        enterTemperature(temperature);
        enterQuestion(question);
    }

    public void clickButtonCreateQuestion() {

        btnCreateQuestion.waitElementToBeClickable();
        btnCreateQuestion.click();
    }

    public void enterHeight(String height) {
        TextBox txtHeight = new TextBox(By.xpath(String.format(xtxtOnCreatQuestion, "height")));
        txtHeight.waitPresenceOfElementLocated();
        txtHeight.sendKeys(height);
    }

    public void enterWeight(String weight) {
        TextBox txtWeight = new TextBox(By.xpath(String.format(xtxtOnCreatQuestion, "weight")));
        txtWeight.sendKeys(weight);
    }

    public void enterTemperature(String temperature) {
        TextBox txtTemperature = new TextBox(By.xpath(String.format(xtxtOnCreatQuestion, "temperature")));
        txtTemperature.sendKeys(temperature);
    }

    public void enterQuestion(String question) {
        txtQuestion.sendKeys(question);
    }

}
