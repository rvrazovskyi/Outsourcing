import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainClass {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "A:\\Загрузки\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://outsourcing.ankhora.co.uk/");

        try {
            Map<String, String> buttonMap = new HashMap<>();
            buttonMap.put("MAIN PAGE", "/html/body/div/header/div[1]/div[1]/div/div/div/div[2]/div/div/div/nav/div/ul/li[1]/a");
            buttonMap.put("SERVICES", "/html/body/div/header/div[1]/div[1]/div/div/div/div[2]/div/div/div/nav/div/ul/li[2]/a");
            buttonMap.put("IT CONSULTING", "//*[@id='post-589']/div/div/section[3]/div/div/div/section[1]/div/div[1]/div/div[2]/div/div/a");
            buttonMap.put("MANAGEMENT CONSULTING", "//*[@id='post-589']/div/div/section[3]/div/div/div/section[1]/div/div[2]/div/div[2]/div/div/a");
            buttonMap.put("SALES", "//*[@id='post-589']/div/div/section[3]/div/div/div/section[1]/div/div[3]/div/div[2]/div/div/a");
            buttonMap.put("WEBSITE DEVELOPMENT", "//*[@id='post-589']/div/div/section[3]/div/div/div/section[2]/div/div[1]/div/div[2]/div/div/a");
            buttonMap.put("CUSTOMER SUPPORT", "//*[@id='post-589']/div/div/section[3]/div/div/div/section[2]/div/div[2]/div/div[2]/div/div/a");
            buttonMap.put("TRANSFER PRICING", "//*[@id='post-589']/div/div/section[3]/div/div/div/section[2]/div/div[3]/div/div[2]/div/div/a");
            buttonMap.put("AUDIT", "//*[@id='post-589']/div/div/section[3]/div/div/div/section[3]/div/div[1]/div/div[2]/div/div/a");
            buttonMap.put("HR CONSULTING", "//*[@id='post-589']/div/div/section[3]/div/div/div/section[3]/div/div[2]/div/div[2]/div/div/a");
            buttonMap.put("MARKETING", "//*[@id='post-589']/div/div/section[3]/div/div/div/section[3]/div/div[3]/div/div[2]/div/div/a");
            buttonMap.put("SEND", "//*[@id='post-589']/div/div/section[2]/div/div[3]/div/div[3]/div/div/div[1]/div[1]/a");

            Map<String, String> pageLinkMap = new HashMap<>();
            pageLinkMap.put("SERVICES", "https://outsourcing.ankhora.co.uk/en/services/");
            pageLinkMap.put("MAIN PAGE", "https://outsourcing.ankhora.co.uk/en/main-page/");
            pageLinkMap.put("IT CONSULTING", "https://outsourcing.ankhora.co.uk/en/it-consulting/");
            pageLinkMap.put("MANAGEMENT CONSULTING", "https://outsourcing.ankhora.co.uk/en/management-consulting/");
            pageLinkMap.put("SALES", "https://outsourcing.ankhora.co.uk/en/sales/");
            pageLinkMap.put("WEBSITE DEVELOPMENT", "https://outsourcing.ankhora.co.uk/en/website-development/");
            pageLinkMap.put("CUSTOMER SUPPORT", "https://outsourcing.ankhora.co.uk/en/customer-support/");
            pageLinkMap.put("TRANSFER PRICING", "https://outsourcing.ankhora.co.uk/en/transfer-pricing/");
            pageLinkMap.put("AUDIT", "https://outsourcing.ankhora.co.uk/en/audit/");
            pageLinkMap.put("HR CONSULTING", "https://outsourcing.ankhora.co.uk/en/hr-consulting/");

            Map<String, String> iconMap = new HashMap<>();
            iconMap.put("SERVICES", "Services");
            iconMap.put("MAIN PAGE", "main page");
            iconMap.put("IT CONSULTING", "IT Consulting");
            iconMap.put("MANAGEMENT CONSULTING", "Management Consulting");
            iconMap.put("SALES", "Sales");
            iconMap.put("WEBSITE DEVELOPMENT", "Website Development");
            iconMap.put("CUSTOMER SUPPORT", "Customer Support");
            iconMap.put("TRANSFER PRICING", "Transfer Pricing");
            iconMap.put("AUDIT", "Audit");
            iconMap.put("HR CONSULTING", "HR Consulting");
            iconMap.put("MARKETING", "Marketing");
            iconMap.put("SEND", "Send");

            List<String> buttonOrder = Arrays.asList(
                    "SERVICES", "MAIN PAGE", "IT CONSULTING", "MANAGEMENT CONSULTING",
                    "SALES", "WEBSITE DEVELOPMENT", "CUSTOMER SUPPORT",
                    "TRANSFER PRICING", "AUDIT", "HR CONSULTING", "MARKETING", "SEND"
            );

            for (String buttonText : buttonOrder) {
                String xpath = buttonMap.get(buttonText);
                String iconName = iconMap.get(buttonText);
                String pageLink = pageLinkMap.get(buttonText);

                WebElement button = driver.findElement(By.xpath(xpath));

                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].scrollIntoView({block: 'center'});", button);

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
                wait.until(ExpectedConditions.elementToBeClickable(button));


                button.click();
                Thread.sleep(5000);

                if (buttonText.equals("SEND")) {
                    System.out.println(iconName + " - Send button clicked successfully.");


                    driver.findElement(By.id("wpforms-551-field_0")).sendKeys("Test");
                    driver.findElement(By.id("wpforms-551-field_0-middle")).sendKeys("User");
                    driver.findElement(By.id("wpforms-551-field_0-last")).sendKeys("TestUser");
                    driver.findElement(By.id("wpforms-551-field_1")).sendKeys("test@example.com");
                    driver.findElement(By.id("wpforms-551-field_4")).sendKeys("Example Company");
                    driver.findElement(By.id("wpforms-551-field_6")).sendKeys("Testing");
                    driver.findElement(By.id("wpforms-551-field_7")).sendKeys("+380978889911");
                    driver.findElement(By.id("wpforms-551-field_2")).sendKeys("This is a test message.");


                    driver.findElement(By.id("wpforms-form-551")).click();

                    System.out.println("Form submitted successfully.");
                } else {
                    String newUrl = driver.getCurrentUrl();
                    if (newUrl.equals(pageLink)) {
                        System.out.println(iconName + " - Button redirects to the correct page: " + newUrl);
                    } else {
                        System.err.println("Error: " + iconName + " - Button redirects to the wrong page: " + newUrl);
                    }
                }

                driver.navigate().back();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}