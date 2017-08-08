import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import java.net.URL;
import java.net.MalformedURLException;

/**
 * Created by Lenovo G50-70 on 08-08-2017.
 */
public class SampleTest {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "Untitled";
    protected IOSDriver driver = null;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "5190f41ff54c980d4ecbfe3025f389bbeb951e1d");
        dc.setBrowserName(MobileBrowserType.SAFARI);
        driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), dc);
    }

    @Test
    public void testUntitled() {
        driver.get("http://www.google.com");
        driver.context("NATIVE_APP");
        driver.hideKeyboard();
        driver.sendKeys("{ENTER}");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
