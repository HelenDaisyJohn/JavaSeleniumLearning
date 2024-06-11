package rahulshettyacademy.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {
	
	public ArrayList<String> getData(String testcaseName) throws IOException
	{
		ArrayList<String> a=new ArrayList<String>();
		FileInputStream fis =new FileInputStream("C:\\Users\\helen\\OneDrive\\Desktop\\Data.ods");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		
		int sheets=workbook.getNumberOfSheets();
		for(int i=0;i<sheets;i++)
		{
			if (workbook.getSheetName(i).equalsIgnoreCase("testdata"))
			{
				XSSFSheet sheet=workbook.getSheetAt(i);
//				Identify scanning the entire first row
				Iterator<Row> rows=sheet.iterator();
				Row firstRow=rows.next();
				
				Iterator<Cell> ce=firstRow.cellIterator();
				int k=0;
				int column=0;
				while(ce.hasNext())
				{
					Cell value=ce.next();
					if(value.getStringCellValue().equalsIgnoreCase("testdata"))
					{
						column=k;
					}
					k++;
				}
				System.out.println(column);
//				Once column is identified, then scan entire testcase column to identify purchase testcase now
				while(rows.hasNext())
				{
					Row r=rows.next();
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName))
					{
						//After grabbing the purchase testcase, pull all the entire row of the purchase
						Iterator<Cell> cv=r.cellIterator();
						while(cv.hasNext())
						{
							
//							If the cell type is other than string, we vcan handle this in below code
							Cell c=cv.next();
							if(c.getCellType()==CellType.STRING)
							{
							System.out.println(cv.next().getStringCellValue());	
							a.add(cv.next().getStringCellValue());
							}
							else
							{
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
								
							}
							}
					}
				}
				
				
			}
		}
		return a;
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		

}
}