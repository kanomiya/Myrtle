import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.io.IOException;

public class Myrtle {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);

        FirefoxDriver driver = new FirefoxDriver(options);
        driver.get("http://www.google.com");

        File tmpfile = driver.getScreenshotAs(OutputType.FILE);
        File dest = new File(tmpfile.getName());
        Files.copy(tmpfile, dest);

        driver.close();
    }
}
