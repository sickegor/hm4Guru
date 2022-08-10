package hm4.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class SimpleTests {

    @BeforeAll
    static public void config() {
        Configuration.baseUrl = "https://github.com/";
        Configuration.browserSize = "1920x1080";
        Configuration.browserPosition = "0x0";
    }

    /**
     * Проверка наличия примера для JUnit5 в Selenide Wiki page
     */
    @Test
    void wikiJUnit5Test() {
        //Открываем страницу Selenide
        open("selenide/selenide");
        //Открываем Wiki Page
        $("#wiki-tab").click();
        //Находим поле "Soft assertions" и проходим по ссылке
        $("#wiki-body").find(byText("Soft assertions")).click();
        //Убеждаемся что на странице есть пример для JUnit5
        $("#wiki-body").shouldHave(Condition.text("Using JUnit5 extend test class:"));
    }

}