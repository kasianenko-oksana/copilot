package com.epam.ui.wiki.test;

import com.epam.ui.wiki.page.MainPage;
import com.epam.ui.wiki.steps.MainSteps;
import org.testng.annotations.Test;

public class MainTest {

    private final MainSteps mainSteps = new MainSteps(new MainPage());

    /**
     * Test wiki menu
     */
    @Test
    public void testWikiMenu() {
        mainSteps.openMainPage();
        mainSteps.verifyWikiMenuIsNotVisible();
        mainSteps.openWikiMenu();
        mainSteps.verifyWikiMenuIsVisible();
        mainSteps.clickOnWikiLogo();
        mainSteps.verifyWikiMenuIsNotVisible();
    }
}
