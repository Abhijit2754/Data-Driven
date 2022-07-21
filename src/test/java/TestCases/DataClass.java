package TestCases;

import org.testng.annotations.DataProvider;

public class DataClass {
	@DataProvider(name="passdcata")
	public String[][] datapcass()
	{
		String[][] data = new String[5][1];
		
		data[0][0] = "Admin";
		
		
		data[1][0] = "Admin";
		
		
		data[2][0] = "Samamsa";
		
		
		data[3][0] = "Fasdas";
		
		
		data[4][0] = "SAFFdf";
		
		
		
		return data;
	}
}
