package pages;

import globedr.selenium.element.By;
import globedr.selenium.element.web.button.Button;

public class ConsultantPage {
    private final Button btnCreateQuestion = new Button(By.xpath("//button[@translate='createNewQuestion']"));


    public void clickButtonCreateQuestion(){
        btnCreateQuestion.waitElementToBeClickable();
        btnCreateQuestion.click();
    }


}
