package My_Projects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Flipkart {
public static void main(String[] args) throws InterruptedException {
		
		WebDriver d=new ChromeDriver();
		d.get("https://www.flipkart.com/");
		d.manage().window().maximize();
		try
		{
		d.findElement(By.xpath("//span[.='✕']")).click();
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement ele=d.findElement(By.xpath("//div[.='Fashion']"));
		Actions ac=new Actions(d);
		ac.moveToElement(ele).perform();
		WebElement ele2=d.findElement(By.xpath("//a[text()='Men Footwear']"));
		Actions ac2=new Actions(d);
		ac2.moveToElement(ele2).perform();
		WebElement ele3=d.findElement(By.xpath("//a[text()='All']"));
		Actions ac3=new Actions(d);
		ac3.moveToElement(ele3).perform();
		ele3.click();
		WebElement page=d.findElement(By.xpath("//div[@class='_2MImiq']//span[contains(text(),'Page')]"));
		String name=page.getText();
		System.out.print(name);
		String nam = name.replace(",", "");
		String[] words=nam.split(" ");
	
		String alpha="";
		int sum=0;
		for(String word:words)
		{
			if(Character.isLetter(word.charAt(0)))
			{
				alpha+=word;
				
			}else
			{
				sum+=Integer.parseInt(word);
			}
		}
		System.out.println("The total is:"+sum);
		
		for(int i=1;i<sum;i++)
		{		
//		List<WebElement> list=d.findElements(By.xpath("//div[@class='_13oc-S']"));					
//		System.out.println("Total list is:"+list.size());
			Thread.sleep(10000);

		List<WebElement> productnames=d.findElements(By.xpath("//div[@class='_13oc-S']//a[contains(@class,'IRpwTa')]"));
		for(WebElement productname:productnames)
		{
			System.out.println(productname.getText().toString());
		}
		System.out.println("===========================================");
		d.findElement(By.xpath("//a[@class='_1LKTO3']//span[contains(text(),'Next')]")).click();
		}
	}

}
