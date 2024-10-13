package org.example;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.example.utils.functions.jsonHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.IOException;


public class FormTask {


    public static void main(String[] args) throws IOException, ParseException, InterruptedException {


        JSONObject personalInfo = jsonHandler.jsonManager("src/main/java/org/example/utils/data/personInfo.json");


        String name = (String) personalInfo.get("name");
        String email = (String) personalInfo.get("email");
        String pass = (String) personalInfo.get("password");
        Boolean loveIceCream = (Boolean) personalInfo.get("loveIceCream");
        String gender = (String) personalInfo.get("gender");
        String employeeStatus = (String) personalInfo.get("employeeStatus");
        String dateOfBirth = (String) personalInfo.get("DateOfBirth");
        String[] DateOfBirthDivided = ((String) personalInfo.get("DateOfBirth")).split("/");


        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.manage().window().maximize();


        WebElement nameInput = driver.findElement(By.name("name"));
        WebElement emailInput = driver.findElement(By.name("email"));
        WebElement passInput = driver.findElement(By.id("exampleInputPassword1"));
        WebElement iceCreamCheckbox = driver.findElement(By.id("exampleCheck1"));

        Select genderOptions = new Select(driver.findElement(By.id("exampleFormControlSelect1")));
        WebElement employeeStatusRadioBtn = driver.findElement(By.id("inlineRadio1"));
        WebElement dateOfBirthInput = driver.findElement(By.name("bday"));

        WebElement submitBtn = driver.findElement(By.cssSelector("input[type='submit']"));
        String confirmationMessage = "Success!";


        nameInput.sendKeys(name);
        emailInput.sendKeys(email);
        passInput.sendKeys(pass);
        if (loveIceCream) iceCreamCheckbox.click();
        genderOptions.selectByVisibleText(gender);
        employeeStatusRadioBtn.click();
        dateOfBirthInput.sendKeys("12/04/2000");

        submitBtn.click();

        WebElement successAlert = driver.findElement(By.xpath("//strong[contains(text(),'Success!')]"));

        Thread.sleep(1500);

        Assert.assertEquals(successAlert.getText(), confirmationMessage);

        Thread.sleep(2000);
        driver.quit();



    }
}
