import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DragAndDropPage;

import static org.testng.Assert.assertEquals;

public class DragDropTest extends BaseTest{
    private DragAndDropPage dragAndDropPage;

    @BeforeMethod
    public void setUp() {
        dragAndDropPage = (DragAndDropPage) new DragAndDropPage().get();

    }

    @Test
    public void dragAndDropTest() {
        assertEquals(dragAndDropPage.getDropText(), "Drop here");
        dragAndDropPage.dragAndDrop();
        assertEquals(dragAndDropPage.getDropText(), "Dropped!");
    }
}
