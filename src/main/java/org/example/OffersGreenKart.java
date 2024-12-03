package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class OffersGreenKart {

    public static void main(String[]args) throws InterruptedException {


        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");


        String dayValue = "12";
        String monthValue = "4";
        String yearValue = "2025";
        String [] expectedList = {monthValue, dayValue, yearValue};

     WebElement calendar = driver.findElement(By.className("react-date-picker__inputGroup"));
     calendar.click();

     WebElement changeDate = driver.findElement(By.className("react-calendar__navigation__label"));
     changeDate.click();

     changeDate.click();

    WebElement year = driver.findElement(By.xpath("//button[text()='"+yearValue+"']"));
    year.click();

        WebElement month = driver.findElements(By.className("react-calendar__year-view__months__month")).get(Integer.parseInt(monthValue) - 1);
        month.click();


    WebElement day = driver.findElement(By.xpath("//abbr[text()='"+dayValue+"']"));
    day.click();

    List<WebElement> dateValues = driver.findElements(By.className("react-date-picker__inputGroup__input"));

    for (int i=0; i<dateValues.size(); i++ ){
        System.out.println(dateValues.get(i).getAttribute("value"));
        Assert.assertEquals(dateValues.get(i).getAttribute("value"), expectedList[i]);
    }

        Thread.sleep(2500);
        driver.quit();
    }
}
