package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YandexMainPage extends AbstractPage {

    private final static String PAGEURL = "https://yandex.ru/";

    @FindBy(xpath = "//input[@class=\"input__control input__input\"]")
    private WebElement searchInput;

    @FindBy(xpath = "//button[contains(@class, \"button_theme_websearch\")]")
    private WebElement searchButton;

    public YandexMainPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void navigateToPage() {
        getDriver().navigate().to(PAGEURL);
    }

    public boolean isOpened() {
        return "Яндекс".equals(getPageTitle());
    }

    public void enterInSearchInput(String line) {
        searchInput.click();
        searchInput.sendKeys(line);
    }

    public void clickOnSearchButton() {
        searchButton.click();
    }
}
