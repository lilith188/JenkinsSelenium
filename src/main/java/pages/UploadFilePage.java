package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UploadFilePage extends BasePage{
    @FindBy(id = "file-upload")
    private WebElement fileUploadInput;

    @FindBy(id = "file-submit")
    private WebElement fileSubmitButton;

    @FindBy(id = "uploaded-files")
    private WebElement uploadedSection;

    public UploadFilePage() {
        visit(getUrl());
    }
    @Override
    public String getUrl() {
        return BASE_URL + "/upload";
    }

    public void typePath(String path) {
        type(fileUploadInput, path);
    }

    public void submit() {
        click(fileSubmitButton);
    }

    public String getUploadedFiles() {
        return uploadedSection.getText();
    }
}
