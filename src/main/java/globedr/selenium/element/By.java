package globedr.selenium.element;


import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.List;

public class By extends org.openqa.selenium.By {

    private org.openqa.selenium.By bySelector;

    public static void getCallerPage() {
        StackTraceElement[] stElements = Thread.currentThread().getStackTrace();
        for (int i=1; i<stElements.length; i++) {
            StackTraceElement ste = stElements[i];
            if(ste.getClassName().contains("pages")){
                System.out.println(ste.getFileName().replaceAll("\\.java", ""));
            }
        }
    }

    public static By keyInFile(String id) {
        getCallerPage();
        return null;
    }

    public static By id(String id) {
        By by = new By();
        by.setBySelector(org.openqa.selenium.By.id(id));
        return by;
    }

    public static By xpath(String id) {
        By by = new By();
        by.setBySelector(org.openqa.selenium.By.xpath(id));
        return by;
    }

    public org.openqa.selenium.By getBySelector() {
        return bySelector;
    }

    public void setBySelector(org.openqa.selenium.By by) {
        this.bySelector = by;
    }


    @Override
    public List<WebElement> findElements(SearchContext context) {
        return null;
    }


}
