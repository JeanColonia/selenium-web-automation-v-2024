package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class checkBoxPracticePage {

    public static void main(String[]args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();

        List<WebElement> optionList = driver.findElements(By.xpath("//div[@id='checkbox-example']/fieldset/label/input"));



        int randomNumber = randomIntNumber(optionList.size());

        optionList.get(randomNumber).click();

       String optionValue  = capitalizeWord(optionList.get(randomNumber).getAttribute("value"));

       WebElement  dropdown = driver.findElement(By.id("dropdown-class-example"));
        Select select = new Select(dropdown);

        select.selectByVisibleText(optionValue);

        WebElement name = driver.findElement(By.id("name"));
        name.sendKeys(optionValue);


        WebElement alertBtn = driver.findElement(By.id("alertbtn"));

        alertBtn.click();


        String alertMessage = driver.switchTo().alert().getText();

        if(alertMessage.contains(optionValue)){
            System.out.println("OPTION VALUE "+optionValue+" GRABBED");
        }
        Thread.sleep(2500);



        driver.quit();
    }

    private  static Integer randomIntNumber(int size) {
        Random random = new Random();
        int number = random.nextInt(size);

        return number;

    }

    private static String capitalizeWord(String text){

        return text.substring(0,1).toUpperCase() + text.substring(1);
    }

}
