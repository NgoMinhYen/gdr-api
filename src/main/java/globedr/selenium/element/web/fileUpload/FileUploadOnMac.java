package globedr.selenium.element.web.fileUpload;


import globedr.selenium.common.CLI;
import globedr.selenium.constants.FilePath;
import globedr.selenium.element.By;

class FileUploadOnMac extends FileUpload {



    public FileUploadOnMac(By by) {
        super(by);
    }

    public FileUploadOnMac(By by, By iframe) {
        super(by, iframe);
    }

    public FileUploadOnMac(org.openqa.selenium.WebElement webElement) {
        super(webElement);
    }

    public void runScriptUpload(String path) {
        CLI cli = new CLI();
        cli.execute("osascript " + FilePath.MAIN_RESOURCES + "upload.scpt " + path);
    }


}
