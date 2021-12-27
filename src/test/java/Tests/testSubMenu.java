package Tests;

import Base.Base;
import org.testng.annotations.Test;
import verification.Methods;
import verification.Verification;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


public class testSubMenu extends Base {

    Verification verification = new Verification();
    Methods function = new Methods();

    @Test
    public void testMenuIconPresent() {
        verification.verifyElementIsPresent(homePage.menuButton);
    }

    @Test
    public void testSubMenuHiding() {
        function.clickOnTheButton(homePage.menuButton);
        assertFalse(function.isElementPresent(homePage.hotLabel));
    }

    @Test
    public void testButtonIsSelected() {
        function.clickOnTheButton(homePage.hotLabel);
        assertTrue(function.elementIsSelected(homePage.hotButton));
    }

    @Test
    public void testIconMoreOptionsForHotLabel() {
        function.clickOnTheButton(homePage.hotLabel);
        function.clickOnTheButton(subMenuPage.iconMore);
        verification.verifyText("Top Posts", subMenuPage.topPosts);
        verification.verifyText("Most Recent", subMenuPage.mostRecent);
    }

}
