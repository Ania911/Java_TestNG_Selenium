package Tests;

import Base.Base;
import org.testng.annotations.*;
import pageObjects.SearchPage;
import utility.Methods;


public class testSearch extends Base {

    private SearchPage search;
    private Methods function;

    @BeforeMethod
    public void setUp() {
        search = new SearchPage(driver);
        function = new Methods(driver);
    }

    @AfterMethod
    public void tearDownAfter() {
        search = null;
        function = null;
        backToHomePage("https://9gag.com/");
    }

    @Test
    public void testSearchResultHint() {
        function.enterSearchText("Tesla");
        function.elementIsDisplayed(search.suggestedSearchResultForTesla);
    }

    @Test
    public void testSearchBarIsPresent() {
        function.enterSearchTextAndClickEnter("Tesla");
        function.elementIsDisplayed(search.searchBar);
    }

    @Test
    public void testSearchResultLink() {
        function.enterSearchTextAndClickEnter("Tesla");
        function.clickTheButton(search.teslaSearchResultLink);
        function.elementIsNotDisplayed(search.searchBar);
    }

    @Test
    public void testClearSearchInputField() {
        function.enterSearchTextAndClickEnter("Tesla");
        search.searchBar.clear();
        function.enterSearchTextAndClickEnter("Apple");
        function.elementIsDisplayed(search.appleSearchResultLink);
    }

    @Test
    public void testSaveSearchAfterRefreshing() {
        function.enterSearchTextAndClickEnter("Tesla");
        function.elementIsDisplayed(search.teslaSearchResultLink);
        function.refreshPage();
        function.elementIsDisplayed(search.teslaSearchResultLink);
    }

}

