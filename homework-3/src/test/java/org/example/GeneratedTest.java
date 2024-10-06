package org.example;

import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.*;

import org.junit.jupiter.api.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@UsePlaywright
public class GeneratedTest {
    @Test
    void test(Page page) {
        page.navigate("https://demo.playwright.dev/todomvc/#/");
        page.getByPlaceholder("What needs to be done?").click();
        page.getByPlaceholder("What needs to be done?").fill("Complete homework 3");
        page.getByPlaceholder("What needs to be done?").press("Enter");
        page.getByLabel("Toggle Todo").check();
        assertThat(page.locator("body")).containsText("0 items left");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Clear completed")).click();
    }
}

//mvn compile exec:java -D exec.mainClass="org.example.GeneratedTest"