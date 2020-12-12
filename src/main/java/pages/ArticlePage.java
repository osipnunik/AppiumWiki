package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ArticlePage extends BasePage {

    public ArticlePage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='org.wikipedia:id/view_page_title_text']")
    MobileElement pageTitle;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='More options']")
    MobileElement moreOptionsButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Add to reading list']")
    MobileElement addToReadingList;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Create new']")
    MobileElement createNewReadingList;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
    MobileElement nameOfListOk;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Add this article to a reading list']")
    MobileElement addToReadingListThisArticle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='GOT IT' and @resource-id='org.wikipedia:id/onboarding_button']")
    MobileElement gotItButton;

    public String getTitleOfPage(){
        return pageTitle.getAttribute("text");
    }

    public void clickMoreOptions(){
        moreOptionsButton.click();
    }

    public void clickAddToReadingList(){
        addToReadingList.click();
    }

    public void clickCreateNewReadingList(){
        createNewReadingList.click();
    }

    public void clickOKNameOfThisList(){
        nameOfListOk.click();
    }

    public void clickGotItBtn(){
        gotItButton.click();
    }

}
