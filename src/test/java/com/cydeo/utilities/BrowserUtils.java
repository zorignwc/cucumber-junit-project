package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;


public class BrowserUtils {

    public static void SwitchWindowAndVerify(String expectedInURL, String expectedTitle){

        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();

        for(String eachWindow : allWindowHandles) {
            //driver.switchTo().window(eachWindow); Syntax will switch window and driver will be able
            Driver.getDriver().switchTo().window(eachWindow);
            //System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl())
            if(Driver.getDriver().getCurrentUrl().contains(expectedInURL)){
                break;

            }

        }

        // 5. Assert: title contains ""Etsy
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue("Title verification failed!" , actualTitle.contains(expectedTitle));


    }

    public static void verifyTitle(String expectedTitle){
        Assert.assertEquals(expectedTitle, Driver.getDriver().getTitle());
    }

    public static void waitForInvisibilityOf(WebElement element){

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(element));



    }







    public static void sleep(int seconds) {
//1 second = 1000 millis;
//millis = second * 1000;

        try {

            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e){

            e.printStackTrace();
            System.out.println("Exception happened in sleep method!!!");

    }



    }


//4. When method is called, it should simply verify expected title with actual title:

//Method info:
//4.1 Name: verifyTitle()
//4.2 Return type: void
//4.3 Arg1: WebDriver
//4.4 Arg2: String expectedTitle
    //BrowserUtils.verifyTitle(driver



    public static void verifyTitle(WebDriver driver, String expectedTitle){

        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);


}

}
