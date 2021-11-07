package SeleniumTest;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenGoogle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();

		// getWindowHandle() - Used to store current focused windows identity
		String oldwindow= driver.getWindowHandle();

		WebElement firstbutton= driver.findElement(By.xpath("//*[@id='home']"));
		firstbutton.click();

		// getWindowHandles() - Used to store all windows identity in set<>
		Set<String> handles = driver.getWindowHandles();
		// Now handles - contain new window  and old window 
		for (String newwindow : handles) {
			driver.switchTo().window(newwindow);
		}
		WebElement editbutton= driver.findElement(By.xpath("//a[contains(@href, 'Edit.html')]"));
		editbutton.click();

		driver.close();
		//switch control to old window
		driver.switchTo().window(oldwindow);
		//firstbutton.click();
		WebElement multiplewindowbutton = driver.findElement(By.xpath("//button[@onclick='openWindows()']"));
		multiplewindowbutton.click();

		int numberofWindow = driver.getWindowHandles().size();
		System.out.println("no. of windows open"+ numberofWindow);

		Set<String> multiplewindowhandle=driver.getWindowHandles();
		for (String allwindows : multiplewindowhandle) {
			if(!allwindows.equals(oldwindow))
			{
				driver.switchTo().window(allwindows);
				driver.close();
				System.out.println("Test Completed successfully"+ allwindows);


			}

		}
		driver.quit();

	}

}
