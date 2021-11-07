package guru.qa;

import guru.qa.pages.dragAndDrop.DragAndDropPage;
import org.junit.jupiter.api.Test;

public class dragAndDropTest {
    DragAndDropPage dragAndDropPage = new DragAndDropPage();

    @Test
    void checkDragAndDropSqures() {
        dragAndDropPage.openDragAndDrop();
        dragAndDropPage.dragAndDropSquareBToA();
    }
}
