import org.testng.annotations.Test;
import pages.CheckBoxPage;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CheckBoxTest extends BaseTest {

    @Test
    public void checkboxSelect1() {
        CheckBoxPage checkBoxPage = new CheckBoxPage();
        assertFalse(checkBoxPage.getCheckBox(0).isSelected());
        checkBoxPage.clickOnCheckBox(0);
        assertTrue(checkBoxPage.getCheckBox(0).isSelected());

    }

    @Test
    public void checkboxSelect2() {
        CheckBoxPage checkBoxPage = new CheckBoxPage();
        assertTrue(checkBoxPage.getCheckBox(1).isSelected());
        checkBoxPage.clickOnCheckBox(1);
        assertFalse(checkBoxPage.getCheckBox(1).isSelected());

    }
}
