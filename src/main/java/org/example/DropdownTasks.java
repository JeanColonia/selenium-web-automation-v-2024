package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DropdownTasks {

    public static void main(String[]args) throws InterruptedException {


        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();

        String country = "India";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement autocompleteInput = driver.findElement(By.id("autocomplete"));

        autocompleteInput.sendKeys(country.split("a")[0].trim());


        WebElement resultsContainer = driver.findElement(By.id("ui-id-1"));

        Thread.sleep(5000);
        /**
        wait.until(e ->
                resultsContainer.getAttribute("style").contains("display:block")
        );
**/
        List<WebElement> results = driver.findElements(By.cssSelector(".ui-menu-item div"));

        Actions actions = new Actions(driver);
        for (int i = 0; i <results.size() ; i++) {

            if(results.get(i).getText().contains(country)){
                actions.moveToElement(results.get(i)).build().perform();
            }

        }


        Thread.sleep(2500);
        driver.quit();


    }
}
