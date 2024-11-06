package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.time.Duration;
import java.util.function.Function;

public class FluentWaitConcept {

    public static void main(String[]args){
        String hiddenTextMessage = "Hello World!";
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                        .pollingEvery(Duration.ofSeconds(3))
                                .ignoring(NoSuchElementException.class);





        driver.get("https://the-internet.herokuapp.com/dynamic_loading");

        WebElement exampleBtn = driver.findElement(By.xpath("//a[@href='/dynamic_loading/1']"));

        exampleBtn.click();

        WebElement startBtn = driver.findElement(By.cssSelector("[id='start'] button"));

        startBtn.click();

        //[id='finish'] h4


        WebElement loader = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {

                WebElement hiddenText = driver.findElement(By.cssSelector("[id='finish'] h4"));

                if(hiddenText.isDisplayed()){
                    return hiddenText;
                }
                else{
                    return null;
                }
            }
        });





        Assert.assertEquals(driver.findElement(By.cssSelector("[id='finish'] h4")).getText(), hiddenTextMessage);

        driver.quit();
    }
}
