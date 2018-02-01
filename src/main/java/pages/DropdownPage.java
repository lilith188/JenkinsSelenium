package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static setup.DriverSetup.getDriver;

/**
 * Created by sargis on 12/25/17
 */
public class DropdownPage extends BasePage {
    @FindBy(id ="dropdown")
    private WebElement dropdownField;

    public DropdownPage() {
        visit(getUrl());
    }

    public String getUrl() {
        return BASE_URL + "/dropdown";
    }

    public WebElement getDropdown() {
        return dropdownField;
    }

    public List<WebElement> getDropdownOptions() {
        return getDropdown().findElements(By.tagName("option"));
    }

    public void forceAlert() {
        ((JavascriptExecutor) driver).executeScript("alert('Hello! I am an alert box!!');");
    }
    public void closeAlert() {
        driver.switchTo().alert().accept();
    }

    public void selectOption(String optionName) {
        List<WebElement> options = getDropdownOptions();
        for (WebElement option:options) {
            if (option.getText().equals(optionName)) {
                option.click();
            }
        }
    }

    public String getSelectedOption() {
        List<WebElement> options = getDropdownOptions();
        for (WebElement option:options) {
            if (option.isSelected()) {
                return option.getText();
            }
        }
        return null;
    }
}
