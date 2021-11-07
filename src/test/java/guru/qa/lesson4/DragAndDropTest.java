package guru.qa.lesson4;

import guru.qa.pages.dragAndDrop.DragAndDropPage;
import org.junit.jupiter.api.Test;

public class DragAndDropTest {
    DragAndDropPage dragAndDropPage = new DragAndDropPage();

    @Test
    void checkDragAndDropSqures() {
        dragAndDropPage.openDragAndDrop();
        dragAndDropPage.dragAndDropSquareBToA();
    }
}
