package CIA;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
public class task1
{
    public static void main( String[] args ) throws InterruptedException
    {
    	WebDriverManager.chromedriver().setup();
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(co);
		driver.get("https://www.amazon.in/Apple-iPhone-256GB-Space-Black/dp/B0BDJ52N7F/ref=sr_1_1_sspa?crid=3BZ6XNBO1OLBC&keywords=apple&qid=1681296811&sprefix=apple%2Caps%2C995&sr=8-1-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9hdGY&psc=1");
		driver.manage().window().maximize();
		String title=driver.getTitle();
		System.out.println(title);
		if(title.equals("Amazon.in: Buy ASUS VivoBook 15 (2021), 15.6-inch (39.62 cm) HD, Dual Core Intel Celeron N4020, Thin and Light Laptop (4GB RAM/256GB SSD/Integrated Graphics/Windows 11 Home/Transparent Silver/1.8 Kg), X515MA-BR011W Online at Low Prices in India | ASUS Reviews & Ratings")) {
			System.out.println("Verified title of the page");
		}else {
			System.out.println("Title not matched");
		}
		JavascriptExecutor js=(JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,1000)","");
    	
    	
		driver.findElement(By.id("add-to-cart-button")).click();
		System.out.println("Verified Add to Cart button");
		
		String lnk=driver.findElement(By.id("//*[@id=\"authportal-main-section\"]/div[2]/div/div[1]/form/div/div/div/h1")).getText();
		if(lnk.equals("Sign in")) {
			System.out.println("Sign in page landed");
		}else {
			System.out.println("Wrong page landed");
		}
		
    	driver.quit();
    }
}
