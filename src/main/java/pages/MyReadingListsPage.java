package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MyReadingListsPage extends BasePage{

    public MyReadingListsPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='My reading list']")
    MobileElement myReadingList;

    public void goToMyReadingList(){
        myReadingList.click();
    }
}
