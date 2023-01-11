package day3;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Multithreading {
    @Test
    public void launch() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext browse1 = browser.newContext();
        Page browser1 = browse1.newPage();
        browser1.navigate("https://www.saucedemo.com/");
        browser1.fill("#user-name", "standard_user");
        browser1.fill("#password", "secret_sauce");
        assertThat(browser1.locator("#login-button")).isEnabled();
        browser1.click("#login-button");
        System.out.println("the Login Button is Enabled ");

        BrowserContext browse2 = browser.newContext();
        Page browser2 = browse2.newPage();
        browser2.navigate("https://www.meesho.com/");
        browser2.fill("//*[@id=\"__next\"]/div[2]/div[1]/div/div[2]/div/input", "Shoes");
        System.out.println(browser2.title());

        BrowserContext browse3 = browser.newContext();
        Page browser3 = browse3.newPage();
        browser3.navigate("https://automatenow.io/sandbox-automation-testing-practice-website/");
        Locator modules=browser3.locator("//a[@class='wp-block-button__link wp-element-button']");
        System.out.println("sand bpx link Modules Count: "+modules.count());

        browse1.close();
        browser1.close();

        browse2.close();
        browser2.close();

        browse3.close();
        browser3.close();
        playwright.close();
    }
}
