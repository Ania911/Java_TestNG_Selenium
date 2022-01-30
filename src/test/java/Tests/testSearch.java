package Tests;

import Base.Base;
import org.testng.annotations.Test;
import pageObjects.SearchPage;
import utility.Methods;

import static utility.Verification.verifyElementIsPresent;

public class testSearch extends Base {

    @Test
    public void testSuggestedSearchResultIsPresent() {
        SearchPage search = new SearchPage(driver);
        Methods function = new Methods(driver);
        function.enterSearchText("Tesla");
        verifyElementIsPresent(search.suggestedSearchResultForTesla);
    }


}
