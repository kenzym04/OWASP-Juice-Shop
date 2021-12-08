package ke.co.jambotechsolutions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JuiceTest {

	WebDriver driver;
	JavascriptExecutor js;

	@BeforeTest
	public void setup() throws Exception {

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("visiting url...");

		driver.get("https://juice-shop.herokuapp.com/#/login");
		Thread.sleep(3000);
		System.out.println("url ok");
	}

	@Test
	public void getRegistrationStatus() throws Exception {

		// Click "Me want it!" pop up
		WebElement wantItPopButton = driver.findElement(By.xpath("//a[@class='cc-btn cc-dismiss']"));
		wantItPopButton.click();
		System.out.println("Me want it! Pop button clicked ...");

		// Click "Me want it!" pop up
		WebElement dismissPopButton = driver.findElement(By.xpath(
				"//button[@class='mat-focus-indicator close-dialog mat-raised-button mat-button-base mat-primary ng-star-inserted']"));
		dismissPopButton.click();
		System.out.println("Dismiss Pop button clicked ...");

		// Click registration link
		driver.findElement(By.xpath("//a[contains(text(),'Not yet a customer?')]")).click();
		System.out.println("Registration link clicked ...");

		// Enter email
		WebElement userName = driver.findElement(By.xpath("//input[@id='emailControl']"));
		userName.sendKeys("jambotechsolutions@gmail.com");
		System.out.println("UserName Set ...");

		// Enter password
		WebElement pw = driver.findElement(By.id("passwordControl"));
		pw.sendKeys("jambotechsolutionsSoko1234");
		System.out.println("Password set ...");

		// repeat password
		WebElement pw2 = driver.findElement(By.id("repeatPasswordControl"));
		pw2.sendKeys("jambotechsolutionsSoko1234");
		System.out.println("Pasword repeated ok ...");

		// click radio button
		WebElement radio1 = driver.findElement(By.xpath(
				"//body/app-root[1]/div[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/app-register[1]/div[1]/mat-card[1]/div[2]/mat-slide-toggle[1]/label[1]/div[1]/div[1]/div[1]"));

		// Select radio button
		radio1.click();
		System.out.println("Radio Button Selected ...");
		Thread.sleep(5000);

		// Deselect radio button is selected
		radio1.click();
		System.out.println("Radio Button Deselected ...");

		// Click drop down menu
		WebElement drop = driver.findElement(By.xpath(
				"//body/app-root[1]/div[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/app-register[1]/div[1]/mat-card[1]/div[2]/div[1]/mat-form-field[1]/div[1]/div[1]/div[3]/mat-select[1]/div[1]/div[1]/span[1]"));
		drop.click();
		System.out.println("Drop down menu clicked ...");

		// Select mother's maiden name
		driver.findElement(By.xpath("//span[contains(text(),\"Mother's maiden name?\")]")).click();
		System.out.println("Maiden name option selected");
		Thread.sleep(2000);

		// Scroll down till registration is visible
		js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath(
				"//body/app-root[1]/div[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/app-register[1]/div[1]/mat-card[1]/div[2]/button[1]/span[1]"));
		js.executeScript("arguments[0].scrollIntoView();", element);
		System.out.println("Scrolled down till registration button visible...");

		// Enter mother's name
		WebElement answer = driver.findElement(By.xpath("//input[@id='securityAnswerControl']"));
		answer.sendKeys("Betty");
		System.out.println("Mother's maiden entered ok ...");
		Thread.sleep(5000);

		// click button to register
		WebElement register = driver.findElement(By.xpath(
				"//body/app-root[1]/div[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/app-register[1]/div[1]/mat-card[1]/div[2]/button[1]/span[1]"));
		register.click();
		System.out.println("Registration COMPLETED SUCCESSFULY ...");
		Thread.sleep(3000);
	}

	@AfterTest
	public void Close() throws Exception {
		driver.quit();
	}
}
