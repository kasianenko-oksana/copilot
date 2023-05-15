package com.epam.ui.wiki.steps;

import com.epam.ui.wiki.page.MainPage;
import lombok.extern.slf4j.Slf4j;

import static com.codeborne.selenide.Condition.visible;

@Slf4j
public class MainSteps {
    /**
     * Main steps
     */

    private final MainPage mainPage;

    /**
     * Constructor
     *
     * @param mainPage main page
     */
    public MainSteps(MainPage mainPage) {
        this.mainPage = mainPage;
    }

    public void openMainPage() {
        log.info("Open main page");
        mainPage.open();
    }

    public void clickOnWikiLogo() {
        log.info("Click on wiki logo");
        mainPage.getWikiLogo().click();
    }

    public void verifyWikiMenuIsVisible() {
        log.info("Verify wiki menu is visible");
        mainPage.getWikiMenu().shouldBe(visible);
    }


    public void verifyWikiMenuIsNotVisible() {
        log.info("Verify wiki menu is not visible");
        mainPage.getWikiMenu().shouldNotBe(visible);
    }

    public void openWikiMenu() {
        log.info("Open wiki menu");
        mainPage.getWikiMainMenuButton().click();
    }
}
