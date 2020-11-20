package Ust_Global.Sample_Project;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

public class Makemytrip {

	public static void main(String[] args) throws InterruptedException {
		String parentWindowHandle = "";
		String childWindowHandle = "";
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com");
		driver.manage().window().maximize();
		List<WebElement> loginBar = driver.findElements(By.cssSelector("li[data-cy='account']>span.userNameIcon>span"));
		List<WebElement> socialLogin = driver.findElements(By.cssSelector("li[data-cy='account'] .login__earn"));
		parentWindowHandle = driver.getWindowHandle();
		Actions act = new Actions(driver);
		if (loginBar.size() > 0) {
			try {
				loginBar.get(0).click();
			} catch (Exception ex) {
				driver.navigate().refresh();
			}
		} else {
			driver.navigate().refresh();
		}
		Thread.sleep(2500);
		if (socialLogin.size() > 0) {
			try {
				for (int i = 0; i < 2; i++) {
					loginBar.get(0).click();
					Thread.sleep(2000);
				}
			} catch (Exception ex) {
				driver.navigate().refresh();
			}
			try {
				driver.findElement(By.xpath("//label[contains(text(), 'Login with Phone/Email')]/following::span[1]"))
						.click();
			} catch (Exception ex) {

			}
			driver.findElement(By.xpath("//span[contains(text(), 'Login with Google')]")).click();
		} else {

			try {
				driver.findElement(By.xpath("//label[contains(text(), 'Login with Phone/Email')]/following::span[1]"))
						.click();
			} catch (Exception ex) {

			}
			driver.findElement(By.xpath("//span[contains(text(), 'Login with Google')]")).click();
		}
		for (String winHandle : driver.getWindowHandles()) {
			childWindowHandle = winHandle;
		}
		driver.switchTo().window(childWindowHandle);
		if (driver.findElement(By.xpath("//span[text()= 'Sign in']")).isDisplayed()) {
			System.out.println("successfully switched to child window");
		} else {
			System.out.println("Unable to switch to child window");
		}
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("madhuriswaroop11@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Next']/following::div[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("hiammanana");
		driver.findElement(By.xpath("//span[text()='Next']/following::div[1]")).click();
		Thread.sleep(5000);
		driver.switchTo().window(parentWindowHandle);
		if (driver.findElement(By.xpath("//img[@alt='Make My Trip']")).isDisplayed()) {
			System.out.println("successfully switched to parent window");
			Thread.sleep(5000);
			driver.navigate().refresh();
		} else {
			System.out.println("Unable to switch to parent window");
		}
		Actions act1 = new Actions(driver);
		Thread.sleep(5000);
		WebElement hotel = driver.findElement(By.xpath("//span[@class='chNavIcon appendBottom2 chSprite chHotels ']"));
		act1.moveToElement(hotel);
		act1.click().build().perform();

		driver.findElement(By.xpath("//div[@class='widgetSection appendBottom40']//input[@id='city']")).click();
		driver.findElement(By.xpath("//div[@id='react-autowhatever-1']//p[contains(text(), 'Delhi')]")).click();

		driver.findElement(By.xpath("//input[@id='checkin']")).click();

		driver.findElement(By.xpath(
				"//div[@class='DayPicker-NavBar']//span[@class='DayPicker-NavButton DayPicker-NavButton--next']"))
				.click();
		driver.findElement(By.xpath("//div[@class='DayPicker-Body']/div[2]/div[contains(text(), '11')]")).click();

		driver.findElement(By.xpath("//input[@id='checkout']")).click();

		driver.findElement(By.xpath("(//div[contains(@aria-label,'15')])[1]")).click();

		driver.findElement(
				By.xpath("//div[@class='hsw_inputBox roomGuests  ']//input[@class='hsw_inputField guests font20']"))
				.click();

		driver.findElement(
				By.xpath("//div[@class='addRooomDetails']/ul[1][@class='guestCounter font12 darkText']/li[2]")).click();

		driver.findElement(
				By.xpath("//div[@class='addRooomDetails']/ul[2][@class='guestCounter font12 darkText']/li[1]")).click();

		driver.findElement(By.xpath("//div[@class='roomsGuests']/div[2]/button[@class='primaryBtn btnApply']")).click();

		driver.findElement(By.xpath("//div[@class='widgetSection appendBottom40']//button[contains(text(), 'Search')]"))
				.click();

		WebDriverWait wait2 = new WebDriverWait(driver, 30);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='locationFtrModal']//span[contains(text(), 'Karol bagh')]"))).click();

		WebDriverWait wait = new WebDriverWait(driver, 30);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[3][@class='listingRowOuter']//div[@class='imgCont']/img")))
				.click();

		WebDriverWait wait4 = new WebDriverWait(driver, 40);
		Thread.sleep(5000);
		for (String winHandle : driver.getWindowHandles()) {
			childWindowHandle = winHandle;
		}
		driver.switchTo().window(childWindowHandle);
		System.out.println("successfully switched to child window");
		Thread.sleep(2000);
		wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'BOOK THIS NOW')]")))
				.click();

		Actions act4 = new Actions(driver);
		try {
			wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='travelerInfo']")));
			WebElement TravellerInformation = driver.findElement(By.xpath("//p[@id='travelerInfo']"));
			act4.moveToElement(TravellerInformation).build().perform();
		} catch (Exception ex) {

		}

		WebElement title = driver.findElement(By.xpath("//select[@id='title']"));
		Select sel = new Select(title);
		sel.selectByIndex(2);
		try {

			driver.findElement(By.xpath("//div[contains(@class, 'modalCont')]/span[contains(@class, 'close')]"))
					.click();
			Thread.sleep(2000);
		} catch (Exception ex) {

		}
		act4.moveToElement(driver.findElement(By.xpath("//input[@id='fName']"))).build().perform();
		driver.findElement(By.xpath("//input[@id='fName']")).click();
		driver.findElement(By.xpath("//input[@id='fName']")).sendKeys("Madhuri");
		driver.findElement(By.xpath("//input[@id='lName']")).click();
		driver.findElement(By.xpath("//input[@id='lName']")).sendKeys("Karnati");
		driver.findElement(By.xpath("//input[@id='mNo']")).sendKeys("9999988888");

		Actions act5 = new Actions(driver);
		WebElement SpecialRequest = driver
				.findElement(By.xpath("//p[@class='latoBlack font20 prependTop20 appendBottom5']"));
		act5.moveToElement(SpecialRequest).build().perform();

		driver.findElement(By.xpath("//ul[@class='appendBottom20']//label[contains(text(), 'Large bed')]")).click();
		Thread.sleep(2000);
		act5.moveToElement(driver.findElement(By.cssSelector(".bxPayNow a.btnPayNow"))).build().perform();
		driver.findElement(By.cssSelector(".bxPayNow a.btnPayNow")).click();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		wait4.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'BOOKING SUMMARY')]")));
		Assert.assertTrue("Booking sumary screen is displayed",
				driver.findElement(By.xpath("//p[contains(text(), 'BOOKING SUMMARY')]")).isDisplayed());
		driver.quit();
	}
}
