package globedr.selenium.element.web.fileUpload;


import globedr.selenium.element.By;
import globedr.selenium.events.EventListener;
import globedr.selenium.element.web.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.util.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class FileUpload extends WebElement {


    public FileUpload(By by) {
        super(by);
    }

    public FileUpload(By by, By iframe) {
        super(by, iframe);
    }

    public FileUpload(org.openqa.selenium.WebElement webElement) {
        super(webElement);
    }


    public void upload(String path) {
        EventListener.getEvent().beforeUploadFile(this, path);
        runScriptUpload(path);
        EventListener.getEvent().afterUploadFile(this, path);
    }

    public void uploadFileByDragAndDrop(String filePath) {
        uploadFileByDragAndDrop(filePath, 0, 0);
    }

    public void uploadFileBySendKey(String filePath) {
        // make the input visible:
        executeScript("arguments[0].style = ''; arguments[0].style.display = 'block'; arguments[0].style.visibility = 'visible';", getWebElement());

        // send file:
        sendKeys(filePath);

    }


    /**
     * Function    :   dragAndDropFile
     * Description :   drop a file into position of element
     */
    public void uploadFileByDragAndDrop(String filePath, int offsetX, int offsetY) {

        String JS_DROP_FILE =
                "var target = arguments[0]," +
                        "    offsetX = arguments[1]," +
                        "    offsetY = arguments[2]," +
                        "    document = target.ownerDocument || document," +
                        "    window = document.defaultView || window;" +
                        "" +
                        "var input = document.createElement('INPUT');" +
                        "input.type = 'file';" +
                        "input.style.display = 'none';" +
                        "input.onchange = function () {" +
                        "  var rect = target.getBoundingClientRect()," +
                        "      x = rect.left + (offsetX || (rect.width >> 1))," +
                        "      y = rect.top + (offsetY || (rect.height >> 1))," +
                        "      dataTransfer = { files: this.files };" +
                        "" +
                        "  ['dragenter', 'dragover', 'drop'].forEach(function (name) {" +
                        "    var evt = document.createEvent('MouseEvent');" +
                        "    evt.initMouseEvent(name, !0, !0, window, 0, 0, 0, x, y, !1, !1, !1, !1, 0, null);" +
                        "    evt.dataTransfer = dataTransfer;" +
                        "    target.dispatchEvent(evt);" +
                        "  });" +
                        "" +
                        "  setTimeout(function () { document.body.removeChild(input); }, 25);" +
                        "};" +
                        "document.body.appendChild(input);" +
                        "return input;";

        org.openqa.selenium.WebElement input = (org.openqa.selenium.WebElement) executeScript(JS_DROP_FILE, this.getWebElement(), offsetX, offsetY);
        input.sendKeys(filePath);
        fluentWait().until(ExpectedConditions.stalenessOf(input));
    }

    protected abstract void runScriptUpload(String path);




}
