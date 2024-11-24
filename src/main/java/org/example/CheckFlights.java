package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class CheckFlights {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1500));

        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");


        WebElement departureCityInput = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));

        departureCityInput.click();

        WebElement departureCity = driver.findElement(By.xpath("//a[@value='DEL']"));

        departureCity.click();

        Thread.sleep(2000);

        WebElement arrivalCity = driver.findElement(By.xpath("(//a[@value='MAA'])[2]"));

        arrivalCity.click();


        WebElement datepickerCurrentDay = driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight"));

        datepickerCurrentDay.click();


        WebElement passengersContainer = driver.findElement(By.id("divpaxinfo"));

        passengersContainer.click();

        WebElement addPassenger = driver.findElement(By.id("hrefIncAdt"));
        WebElement donePassengersQuantity = driver.findElement(By.id("btnclosepaxoption"));

        int totalPassengers = 5;
        int i=1;

        while(i<5){
            addPassenger.click();
            i++;
        }

            donePassengersQuantity.click();

        WebElement currencySelect = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

        Select currency = new Select(currencySelect);

        currency.selectByValue("USD");



        WebElement searchFlights = driver.findElement(By.id("ctl00_mainContent_btn_FindFlights"));

        Thread.sleep(2000);
        searchFlights.click();



        driver.quit();








    }
}
