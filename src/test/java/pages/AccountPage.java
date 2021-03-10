package pages;

import dataObject.Account;
import globedr.selenium.Assert;
import globedr.selenium.driver.DriverUtils;
import globedr.selenium.element.By;
import globedr.selenium.constants.FilePath;
import globedr.selenium.element.web.button.Button;
import globedr.selenium.element.web.combobox.ComboBox;
import globedr.selenium.element.web.fileUpload.FileUpload;
import globedr.selenium.element.web.fileUpload.FileUploadFactory;
import globedr.selenium.element.web.textbox.TextBox;

public class AccountPage {

    private String xMyProfile = "//label[@translate='%s']/preceding-sibling::*";
    private TextBox txtYourName = new TextBox(By.xpath(String.format(xMyProfile, "yourName")));
    private TextBox txtTitle = new TextBox(By.xpath(String.format(xMyProfile, "title")));
    private TextBox txtEmail = new TextBox(By.xpath(String.format(xMyProfile, "email")));
    private TextBox txtAddress = new TextBox(By.xpath(String.format(xMyProfile, "address")));
    private TextBox txtPhoneNumber = new TextBox(By.xpath(String.format(xMyProfile, "phoneNumber")));
    private TextBox txtWorkPhone = new TextBox(By.xpath(String.format(xMyProfile, "workPhone")));
    private TextBox txtDOB = new TextBox(By.xpath("//app-ng-date-gdr//input"));


    private ComboBox cbGender = new ComboBox(By.xpath(String.format(xMyProfile, "gender")));
    private ComboBox cbVisitCountry = new ComboBox(By.xpath(String.format(xMyProfile, "visitCountry")));
    private ComboBox cbCountry = new ComboBox(By.xpath(String.format(xMyProfile, "country")));
    private ComboBox cbCity = new ComboBox(By.xpath(String.format(xMyProfile, "city")));
    private ComboBox cbRegion = new ComboBox(By.xpath("(//select)[4]"));
    private Button btnSave = new Button(By.xpath("//a[@translate='save']"));

    private FileUpload icUpload = FileUploadFactory.getElement(By.xpath("//div[contains(@class,'btn-file')]"));
    private FileUpload icUploadTest = FileUploadFactory.getElement(By.id("uploadImage"));

    private Button btnOKOnCropImgPop = new Button(By.xpath("//app-crop-image//button[contains(@class, 'btn-gdr')]"));
    private Button icChangeLoginId = new Button(By.xpath("//i[@title='Change']"));
    private TextBox txtLoginId = new TextBox(By.xpath("//label[@translate='loginId']//preceding-sibling::div"));

    public void waitLoadCompleted() {
        txtLoginId.waitTextIsDisplayed();
    }

    public void updateProfile(Account account) {
        updateProfile(
                account.getYourName(),
                account.getTitle(),
                account.getEmail(),
                account.getDob(),
                account.getGender(),
                account.getVisitCountry(),
                account.getCountry(),
                account.getRegion(),
                account.getCity(),
                account.getAddress(),
                account.getPhoneNumber(),
                account.getWorkPhone());
    }

    public void updateProfile(String yourName, String title, String email, String dob, String gender,
                              String visitingCountry, String country, String region, String city, String address, String phoneNumber,
                              String workPhone) {

        enterYourName(yourName);
        enterTitle(title);
        enterEmail(email);
        enterDOB(dob);
        selectGender(gender);
        selectVisitCountry(visitingCountry);
        selectCountry(country);
        selectRegion(region);
        selectCity(city);
        enterAddress(address);
        enterPhoneNumber(phoneNumber);
        enterWorkPhone(workPhone);
        save();
    }

    public void checkProfile(Account account) {
        checkProfile(
                account.getYourName(),
                account.getTitle(),
                account.getEmail(),
                account.getDob(),
                account.getGender(),
                account.getVisitCountry(),
                account.getCountry(),
                account.getRegion(),
                account.getCity(),
                account.getAddress(),
                account.getPhoneNumber(),
                account.getWorkPhone());
    }

    public void checkProfile(String yourName, String title, String email, String dob, String gender,
                             String visitingCountry, String country, String region, String city, String address, String phoneNumber,
                             String workPhone) {
        Assert.assertEquals(getYourName(), yourName);
        Assert.assertEquals(getTitle(), title);
        Assert.assertEquals(getEmail(), email);
        Assert.assertEquals(getDOB(), dob);
        Assert.assertEquals(getGender(), gender);
        Assert.assertEquals(getVisitCountry(), visitingCountry);
        Assert.assertEquals(getCountry(), country);
        Assert.assertEquals(getRegion(), region);
        Assert.assertEquals(getCity(), city);
        Assert.assertEquals(getAddress(), address);
        Assert.assertEquals(getPhoneNumber(), phoneNumber);
        Assert.assertEquals(getWorkPhone(), workPhone);

    }

