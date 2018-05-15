import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class syadmin {
  @Test
	WebDriver driver;
	
public sysadminUrl(WebDriver driver){
	this.driver = driver;
}
	@FindBy(xpath="html/body/h1[contains(text(),'Forbidden')]") WebElement forbidden_txt;
	@FindBy(xpath="html/body/p[contains(text(),'You are not authorized to access the requested resource.')]") WebElement auth;

public String forbidden() throws InterruptedException
{
	Thread.sleep(3000);
	return forbidden_txt.getText();
	
}

public String auth() throws InterruptedException {
	Thread.sleep(3000);
	return auth.getText();
}
}
