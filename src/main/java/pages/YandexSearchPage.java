package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class YandexSearchPage extends AbstractPage {

    @FindBy(xpath = "//div[contains(@class, \"navigation__item_state_selected\")]//a")
    private WebElement selectedTab;

    @FindAll(@FindBy(xpath = "//div[contains(@class, \"typo_type_greenurl\")]//a/b"))
    private List<WebElement> searchReultsUrls;

    public YandexSearchPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public boolean isOpened() {
        return selectedTab.isEnabled();
    }

    public boolean isURLContainsInSearchResult(String url) {
        for (WebElement elem : searchReultsUrls) {
            if(url.equalsIgnoreCase(elem.getText()))
                return true;
        }
        return false;
    }
}
