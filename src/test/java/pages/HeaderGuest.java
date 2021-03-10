package pages;

import config.ResourceLanguage;
import enums.Language;
import enums.PageGuest;
import globedr.selenium.Assert;
import globedr.selenium.element.By;
import globedr.selenium.element.Element;
import globedr.selenium.element.web.button.Button;
import globedr.selenium.element.web.label.Label;
import globedr.selenium.element.web.link.Link;

public class HeaderGuest {

    Link lkDownloadApp = new Link(By.xpath("//span[@translate='downloadApp']"));
    Link lkService = new Link(By.xpath("//span[@translate='services']"));
    Link lkContacts = new Link(By.xpath("//span[@translate='contacts']"));
    Link lkCooperate = new Link(By.xpath("//span[@translate='cooperate']"));
    Link lkSignIn= new Link(By.xpath("//a[@href='/signin']"));
    Label lblLanguage = new Label(By.xpath("//ul[contains(@class, 'mainmenu dropdown')]"));


    public String getLanguage(){
        lblLanguage.waitTextIsDisplayed();
        return lblLanguage.getText();
    }

    public void changeLanguage(Language language){
        if(!getLanguage().trim().equalsIgnoreCase(language.toString())){
            Button itemLanguage = new Button(By.xpath(String.format("//ul[contains(@class, 'mainmenu dropdown')]//a[contains(.,'%s')]", language.toString())));
            itemLanguage.waitElementToBeClickable();
            itemLanguage.click();
            ResourceLanguage.getInstance().setCurrentLanguage(language.toString());
        }
    }


    public void openPage(PageGuest pageGuest){
        Element e = null;
        switch (pageGuest){
            case CONTACTS:
                e = lkContacts;
                break;
            case SERVICES:
                e = lkService;
                break;
            case COOPERATE:
                e = lkCooperate;
                break;
            case DOWNLOAD_APP:
                e = lkDownloadApp;
                break;
            case SIGN_IN:
                e = lkSignIn;
                break;
            default:
        }

        e.waitElementToBeClickable();
        e.click();

    }
}
