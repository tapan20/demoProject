package pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.List;
import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import base.ExtentReportTest;

public class eazDinePOS_browser extends ExtentReportTest {

	String webURL = "https://www.naukri.com/";
	String filePath = "/Users/tapan.khimani/Desktop/sample.pdf";

	public void uploadFile() throws Exception {

		driver.navigate().to(webURL);
		Thread.sleep(1500);

		WebElement uploadFile = driver.findElement(By.cssSelector("input#file_upload"));
		Thread.sleep(1500);
		// uploadFile.click();
		Thread.sleep(1500);

		File file = null;
		file = new File(filePath);
		System.out.println(filePath);
		System.out.println(file.getAbsolutePath());
		uploadFile.sendKeys(file.getAbsolutePath());

		Thread.sleep(3000);

		testStep("PASS", "File Uploaded Successfully");

	}

	public void windowHandles() throws Exception {
		// 1) Navigate to URL
		driver.navigate().to("http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target");
		driver.manage().window().maximize();

		Thread.sleep(1500);

		// 2) Get the current window's handle and write to the console window. It must
		// be first window handle.
		System.out.println("Current Window Handle: " + driver.getWindowHandle() + "\n");
		// Switch to iframeResult iframe because all elements located in this iframe
		driver.switchTo().frame("iframeResult");

		Thread.sleep(1500);

		// 3) Locate the link and click it
		WebElement visitLink = driver.findElement(By.linkText("Visit W3Schools.com!"));
		visitLink.click();

		Thread.sleep(1500);

		// 4) Get all window handles and hold them in a list.
		Set<String> windowHandles = driver.getWindowHandles();
		java.util.List<String> windowHandlesList = new ArrayList<>(windowHandles);
		// Set to List Conversion

		Thread.sleep(1500);

		// 5) Write to total window handle number to the console.
		System.out.println("Total window number: " + windowHandlesList.size() + "\n");

		Thread.sleep(1500);

		// 6) Switch to second window
		driver.switchTo().window(windowHandlesList.get(1));

		Thread.sleep(1500);

		// 7) Get the current window's handle and write to the console window. It must
		// be second window handle.
		System.out.println("Current Window Handle: " + driver.getWindowHandle() + "\n");

		Thread.sleep(1500);

		// 8) Check the upper left side text is "THE WORLD'S LARGEST WEB DEVELOPER SITE"
		// in second window
		WebElement expectedText = driver
				.findElement(By.cssSelector("#main > div:nth-child(1) > div > div.w3-col.l6.w3-center > p"));
		assertEquals("The language for building web pages", expectedText.getText());

		Thread.sleep(1500);

		// 9) Go back (Switch) to first window
		driver.switchTo().window(windowHandlesList.get(0));
		// 10) Get the current window's handle and write to the console window. It must
		// be first window handle.
		System.out.println("Current Window Handle: " + driver.getWindowHandle() + "\n");

		Thread.sleep(1500);

		testStep("PASS", "Successfully Handles Tabs");

	}

}