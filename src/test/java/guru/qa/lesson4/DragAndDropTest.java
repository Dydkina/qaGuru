package guru.qa.lesson4;

import guru.qa.TestBase;
import guru.qa.pages.dragAndDrop.DragAndDropPage;
import io.qameta.allure.AllureId;
import org.junit.jupiter.api.Test;

public class DragAndDropTest extends TestBase {
    DragAndDropPage dragAndDropPage = new DragAndDropPage();

    @Test
    @AllureId("7751")
    void checkDragAndDropSqures() {
        dragAndDropPage.openDragAndDrop();
        dragAndDropPage.dragAndDropSquareBToA();
    }
}
