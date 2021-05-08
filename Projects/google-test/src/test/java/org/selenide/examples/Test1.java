package org.selenide.examples;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.junit.ScreenShooter;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;

public class Test1 {

    @Test
    public void userSearch() {
        //open url
        open("https://www.google.com/");

        //search for keyword - testing
        $(By.name("q")).setValue("testing").pressEnter();
        $(".loading_progress").should(Condition.disappear);

        //result collection should have req text - Asserting
        //for successful run - PASS
        //$("#rso div.g").shouldHave(Condition.text("Software testing - Wikipedia"));

        //iterate over results, search for string and print first 5 results
        boolean bflag = false;
        for(int i=0; i<=5; i++) {
            //reading the results collection using index
            String result = $$("#rso div.g").get(i).toString();
            if(result.equalsIgnoreCase("President Donald Trump says he has tested positive for coronavirus")) {
                System.out.println("PASS..President Donald Trump says he has tested positive for coronavirus is present.");
                bflag = true;
            } else {
                bflag = false;
            }
            System.out.println(result);
        }
        if(bflag = false) {
            System.out.println("FAIL..President Donald Trump says he has tested positive for coronavirus is NOT present.");
        }
    }

    @Rule // automatically takes screenshot of every failed test - junit framework
    public ScreenShooter makeScreenshotOnFailure = ScreenShooter.failedTests();
}
