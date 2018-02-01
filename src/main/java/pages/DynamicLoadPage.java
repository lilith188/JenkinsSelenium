package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import setup.WaitHelper;

import static setup.DriverSetup.getDriver;

/**
 * Created by sargis on 12/21/17
 */
public class DynamicLoadPage extends BasePage {
    @FindBy(css = "#start button")
    private WebElement startButton;

    @FindBy(id = "finish")
    private WebElement finishText;

    @FindBy(id = "loading")
    private WebElement loadingText;


    public DynamicLoadPage() {
        visit(getUrl());
    }

    public String getUrl() {
        return BASE_URL + "/dynamic_loading/1";
    }

    public void clickStart() {
        click(startButton);
    }

    public boolean isFinishDisplayed() {
        try {
            WaitHelper.getWait().waitForElementToBeVisible(finishText);
            return true;
        } catch (Error e) {
            return false;
        }
    }

    public boolean isLoadingDisplayed() {
        try {
            WaitHelper.getWait().waitForElementToBeVisible(loadingText);
            return true;
        } catch (Error e) {
            return false;
        }
    }
    public boolean isLoadingNotDisplayed() {
        try {
            WaitHelper.getWait().waitForElementNotVisible(loadingText);
            return true;
        } catch (Error e) {
            return false;
        }
    }

    public WebElement getFinish() {
        return finishText;
    }


}
