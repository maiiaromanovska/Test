import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Example {
    WebDriver driver;
    WebElement addCarStartButton;
    WebElement addCarFinishButton;
    WebElement guestLoginMenu;
    WebElement mileageField;
    WebElement addExpenseStartButton;
    WebElement litersField;
    WebElement costField;
    WebElement expenseMenu;
    WebElement addExpenseFinishButton;
    WebElement expense1;
    WebElement expense2;
    String expensestr1;
    String expensestr2;


    void startBrowser(){

            System.setProperty("webdriver.chrome.driver", "C:/driver/chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("https://guest:welcome2qauto@qauto2.forstudy.space");
            driver.manage().window().maximize();
        }

    void loginGuest(){
        guestLoginMenu = driver.findElement(By.xpath("/html/body/app-root/app-global-layout/div/div/app-header/header/div/div/div[2]/button[1]"));
        guestLoginMenu.click();
    }
    void addCar() throws InterruptedException {
        addCarStartButton = driver.findElement(By.xpath("/html/body/app-root/app-global-layout/div/div/div/app-panel-layout/div/div/div/div[2]/div/app-garage/div/div[1]/button"));
        addCarStartButton.click();

        mileageField = driver.findElement(By.id("addCarMileage"));
        mileageField.clear();
        mileageField.sendKeys("1");

        addCarFinishButton = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/app-add-car-modal/div[3]/button[2]"));
        addCarFinishButton.click();
    }

    void addExpense() throws InterruptedException {
        Thread.sleep(1000);
        expenseMenu = driver.findElement(By.xpath("/html/body/app-root/app-global-layout/div/div/div/app-panel-layout/div/div/div/div[1]/nav/a[2]"));
        expenseMenu.click();

        Thread.sleep(1000);
        addExpenseStartButton = driver.findElement(By.xpath("/html/body/app-root/app-global-layout/div/div/div/app-panel-layout/div/div/div/div[2]/div/app-fuel-expenses/div/div[1]/div/button"));
        addExpenseStartButton.click();

        Thread.sleep(1000);
        mileageField = driver.findElement(By.id("addExpenseMileage"));
        mileageField.clear();
        mileageField.sendKeys("2");

        litersField = driver.findElement(By.id("addExpenseLiters"));
        litersField.clear();
        litersField.sendKeys("1");

        costField = driver.findElement(By.id("addExpenseTotalCost"));
        costField.clear();
        costField.sendKeys("1");

        addExpenseFinishButton = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/app-add-expense-modal/div[3]/button[2]"));
        addExpenseFinishButton.click();

    }

    void getAddedExpenses(){
        expense1 = driver.findElement(By.xpath("/html/body/app-root/app-global-layout/div/div/div/app-panel-layout/div/div/div/div[2]/div/app-fuel-expenses/div/div[2]/div/div[1]/table/tbody/tr[1]/td[1]"));
        expense2 = driver.findElement(By.xpath("/html/body/app-root/app-global-layout/div/div/div/app-panel-layout/div/div/div/div[2]/div/app-fuel-expenses/div/div[2]/div/div[1]/table/tbody/tr[2]/td[1]"));
        expensestr1 = expense1.getText();
        expensestr2 = expense2.getText();
}

    @Test
    public void ExampleTest() throws InterruptedException {
        startBrowser();
        loginGuest();
        addCar();
        addExpense();
        addExpense();
        getAddedExpenses();

        Assert.assertEquals("08.11.2022", expensestr1);
        Assert.assertEquals("08.11.2022", expensestr2);
    }



}
