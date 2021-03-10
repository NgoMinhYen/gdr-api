package globedr.selenium.element.web.fileUpload;


import globedr.selenium.element.By;

class FileUploadOnLinux extends FileUpload {



    public FileUploadOnLinux(By by) {
        super(by);
    }

    public FileUploadOnLinux(By by, By iframe) {
        super(by, iframe);
    }

    public FileUploadOnLinux(org.openqa.selenium.WebElement webElement) {
        super(webElement);
    }

    public void runScriptUpload(String path) {

    }



}
