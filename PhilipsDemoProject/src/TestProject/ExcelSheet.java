package TestProject;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheet {
	
	    //excel sheet ,row ,cell 
		public String getCellData(String path,String Sheet,int r,int c) throws Exception
		{
			FileInputStream fis = new FileInputStream(path);
			Workbook wb=WorkbookFactory.create(fis);
			String excelvalue=wb.getSheet(Sheet).getRow(r).getCell(c).toString();
			return excelvalue;
		}
		
		public int getRowCount(String path,String Sheet) throws Exception
		{
			//sheet LastRowNum
			FileInputStream fis = new FileInputStream(path);
			Workbook wb=WorkbookFactory.create(fis);
			int rc=wb.getSheet(Sheet).getLastRowNum();
			return rc;
		}
		
		public void setCellData(String path,String Sheet,int r,int c,String data) throws Exception
		{
			//from excel sheet value(outputstream)
			FileInputStream fis = new FileInputStream(path);
			Workbook wb=WorkbookFactory.create(fis);
			wb.getSheet(Sheet).getRow(r).createCell(c).setCellValue(data);
			FileOutputStream fos=new FileOutputStream(path);
			wb.write(fos);
		}



	


}
