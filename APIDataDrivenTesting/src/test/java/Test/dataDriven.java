package Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {

	public static void main(String[] args) throws IOException {
		// identify the sheet, then find the purchase test, then identified the row and column
		FileInputStream fis=new FileInputStream("D://TestedDocument//TestData.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		int sheets=workbook.getNumberOfSheets();
		for(int i=0; i<sheets;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("testdata"))
					{
				XSSFSheet sheet=workbook.getSheetAt(i);
				
//				Identify scanning the first row of the entire 1st row
				Iterator<Row> rows=sheet.iterator(); //sheet is collection of rows
				Row firstrow=rows.next();
				Iterator<Cell> ce=firstrow.cellIterator();//row is collection of cells
				int k=0;
				int column = 0;
				while(ce.hasNext()) {
					Cell value=ce.next();
					if(value.getStringCellValue().equalsIgnoreCase("TestCases"))
					{
//						Desired column
						column=k;
					}
					k++;
					
				}
				System.out.println(column);
				
				while(rows.hasNext())
				{
					
				}
				
					}
		}
	}

}
