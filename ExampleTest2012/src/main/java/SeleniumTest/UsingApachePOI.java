package SeleniumTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsingApachePOI {

	static List<String> userNameList= new ArrayList<String>();
	static List<String> passwordList= new ArrayList<String>();
	public void readexcel() throws IOException {
		
		FileInputStream excel=new FileInputStream("C:\\Users\\Admin\\OneDrive - Honeywell\\Documents\\learn\\testdata2.xlsx");
		Workbook workbook=new XSSFWorkbook(excel);
		Sheet sheet=workbook.getSheetAt(0);
		
		Iterator<Row> rowIterator=sheet.iterator();
		while(rowIterator.hasNext()) {
			Row rowvalue=rowIterator.next();
			
			Iterator<Cell> columnIterator=rowvalue.iterator();
			int i=2;
			while(columnIterator.hasNext()) {
				if(i%2==0) {
				userNameList.add(columnIterator.next().getStringCellValue());
				}
				else {
					
					passwordList.add(columnIterator.next().getStringCellValue());
				}
				
				i++;
				//System.out.println(cellvalue);
			}
		}
	}
	
	
	public void testcase(String uname, String pword) {
		//System.setProperty("webdriver.chrome.driver", "E:\\selenium\\chrome driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		
		WebElement username=driver.findElement(By.id("txtUsername"));
		username.sendKeys(uname);
		WebElement password=driver.findElement(By.id("txtPassword"));
		password.sendKeys(pword);
		
		WebElement loginbutton=driver.findElement(By.id("btnLogin"));
		loginbutton.click();
		
		driver.quit();
	}
	
	public void execureTest() {
		for(int i=0;i< userNameList.size();i++) {
			testcase(userNameList.get(i), passwordList.get(i));
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		UsingApachePOI obj=new UsingApachePOI();
		obj.readexcel();
		
		System.out.println("Username List " +  userNameList);
		System.out.println("Password List " +  passwordList);
		obj.execureTest();
	}
}
