package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import static config.Credentials.*;
import static java.lang.String.format;


public class BaseTest {

    @BeforeAll
    static void setup(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        String login = credentials.login();
        String password = credentials.password();
        String url = System.getProperty("url", "selenoid.autotests.cloud/wd/hub/");

        Configuration.browserCapabilities = capabilities;
        Configuration.startMaximized = true;
        Configuration.remote = format("https://%s:%s@%s", login, password, url);
    }

    @AfterEach
    public void tearDown(){
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

}
