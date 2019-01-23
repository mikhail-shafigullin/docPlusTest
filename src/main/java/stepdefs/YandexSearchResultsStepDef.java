package stepdefs;

import cucumber.api.java.ru.Тогда;
import org.junit.Assert;
import pages.YandexSearchPage;

public class YandexSearchResultsStepDef {

    final YandexSearchPage yandexSearchPage = new YandexSearchPage();

    @Тогда("^открывается страница результатов поиска Яндекса$")
    public void isOpenedSearchResults(){
        Assert.assertTrue("Страница результатов поиска Яндекса не открылась", yandexSearchPage.isOpened());
    }

    @Тогда("^в результатах поиска есть ссылка на сайт \"(.*)\"$")
    public void checkURLFromSearchResult(String url){
        Assert.assertTrue("Ссылка (" + url + ") в результатах поиска не найдена." ,
                yandexSearchPage.isURLContainsInSearchResult(url));
    }

}
