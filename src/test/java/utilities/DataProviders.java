package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	

	//DataProvider 1
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=".\\testData\\Opencart_LoginData.xlsx";//taking xl file from testData
		
		ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
		
		
		int totalrows=xlutil.getRowCount("Sheet1");	
		int totalcols=xlutil.getCellCount("Sheet1",1);
				
		String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
		
		for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array bcsz first row always headers
		{		
			for(int j=0;j<totalcols;j++)  //0    i is rows j is col
			{
				logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
			}
		}
	return logindata;//returning two dimension array
				
	}
	
	//DataProvider 2
	@DataProvider(name="Searchproduct")
	public String[][] getProduct() throws IOException
	{
		String path=".\\testData\\Opencart_LoginData.xlsx";//taking xl file from testData
		ExcelUtility util=new ExcelUtility(path);
		int totalrows=util.getRowCount("Sheet2");
		int totalcols=util.getCellCount("Sheet2", 1);
		
		String SearchProduct[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++)
		{
			for(int j=0;j<totalcols;j++)
			{
				SearchProduct[i-1][j]=util.getCellData("Sheet2", i, j);
			}
		}
		return SearchProduct;
	}
	
	//DataProvider 3
	@DataProvider(name="compareProducts")
	public String[][] ProductCompare() throws IOException
	{
		String path=".\\testData\\OpenCart_ProductCompare.xlsx";//taking xl file from testData
		ExcelUtility util=new ExcelUtility(path);
		int totalrows=util.getRowCount("Sheet1");
		int totalcols=util.getCellCount("Sheet1", 1);
		
		String productcomp[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++)
		{
			for(int j=0;j<totalcols;j++)
			{
				productcomp[i-1][j]=util.getCellData("Sheet1", i, j);
			}
		}
		return productcomp;
	}
	
	//DataProvider 4
	@DataProvider(name="WishList")
	public String[][] grtWishlistData() throws IOException
	{
		String path=".\\testData\\OpenCart_WishList.xlsx";
		ExcelUtility utills=new ExcelUtility(path);
		
		int totalrows=utills.getRowCount("Sheet1");
		int totalcols=utills.getCellCount("Sheet1", 1);
		
		
		String searchdata[][]=new String[totalrows][totalcols];
		for(int i=1;i<=totalrows;i++)
		{
			for(int j=0;j<totalcols;j++)
			{
				searchdata[i-1][j]=utills.getCellData("Sheet1", i, j);
			}
		}
		return searchdata;
				
				
	}
}