    public void uploadAvatar(String filePath) {

        icUpload.waitElementToBeClickable();
        icUpload.click();
        icUpload.upload(FilePath.PROJECT + filePath);
//        icUploadTest.uploadFileBySendKey(FilePath.PROJECT + filePath);

        btnOKOnCropImgPop.waitElementToBeClickable();
        btnOKOnCropImgPop.click();

    }


    private void enterYourName(String text) {
        if(text != null){
            txtYourName.waitVisibilityOfElementLocated();
            txtYourName.clear();
            txtYourName.sendKeys(text);
        }

    }

    private String getYourName() {
        txtYourName.waitVisibilityOfElementLocated();
        return txtYourName.getValue();
    }


    private void enterTitle(String text) {
        if(text != null){
            txtTitle.waitVisibilityOfElementLocated();
            txtTitle.clear();
            txtTitle.sendKeys(text);
        }

    }

    public String getTitle() {
        txtTitle.waitVisibilityOfElementLocated();
        return txtTitle.getValue();
    }


    private void enterEmail(String text) {
        if(text != null){
            txtEmail.waitVisibilityOfElementLocated();
            txtEmail.clear();
            txtEmail.sendKeys(text);
        }

    }

    public String getEmail() {
        txtEmail.waitVisibilityOfElementLocated();
        return txtEmail.getValue();
    }

    private void enterDOB(String text) {
        if(text != null) {
            txtDOB.waitVisibilityOfElementLocated();
            txtDOB.clear();
            txtDOB.sendKeys(text);
        }

    }

    public String getDOB() {
        txtDOB.waitVisibilityOfElementLocated();
        return txtDOB.getValue();
    }

    private void enterAddress(String text) {
        if(text != null) {
            txtAddress.waitVisibilityOfElementLocated();
            txtAddress.clear();
            txtAddress.sendKeys(text);
        }

    }

    public String getAddress() {
        txtAddress.waitVisibilityOfElementLocated();
        return txtAddress.getValue();
    }


    private void enterPhoneNumber(String text) {
        if(text != null) {
            txtPhoneNumber.waitVisibilityOfElementLocated();
            txtPhoneNumber.clear();
            txtPhoneNumber.sendKeys(text);
        }

    }

    public String getPhoneNumber() {
        txtPhoneNumber.waitVisibilityOfElementLocated();
        return txtPhoneNumber.getValue();
    }

    private void enterWorkPhone(String text) {
        if(text != null) {
            txtWorkPhone.waitVisibilityOfElementLocated();
            txtWorkPhone.clear();
            txtWorkPhone.sendKeys(text);
        }

    }

    public String getWorkPhone() {
        txtWorkPhone.waitVisibilityOfElementLocated();
        return txtWorkPhone.getValue();
    }

    private void selectGender(String text) {
        cbGender.waitOptionsExisted();
        cbGender.selectText(text);
    }

    public String getGender() {
        cbGender.waitOptionsExisted();
        return cbGender.getText();
    }


    private void selectVisitCountry(String text) {
        if(text != null) {
            cbVisitCountry.waitOptionsExisted();
            cbVisitCountry.selectText(text);
        }

    }


    public String getVisitCountry() {
        cbVisitCountry.waitOptionsExisted();
        return cbVisitCountry.getText();
    }

    private void selectCountry(String text) {
        if(text != null) {
            cbCountry.waitOptionsExistedText(text);
            cbCountry.selectText(text);
        }

    }

    public String getCountry() {
        cbCountry.waitOptionsExisted();
        return cbCountry.getText();
    }


    private void selectCity(String text) {
        if(text != null) {
            cbCity.waitOptionsExistedText(text);
            cbCity.selectText(text);
        }

    }


    public String getCity() {
        cbCity.waitOptionsExisted();
        return cbCity.getText();
    }

    private void selectRegion(String text) {
        if(text != null) {
            cbRegion.waitOptionsExistedText(text);
            cbRegion.selectText(text);
        }

    }


    public String getRegion() {
        cbRegion.waitOptionsExisted();
        return cbRegion.getText();
    }


    private void save() {
        btnSave.waitElementToBeClickable();
        btnSave.click();
    }


}
