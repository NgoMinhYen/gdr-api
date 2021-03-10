package globedr.selenium.element.web.fileUpload;


import globedr.selenium.Assert;
import globedr.selenium.common.CLI;
import globedr.selenium.constants.FilePath;
import globedr.selenium.element.By;

import java.io.File;

class FileUploadOnWin extends FileUpload {


    public FileUploadOnWin(By by) {
        super(by);
    }

    public FileUploadOnWin(By by, By iframe) {
        super(by, iframe);
    }

    public FileUploadOnWin(org.openqa.selenium.WebElement webElement) {
        super(webElement);
    }

    public void runScriptUpload(String path) {
        File file = new File(path);

        if (file.exists()) {
            String uploadPopupTitle = "\"[REGEXPTITLE:.*(Upload$|Open|Open$|Tải lên).*]\"";
            String txtUpload = "Edit1";
            String btnOK = "Button1";

            String msg = String.format("upload file '%s'", file.getPath());

            String addImagePath = String.format(FilePath.MAIN_RESOURCES + "window_action.exe %s %s %s %s", "SetText",
                    uploadPopupTitle, txtUpload, file.getPath());
            String clickOK = String.format(FilePath.MAIN_RESOURCES + "window_action.exe %s %s %s", "Click", uploadPopupTitle,
                    btnOK);

            try {
                CLI CLI = new CLI();
                System.out.println(CLI.execute(addImagePath));
                System.out.println(CLI.execute(clickOK));
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            Assert.fail(String.format("File '%s' isn't existed.", file.getPath()));
        }
    }


}
