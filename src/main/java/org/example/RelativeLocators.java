package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocators {


    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/angularpractice/");

        WebElement nameInput = driver.findElement(By.name("name"));

        WebElement nameLabel = driver.findElement(RelativeLocator.with(By.tagName("label")).above(nameInput));


        System.out.println(nameLabel.getText());


        WebElement dateLabel = driver.findElement(By.cssSelector("[for='dateofBirth']"));

        WebElement calendar = driver.findElement(RelativeLocator.with(By.tagName("input")).below(dateLabel));

        calendar.click();




        WebElement checkLabel = driver.findElement(By.cssSelector("[for='exampleCheck1']"));

        WebElement checkBoxOption = driver.findElement(RelativeLocator.with(By.tagName("input")).toLeftOf(checkLabel));

        checkBoxOption.click();

        WebElement employeeStatusLabel = driver.findElement(By.cssSelector("[for='exampleFormControlRadio1']"));

        WebElement employeeStatusOption = driver.findElement(RelativeLocator.with(By.tagName("input")).toRightOf(employeeStatusLabel));

        employeeStatusOption.click();


        Thread.sleep(2000);
        driver.quit();
    }
}
