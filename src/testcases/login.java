package testcases;

import org.testng.annotations.Test;

import project_pages.login_Page;

public class login {
	
		
		@Test(dataProviderClass=dataProvider.login_dataProvider.class, dataProvider = "cardDetails")
	public void cardcreation(String username,String password,String createCard,String List1,String List2,String cardName)
	{
		
		new login_Page()
		.login()
		.username(username)
		.button()
		.password(password)
		.loginbutton()
		.createCard(createCard)
		.createList(List1,List2)		
		.cardCreation(cardName)
		.cordinates()
		.deleteCard()
		.logout()
		.closeBrowser()
		;
	}
	
	

}
