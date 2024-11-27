package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Assignment_1 {

    public static WebDriverWait wait;
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        //TASK1: Open HomePage
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        driver.get("https://www.fitpeo.com/");
        driver.manage().window().maximize();

        //TASK2:
        navigateTo("Revenue Calculator");

        //TASK4
        adjustSlider(820);

        //TASK7
        selectCptCodes();

        //TASK5
        navigateTo("Revenue Calculator");
        updateSliderTextBox(560);

        driver.quit();

    }

    private static void updateSliderTextBox(int value) throws InterruptedException {
        String valueToSet = String.valueOf(value); // Value to be set
        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        WebElement slider = driver.findElement(By.xpath("//input[@data-index='0']"));
        WebElement inputBox = driver.findElement(By.xpath("//input[@id=':r0:']"));

        WebElement inputField = driver.findElement(By.xpath("//input[@type='number']"));
        Thread.sleep(200);

        jsx.executeScript("window.scrollTo(0, 0);");

        Integer slideVal = Integer.parseInt(slider.getAttribute("aria-valuenow").toString());

        while (slideVal > 0) {
            inputBox.sendKeys(Keys.BACK_SPACE);
            slideVal = Integer.parseInt(slider.getAttribute("aria-valuenow").toString());
        }

        inputBox.sendKeys(valueToSet);
        Thread.sleep(2000);

        String currentValue = inputField.getAttribute("value");

        if (currentValue.equalsIgnoreCase(valueToSet)) {
            System.out.println("Input field value is correct: " + currentValue);
        } else {
            System.out.println("Input field value is incorrect. Expected: " + valueToSet + ", but got: " + currentValue);
        }
        slideVal = Integer.parseInt(slider.getAttribute("aria-valuenow").toString());
        System.out.println("Slider value: " + slideVal);

        if (slideVal.toString().equalsIgnoreCase(valueToSet)) {
            System.out.println("Slider value is correct.");
        } else {
            System.out.println("Slider value is incorrect. Expected: " + valueToSet + ", but got: " + slideVal);
        }
        Thread.sleep(2000);
    }

    private static void selectCptCodes() throws InterruptedException {
        WebElement chk1 = driver.findElement(By.xpath("//div[@class='MuiBox-root css-rfiegf']//div[1]//label[1]//span[1]//input[1]"));
        chk1.click();
        Thread.sleep(200);
        WebElement chk2 = driver.findElement(By.xpath("//div[@class='MuiBox-root css-1p19z09']//div[2]//label[1]//span[1]//input[1]"));
        chk2.click();
        Thread.sleep(200);
        WebElement chk3 = driver.findElement(By.xpath("//div[3]//label[1]//span[1]//input[1]"));
        chk3.click();
        Thread.sleep(200);
        WebElement chk4 = driver.findElement(By.xpath("//div[8]//label[1]//span[1]//input[1]"));
        chk4.click();
        Thread.sleep(200);

        driver.findElement(By.xpath("//div[@class='MuiBox-root css-19zjbfs']"));
        Thread.sleep(200);
        String s = driver.findElement(By.xpath("(//div[@class='MuiBox-root css-m1khva'])[1]")).getText();
        Thread.sleep(200);
        System.out.println(s);
        Thread.sleep(5000);
    }

    private static void adjustSlider(int value) throws InterruptedException {
        JavascriptExecutor jsx = (JavascriptExecutor) driver;

        driver.findElement(By.xpath("//h4[normalize-space()='Medicare Eligible Patients']"));
        WebElement slider = driver.findElement(By.xpath("//input[@data-index='0']"));
        WebElement sliderVal = driver.findElement(By.xpath("//span[@data-index='0']"));
        WebElement sliderVal_2 = driver.findElement(By.xpath("//span[@class='MuiSlider-track css-10opxo5']"));
        WebElement inputBox = driver.findElement(By.xpath("//input[@id=':r0:']"));

        double minValue = Double.parseDouble(slider.getAttribute("min"));
        double maxValue = Double.parseDouble(slider.getAttribute("max"));
        double slideValue = ((value * 200) / (maxValue - minValue));    //Slider Move Speed Formula

        jsx.executeScript("var a=arguments[1];arguments[0].setAttribute('style', 'left: ' + a + '%;')", sliderVal, slideValue);
        jsx.executeScript("var a=arguments[1];arguments[0].setAttribute('style', 'width: ' + a + '%;')", sliderVal_2, slideValue);
        Thread.sleep(200);

        sliderVal_2.click();

        int slideVal = Integer.parseInt(slider.getAttribute("aria-valuenow").toString());

        if (slideVal <= value) {
            while (slideVal < value) {
                slider.sendKeys(Keys.ARROW_RIGHT);
                slideVal = Integer.parseInt(slider.getAttribute("aria-valuenow").toString());
            }
        } else {
            while (slideVal > value) {
                slider.sendKeys(Keys.ARROW_LEFT);
                slideVal = Integer.parseInt(slider.getAttribute("aria-valuenow").toString());
            }
        }
        Thread.sleep(200);
    }

    private static void navigateTo(String revenueCalculator) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText(revenueCalculator)));
        WebElement link = driver.findElement(By.linkText(revenueCalculator));
        link.click();
        Thread.sleep(5000);
    }

}






