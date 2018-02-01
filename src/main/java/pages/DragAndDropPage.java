package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import setup.WaitHelper;

import static setup.DriverSetup.getDriver;

public class DragAndDropPage extends BasePage {
    @FindBy(css = ".ui-draggable")
    private WebElement draggable;

    @FindBy(css = ".ui-droppable")
    private WebElement droppable;


    public DragAndDropPage() {
        visit(getUrl());
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        WaitHelper.getWait()
                .waitForElementToBeVisible(draggable)
                .waitForElementClickable(draggable);
    }

    public String getUrl() {
        return "http://jqueryui.com/resources/demos/droppable/default.html";
    }

    public void dragAndDrop(WebElement draggable, WebElement target) {
        Actions actions = new Actions(getDriver());
        actions.dragAndDrop(draggable, target).build().perform();
    }

    public void dragAndDrop() {
        log.info("Dragging the Element");
        dragAndDrop(draggable, droppable);
    }

    public String getDropText() {
        return find(By.cssSelector(".ui-droppable")).getText();
    }


}
