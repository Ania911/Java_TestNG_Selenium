package Tests;

import Base.Base;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pageObjects.SearchPage;
import utility.Methods;


import java.time.Duration;

import static utility.Verification.verifyElementIsPresent;

public class testSearch extends Base {

    @Override
    @AfterClass
    public void tearDown() {
        backToHomePage("https://9gag.com/");
        driver.quit();
    }

    @Test
    public void testSuggestedSearchResultIsPresent() {
        SearchPage search = new SearchPage(driver);
        Methods function = new Methods(driver);
        function.enterSearchText("Tesla");
        function.implicitlyWait(15);
        verifyElementIsPresent(search.suggestedSearchResultForTesla);
    }

    @Test
    public void testSearchBarIsPresent() {
        SearchPage search = new SearchPage(driver);
        Methods function = new Methods(driver);
        function.enterSearchTextAndClickEnter("Tesla");
        verifyElementIsPresent(search.searchBar);
    }

    @Test
    public void testSearchResultLink() {
        SearchPage search = new SearchPage(driver);
        Methods function = new Methods(driver);
        function.enterSearchTextAndClickEnter("Tesla");
        function.clickTheButton(search.teslaSearchResultLink);
        function.elementIsNotDisplayed(search.searchBar);
    }

    @Test
    public void testClearSearchInputField() {
        SearchPage search = new SearchPage(driver);
        Methods function = new Methods(driver);
        function.enterSearchTextAndClickEnter("Tesla");
        search.searchBar.clear();
        function.enterSearchTextAndClickEnter("Apple");
        verifyElementIsPresent(search.appleSearchResultLink);
    }

    @Test
    public void testSaveSearchAfterRefreshing() {
        SearchPage search = new SearchPage(driver);
        Methods function = new Methods(driver);
        function.enterSearchTextAndClickEnter("Tesla");
        function.refreshPage();
        verifyElementIsPresent(search.teslaSearchResultLink);
    }

}
