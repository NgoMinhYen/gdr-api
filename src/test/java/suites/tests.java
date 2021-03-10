package suites;

import globedr.selenium.driver.DriverUtils;
import globedr.selenium.enums.DriverType;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;

@Listeners(listeners.ListenerTest.class)
public class tests {
    LoginPage loginPage = new LoginPage();

    @Test
    public void TC01_login(){
        DriverUtils.init(DriverType.CHROME);
        DriverUtils.openUrl("https://demoqa.com/radio-button");
        DriverUtils.maximum();
        loginPage.likeSite("yesRadio");
        DriverUtils.sleep(5);
        DriverUtils.quit();
    }


    @Test
    public void TC02_login(){


        DriverUtils.init(DriverType.CHROME);
        DriverUtils.openUrl("https://web1.globedr.com/signin");
        DriverUtils.maximum();
        loginPage.login("0767892632", "123456", "Việt Nam");
        DriverUtils.quit();
    }

    @Test
    public void TC03_login(){


        DriverUtils.init(DriverType.CHROME);
        DriverUtils.openUrl("https://nunzioweb.com/");
        DriverUtils.maximum();
        DriverUtils.quit();

    }


    static int i = 0;
    @Test(successPercentage=50, invocationCount=10)
    public void TC04_login(){

        i++;
        System.out.println(i);
        Assert.assertEquals(i%2, 1); //success if "i" is an odd number


    }

}
