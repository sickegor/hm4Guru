package hm4.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;


public class SimpleTests {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
    }

    @BeforeEach
    void openPage() {
        System.out.println("### @BeforeEach open");
        Selenide.open("/automation-practice-form");
    }

    @AfterEach
    void close() {
        System.out.println("### @BeforeEach close");
            Selenide.closeWebDriver();
    }

    @Test
    void asserTest() {
        System.out.println("### Test1");
        $("#firstName").setValue("Egor");
        $("#lastName").setValue("Egor2");
        $("#userEmail").setValue("Egor@Egor.Egor");
        $("[for=gender-radio-1]").click();
        $("#userNumber").setValue("1234567890");
        $("#uploadPicture").uploadFile(new File("src/test/resources/pngegg.png"));

        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Egor Egor2"),
                text("Egor@Egor.Egor"),
                text("Egor@Egor.Egor"),
                text("1234567890"),
                text("pngegg.png")
                );

    }
}
