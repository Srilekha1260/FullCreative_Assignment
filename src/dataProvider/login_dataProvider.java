package dataProvider;

import org.testng.annotations.DataProvider;

import wrappers.DataInputProvider;

public class login_dataProvider {
	
	@DataProvider(name = "cardDetails")
	public static Object[][] getData1() {
		return DataInputProvider.getSheet("\\cardDetails","cardDetails");
	}
}
