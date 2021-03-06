// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class RegisterAccountNoInputTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new FirefoxDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void registerAccountNoInput() {
    // Test name: RegisterAccountNoInput
    // Step # | name | target | value
    // 1 | open | https://www.sportchek.ca/ | 
    // open start page
    driver.get("https://www.sportchek.ca/");
    // 2 | setWindowSize | 1595x923 | 
    // window size changes
    driver.manage().window().setSize(new Dimension(1595, 923));
    // 3 | click | css=.enterprise-account__button_register | 
    // click the register button
    driver.findElement(By.cssSelector(".enterprise-account__button_register")).click();
    // 4 | assertText | css=.gigya-container-enabled > .gigya-composite-control-header | Create Your Triangle ID
    // Assert the Create Truangle ID is present
    assertThat(driver.findElement(By.cssSelector(".gigya-container-enabled > .gigya-composite-control-header")).getText(), is("Create Your Triangle ID"));
    // 5 | click | css=#register-site-login .gigya-input-submit | 
    // Click the Create account button
    driver.findElement(By.cssSelector("#register-site-login .gigya-input-submit")).click();
    // 6 | assertText | id=__gig_template_element_3_1647548856839 | This field is required.
    // Assert that the email errormessage is present
    assertThat(driver.findElement(By.id("__gig_template_element_3_1647548856839")).getText(), is("This field is required."));
    // 7 | assertText | css=.pwd-cxty-val-err-msg | Password field is required.
    // Assert that the Password error message is present
    assertThat(driver.findElement(By.cssSelector(".pwd-cxty-val-err-msg")).getText(), is("Password field is required."));
  }
}
