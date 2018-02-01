import org.testng.annotations.*;
import setup.DriverSetup;
import setup.listeners.SuiteListener;

import java.security.AlgorithmParameters;

import static setup.DriverSetup.initDriver;
import static setup.DriverSetup.quitDriver;
@Listeners(SuiteListener.class)
public class BaseTest {
    @BeforeMethod
    public void setUpBase() {
        initDriver();
    }

    @AfterMethod
    public void tearDownBase() {
        quitDriver();
    }
}
