package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class CheckBoxPage extends BasePage{
    public CheckBoxPage() {
        visit(getUrl());
    }
    @FindBys(
            @FindBy(css = "input[type='checkbox']")
    )
    private List<WebElement> checkboxes;

    @Override
    public String getUrl() {
        return BASE_URL + "/checkboxes";
    }

    public void clickOnCheckBox(int index) {
        checkboxes.get(index).click();
    }

    public WebElement getCheckBox(int index){
        return checkboxes.get(index);
    }
}
