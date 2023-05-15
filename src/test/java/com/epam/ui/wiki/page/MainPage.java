package com.epam.ui.wiki.page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Data;

import static com.codeborne.selenide.Selenide.$x;

@Data
public class MainPage {
    private final SelenideElement wikiLogo = $x("//*[@class = 'mw-logo-container']");
    private final SelenideElement wikiMainMenuButton = $x("//div[contains (@id, 'main-menu-dropdown')]");
    private final SelenideElement wikiMenu = $x("//div[@class='vector-header-start']//div[contains (@class, 'content vector-dropdown-content')]");

    public void open() {
        Selenide.open(
                "https://en.wikipedia.org/wiki/Main_Page"
        );
    }
}
