package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;

public class invokingMultipleWindows {



    public static void main(String[]args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        String[] productToSearch = {"Tomato", "37", "26"};
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        driver.switchTo().newWindow(WindowType.TAB);
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();

        String parent = it.next();
        String child = it.next();

        driver.switchTo().window(child);
        driver.get("https://rahulshettyacademy.com/");

        List<WebElement> courses = driver.findElements(By.className("courses-block"));

        List<String> courseNameList = new ArrayList<>();

        for(int i= 0; i<courses.size(); i++){

            List<WebElement> course_name = courses.get(i).findElements(By.cssSelector(".upper-box h2"));
            courseNameList.add(course_name.get(0).getText());
        }


        String firstCourseName = courseNameList.get(1);

        driver.switchTo().window(parent);


        WebElement courseNameInput = driver.findElement(By.name("name"));

        courseNameInput.sendKeys(firstCourseName);

        Thread.sleep(3000);

        driver.quit();

    }
}