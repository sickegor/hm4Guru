package hm4.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;


public class SimpleTests {
    String table = "\".table-responsive\"";

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
        //    WebDriverRunner.closeWindow();
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
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(table).shouldHave(text("Egor Egor2"));
        $(table).shouldHave(text("Egor@Egor.Egor"));
        $(table).shouldHave(text("Male"));
        $(table).shouldHave(text("1234567890"));
        $(table).shouldHave(text("pngegg.png"));
    }
}
