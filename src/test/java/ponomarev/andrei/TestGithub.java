package ponomarev.andrei;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestGithub {

    @BeforeAll
    static void configure() {
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
    }

    @Test
    void SearchAndTest() {
        open("https://github.com/");
        $("[data-scoped-placeholder=Search]").setValue("selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $("#wiki-tab").click();
        $(".markdown-body").shouldHave(text("Soft assertions"));
        $$("div.markdown-body").first().$("ul").$("li").sibling(4).$("a").click();
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"));
    }
}
