package stepdefs;

import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.И;
import org.junit.Assert;
import pages.YandexMainPage;

public class YandexMainPageStepDef {

    final YandexMainPage yandexPage = new YandexMainPage();

    @Дано("^пользователь заходит на страницу Яндекса$")
    public void enterYandexPage(){
        yandexPage.navigateToPage();
        Assert.assertTrue("Страница не открылась", yandexPage.isOpened());
    }

    @И("^пользователь вводит в строку поиска \"(.*)\"")
    public void enterStringToSearchInput(String line){
        yandexPage.enterInSearchInput(line);
        yandexPage.clickOnSearchButton();
    }

    @И("^пользователь нажимает кнопку \"Найти\"")
    public void enterStringToSearchInput(){
        yandexPage.clickOnSearchButton();
    }

}
