import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WikiTests {
    private AppiumDriver<MobileElement> driver;

    @Before
    public void init() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();//DesiredCapabilities.android();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        caps.setCapability("automationName", "UIAutomator2");

        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.wikipedia");//"epam.com.giftapp");
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "org.wikipedia.main.MainActivity");//"pam.com.giftapp.ui.activity.SplashScreenActivity");

        URL url = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(url, caps);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @Test
    public void test1() {
        MainPage main = new MainPage(driver);
        main.inputArticleInField("Selenium");
        ArticlePage article = new ArticlePage(driver);
        String actualTitle = article.getTitleOfPage();
        Assert.assertEquals("Selenium", actualTitle);
    }

    @Test
    public void test2() {
        MainPage main = new MainPage(driver);
        main.clickOnFirstArticle();
        ArticlePage article = new ArticlePage(driver);
        article.clickMoreOptions();
        article.clickAddToReadingList();
        article.clickGotItBtn();
        article.clickOKNameOfThisList();
        article.closeXPage();
        main.goToReadingList();
        MyReadingListsPage listspage = new MyReadingListsPage(driver);
        listspage.goToMyReadingList();
        ReadingListPage listPage = new ReadingListPage(driver);
        listPage.seeListActions();
        listPage.clickRemoveFromMyReadingList();
        Assert.assertTrue(listPage.isReadingListEmpty());
    }


}
