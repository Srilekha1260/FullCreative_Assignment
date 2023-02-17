package project_pages;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import wrappers.Base_Page;

public class login_Page extends Base_Page {
	
	Properties prop;
	
	public login_Page()
	{
		try
		{ 
			prop=loadRepository("properties\\login.properties");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public login_Page login()
	{
		lauchBrowser(prop.getProperty("url.Xpath"));
		return this;
	}
	public login_Page username(String user)
	{
		enterTextByXPath(prop.getProperty("user.Xpath"),user);
		return this;
	}
	
	public login_Page button()
	{
		clickById(prop.getProperty("login.Id"));
		return this;
	}
	public login_Page password(String password)
	{
		
		
			password1(prop.getProperty("password.Xpath"),password);
		
		return this;
	}
	public login_Page loginbutton()
	{
		clickById(prop.getProperty("login_button.Id"));
		return this;
	}
	public login_Page createCard(String cardName)
	{
		//driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
		clickByXpath(prop.getProperty("createButton.Xpath"));
		clickByXpath(prop.getProperty("createCard.Xpath"));
		enterTextByXPath(prop.getProperty("cardName.Xpath"),cardName);
		clickByXpath(prop.getProperty("newCardCreationButton.Xpath"));
		
		return this;
	}
	
	public login_Page createList(String list1,String list2)
	{
	
		 
		clickByXpath(prop.getProperty("newListAddButton.Xpath"));
		enterTextByXPath(prop.getProperty("newListCreattion.Xpath"),list1);
		clickByXpath(prop.getProperty("listAddButton.Xpath"));
		enterTextByXPath(prop.getProperty("newListCreattion.Xpath"),list2);
		clickByXpath(prop.getProperty("listAddButton.Xpath"));
		
		
		return this;
	}
	
	public login_Page cardCreation(String list1)
	{
		
		
		clickByXpath(prop.getProperty("cardAddButton.Xpath"));
		enterTextByXPath(prop.getProperty("cardDetials.Xpath"),list1);
		clickByXpath(prop.getProperty("addCard.Xpath"));
		dragAndDrop(prop.getProperty("drag.Xpath"),prop.getProperty("drop.Xpath"));
		return this;
	}
	
	public login_Page cordinates()
	{
		XandY_Cordinates(prop.getProperty("cord.Xpath"));
		
	      return this;
	}
	public login_Page deleteCard()
	{
		clickByXpath(prop.getProperty("boardName.Xpath"));
		clickByXpath(prop.getProperty("board.Xpath"));
		clickByXpath(prop.getProperty("closeboard.Xpath"));
		clickByXpath(prop.getProperty("closeButton.Xpath"));
		return this;
	}
	public login_Page logout()
	{
		clickByXpath(prop.getProperty("profile.Xpath"));
	
		clickByXpath(prop.getProperty("logout.Xpath"));
		return this;
	}
	public login_Page closeBrowser()
	{
		close_Browser();
		return this;
	}
   
}
