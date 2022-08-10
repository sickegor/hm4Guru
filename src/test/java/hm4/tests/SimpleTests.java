package hm4.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class SimpleTests {

    @BeforeAll
    static public void config() {
        Configuration.baseUrl = "https://github.com/";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void wikiTest() {
        open("selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-body").find(byText("Soft assertions")).click();
        $("#wiki-body").shouldHave(Condition.text("Using JUnit5 extend test class:"));
    }
}