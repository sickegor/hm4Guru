package hm4;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;

public class SimpleTest {

    @BeforeAll
    static void initDB() {
        System.out.println("### @BeforeAll");
    }

    @BeforeEach
    void openPage() {
        System.out.println("### @BeforeEach open");
      //  Selenide.open("https://demoqa.com/automation-practice-form")
    }

    @AfterEach
    void close() {
        System.out.println("### @BeforeEach close");
    //    WebDriverRunner.closeWindow();
    }

    @Test
    void asserTest() {
        System.out.println("### Test1");
        Assertions.assertTrue(3 > 2);
    }

    @Test
    void asserTest2() {
        System.out.println("### Test2");
        Assertions.assertTrue(2 <= 2);
    }
}
