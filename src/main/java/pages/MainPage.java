package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MainPage extends BasePage{

    public MainPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Search Wikipedia']")
    MobileElement searchFieldForClicking;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='org.wikipedia:id/search_src_text']")
    MobileElement searchField;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='org.wikipedia:id/view_featured_article_card_article_title']")
    MobileElement articleTitle;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='My lists']")
    MobileElement goToReadingList;

    public void inputArticleInField(String input){
        searchFieldForClicking.click();
        searchField.setValue(input);
        ((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void clickOnFirstArticle(){
         ((AndroidDriver)driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+"Complete blood count"+"\").instance(0))").click();
    }

    public void goToReadingList(){
        goToReadingList.click();
    }
}
