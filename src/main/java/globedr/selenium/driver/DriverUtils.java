package globedr.selenium.driver;

import globedr.selenium.constants.FilePath;
import globedr.selenium.enums.DriverType;
import globedr.selenium.events.EventListener;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.service.DriverService;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Remote;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class DriverUtils {
    private static WebDriver driver;
    private static DriverService service;

    public static void init(DriverType driverType) {

        try {
            switch (driverType) {

                case REMOTE:
                    DesiredCapabilities capability = new DesiredCapabilities();

                    capability.setBrowserName(BrowserType.CHROME);
                    capability.setPlatform(Platform.ANY);
                    driver = new RemoteWebDriver(new URL("http://172.177.0.5:4444/wd/hub"), capability);
                    System.out.println("!!!driver "+ driver);

                    break;


                case EDGE:
                    System.setProperty("webdriver.edge.driver", FilePath.MAIN_RESOURCES + "drivers/win/msedgedriver.exe");
                    driver = new EdgeDriver();
                    break;

                case IE:

                    System.setProperty("webdriver.ie.driver", FilePath.MAIN_RESOURCES + "drivers/win/IEDriverServer.exe");
                    InternetExplorerOptions optionIE = new InternetExplorerOptions();
                    optionIE.requireWindowFocus();
                    optionIE.introduceFlakinessByIgnoringSecurityDomains();

                    driver = new InternetExplorerDriver(optionIE);
                    break;

                case CHROME:
                    service = new ChromeDriverService.Builder()
                            .usingAnyFreePort()
                            .usingDriverExecutable(new File(FilePath.MAIN_RESOURCES + "drivers/win/chromedriver.exe"))
                            .withTimeout(Duration.ofMillis(60000))
                            //.withVerbose(true)
                            .build();

                    try {
                        service.start();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //System.setProperty("webdriver.chrome.driver", FilePath.MAIN_RESOURCES + "drivers/chromedriver.exe");
                    ChromeOptions options = new ChromeOptions();

                    options.addArguments("enable-automation"); // https://stackoverflow.com/a/43840128/1689770
                    options.addArguments("--no-sandbox"); //https://stackoverflow.com/a/50725918/1689770
                    options.addArguments("--disable-infobars"); //https://stackoverflow.com/a/43840128/1689770
                    options.addArguments("--disable-dev-shm-usage"); //https://stackoverflow.com/a/50725918/1689770
                    options.addArguments("--disable-browser-side-navigation"); //https://stackoverflow.com/a/49123152/1689770
                    options.addArguments("--disable-gpu"); //https://stackoverflow.com/questions/51959986/how-to-solve-selenium-chromedriver-timed-out-receiving-message-from-renderer-exc
                    options.addArguments("ignore-certificate-errors");


                    options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                    // Headless
//                    options.addArguments("--window-size=1920,1080");
//                    options.setHeadless(true);

                    driver = new ChromeDriver((ChromeDriverService) service, options);
                    break;

                case CHROME_UBUNTU:
                    service = new ChromeDriverService.Builder()
                            .usingAnyFreePort()
                            .usingDriverExecutable(new File(FilePath.MAIN_RESOURCES + "drivers/linux/ubuntu/chromedriver"))
                            .withTimeout(Duration.ofMillis(60000))
                            //.withVerbose(true)
                            .build();

                    try {
                        service.start();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //System.setProperty("webdriver.chrome.driver", FilePath.MAIN_RESOURCES + "drivers/chromedriver.exe");
                    ChromeOptions ops = new ChromeOptions();
                    ops.addArguments("start-maximized"); // https://stackoverflow.com/a/26283818/1689770
                    ops.addArguments("enable-automation"); // https://stackoverflow.com/a/43840128/1689770
                    ops.addArguments("--no-sandbox"); //https://stackoverflow.com/a/50725918/1689770
                    ops.addArguments("--disable-infobars"); //https://stackoverflow.com/a/43840128/1689770
                    ops.addArguments("--disable-dev-shm-usage"); //https://stackoverflow.com/a/50725918/1689770
                    ops.addArguments("--disable-browser-side-navigation"); //https://stackoverflow.com/a/49123152/1689770
                    ops.addArguments("--disable-gpu"); //https://stackoverflow.com/questions/51959986/how-to-solve-selenium-chromedriver-timed-out-receiving-message-from-renderer-exc
                    ops.addArguments("ignore-certificate-errors");
                    ops.addArguments("--window-size=1920,1080");
                    ops.setHeadless(true);
                    ops.setPageLoadStrategy(PageLoadStrategy.NORMAL);

                    driver = new ChromeDriver((ChromeDriverService) service, ops);
                    break;

                case FIREFOX:
                    System.setProperty("webdriver.gecko.driver", FilePath.MAIN_RESOURCES + "drivers/win/geckoDriver.exe");
                    driver = new FirefoxDriver();
                    break;

                default:
                    new Throwable(String.format("not support this driver type : %s", driverType));
            }
        } catch (Exception e) {
            System.out.println(String.format("Error occur while init driver %s, Exception : %s", driverType, e));
        }


    }


    public static void openUrl(String url) {
        EventListener.getEvent().beforeOpenUrl(url);
        getDriver().get(url);
        EventListener.getEvent().afterOpenUrl(url);
    }

    public static void loginOnBasicAuthPopUp(String url, String user, String pass) {
        loginOnBasicAuthPopUp(url, user, pass, -1);
    }

    public static void loginOnBasicAuthPopUp(String url, String user, String pass, int port) {
        //driver.get("http://UserName:Password@Example.com");

        URL domain = null;
        String auth = String.format("%s:%s@", user, pass);
        String protocol = null;
        String hostname = null;
        String portDomain = (port > 0) ? ":" + port : "";

        try {
            domain = new URL(url);
            protocol = domain.getProtocol() + "://";
            hostname = domain.getHost();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        openUrl(protocol + auth + hostname + portDomain);
    }


    public static void maximum() {
        getDriver().manage().window().maximize();
    }

    public static String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }

    public static String getTitle() {
        return getDriver().getTitle();
    }

    public static List<WebElement> findElements(By by) {
        return getDriver().findElements(by);
    }

    public static org.openqa.selenium.WebElement findElement(org.openqa.selenium.By by) {
        return getDriver().findElement(by);
    }

    public static String getPageSource() {
        return getDriver().getPageSource();
    }

    public static void close() {
        getDriver().close();
    }

    public static void quit() {
        if (getDriver() != null) getDriver().quit();
        if (service != null) service.stop();

    }

    public static Set<String> getWindowHandles() {
        return getDriver().getWindowHandles();
    }

    public static String getWindowHandle() {
        return getDriver().getWindowHandle();
    }


    public static WebDriver getDriver() {
        return driver;
    }

    private static void setDriver(WebDriver driver) {
        DriverUtils.driver = driver;
    }

    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sleepInMiliseconds(int miliSeconds) {
        try {
            Thread.sleep(miliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void switchToIframe(By iframe) {
        switchTo().frame(DriverUtils.findElement(iframe));
    }

    public static void switchToIframe(WebElement element) {
        switchTo().frame(element);
    }

    public static void switchToDefault() {
        switchTo().defaultContent();
    }

    public static WebDriver.TargetLocator switchTo() {
        return DriverUtils.getDriver().switchTo();
    }

    public static String takeScreenShot() {

        String output = FilePath.TARGET + "temp.png";
        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot = ((TakesScreenshot) getDriver());

        //Call getScreenshotAs method to create image file
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
        File DestFile = new File(output);

        //Copy file at destination

        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;

    }


}
