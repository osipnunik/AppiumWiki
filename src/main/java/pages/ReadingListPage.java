package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ReadingListPage extends BasePage{

    public ReadingListPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='org.wikipedia:id/page_list_item_title']")
    MobileElement articleTitle;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='org.wikipedia:id/page_list_item_action_primary']")
    MobileElement listItemAction;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='org.wikipedia:id/reading_list_item_remove_text']")
    MobileElement removeFromMyReadingList;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='org.wikipedia:id/reading_list_empty_text']")
    MobileElement readingListEmpty;

    public void seeListActions(){
        listItemAction.click();
    }

    public void clickRemoveFromMyReadingList(){
        removeFromMyReadingList.click();
    }

    public boolean isReadingListEmpty(){
        return readingListEmpty.isDisplayed();
    }
}
