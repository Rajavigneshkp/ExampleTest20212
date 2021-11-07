package SeleniumTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		File src=new File("C:\\Users\\Admin\\OneDrive - Honeywell\\Documents\\learn\\testdata3.xlsx");

		FileInputStream fstream=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fstream);
		XSSFSheet sheet0=wb.getSheetAt(0);
		
	/*	//Single Value
		String data0=sheet0.getRow(0).getCell(1).getStringCellValue();
		System.out.println(data0);
*/
		
		//Multiple Value
		
		int rowcount=sheet0.getLastRowNum();
		int columncount=sheet0.getColumnWidth(rowcount);
		
		System.out.println("columncount is "  + columncount);
		
		for (int i=0;i<rowcount;i++) {
			String data0=sheet0.getRow(i).getCell(0).getStringCellValue();
			
			System.out.println(data0);
		}
		
		
		
	}

}
