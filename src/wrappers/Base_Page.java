package wrappers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Point;
//import project_pages.Point;

public class Base_Page {

	 WebDriver driver;
	
	public Properties loadRepository(String fileName) throws FileNotFoundException, IOException
	{
			Properties p = new Properties();		
			p.load(new FileInputStream(new File(fileName)));
			return p; 
		
	}
	
	public void lauchBrowser(String url)
	{
		try
		{
		System.setProperty("webdriver.chrome.driver","driver\\chromedriver.exe");
		
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void enterTextByXPath(String user,String name)
	{
		try
		{		
			
			Thread.sleep(1000);
			driver.findElement(By.xpath(user)).sendKeys(name);			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void clickByXpath(String user)
	{
		
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			//Thread.sleep(2000);
			driver.findElement(By.xpath(user)).click();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void clickById(String user)
	{
		
		try
		{
		driver.findElement(By.id(user)).click();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void password1(String password,String name)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(password)));	
			
			//Thread.sleep(3000);
			//System.out.println(password+"  "+name);
			
			//JavascriptExecutor javascript = (JavascriptExecutor) driver;
			//javascript.executeScript("var element = document.querySelector('user'); element.value = 'name';");
			driver.findElement(By.xpath(password)).sendKeys(name);			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void dragAndDrop(String draggable,String droppable)
	{
		try
		{
			Thread.sleep(1000);
			Actions builder = new Actions(driver);
			
			WebElement from = driver.findElement(By.xpath(draggable));
			
			WebElement to = driver.findElement(By.xpath(droppable));	 
			//Perform drag and drop
			builder.dragAndDrop(from, to).perform();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void XandY_Cordinates(String cord)
	{
		try
		{
			
			WebElement n = driver.findElement(By.xpath(cord));
			
			//obtain element x, y coordinates with getLocation method
			Point p = n.getLocation();
			int X = p.getX();
			int Y = p.getY();
			System.out.println("The X and Y coordinates of "+n.getText()+" are X = "+X+" Y = "+Y);
			//System.out.println(n.getText());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}  
	}
	public void scrollingIntoView(String path)
	{
		WebElement loc=driver.findElement(By.xpath(path));
	      // Javascript executor
	      ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", loc);
	}
	public void close_Browser()
	{
		driver.close();
	}
}
