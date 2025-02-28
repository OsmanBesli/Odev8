package Odev8;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static dev.failsafe.internal.util.Assert.isTrue;

public class LocatorsXpath {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/webtables");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Page Title: " + driver.getTitle());
        driver.manage().window().maximize();

        //Add butonun tıklanabilir olmasını bekle
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='addNewRecordButton']")));

        // URL deki Add butonuna tıkla.
        WebElement addButton= driver.findElement(By.xpath("//*[@id='addNewRecordButton']"));
        addButton.click();

        //Formda firstName alanını doldur.
        WebElement firstName=driver.findElement(By.xpath("//*[@id='firstName']"));
        firstName.sendKeys("Osman");

        //Formda lastName alanını doldur.
        WebElement lastName=driver.findElement(By.xpath("//*[@id='lastName']"));
        lastName.sendKeys("Besli");

        //Formda email alanını doldur.
        WebElement email=driver.findElement(By.xpath("//*[@id='userEmail']"));
        email.sendKeys("osmanbesli63@gmail.com");

        //Formda age alanını doldur.
        WebElement age=driver.findElement(By.xpath("//*[@id='age']"));
        age.sendKeys("30");

        //Formda salary alanını doldur.
        WebElement salary=driver.findElement(By.xpath("//*[@id='salary']"));
        salary.sendKeys("5000");

        //Formda department alanını doldur.
        WebElement department=driver.findElement(By.xpath("//*[@id='department']"));
        department.sendKeys("IT Sektor");

        //Forumdaki Submit butonuna tıkla .
        WebElement submitButton= driver.findElement(By.xpath("//*[@id='submit']"));
        submitButton.click();
        System.out.println("Forma yeni kayıt eklendi");

        //Formu doldurup Submit butonuna tıkladıktan sonra edit butonun tıklnanabilir olmasını bekle.
        WebDriverWait wait2 =new WebDriverWait(driver, Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='edit-record-4']")));

        //Formda yeni kaydın edit butonuna tıkla.
        WebElement editButton= driver.findElement(By.xpath("//*[@id='edit-record-4']"));
        editButton.click();

        //Formdaki firstName  alanını güncelle.
        WebElement firstNameEdit=driver.findElement(By.xpath("//*[@id='firstName']"));
        firstNameEdit.clear();
        firstNameEdit.click();
        firstNameEdit.sendKeys("KeremALi");

        //Formda güncelleme sonrası tekrar Submit butonuna  tıkla.
        WebElement submitButtonUpdated= driver.findElement(By.xpath("//*[@id='submit']"));
        submitButtonUpdated.click();
        System.out.println("Forumdaki kayıt da firstName alanı güncellendi");


        //Formu doldurup Submit butonuna tıkla, sonra edit yap en son da delete butonun tıklnanabilir olmasını bekle.
        WebDriverWait wait3 =new WebDriverWait(driver, Duration.ofSeconds(10));
        wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='delete-record-4']")));

        //Formdaki en son eklenen kaydı sil.
        WebElement deleteButton= driver.findElement(By.xpath("//*[@id='delete-record-4']"));
        deleteButton.click();
        System.out.println("Forumdaki yeni kayıt Silindi");

        driver.close();


    }
}
