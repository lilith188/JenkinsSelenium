package pages;

import org.openqa.selenium.WebDriver;

import static setup.DriverSetup.getDriver;

/**
 * Created by sargis on 12/25/17
 */
public class WindowsPage extends BasePage {
    public WindowsPage() {
        visit(getUrl());
    }

    @Override
    public String getUrl() {
        return BASE_URL + "/windows";
    }

    public void clickLink() {
        find(".example a").click();
    }

    public Object[] getAllWindows() {
        return driver.getWindowHandles().toArray();
    }

    public void switchToWindow(int index) {
        driver.switchTo().window(getAllWindows()[index].toString());
    }
}
