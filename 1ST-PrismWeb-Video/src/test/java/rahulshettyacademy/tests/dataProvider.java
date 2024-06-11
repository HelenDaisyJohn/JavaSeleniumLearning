package rahulshettyacademy.tests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//public class dataProvider {
//	DataFormatter formatter=new DataFormatter();
//	@Test(dataProvider="driveTest")
//	public void testCaseData(String greeting, String Communication, int ID)
//	{
//		System.out.println(greeting+Communication+ID);
//	}
public class dataProvider {



    @Test(dataProvider = "driveTest")

    public void testCaseData(String greeting, String communication, int id) {

        System.out.println(greeting + " " + communication + " " + id);

    }



    @DataProvider(name = "driveTest")

    public Object[][] getData() {

        // Note the change here: the third element in each array is now an int

        return new Object[][] {

            {"Hello", "Test", 123},

            {"Bye", "Message", 12345},

            {"Solo", "Call", 789}

        };

    }

}


	
//	@DataProvider(name="driveTest")
//	public Object[][] getData() throws IOException
//	{
////		Object[][] data= {{"Hello", "Test", "123"},{"Bye", "Message", "12345"},{"Solo", "call", "789"}};
////		return data;
//		
//		FileInputStream fis =new FileInputStream("C:\\Users\\helen\\OneDrive\\Desktop\\Data.ods");
//		XSSFWorkbook wb=new XSSFWorkbook(fis);
//		XSSFSheet sheet=wb.getSheetAt(0);
//		int rowCount=sheet.getPhysicalNumberOfRows();
//		XSSFRow row=sheet.getRow(0);
//		int columnCount=row.getLastCellNum();
//		Object Data[][]=new Object[rowCount-1][columnCount];
//		for(int i=0;i<=rowCount-1;i++) {
//			row=sheet.getRow(i+1);
//			for(int j=0;j<-columnCount-1;j++)
//			{
////				System.out.println(row.getCell(j));
//				XSSFCell cell=row.getCell(j);
//
//				Data[i][j] = formatter.formatCellValue(cell);
//			}
//		}
//		return Data;
//		
//	}
//}
