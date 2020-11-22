package test.utils;

import org.testng.annotations.DataProvider;

public class DataForTest {
	@DataProvider(name = "dataForLogin")
	public Object dataForLogin() {
		Object[][] data = new Object[2][2];
		data[0][0] = "sselenium674@gmail.com";
		data[0][1] = "abdou01";

		// 2nd row
		data[1][0] = "sselenium674@gmail.com";
		data[1][1] = "Selenium01";
		return data;
		/*
		 * 
		 * new Object[][]{
		 * 
		 * { "sselenium674@gmail.com", "abdou01" }, { "sselenium674@gmail.com",
		 * "Selenium01" } };
		 * 
		 * }
		 */
	}
}
