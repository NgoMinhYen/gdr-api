package globedr.selenium.element.web.fileUpload;


import globedr.selenium.common.OS;
import globedr.selenium.element.By;


public class FileUploadFactory {

    public static FileUpload getElement(By by) {
        return getFileUpload(by, null);
    }

    public static FileUpload getElement(By by, By iframe) {
        return getFileUpload(by, iframe);
    }

    public static FileUpload getElement(org.openqa.selenium.WebElement webElement) {
        return getFileUpload(webElement);
    }


    private static FileUpload getFileUpload(By by, By iframe) {

        switch (OS.getCurrent()) {
            case MAC:
                return new FileUploadOnMac(by, iframe);
            case UNIX:
                return new FileUploadOnLinux(by, iframe);
            case SOLARIS:
                return null;
            case WINDOWS:
                return new FileUploadOnWin(by, iframe);
            default:
                try {
                    throw new Exception("Your OS is not support!!");
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
        }
        return null;
    }

    private static FileUpload getFileUpload(org.openqa.selenium.WebElement webElement) {

        switch (OS.getCurrent()) {
            case MAC:
                return new FileUploadOnMac(webElement);
            case UNIX:
                return new FileUploadOnLinux(webElement);
            case SOLARIS:
                return null;
            case WINDOWS:
                return new FileUploadOnWin(webElement);
            default:
                try {
                    throw new Exception("Your OS is not support!!");
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
        }
        return null;
    }


}
